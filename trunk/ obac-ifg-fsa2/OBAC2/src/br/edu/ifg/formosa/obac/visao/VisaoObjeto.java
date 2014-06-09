package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class VisaoObjeto extends JPanel {
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;
	
	//Metodos
	//--Construtor
	public VisaoObjeto() {
		super(null);
		
		this.setSize(750, 600);
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.yellow);
		g2d.fillRect(120, 120, 300, 200);
		
		g2d.setColor(Color.black);
		g2d.drawString("Este retangulo pertence ao objeto", 120, 130);
	}
}
