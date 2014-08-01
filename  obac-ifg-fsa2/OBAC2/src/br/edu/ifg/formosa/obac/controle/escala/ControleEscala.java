package br.edu.ifg.formosa.obac.controle.escala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloMola;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControleEscala {
	//Variáveis
	private ModeloEscala mEP = null;
	private ModeloEscala mES = null;
	
	//Metodos
	//--Construtor
	public ControleEscala(final VisaoPainelInformacao vpi, final VisaoPainelSimulacao vps,  final VisaoEscala vE, final ModeloAmbiente mA, final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mPC) {		
		mEP = mA.getmEPri();
		mES = mA.getmESec();		

		mudaMarcadores(50);
		
		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 0) { //Plano
					mudaModeloEscala(mA.getmEPri(), 160, 520, 700, 520, 0, false); 
					mudaPosMola(mA.getmM(), 30, 470);
					mudaPosObjeto(mA.getmO(), 130, 470);
					ModeloAmbiente.anguloInclinacaoGraus = 0;
					
					vps.getVisaoEscalaSec().setVisible(false); //Escala secundaria fica invisivel
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 1) {//Subida
					mudaModeloEscala(mA.getmEPri(), 160, 480, 720, 480, -24, false); 
					mudaPosMola(mA.getmM(), 19, 475);
					mudaPosObjeto(mA.getmO(), 120, 475);
					ModeloAmbiente.anguloInclinacaoGraus = -24;
					
					vps.getVisaoEscalaSec().setVisible(false);
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 2) {//Descida
					mudaModeloEscala(mA.getmEPri(), 160, 300, 710, 300, 24, false); 
					mudaPosMola(mA.getmM(), 40, 169);
					mudaPosObjeto(mA.getmO(), 140, 168);
					ModeloAmbiente.anguloInclinacaoGraus = 24;
					
					vps.getVisaoEscalaSec().setVisible(false);
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 3) {//Precipicio
					mudaModeloEscala(mA.getmEPri(), 160, 520, 700, 520, 0, true); 
					mudaPosMola(mA.getmM(), 30, 166);
					mudaPosObjeto(mA.getmO(), 130, 166);
					ModeloAmbiente.anguloInclinacaoGraus = 0;
					
					vps.getVisaoEscalaSec().setVisible(true);					
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 4) {//Queda
					mudaModeloEscala(mA.getmEPri(), 320, 123, 696, 123, 90, false);
					mudaPosObjeto(mA.getmO(), 361, 94);
					ModeloAmbiente.anguloInclinacaoGraus = 0;
					
					vps.getVisaoEscalaSec().setVisible(false);
				} else { //Projétil
					mudaModeloEscala(mA.getmEPri(), 160, 520, 700, 520, 0, false); 
					ModeloAmbiente.anguloInclinacaoGraus = 0;
					
					mudaModeloEscala(mA.getmESec(), 60, 100, 459, 100, 90, false);
					vps.getVisaoEscalaSec().setVisible(true);
				}
				vpi.repaint();
				vps.repaint();
				//Colocar o repaint no final do código evita repetições no código
			}
		});
	}
	
	//--Metodo utilizado para deteminar espacamento dos marcadores na escala
	public static int retornaPedaco(int inicio, int fim, int marcadores) {
		return (fim - inicio) / (marcadores + 1);
		/*
		 * Explicacao 'marcadores + 1'
		 * Se o numero de marcadores for 1, a linha (escala) tera de ser dividida em duas partes (1 mar + 1 = 2 partes)
		 * Se o numero de marcadores for 8, a linha (escala) tera de ser dividida em nove partes (8 mar + 1 = 9 partes)
		 */
	}
	
	//--Altera os valores do ModeloEscala
	private void mudaModeloEscala(ModeloEscala mE, int eIX, int eIY, int eFX, int eFY, double angulo, boolean isPEP) {
		mE.setEscalaFimXPix(eFX);
		mE.setEscalaFimYPix(eFY);
		mE.setEscalaInicioX(eIX);
		mE.setEscalaInicioY(eIY);
		mE.setAnguloRotacaoGraus(angulo);
		mE.setIsPEP(isPEP);
	}
	
	//--Altera os valores de posicionamento da propulsão-Mola
	private void mudaPosMola(ModeloMola mM, int posX, int posY) {
		mM.setPosX(posX);
		mM.setPosY(posY);
	}
	
	//--Altera os valores de posicionamento do objeto
	private void mudaPosObjeto(ModeloObjeto mO, int posX, int posY) {
		mO.setPosicaoXPx(posX);
		mO.setPosicaoYPx(posY);
	}
	
	//--Altera os valores dos marcadores das escalas
	public static void mudaMarcadores(int valorFinal) {
		ModeloEscala.marcadoresEscala[0] = valorFinal * 0.0;
		ModeloEscala.marcadoresEscala[1] = valorFinal * 0.2;
		ModeloEscala.marcadoresEscala[2] = valorFinal * 0.4;
		ModeloEscala.marcadoresEscala[3] = valorFinal * 0.6;
		ModeloEscala.marcadoresEscala[4] = valorFinal * 0.8;
		ModeloEscala.marcadoresEscala[5] = valorFinal * 1.0;
	}
}