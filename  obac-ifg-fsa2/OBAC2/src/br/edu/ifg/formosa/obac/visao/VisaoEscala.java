package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.controle.escala.ControleEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;

public class VisaoEscala extends JPanel{
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;
	
	//Variaveis
	//--ModeloEscala
	private ModeloEscala mE = null;
	
	//Metodos
	//--Construtor #01
	public VisaoEscala(ModeloEscala mE) {
		super(null);		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mE = mE;
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.translate(mE.getEscalaInicioX(), mE.getEscalaInicioY());
		g2d.rotate(Math.toRadians(mE.getAngulo()));
		g2d.translate(-mE.getEscalaInicioX(), -mE.getEscalaInicioY());
		
		mE.setEspacamentoMarcadores(ControleEscala.retornaPedaco(mE.getEscalaInicioX(), mE.getEscalaFimXPix(), mE.getQtdMarcadores()));
		
		g2d.setColor(Color.white);
		g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaFimXPix(), mE.getEscalaFimYPix());
				
		g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaInicioX(), mE.getEscalaInicioY() + 15);
		g2d.drawLine(mE.getEscalaFimXPix(), mE.getEscalaFimYPix(), mE.getEscalaFimXPix(), mE.getEscalaFimYPix() + 15);

		//for -> desenha os marcadores
		for (int i=1;i<=mE.getQtdMarcadores();i++) {
			int auxiliar = mE.getEscalaInicioX() + (i * mE.getEspacamentoMarcadores());

			g2d.drawLine(auxiliar, mE.getEscalaInicioY(), auxiliar, mE.getEscalaInicioY() + 8);
		}		
	}
}