package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoSuperficie;

public class ControleAmbiente {
	//Métodos
	//--Construtor
	public ControleAmbiente(final ModeloAmbiente mA, final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mPC, final ControleOBAC cO) {
		vPC.getCsAmbienteGravidade().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mudaImagemFundo(vPC, mA);
				cO.repinta();
			}
		});
	}
	
	//Método utilizado para mudar a imagem de fundo
	public static void mudaImagemFundo(VisaoPainelConfiguracao vPC, ModeloAmbiente mA) {
		switch (vPC.getCsAmbienteGravidade().getSelectedIndex()) {
			case 0:
				mA.gravidadeSel = "terra";
				break;
			case 1:
				mA.gravidadeSel = "lua";
				break;
			case 2:
				mA.gravidadeSel = "marte";
				break;
		}
		
	}
}