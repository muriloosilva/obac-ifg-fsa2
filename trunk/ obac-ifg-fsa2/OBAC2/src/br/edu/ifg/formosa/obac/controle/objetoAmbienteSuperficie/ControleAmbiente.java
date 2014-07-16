package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;

public class ControleAmbiente {
	//Métodos
	//--Construtor
	public void ControleAmbiente(final ModeloAmbiente mA, final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mPC) {
		vPC.getCsAmbienteGravidade().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (vPC.getCsAmbienteGravidade().getSelectedItem().equals(mPC.getGravidade()[0])) {
					mA.setGravidadeSel(0);
				} else if (vPC.getCsAmbienteGravidade().getSelectedItem().equals(mPC.getGravidade()[1])) {
					mA.setGravidadeSel(1);
				} else {
					mA.setGravidadeSel(2);
				}
			}
		});
	}
	
	//Método utilizado para mudar a imagem de fundo
	/*public static void mudaImagemFundo(ModeloAmbiente mA) {
		switch (mA.getmE().getEsca)
	}*/
}