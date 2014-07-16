package br.edu.ifg.formosa.obac.visao;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;

public class VisaoSuperficie extends JPanel {
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;

	//Variaveis
	//--ImageIcon
	private ImageIcon gravidade = null;
	private ImageIcon andaime = null;
	private ImageIcon superficie = null;
	//--URL
	public static URL urlG = null;
	public static URL urlA = null;
	public static URL urlS = null;	
	
	//Metodos
	//--Construtor
	public VisaoSuperficie() {
		super(null);
		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		//URL
		urlG = this.getClass().getClassLoader().getResource(ModeloAmbiente.modeloURL + "ambiente/" + ModeloAmbiente.gravidadeSel + ".png");
		urlA = this.getClass().getClassLoader().getResource(ModeloAmbiente.modeloURL + "andaimes/" + ModeloAmbiente.andaimeSel + ".png");

		//ImageIcon
		gravidade = new ImageIcon(urlG);
		andaime = new ImageIcon(urlA);
	}
	
	//--Paint
	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(gravidade.getImage(), 0, 0, this);
		g2d.drawImage(andaime.getImage(), 0, 0, this);
		//g2d.drawImage(superficie.getImage(), 0, 0, this);
	}
}