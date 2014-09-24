package br.edu.ifg.formosa.obac.controle.paineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie.ControleInicioSimulacoes;
import br.edu.ifg.formosa.obac.controle.propulsao.ControleMolaMouse;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControlePainelConfiguracaoExecucao {
	
	private ModeloAmbiente mA = null;
	private VisaoPainelConfiguracao vPC = null;
	private ControleInicioSimulacoes cIS = null;
	
	public ControlePainelConfiguracaoExecucao(
			final ModeloAmbiente mA,
			final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mpc,
			final ControlePainelConfiguracaoAtualizacoes cpca,
			final ControlePainelConfiguracaoEntradaDeDados cpced,
			final ControleInicioSimulacoes cIS, final ControleMolaMouse cMM)
	{
		this.mA = mA;
		this.vPC = vPC;
		this.cIS = cIS;
		
		//Botão Iniciar/Pausar
		vPC.getBaIniciaPausar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Inicia simulação
				if (vPC.getBaIniciaPausar().getText().equals(mpc.getBotaoIniciar())==true
					&& cpced.verificaCampos()==true) {
					//Desativar componentes do Painel de Cofiguração
						cpca.desativaComponentes(false);
					//____________________________________________________
					//Passagem do valor da massa para o ModeloObjeto
						mA.getmO().setMassa(Double.parseDouble(vPC.getCtObjetoMassa().getText().replaceAll(",", ".")));
					//____________________________________________________
					//Início dos testes lógicos para executar
					//--Propulsão por canhão
						if (vPC.getCsPropulsao().getSelectedIndex()==0){exeCanhao();}
					//--Execução da mola
						else if (vPC.getCsPropulsao().getSelectedIndex()==1){exeMola();}
					//--Execução Queda Livre
						else{cIS.iniciarSimulacao();}
					//____________________________________________________
					//Troca do rótulo do painel
					vPC.getBaIniciaPausar().setText(mpc.getBotaoPausar());
				}
				
				//Pausa simulação
				else if(vPC.getBaIniciaPausar().getText().equals(mpc.getBotaoPausar())){
					
					vPC.getBaIniciaPausar().setText(mpc.getBotaoIniciar());
				}
				
				//Se vier para cá a simulação deu errado por uma falha no código
				else{System.err.println("!!!Erro!!!");}
			}
		});
		
		/*Botão nova simulação - Para simulação retornando-a para seu estado original,
		 *tornando possível a realização de uma nova simulação*/ 
		vPC.getBaNovaSimulacao().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Troca o rótulo do botão Para garantir que seja Iniciar Simulação
					vPC.getBaIniciaPausar().setText(mpc.getBotaoIniciar());
				//____________________________________________________
				//Reativar componentes do painel de Configuração
					cpca.desativaComponentes(true);
			}
		});
	}
	
	private void exeCanhao(){
		//Ângulo
		mA.getmP().setAnguloRotacaoGraus(
				Double.parseDouble(vPC.getCtPropulsaoDado1().getText().replace(",", ".")));
		//Energia
		mA.getmP().getmC().setEnergia(
				Double.parseDouble(vPC.getCtPropulsaoDado2().getText().replace(",", ".")));
		
		mA.getmP().getmC().calculaVelocidade(); //Velocidade do canhão
		
		cIS.iniciarSimulacao();
	}
	
	private void exeMola(){
		//Tamanho da Mola
		mA.getmP().getModeloMola().setTamanhoMolaTotalM(Double.parseDouble(vPC.getCtPropulsaoDado1().getText()));
		//Constante elástica
		mA.getmP().getModeloMola().setkAtual(
				Double.parseDouble(vPC.getCtPropulsaoDado2().getText().replaceAll(",", "."))/100);
		//Listener da mola
//		cMM.ativaMolaMouse();
	}
	
}
