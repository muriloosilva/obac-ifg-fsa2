package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class VisaoPropulsao extends JPanel {
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;
	
	//Metodos
	//--Construtor
	public VisaoPropulsao() {
		super(null);
		
		this.setSize(750, 600);
		this.setOpaque(true);
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.red);
		g2d.fillRect(160, 160, 300, 200);
		
		g2d.setColor(Color.black);
		g2d.drawString("Este retangulo pertence a propulsao", 160, 170);
	}
}