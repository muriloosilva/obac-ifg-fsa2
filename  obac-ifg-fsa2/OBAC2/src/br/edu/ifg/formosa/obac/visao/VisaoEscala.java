package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
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
	public VisaoEscala() {
		super(null);		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		mE = new ModeloEscala();		
	}
	
	//--Construtor #02 - Inicio em X; Fim em X; Inicio em Y; Fim em Y; Quantidade de marcadores desejados
	public VisaoEscala(int eIX, int eFX, int eIY, int eFY, int qMarcadores, double angulo) {
		this();
		
		mE.setEscalaInicioX(eIX);
		mE.setEscalaFimX(eFX);
		
		mE.setEscalaInicioY(eIY);
		mE.setEscalaFimY(eFY);
		
		mE.setQtdMarcadores(qMarcadores);		
		mE.setEspacamentoMarcadores(ControleEscala.retornaPedaco(eIX, eFX, qMarcadores));
		
		mE.setAngulo(Math.toRadians(angulo));
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.translate(mE.getEscalaInicioX(), mE.getEscalaInicioY());
		g2d.rotate(mE.getAngulo());
		g2d.translate(-mE.getEscalaInicioX(), -mE.getEscalaInicioY());
		
		g2d.setColor(Color.black);
		g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaFimX(), mE.getEscalaFimY());
				
		g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaInicioX(), mE.getEscalaInicioY() + 15);
		g2d.drawLine(mE.getEscalaFimX(), mE.getEscalaFimY(), mE.getEscalaFimX(), mE.getEscalaFimY() + 15);

		//for -> desenha os marcadores
		for (int i=1;i<=mE.getQtdMarcadores();i++) {
			int auxiliar = mE.getEscalaInicioX() + (i * mE.getEspacamentoMarcadores());

			g2d.drawLine(auxiliar, mE.getEscalaInicioY(), auxiliar, mE.getEscalaInicioY() + 8);
		}		
	}
}