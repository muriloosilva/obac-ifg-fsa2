package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class VisaoSuperficie extends JPanel {
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;

	//Metodos
	//--Construtor
	public VisaoSuperficie() {
		super(null);
		
		this.setSize(750, 600);
	}
	
	//--Paint
	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.white);
		g2d.fillRect(80, 80, 300, 200);
		
		g2d.setColor(Color.black);
		g2d.drawString("Este retangulo pertence a superficie", 80, 90);
	}
}