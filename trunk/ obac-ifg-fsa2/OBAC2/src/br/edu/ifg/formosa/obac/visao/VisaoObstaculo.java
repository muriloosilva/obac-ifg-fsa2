package br.edu.ifg.formosa.obac.visao;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;

public class VisaoObstaculo extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon imagemObstaculo = null;

	//--Modelos das propulsões
	private ModeloAmbiente mA = null;

	public VisaoObstaculo(ModeloAmbiente mA){

		super(null);
		this.setSize(750, 600);
		this.setOpaque(true);

		this.mA = mA;
		imagemObstaculo = mA.getmObs().getImagemObstaculo();
		
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
			
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(imagemObstaculo.getImage(), mA.getmObs().getPosicaoXPx(), mA.getmObs().getPosicaoYPx(), this);
	}
}
