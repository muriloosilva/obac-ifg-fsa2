package br.edu.ifg.formosa.obac.controle.simulacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloMola;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControleSimulacao {	
	//Metodos
	//--Construtor
	public ControleSimulacao(final VisaoPainelInformacao vpi, final VisaoPainelSimulacao vps, final ModeloAmbiente mA, final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mPC) {		

		mudaMarcadores(mA.getmEH(), 100);
		
		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 0) { //Plano
					mudaModeloEscala(mA.getmEH(), 130, 520, 700, 520, 0, false); 
					mudaPosMola(mA.getmP().getModeloMola(), 30, 470);
					mudaPosObjeto(mA.getmO(), 130, 470);
					mudaMarcadores(mA.getmEH(), 100);
					
					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 1) {//Subida
					mudaModeloEscala(mA.getmEH(), -65, 500, 520, 500, -23.87, false);
					mudaPosMola(mA.getmP().getModeloMola(), -165, 440);
					mudaPosObjeto(mA.getmO(), -65, 440);
					mudaMarcadores(mA.getmEH(), 100);
					
					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 2) {//Descida
					mudaModeloEscala(mA.getmEH(), 214, 198, 799, 198, 23.87, false); 
					mudaPosMola(mA.getmP().getModeloMola(), 114, 138);
					mudaPosObjeto(mA.getmO(), 214, 138);
					mudaMarcadores(mA.getmEH(), 100);
					
					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 3) {//Precipicio
					mudaModeloEscala(mA.getmEH(), 160, 520, 700, 520, 0, true); 
					mudaPosMola(mA.getmP().getModeloMola(), 30, 166);
					mudaPosObjeto(mA.getmO(), 130, 166);
					mudaMarcadores(mA.getmEH(), 100);
					
					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel			
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 4) {//Queda
					mudaModeloEscala(mA.getmEV(), 320, 104, 320, 499, 0, false);
					mudaPosObjeto(mA.getmO(), 361, 104);
					mudaMarcadores(mA.getmEV(), 1000);
					
					vps.getVisaoEscalaH().setVisible(false); //Escala Horizontal fica invisível
					vps.getVisaoEscalaV().setVisible(true); //Escala Vertical fica visivel
				} else { //Projétil
					mudaModeloEscala(mA.getmEH(), 160, 520, 700, 520, 0, false);	
					mudaModeloEscala(mA.getmEV(), 70, 100, 70, 499, 0, false);
					
					mudaMarcadores(mA.getmEH(), 100);
					mudaMarcadores(mA.getmEV(), 100);
					
					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível		
					vps.getVisaoEscalaV().setVisible(true); //Escala Vertical fica visivel
				}
				vpi.repaint();
				vps.repaint();
			}
		});
	}
	
	//--Metodo utilizado para deteminar espacamento dos marcadores na escala
	public static int retornaPedaco(int inicio, int fim) {
		return (fim - inicio) / (ModeloEscala.qtdMarcadores + 1);
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
		
		ModeloAmbiente.anguloInclinacaoGraus = angulo;
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
	public static void mudaMarcadores(ModeloEscala mE, int valorFinal) {
		mE.getMarcadoresEscala()[0] = valorFinal * 0.2;
		mE.getMarcadoresEscala()[1] = valorFinal * 0.4;
		mE.getMarcadoresEscala()[2] = valorFinal * 0.6;
		mE.getMarcadoresEscala()[3] = valorFinal * 0.8;
		mE.getMarcadoresEscala()[4] = valorFinal * 1.0;
	}
}