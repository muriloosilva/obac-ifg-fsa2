package br.edu.ifg.formosa.obac.controle.paineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.controle.obstaculo.ControleObstaculoMouse;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelFormulas;
import br.edu.ifg.formosa.obac.modelo.ModeloPropulsao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControlePainelConfiguracaoAtualizacoes {
	
	//Constantes
	private final VisaoPainelConfiguracao vpc;
	private final ModeloPainelConfiguracao mpc;
	private final VisaoPainelFormulas vpf;
	private final VisaoPainelInformacao vpi;
	private final VisaoPainelSimulacao vPS;
	private final ModeloPropulsao mP;
	private final ControleObstaculoMouse com;
	private final ControleOBAC cOBAC;
	
	//Construtor
	public ControlePainelConfiguracaoAtualizacoes(
		   VisaoPainelConfiguracao vpc, ModeloPainelConfiguracao mpc,
		   VisaoPainelFormulas vpf, VisaoPainelInformacao vpi, VisaoPainelSimulacao vPS,
		   ModeloPropulsao mP, ControleObstaculoMouse com, ControleOBAC cOBAC)
	{
		this.vpc = vpc;
		this.mpc = mpc;
		this.vpf = vpf;
		this.vpi = vpi;
		this.vPS = vPS;
		this.mP = mP;
		this.com = com;
		this.cOBAC = cOBAC;
		
		acaoPropulsoes();
		acaoCoefDeRestituicao();
		acaoExibirColisao();
		
	}
	
	//Alterações realizadas de acordo com a propulsão selecionada
	private void acaoPropulsoes(){
		vpc.getCsPropulsao().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Propulsão pelo canhão
				if(vpc.getCsPropulsao().getSelectedItem().equals(mpc.getCanhao())){
					//Rótulos
					vpc.getrPropulsaoDado1().setText(mpc.getDado1Canhao());
					vpc.getrPropulsaoDado2().setText(mpc.getDado2Canhao());
					//Caixa de seleção das simulações
					if(vpc.getCsAmbienteSimulacao().getItemCount()==5)//Teste lógico para que adicione apenas uma vez
						vpc.getCsAmbienteSimulacao().insertItemAt(mpc.getLancamentoObliquo(), vpc.getCsAmbienteSimulacao().getItemCount());
					//Painel de Fórmulas
					vpf.getAtVInicial().setText(ModeloPainelFormulas.propCanhao);
					//Painel de Informações
					vpi.setVisivelCanhao();
					//Altera a imagem
					mP.trocaImagemProp(true);
					vPS.getVisaoPropulsao().setImagemPropulsao(mP.getImagemPropulsao());
					vPS.getVisaoAuxiliar().getpCompressor().setVisible(false);
					//Método necessário para corrigir o campo de dado 1 da propulsão por canhão
					ajustesPConfig();
				}
				//Propulsão pela mola
				else if(vpc.getCsPropulsao().getSelectedItem().equals(mpc.getMola())){
					//Rótulos
					vpc.getrPropulsaoDado1().setText(mpc.getDado1Mola());
					vpc.getrPropulsaoDado2().setText(mpc.getDado2Mola());
					//Caixas de seleção das simulações
					if(vpc.getCsAmbienteSimulacao().getItemCount()==6)//Teste lógico para não remover uma linha desnecessária
						vpc.getCsAmbienteSimulacao().removeItemAt(vpc.getCsAmbienteSimulacao().getItemCount()-1);//Remove a opção de lançamento oblíquo
					//Painel de Fórmulas
					vpf.getAtVInicial().setText(ModeloPainelFormulas.propMola);
					//Painel de Informações
					vpi.setVisivelMola();
					//Altera a imagem
					mP.trocaImagemProp(false);
					vPS.getVisaoPropulsao().setImagemPropulsao(mP.getImagemPropulsao());
					//Método necessário para desfazer a correção o campo de dado 1 da propulsão por canhão
					ajustesPConfig();
				} 
				else{
					JOptionPane.showMessageDialog(null,
						"Falha catastrófica no funcionamento do programa", 
						"Aviso", JOptionPane.WARNING_MESSAGE, null);
				}
				cOBAC.repinta();
			}
		});
	}
	
	//Atualização do rótulo da barra do Coeficiente de restituição
	private void acaoCoefDeRestituicao(){
		vpc.getdObjetoCoeficienteRestituicao().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				vpc.getrObjetoAtualCoefRest().setText(""+(vpc.getdObjetoCoeficienteRestituicao().getValue()/100.0));
				//O valor do Deslizante (JSlider) é pego e dividido por 100
				//Em seguida é passado para um rótulo (JLabel), a fim do usuário saber o valor que a simulação usará
			}
		});
	}
	
	private void acaoExibirColisao(){		
		vpc.getBoColisaoNao().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vPS.getVisaoObstaculo().setVisible(false);
				com.setListener(false);
				vpi.setVisivelColisao(false);
				cOBAC.repinta();
			}
		});
		vpc.getBoColisaoSim().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vPS.getVisaoObstaculo().setVisible(true);
				com.setListener(true);
				vpi.setVisivelColisao(true);
				cOBAC.repinta();
			}
		});
	}
	private String cacheTexto = "0";  
	//Série de ajustes feitos no Painel de Configuração durante a seleção de simulações
		public void ajustesPConfig(){
			//1º - Configura o segundo campo de dados referentes a propulsão no painel de configuração
			//-----para que so possa ter seu valor editado caso seja a simulação de lançamento oblíquo.
				cacheTexto = vpc.getCtPropulsaoDado1().getText();
				if (vpc.getCsAmbienteSimulacao().getSelectedIndex()!=5 
					&& vpc.getCsPropulsao().getSelectedIndex()==0)
				{//Inicio IF/ELSE 1
					vpc.getCtPropulsaoDado1().setText("0");
					vpc.getCtPropulsaoDado1().setEnabled(false);
				}
				else {
					vpc.getCtPropulsaoDado1().setText(cacheTexto);
					vpc.getCtPropulsaoDado1().setEnabled(true);
				}
			//Fim 1º
			
			//2º - (Des)Abilitação do obstáculo de acordo com o tipo de simulação
				if (vpc.getCsAmbienteSimulacao().getSelectedIndex()==0//Plano
					||vpc.getCsAmbienteSimulacao().getSelectedIndex()==1//Subida
					||vpc.getCsAmbienteSimulacao().getSelectedIndex()==2//Descida
				){
					vpc.getBoColisaoNao().setSelected(vpc.getBoColisaoNao().isSelected());
					segundoAjuste(true);
				}
				else {//Simulações que não suportam a colisão: P&P, QL e LO
					vpc.getBoColisaoNao().setSelected(true);
					segundoAjuste(false);
				}
			//Fim 2º
		}
		//Métodos usados por ajustesPConfig() para evitar a redundância e código
		private void segundoAjuste(boolean enabled){
			//Interação com os botões de opção da colisão
			vpc.getBoColisaoNao().setEnabled(enabled);
			vpc.getBoColisaoSim().setEnabled(enabled);
		} 
		private void terceiroAjuste(boolean enabled){
			//Interação dos Campos de Texto referentes aos dados
			vpc.getCtPropulsaoDado1().setEnabled(enabled);
			vpc.getCtPropulsaoDado2().setEnabled(enabled);
			//Visibilidade do painel de propulsão
			vPS.getVisaoPropulsao().setVisible(enabled);
		}
		

	//Método usado na execução para que a interação com os componentes seja removida
	public void desativaComponentes(boolean ativado){
		vpc.getCsPropulsao().setEnabled(ativado);
		vpc.getCtPropulsaoDado2().setEnabled(ativado);
		vpc.getCsAmbienteSimulacao().setEnabled(ativado);
		vpc.getCsAmbienteAtrito().setEnabled(ativado);
		vpc.getCsAmbienteGravidade().setEnabled(ativado);
		vpc.getCtObjetoMassa().setEnabled(ativado);
		vpc.getdObjetoCoeficienteRestituicao().setEnabled(ativado);
		vpc.getBoColisaoSim().setEnabled(ativado);
		vpc.getBoColisaoNao().setEnabled(ativado);
		vpc.getBaNovaSimulacao().setVisible(!ativado);
	}
}
