package br.edu.ifg.formosa.obac.controle.propulsao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControlePropulsao {
	//M�todos
	//--Construtor
	public ControlePropulsao(VisaoPainelInformacao vPI, final VisaoPainelSimulacao vPS, final ModeloAmbiente mA,
							 final VisaoPainelConfiguracao vPC, ModeloPainelConfiguracao mPC, final ControleOBAC cOBAC) {
		
		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mudaPosProp(vPC, mA, cOBAC);
			}
		});
		
		vPC.getCsPropulsao().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				mudaPosProp(vPC, mA, cOBAC);
			}
		});
	}
	 //--Muda o posicionamento da propuls�o
	private void mudaPosProp(VisaoPainelConfiguracao vPC, ModeloAmbiente mA, ControleOBAC cOBAC) {
		switch (vPC.getCsAmbienteSimulacao().getSelectedIndex()) {
		case 0: //Plano
			if (vPC.getCsPropulsao().getSelectedIndex() == 0) {
				mA.getmP().setPosXProp(mA.getmP().getPosXC());
				mA.getmP().setPosYProp(mA.getmP().getPosYC());

				mA.getmP().setPosXBase(mA.getmP().getPosXB());
				mA.getmP().setPosYBase(mA.getmP().getPosYB());
			} else {
				mA.getmP().setPosXProp(mA.getmP().getPosXM());
				mA.getmP().setPosYProp(mA.getmP().getPosYM());						
			}
			break;
		case 1: //Subida
			if (vPC.getCsPropulsao().getSelectedIndex() == 0) {
				mA.getmP().setPosXProp(mA.getmP().getPosXC());
				mA.getmP().setPosYProp(mA.getmP().getPosYC() - 41);
				
				mA.getmP().setPosYBase(mA.getmP().getPosYB() - 33);
				mA.getmP().setPosXBase(mA.getmP().getPosXB() - 25);				
			} else {
				mA.getmP().setPosXProp(mA.getmP().getPosXM());		
				mA.getmP().setPosYProp(mA.getmP().getPosYM() - 40);					
			}					
			break;
		case 2: //Descida
			if (vPC.getCsPropulsao().getSelectedIndex() == 0) {
				mA.getmP().setPosXProp(mA.getmP().getPosXC());
				mA.getmP().setPosYProp(mA.getmP().getPosYC() - 6);
				
				mA.getmP().setPosYBase(mA.getmP().getPosYB() - 237);
				mA.getmP().setPosXBase(mA.getmP().getPosXB() + 80);			
			} else {
				mA.getmP().setPosXProp(mA.getmP().getPosXM());
				mA.getmP().setPosYProp(mA.getmP().getPosYM() - 3);					
			}
			break;
		case 3: //Precip�cio
			if (vPC.getCsPropulsao().getSelectedIndex() == 0) {
				mA.getmP().setPosXProp(mA.getmP().getPosXC());
				mA.getmP().setPosYProp(mA.getmP().getPosYC() - 307);
				
				mA.getmP().setPosYBase(mA.getmP().getPosYB() - 307);	
				mA.getmP().setPosXBase(mA.getmP().getPosXB());			
			} else {
				mA.getmP().setPosXProp(mA.getmP().getPosXM());
				mA.getmP().setPosYProp(mA.getmP().getPosYM() - 304);					
			}
			break;
		case 4: //Obl�quo
			mA.getmP().setPosXProp(mA.getmP().getPosXC() -65);
			mA.getmP().setPosYProp(mA.getmP().getPosYC());
			
			mA.getmP().setPosXBase(mA.getmP().getPosXB() - 65);	
			mA.getmP().setPosYBase(mA.getmP().getPosYB());
			
			break;
		}
		cOBAC.repinta();
	}
}