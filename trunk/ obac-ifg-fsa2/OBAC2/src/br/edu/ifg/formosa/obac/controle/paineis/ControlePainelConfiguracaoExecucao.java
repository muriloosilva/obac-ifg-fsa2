package br.edu.ifg.formosa.obac.controle.paineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie.ControleInicioSimulacoes;
import br.edu.ifg.formosa.obac.controle.propulsao.ControleMolaMouse;
import br.edu.ifg.formosa.obac.controle.simulacao.ControleSimulacao;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControlePainelConfiguracaoExecucao {
	
	private ModeloAmbiente mA = null;
	private VisaoPainelConfiguracao vPC = null;
	private VisaoPainelSimulacao vPS = null;
	private ControleInicioSimulacoes cIS = null;
	
	public ControlePainelConfiguracaoExecucao(
			final ModeloAmbiente mA, final VisaoPainelSimulacao vPS,
			final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mpc,
			final ControlePainelConfiguracaoAtualizacoes cpca,
			final ControlePainelConfiguracaoEntradaDeDados cpced,
			final ControleInicioSimulacoes cIS, final ControleMolaMouse cMM,
			final ControleOBAC cOBAC)
	{
		this.mA = mA;
		this.vPC = vPC;
		this.vPS = vPS;
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
						if (vPC.getCsPropulsao().getSelectedIndex()==0){exeCanhao(); cOBAC.getPainelAbas().setSelectedIndex(1);}
					//--Execução da mola
						else if (vPC.getCsPropulsao().getSelectedIndex()==1){exeMola(); cOBAC.getPainelAbas().setSelectedIndex(1);}
					//--Execução Queda Livre
						else{
							mA.getmEV().setEscalaFimYM(Integer.parseInt(vPC.getCtPropulsaoDado1().getText()));
							ControleSimulacao.mudaMarcadores(mA.getmEV(), (int)mA.getmEV().getEscalaFimYM());
							cIS.iniciarSimulacao();
						}
					//Retira os listeners case seja LO
						if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 4) {
							vPS.getVisaoPropulsao().removeMouseListener(cOBAC.getcCM().getcCML());
							vPS.getVisaoPropulsao().removeMouseMotionListener(cOBAC.getcCM().getcCML());						
						}
					//_________________________________________________
					//Troca do rótulo do painel
					vPC.getBaIniciaPausar().setText(mpc.getBotaoPausar());
				}
				
				//Pausa simulação
				else if(vPC.getBaIniciaPausar().getText().equals(mpc.getBotaoPausar())){
					cIS.getCObjeto().pausar();
					//Troca do rótulo do painel
					vPC.getBaIniciaPausar().setText(mpc.getBotaoContinuar());
				}
				else if(vPC.getBaIniciaPausar().getText().equals(mpc.getBotaoContinuar())){
					cIS.getCObjeto().continuar();
					//Troca do rótulo do painel
					vPC.getBaIniciaPausar().setText(mpc.getBotaoPausar());
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
				vPC.getBaIniciaPausar().setText(mpc.getBotaoIniciar());
				//Deixa o slider invisivel
					vPS.getVisaoAuxiliar().getpCompressor().setVisible(false);
					vPS.getVisaoAuxiliar().getpCompressor().setEnabled(false);
				//Para a simulação
				cIS.getCObjeto().parar();
				//Reserta os valores do PConfig
				vPC.getCtPropulsaoDado2().setText("");
				vPC.getCtObjetoMassa().setText("");
				//____________________________________________________
				//Troca o rótulo do botão Para garantir que seja Iniciar Simulação
					vPC.getBaIniciaPausar().setText(mpc.getBotaoIniciar());
				//____________________________________________________
				//Reativar componentes do painel de Configuração
					cpca.desativaComponentes(true);
				//Ajustes de acordo co a simulação
					if(vPC.getCsPropulsao().getSelectedIndex()==0
					   && vPC.getCsAmbienteSimulacao().getSelectedIndex()!=4){
						vPC.getCtPropulsaoDado1().setEnabled(false);
						vPC.getCtPropulsaoDado1().setText("0");
					}
					else if(vPC.getCsPropulsao().getSelectedIndex()==2){
						vPC.getCtPropulsaoDado1().setEnabled(false);
						vPC.getCtPropulsaoDado2().setEnabled(false);
						vPC.getdObjetoCoeficienteRestituicao().setEnabled(true);
						vPC.getCtPropulsaoDado2().setText("0");
					}
					else{
						vPC.getCtPropulsaoDado1().setEnabled(true);
						vPC.getCtPropulsaoDado1().setText("");
					}
				//Reposiciona o objeto
					switch(vPC.getCsAmbienteSimulacao().getSelectedIndex()){
					case 0:
						mA.getmO().setPosicaoXPx(ModeloObjeto.pXPadPx);
						mA.getmO().setPosicaoYPx(ModeloObjeto.pPlaYPx);
						break;
					case 1:	
						mA.getmO().setPosicaoXPx(ModeloObjeto.pXPadPx);
						mA.getmO().setPosicaoYPx(ModeloObjeto.pSubYPx);
						break;
					case 2:	
						mA.getmO().setPosicaoXPx(ModeloObjeto.pXPadPx);
						mA.getmO().setPosicaoYPx(ModeloObjeto.pDesYPx);
						break;
					case 3:	
						mA.getmO().setPosicaoXPx(ModeloObjeto.pXPadPx);
						mA.getmO().setPosicaoYPx(ModeloObjeto.pPepYPx);
						break;
					case 4:	
						mA.getmO().setPosicaoXPx(ModeloObjeto.pOblXPx);
						mA.getmO().setPosicaoYPx(ModeloObjeto.pQueYPx);
						break;	
					case 5:	
						mA.getmO().setPosicaoXPx(ModeloObjeto.pQueXPx);
						mA.getmO().setPosicaoYPx(ModeloObjeto.pOblYPx);
						break;
					}
					
				//Readiciona o listener do canhao case seja LO
					if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 4) {
						vPS.getVisaoPropulsao().addMouseListener(cOBAC.getcCM().getcCML());
						vPS.getVisaoPropulsao().addMouseMotionListener(cOBAC.getcCM().getcCML());
						mA.getmO().setPosicaoYPx(ModeloObjeto.pOblYPx);
					} else {
						vPS.getVisaoPropulsao().removeMouseListener(cOBAC.getcCM().getcCML());
						vPS.getVisaoPropulsao().removeMouseMotionListener(cOBAC.getcCM().getcCML());						
					}
				//Repinta
					zeraModelos();
					mA.getmEH().setEscalaFimXM(100);
					ControleSimulacao.mudaMarcadores(mA.getmEH(), 100);
					cOBAC.repinta();
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
		vPC.getBaNovaSimulacao().setVisible(true);
		
		cIS.iniciarSimulacao();
	}
	
	private void exeMola(){
		this.vPS.getVisaoAuxiliar().getDeslizanteMola().setValue(this.vPS.getVisaoAuxiliar().getDeslizanteMola().getMaximum());
		this.vPS.getVisaoAuxiliar().getRotuloCompressao().setText("100%");
		//Tamanho da Mola
		mA.getmP().getModeloMola().setTamanhoMolaTotalM(
				Double.parseDouble(vPC.getCtPropulsaoDado1().getText().replaceAll(",", "."))/100);
		//Constante elástica
		mA.getmP().getModeloMola().setkAtual(
				Double.parseDouble(vPC.getCtPropulsaoDado2().getText().replaceAll(",", ".")));
		
		//Listener da mola
		vPS.getVisaoAuxiliar().getpCompressor().setVisible(true);
		vPS.getVisaoAuxiliar().getpCompressor().setEnabled(false);
//		cMM.ativaMolaMouse();
	}
	
	private void zeraModelos(){
		mA.setTempoAtual(0);
		mA.setTempoTotal(0);
		mA.getmEH().setEscalaFimXM(0);
		mA.getmEH().setEscalaFimYM(0);
		mA.getmEV().setEscalaFimXM(0);
		mA.getmEH().setEscalaFimYM(0);
		mA.getmO().setAceleracao(0);
		mA.getmO().setAceleracaoY(0);
		mA.getmO().setCoefRestituicao(0);
		mA.getmO().setForcaNormal(0);
		mA.getmO().setMassa(0);
		mA.getmO().setPosFinalXMetros(0);
		mA.getmO().setPosFinalYMetros(0);
		mA.getmO().setVelocidade(0);
		mA.getmO().setVelocidadeInicial(0);
		mA.getmP().setAnguloRotacaoGraus(0);
		mA.getmP().getmC().setAlturaMaxima(0);
		mA.getmP().getmC().setCatAd(0);
		mA.getmP().getmC().setCatOpo(0);
		mA.getmP().getmC().setEnergia(0);
		mA.getmP().getmC().setHip(0);
		mA.getmP().getmC().setVerAX(0);
		mA.getmP().getmC().setVerAY(0);
		mA.getmP().getmC().setVerBX(0);
		mA.getmP().getModeloMola().setkAtual(0);
		mA.getmP().getModeloMola().setTamanhoMolaAtualM(0);
		mA.getmP().getModeloMola().setTamanhoMolaAtualPix(0);
		mA.getmP().getModeloMola().setTamanhoMolaTotalM(0);
		mA.getmS().setForcaAtrito(0);
	}
	
}
