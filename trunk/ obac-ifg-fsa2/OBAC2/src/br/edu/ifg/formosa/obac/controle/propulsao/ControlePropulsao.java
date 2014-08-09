package br.edu.ifg.formosa.obac.controle.propulsao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControlePropulsao {
	//Métodos
	//--Construtor
	public ControlePropulsao(VisaoPainelInformacao vPI, VisaoPainelSimulacao vPS, final ModeloAmbiente mA,
							 final VisaoPainelConfiguracao vPC, ModeloPainelConfiguracao mPC) {
		
		vPC.getCsPropulsao().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (vPC.getCsPropulsao().getSelectedIndex()) {
				case 0:
					break;
				case 1:
					break;
				}
			}
		});
	}
}