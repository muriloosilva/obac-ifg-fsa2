package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import br.edu.ifg.formosa.obac.principal.OBAC;

public class VisaoOBAC {

	public VisaoOBAC(OBAC obac) {
		
		obac.setSize(1000, 600);
		obac.setLayout(null);
		obac.setVisible(true);
	}
	
}