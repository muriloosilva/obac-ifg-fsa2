package br.edu.ifg.formosa.obac.visao;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;

public class VisaoPropulsao extends JPanel {
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;
	
	//Vari�veis
	//--Modelos das propuls�es
	private ModeloAmbiente mA = null;
	//--Imagem exibida
	private ImageIcon imagemPropulsao = null;
	
	//Metodos
	//--Construtor
	public VisaoPropulsao(ModeloAmbiente mA) {
		super(null);
		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mA = mA;
		imagemPropulsao = mA.getmP().getModeloMola().getImagemMola();
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;		

		//g2d.translate(mA.getmP().getTranslaX(), mA.getmP().getTranslaY());
		g2d.rotate(Math.toRadians(mA.anguloInclinacaoGraus));
		//g2d.translate(-mA.getmP().getTranslaX(), -mA.getmP().getTranslaY());
		
		g2d.drawImage(imagemPropulsao.getImage(), mA.getmP().getModeloMola().getPosX(), mA.getmP().getModeloMola().getPosY(), this);
	}

	//Get e Set
	public ImageIcon getImagemPropulsao(){return imagemPropulsao;}
	public void setImagemPropulsao(ImageIcon imagemPropulsao){this.imagemPropulsao = imagemPropulsao;}
}