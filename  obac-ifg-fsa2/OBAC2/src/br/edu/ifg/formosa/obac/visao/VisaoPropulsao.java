package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPropulsao;

public class VisaoPropulsao extends JPanel {
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;
	
	//Variáveis
	//--Modelos das propulsões
	private ModeloAmbiente mA = null;
	//--Imagem exibida
	private ImageIcon imagemPropulsao = null;
	//--Posições iniciais da propulção
	private int posIniXProp=30, posIniYProp=470;
	
	//Metodos
	//--Construtor
	public VisaoPropulsao(ModeloAmbiente mA) {
		super(null);
		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mA = mA;
		imagemPropulsao = mA.getmP().getImagemMola();
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;		

		g2d.translate(posIniXProp, posIniYProp);
		g2d.rotate(Math.toRadians(mA.anguloInclinacaoGraus));
		g2d.translate(-posIniXProp, -posIniYProp);
		
		g2d.drawImage(imagemPropulsao.getImage(), posIniXProp, posIniYProp, this);
	}

	//Get e Set
	public ImageIcon getImagemPropulsao(){return imagemPropulsao;}
	public void setImagemPropulsao(ImageIcon imagemPropulsao){this.imagemPropulsao = imagemPropulsao;}
	public void setPosicoes(int posIniXProp, int posIniYProp){this.posIniXProp=posIniXProp; this.posIniYProp=posIniYProp;}
	public int getPosIniXProp(){return posIniXProp;}
	public int getPosIniYProp(){return posIniYProp;}
}