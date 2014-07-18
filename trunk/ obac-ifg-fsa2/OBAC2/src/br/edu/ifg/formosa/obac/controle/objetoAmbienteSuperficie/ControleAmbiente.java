package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.principal.OBAC;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoSuperficie;

public class ControleAmbiente {
	//Métodos
	//--Construtor
	public ControleAmbiente(final ModeloAmbiente mA, final VisaoPainelConfiguracao vPC, final ModeloPainelConfiguracao mPC, final ControleOBAC cO, final VisaoSuperficie vS) {
		vPC.getCsAmbienteGravidade().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (vPC.getCsAmbienteGravidade().getSelectedIndex()) { //Determina qual a imagem de fundo
					case 0:
						mA.setUrlGr("terra");
						break;
					case 1:
						mA.setUrlGr("lua");
						break;
					case 2:
						mA.setUrlGr("marte");
						break;
				}
				mudaImagem(cO, vS, mA);
			}
		});
		
		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() { //Determina o guindaste de acordo com a simulação
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (vPC.getCsAmbienteSimulacao().getSelectedIndex()) {
					case 0: //Plano
						mA.setUrlA("plano");
						break;
					case 1: //Subida
						mA.setUrlA("subida");
						break;
					case 2: //Descida
						mA.setUrlA("descida");
						break;
					case 3: //P&P
						mA.setUrlA("precipicio");
						break;
					case 4: //Queda
						mA.setUrlA("plano");
						
						if (!vPC.getBaNovaSimulacao().isVisible()) 
							mA.setUrlGu("guindasteF");
						else
							mA.setUrlGu("guindasteA");
						
						break;
					case 5: //Projétil
						mA.setUrlA("plano");
						break;
				}
				mudaImagem(cO, vS, mA);
			}
		});
	}
	
	//--Muda imagem fundo
	public void mudaImagem(ControleOBAC cO, VisaoSuperficie vS, ModeloAmbiente mA) {
		vS.novasImagens(mA.getUrlGr(), mA.getUrlA(), mA.getUrlGu());
		cO.repinta();
	}
}