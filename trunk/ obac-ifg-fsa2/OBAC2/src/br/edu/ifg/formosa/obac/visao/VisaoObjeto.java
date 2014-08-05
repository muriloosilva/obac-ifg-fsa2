package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;

public class VisaoObjeto extends JPanel {
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;
	
	//Variáveis
	//--ModeloAmbiente
	private ModeloAmbiente mA = null;
	
	//Metodos
	//--Construtor
	public VisaoObjeto(ModeloAmbiente mA) {
		super(null);
		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mA = mA;
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.translate(mA.getmP().getTranslaX(), mA.getmP().getTranslaY());
		g2d.rotate(Math.toRadians(ModeloAmbiente.anguloInclinacaoGraus));
		g2d.translate(-mA.getmP().getTranslaX(), -mA.getmP().getTranslaY());
		
		g2d.setColor(Color.blue);
		g2d.fillRect(mA.getmO().getPosicaoXPx(), mA.getmO().getPosicaoYPx(), ModeloObjeto.alturaLargura, ModeloObjeto.alturaLargura);
	}
}
