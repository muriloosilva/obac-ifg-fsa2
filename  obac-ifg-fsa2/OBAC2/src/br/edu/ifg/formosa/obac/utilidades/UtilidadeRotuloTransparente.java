package br.edu.ifg.formosa.obac.utilidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;



public class UtilidadeRotuloTransparente extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;
	
	public UtilidadeRotuloTransparente(String text) {
		super(text, JLabel.LEFT);
		this.setForeground(Color.white);
		this.setFont(new Font("Arial", Font.BOLD, 11));
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height){
		// 1wdsx 
		super.setBounds(x, y, width, height);
		this.width = width;
		this.height = height;
	}
	
	public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Color ppColor = new Color(0, 0, 0, 0); //r,g,b,alpha
        g.setColor(ppColor);
        g.fillRect(0,0,width,height); //x,y,width,height
    }   

}
