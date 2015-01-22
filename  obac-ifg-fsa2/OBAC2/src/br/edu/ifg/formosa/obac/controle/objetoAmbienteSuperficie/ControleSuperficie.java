package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.modelo.ModeloSuperficie;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;

public class ControleSuperficie {
	//Métodos
	//--Construtor
	public ControleSuperficie(
			final ModeloSuperficie mS, final VisaoPainelConfiguracao vPC,
			final ModeloPainelConfiguracao mPC, final ControleOBAC cOBAC)
	{
		
		vPC.getCsAmbienteAtrito().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(vPC.getCsAmbienteAtrito().getSelectedIndex()) {
					case 0:
						mS.setCoefAtritoSelecionado(ModeloSuperficie.atritoAsfalto);
						break;
					case 1:
						mS.setCoefAtritoSelecionado(ModeloSuperficie.atritoAluminio);
						break;
					case 2:
						mS.setCoefAtritoSelecionado(ModeloSuperficie.atritoMadeira);
						
				}
				cOBAC.repinta();
			}
		});
	}
}