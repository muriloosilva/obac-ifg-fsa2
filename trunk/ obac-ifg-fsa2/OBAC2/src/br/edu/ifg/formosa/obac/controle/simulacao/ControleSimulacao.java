package br.edu.ifg.formosa.obac.controle.simulacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeArredondamento;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControleSimulacao {

	//Metodos
	//--Construtor
	public ControleSimulacao(final VisaoPainelInformacao vpi, final VisaoPainelSimulacao vps, final ModeloAmbiente mA, 
			final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mPC, final ControleOBAC cOBAC) {
		mudaMarcadores(mA.getmEH(), 100);

		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (vPC.getCsAmbienteSimulacao().getSelectedIndex()) {
				case 0://Plano
					mudaModeloEscala(mA.getmEH(), 130, 520, 700, 520); 
					mudaAngulo(mA, 0, false);
					mudaTranslate(mA, 0, 0);
					mudaPosObjeto(mA.getmO(), ModeloObjeto.pXPadPx, ModeloObjeto.pPlaYPx);
					mudaMarcadores(mA.getmEH(), 100);

					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel
					break;
				case 1: //Subida
					mudaModeloEscala(mA.getmEH(), 130, 490, 700, 490);
					mudaAngulo(mA, -23.87, false);
					mudaTranslate(mA, 130, 490);
					mudaPosObjeto(mA.getmO(), ModeloObjeto.pXPadPx, ModeloObjeto.pSubYPx);
					mudaMarcadores(mA.getmEH(), 100);

					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel
					break;
				case 2: //Descida
					mudaModeloEscala(mA.getmEH(), 130, 520, 700, 520);
					mudaAngulo(mA, 23.87, false);
					mudaTranslate(mA, 700, 520);
					mudaPosObjeto(mA.getmO(), ModeloObjeto.pXPadPx, ModeloObjeto.pDesYPx);
					mudaMarcadores(mA.getmEH(), 100);

					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(false); //Escala Vertical fica invisivel
					break;
				case 3: //Precipicio
					mudaModeloEscala(mA.getmEH(), 130, 520, 700, 520);
					mudaModeloEscala(mA.getmEV(), 70, 166, 70, 600);
					mudaAngulo(mA, 0, false);
					mudaTranslate(mA, 0, 0);
					mudaPosObjeto(mA.getmO(), ModeloObjeto.pXPadPx, ModeloObjeto.pPepYPx);
					mudaMarcadores(mA.getmEH(), 100);
					mudaMarcadores(mA.getmEV(), 1000);

					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível
					vps.getVisaoEscalaV().setVisible(true); //Escala Vertical fica invisivel
					break;
				case 4: //Projétil
					mudaModeloEscala(mA.getmEH(), 80, 497, 700, 497);	
					mudaModeloEscala(mA.getmEV(), 80, 497, 80, 100);

					mudaAngulo(mA, 0, true); //Ambos são necessários para não dar nenhum bug
					mudaAngulo(mA, mA.getmP().getAnguloRotacaoGraus(), true);

					mudaTranslate(mA, 80, 485);
					mudaPosObjeto(mA.getmO(), ModeloObjeto.pOblXPx, ModeloObjeto.pOblYPx);

					mudaMarcadores(mA.getmEH(), 100);
					mudaMarcadores(mA.getmEV(), 100);

					vps.getVisaoEscalaH().setVisible(true); //Escala Horizontal fica visível		
					vps.getVisaoEscalaV().setVisible(true); //Escala Vertical fica visivel
					break;
				case 5://Queda
					mudaModeloEscala(mA.getmEV(), 320, 496, 320, 134);
					mudaAngulo(mA, 0, false);
					mudaTranslate(mA, 0, 0);
					mudaPosObjeto(mA.getmO(), ModeloObjeto.pQueXPx, ModeloObjeto.pQueYPx);
					mudaMarcadores(mA.getmEV(), 1000);

					vps.getVisaoEscalaH().setVisible(false); //Escala Horizontal fica invisível
					vps.getVisaoEscalaV().setVisible(true); //Escala Vertical fica visivel
					break;
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

	//--Altera os valores do translate
	private void mudaTranslate(ModeloAmbiente mA, int tX, int tY) {
		mA.setTranslateX(tX);
		mA.setTranslateY(tY);
	}

	//--Altera os valores do ModeloEscala
	private void mudaModeloEscala(ModeloEscala mE, int eIX, int eIY, int eFX, int eFY) {
		mE.setEscalaFimXPix(eFX);
		mE.setEscalaFimYPix(eFY);
		mE.setEscalaInicioX(eIX);
		mE.setEscalaInicioY(eIY);		
	}

	//Altera o valor do angulo
	private void mudaAngulo(ModeloAmbiente mA, double angulo, boolean isProjetil) {
		mA.getmP().setAnguloRotacaoGraus(angulo);
		if (!isProjetil)
			ModeloAmbiente.anguloInclinacaoGraus = angulo;
		else
			ModeloAmbiente.anguloInclinacaoGraus = 0;
	}

	//--Altera os valores de posicionamento do objeto
	private void mudaPosObjeto(ModeloObjeto mO, int posX, int posY) {
		mO.setPosicaoXPx(posX);
		mO.setPosicaoYPx(posY);
	}

	//--Altera os valores dos marcadores das escalas
	public static void mudaMarcadores(ModeloEscala mE, int valorFinal) {
		mE.getMarcadoresEscala()[0] = UtilidadeArredondamento.arredondamento(2, valorFinal * 0.2);
		mE.getMarcadoresEscala()[1] = UtilidadeArredondamento.arredondamento(2, valorFinal * 0.4);
		mE.getMarcadoresEscala()[2] = UtilidadeArredondamento.arredondamento(2, valorFinal * 0.6);
		mE.getMarcadoresEscala()[3] = UtilidadeArredondamento.arredondamento(2, valorFinal * 0.8);
		mE.getMarcadoresEscala()[4] = UtilidadeArredondamento.arredondamento(2, valorFinal * 1.0);
	}
}