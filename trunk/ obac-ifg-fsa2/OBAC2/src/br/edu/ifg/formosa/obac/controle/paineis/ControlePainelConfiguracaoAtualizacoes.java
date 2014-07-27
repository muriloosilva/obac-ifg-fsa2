package br.edu.ifg.formosa.obac.controle.paineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.edu.ifg.formosa.obac.controle.propulsao.ControleMolaMouse;
import br.edu.ifg.formosa.obac.modelo.ModeloPropulsao;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelFormulas;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPropulsao;

public class ControlePainelConfiguracaoAtualizacoes {
	
	//Constantes
	private final VisaoPainelConfiguracao vpc;
	private final ModeloPainelConfiguracao mpc;
	private final VisaoPainelFormulas vpf;
	private final VisaoPainelInformacao vpi;
	private final VisaoPropulsao vp;
	private final ModeloPropulsao mm;
	private final ControleMolaMouse cmm;
	
	//Construtor
	public ControlePainelConfiguracaoAtualizacoes( VisaoPainelConfiguracao vpc,
		   ModeloPainelConfiguracao mpc, VisaoPainelFormulas vpf,
		   VisaoPainelInformacao vpi, VisaoPropulsao vp,
		   ModeloPropulsao mm, ControleMolaMouse cmm)
	{
		this.vpc = vpc;
		this.mpc = mpc;
		this.vpf = vpf;
		this.vpi = vpi;
		this.vp = vp;
		this.mm = mm;
		this.cmm = cmm;
		
		acaoPropulsoes();
		acaoCoefDeRestituicao();
		
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
//					vp.setImagemPropulsao(null);
					//Remove o movimento da mola
					cmm.desativaMolaMouse();
				}
				//Propulsão pela mola
				else if(vpc.getCsPropulsao().getSelectedItem().equals(mpc.getMola())){
					//Rótulos
					vpc.getrPropulsaoDado1().setText(mpc.getDado1Mola());
					vpc.getrPropulsaoDado2().setText(mpc.getDado2Mola());
					//Caixa de seleção das simulações
					if(vpc.getCsAmbienteSimulacao().getItemCount()==6)//Teste lógico para não remover uma linha desnecessária
						vpc.getCsAmbienteSimulacao().removeItemAt(vpc.getCsAmbienteSimulacao().getItemCount()-1);//Remove a opção de lançamento oblíquo
					//Painel de Fórmulas
					vpf.getAtVInicial().setText(ModeloPainelFormulas.propMola);
					//Painel de Informações
					vpi.setVisivelMola();
					//Altera a imagem
					vp.setImagemPropulsao(mm.getImagemMola());
					//Adiciona o movimento da mola
					cmm.ativaMolaMouse();
				} 
				else{
					JOptionPane.showMessageDialog(null,
						"Falha catastrófica no funcionamento do programa", 
						"Aviso", JOptionPane.WARNING_MESSAGE, null);
				}
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

	//Método usado na execução para que a interação com os componentes seja removida
	public void desativaComponentes(boolean ativado){
		vpc.getCsPropulsao().setEnabled(ativado);
		vpc.getCtPropulsaoDado1().setEnabled(ativado);
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
