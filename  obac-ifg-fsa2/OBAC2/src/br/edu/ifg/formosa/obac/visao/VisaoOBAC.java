package br.edu.ifg.formosa.obac.visao;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import br.edu.ifg.formosa.obac.principal.OBAC;

public class VisaoOBAC {

	public VisaoOBAC(OBAC obac) {
		
		obac.setSize(1000, 600);
		obac.setLayout(null);
		obac.setVisible(true);
		
	}
	
}