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
	public VisaoEscala() {
		super(null);		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		mE = new ModeloEscala();		
	}
	
	//Plano - Tipo de Simulacao(0); Inicio em X; Fim em X; Inicio em Y; Fim em Y;
	public VisaoEscala(int zero, int eIX, int eFX, int eIY, int eFY) {
		this();
		mE.setTipoSimulacao(zero);
		
		mE.setEscalaInicioX(eIX);
		mE.setEscalaFimX(eFX);
		
		mE.setEscalaInicioY(eIY);
		mE.setEscalaFimY(eFY);
		
		mE.setMetadeEscala(ControleEscala.retornaMetade(eIX, eFX));
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.black);
		
		switch (mE.getTipoSimulacao()) {
			case 0: //Plano
				g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaFimX(), mE.getEscalaFimY());
				
				g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaInicioX(), mE.getEscalaInicioY() + 10);
				g2d.drawLine(mE.getMetadeEscala(), mE.getEscalaInicioY(), mE.getMetadeEscala(), mE.getEscalaInicioY() + 5);
				g2d.drawLine(mE.getEscalaFimX(), mE.getEscalaInicioY(), mE.getEscalaFimX(), mE.getEscalaInicioY() + 10);
				break;
			default:
				break;
		}
	}
}