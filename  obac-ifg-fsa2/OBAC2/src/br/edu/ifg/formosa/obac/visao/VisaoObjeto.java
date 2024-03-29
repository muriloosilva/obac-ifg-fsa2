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
	//--Visao
	private VisaoPainelConfiguracao vPC = null;
	
	//Metodos
	//--Construtor
	public VisaoObjeto(ModeloAmbiente mA, VisaoPainelConfiguracao vPC) {
		super(null);
		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mA = mA;
		this.vPC = vPC;
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.blue);
		
		if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 4) {
			g2d.rotate(Math.toRadians(mA.anguloInclinacaoGraus), 0, 0);
			g2d.fillOval(mA.getmO().getPosicaoXPx(), mA.getmO().getPosicaoYPx(), ModeloObjeto.alturaLargura, ModeloObjeto.alturaLargura);
		}
		else {
			g2d.rotate(Math.toRadians(mA.anguloInclinacaoGraus), mA.getTranslateX(), mA.getTranslateY());
			g2d.fillRect(mA.getmO().getPosicaoXPx(), mA.getmO().getPosicaoYPx(), ModeloObjeto.alturaLargura, ModeloObjeto.alturaLargura);
		}		
	}
}
