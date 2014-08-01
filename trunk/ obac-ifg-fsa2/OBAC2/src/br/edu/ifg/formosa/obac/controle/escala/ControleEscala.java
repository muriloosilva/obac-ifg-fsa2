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
	private ModeloEscala mE = null;
	
	//Metodos
	//--Construtor
	public ControleEscala(final VisaoPainelInformacao vpi, final VisaoPainelSimulacao vps,  final VisaoEscala vE, final ModeloAmbiente mA, final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mPC) {		
		this.mE = mA.getmE();	

		mudaMarcadores(50);
		
		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 0) { //Plano
					mudaModeloEscala(mA.getmE(), 160, 520, 700, 520, 0, false); 
					mudaPosMola(mA.getmM(), 30, 470);
					mudaPosObjeto(mA.getmO(), 130, 470);
					
					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 1) {//Subida
					mudaModeloEscala(mA.getmE(), 160, 480, 720, 480, -24, false); 
					mudaPosMola(mA.getmM(), 19, 475);
					mudaPosObjeto(mA.getmO(), 120, 475);
					
					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 2) {//Descida
					mudaModeloEscala(mA.getmE(), 160, 300, 710, 300, 24, false); 
					mudaPosMola(mA.getmM(), 40, 169);
					mudaPosObjeto(mA.getmO(), 140, 168);
					
					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 3) {//Precipicio
					mudaModeloEscala(mA.getmE(), 160, 520, 700, 520, 0, true); 
					mudaPosMola(mA.getmM(), 30, 166);
					mudaPosObjeto(mA.getmO(), 130, 166);
					
					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel			
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 4) {//Queda
					mudaModeloEscala(mA.getmE(), 320, 123, 696, 123, 0, false);
					mudaPosObjeto(mA.getmO(), 361, 94);
					
					vps.getVisaoEscalaH().setVisible(false); //Escala Horizontal fica invisível
					vps.getVisaoEscalaV().setVisible(true); //Escala Vertical fica visivel
				} else { //Projétil
					mudaModeloEscala(mA.getmE(), 160, 520, 700, 520, 0, false); 
					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					
					mudaModeloEscala(mA.getmE(), 60, 100, 459, 100, 0, false);					
					vps.getVisaoEscalaV().setVisible(true); //Escala Vertical fica visivel
				}
				vpi.repaint();
				vps.repaint();
				//Colocar o repaint no final do código evita repetições no código
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
	public static void mudaMarcadores(int valorFinal) {
		ModeloEscala.marcadoresEscala[0] = valorFinal * 0.0;
		ModeloEscala.marcadoresEscala[1] = valorFinal * 0.2;
		ModeloEscala.marcadoresEscala[2] = valorFinal * 0.4;
		ModeloEscala.marcadoresEscala[3] = valorFinal * 0.6;
		ModeloEscala.marcadoresEscala[4] = valorFinal * 0.8;
		ModeloEscala.marcadoresEscala[5] = valorFinal * 1.0;
	}
}