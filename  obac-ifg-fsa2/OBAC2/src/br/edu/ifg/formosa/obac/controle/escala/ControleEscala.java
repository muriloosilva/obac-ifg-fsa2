package br.edu.ifg.formosa.obac.controle.escala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControleEscala {
	//Metodos
	//--Construtor
	public ControleEscala(final VisaoPainelInformacao vpi, final VisaoPainelSimulacao vps,  final VisaoEscala vE, final ModeloAmbiente mA, final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mPC) {		
		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 0) { //Plano
					mudaModeloEscala(mA.getmEPri(), 100, 564, 700, 564, 5, 0);
					
					vps.getVisaoEscalaSec().setVisible(false); //Escala secundaria fica invisivel
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 1) {//Subida
					mudaModeloEscala(mA.getmEPri(), 100, 564, 750, 564, 5, -27.5);
					
					vps.getVisaoEscalaSec().setVisible(false);
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 2) {//Descida
					mudaModeloEscala(mA.getmEPri(), 100, 100, 750, 100, 5, 27.5);
					
					vps.getVisaoEscalaSec().setVisible(false);
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 3) {//Precipicio
					mudaModeloEscala(mA.getmEPri(), 100, 564, 700, 564, 5, 0);
					
					mudaModeloEscala(mA.getmESec(), 10, 300, 296, 300, 2, 0);
					vps.getVisaoEscalaSec().setVisible(true); //Escala secundaria fica visivel
				} else if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 4) {//Queda
					mudaModeloEscala(mA.getmEPri(), 100, 100, 500, 100, 5, 90);
					
					vps.getVisaoEscalaSec().setVisible(false);
				} else { //Projétil
					mudaModeloEscala(mA.getmEPri(), 100, 564, 700, 564, 5, 0);
					
					mudaModeloEscala(mA.getmESec(), 100, 100, 500, 100, 5, 90);
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
	private void mudaModeloEscala(ModeloEscala mE, int eIX, int eIY, int eFX, int eFY, int qMarcadores, double angulo) {
		mE.setAngulo(angulo);
		mE.setEscalaFimXPix(eFX);
		mE.setEscalaFimYPix(eFY);
		mE.setEscalaInicioX(eIX);
		mE.setEscalaInicioY(eIY);
		mE.setQtdMarcadores(qMarcadores);
	}
}