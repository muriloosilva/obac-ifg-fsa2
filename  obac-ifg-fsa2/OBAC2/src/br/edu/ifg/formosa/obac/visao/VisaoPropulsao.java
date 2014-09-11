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
	
	//Variáveis
	//--Modelos das propulsões
	private ModeloAmbiente mA = null;
	//--Imagem exibida
	private ImageIcon imagemPropulsao = null;
	//--VisaoPainelConfiguracao
	private VisaoPainelConfiguracao vPC = null;
	
	//Metodos
	//--Construtor
	public VisaoPropulsao(ModeloAmbiente mA, VisaoPainelConfiguracao vPC) {
		super(null);
		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mA = mA;
		this.vPC = vPC;
		
		imagemPropulsao = mA.getmP().getImagemPropulsao();
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;		

		g2d.translate(700, 520);
		g2d.rotate(Math.toRadians(mA.anguloInclinacaoGraus));
		g2d.translate(-700, -520);
		
		g2d.drawImage(imagemPropulsao.getImage(), mA.getmP().getPosXProp(), mA.getmP().getPosYProp(), this);
	}

	//Get e Set
	public ImageIcon getImagemPropulsao(){return imagemPropulsao;}
	public void setImagemPropulsao(ImageIcon imagemPropulsao){this.imagemPropulsao = imagemPropulsao;}
}