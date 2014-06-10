package br.edu.ifg.formosa.obac.controle.escala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.principal.OBAC;
import br.edu.ifg.formosa.obac.visao.VisaoEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;

public class ControleEscala {
	//Metodos
	//--Construtor
	public ControleEscala(final OBAC obac, final VisaoEscala vE, final ModeloEscala mE, final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mPC) {		
		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (vPC.getCsAmbienteSimulacao().getSelectedItem().equals(mPC.getSimulacoesPadrao()[0])) { //Plano
					mudaModeloEscala(mE, 100, 564, 700, 564, 5, 0);
				} else if (vPC.getCsAmbienteSimulacao().getSelectedItem().equals(mPC.getSimulacoesPadrao()[1])) {//Descida
					mudaModeloEscala(mE, 100, 564, 750, 564, 5, -45);
				} else if (vPC.getCsAmbienteSimulacao().getSelectedItem().equals(mPC.getSimulacoesPadrao()[2])) {//Subida
					mudaModeloEscala(mE, 100, 100, 750, 100, 5, 45);
				} else if (vPC.getCsAmbienteSimulacao().getSelectedItem().equals(mPC.getSimulacoesPadrao()[3])) {//Precipicio
					mudaModeloEscala(mE, 100, 564, 700, 564, 5, 0);
				} else if (vPC.getCsAmbienteSimulacao().getSelectedItem().equals(mPC.getSimulacoesPadrao()[4])) {//Queda
					mudaModeloEscala(mE, 100, 100, 500, 100, 5, 90);
				}
				obac.repaint(); //da um 'glitch' no obac. buscar alternativa
				//economiza linhas se estiver embaixo dos ifs
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
		mE.setEscalaFimX(eFX);
		mE.setEscalaFimY(eFY);
		mE.setEscalaInicioX(eIX);
		mE.setEscalaInicioY(eIY);
		mE.setQtdMarcadores(qMarcadores);
	}
}