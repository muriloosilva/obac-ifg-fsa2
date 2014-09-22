package br.edu.ifg.formosa.obac.controle.propulsao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControleCanhaoMouse {
	//Variáveis
	//--Modelo
	private ModeloAmbiente mA = null;
	//--Visao
	private VisaoPainelSimulacao vPS = null;
	private VisaoPainelConfiguracao vPC = null;
	//--MouseListener, MouseMotionListener
	private ControleCanhaoListeners cCML = null;
	
	public ControleCanhaoMouse(ModeloAmbiente mA, final VisaoPainelSimulacao vPS, final VisaoPainelConfiguracao vPC, ControleOBAC cOBAC) {
		this.mA = mA;
		this.vPS = vPS;
		this.vPC = vPC;
		
		cCML = new ControleCanhaoListeners(vPS.getVisaoPropulsao(), mA, cOBAC, vPC);
		
		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) { 
				if(vPC.getCsAmbienteSimulacao().getSelectedIndex() == 5) {
					vPS.getVisaoPropulsao().addMouseListener(cCML);
					vPS.getVisaoPropulsao().addMouseMotionListener(cCML);
					System.out.println("Chamando thread");
					cCML.setRodaT(true);
				} else {
					vPS.getVisaoPropulsao().removeMouseListener(cCML);
					vPS.getVisaoPropulsao().removeMouseMotionListener(cCML);
					System.out.println("Chamando de novo thread");
					cCML.setRodaT(false);
				}					
			}
		});
	}
	
}