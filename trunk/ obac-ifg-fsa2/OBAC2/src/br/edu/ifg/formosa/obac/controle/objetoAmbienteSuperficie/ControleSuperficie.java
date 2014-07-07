package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.modelo.ModeloSuperficie;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;

public class ControleSuperficie {
	//Métodos
	//--Construtor
	public ControleSuperficie(final ModeloSuperficie mS, final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mPC) {
		vPC.getCsAmbienteAtrito().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vPC.getCsAmbienteAtrito().getSelectedItem().equals(mPC.getAtritos()[0])) {
					mS.setSuperficieSelecionada(0);
				} else if (vPC.getCsAmbienteAtrito().getSelectedItem().equals(mPC.getAtritos()[1])) {
					mS.setSuperficieSelecionada(1);
				} else {
					mS.setSuperficieSelecionada(2);
				}
			}
		});
	}
}