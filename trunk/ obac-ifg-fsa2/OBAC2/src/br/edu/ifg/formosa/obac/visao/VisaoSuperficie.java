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
	//--VisaoPainelConfiguracao
	private VisaoPainelConfiguracao vPC = null;
	
	//--ModeloAmbiente
	private ModeloAmbiente mA = null;
		
	//--ImageIcon
	private ImageIcon gravidade = null;
	private ImageIcon andaime = null;
	private ImageIcon superficie = null;
	private ImageIcon guindaste = null;
	
	//Metodos
	//--Construtor
	public VisaoSuperficie(VisaoPainelConfiguracao vPC, ModeloAmbiente mA) {
		super(null);
		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.vPC = vPC;
		this.mA = mA;

		//ImageIcon
		gravidade = new ImageIcon(mA.getUrlGr());
		andaime = new ImageIcon(mA.getUrlA());
		guindaste = new ImageIcon(mA.getUrlGu());
	}
	
	//--Paint
	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		switch (vPC.getCsAmbienteGravidade().getSelectedIndex()) {
			case 0:
				mA.setUrlGr("terra");
				gravidade = new ImageIcon(mA.getUrlGr());
				break;
			case 1:
				mA.setUrlGr("lua");
				gravidade = new ImageIcon(mA.getUrlGr());
				break;
			case 2:
				mA.setUrlGr("marte");
				gravidade = new ImageIcon(mA.getUrlGr());
				break;
		}
		
		switch (vPC.getCsAmbienteSimulacao().getSelectedIndex()) {
			case 0: //Plano
				mA.setUrlA("plano");
				andaime = new ImageIcon(mA.getUrlA());
				break;
			case 1: //Subida
				mA.setUrlA("subida");
				andaime = new ImageIcon(mA.getUrlA());
				break;
			case 2: //Descida
				mA.setUrlA("descida");
				andaime = new ImageIcon(mA.getUrlA());
				break;
			case 3: //P&P
				mA.setUrlA("precipicio");
				andaime = new ImageIcon(mA.getUrlA());
				break;
			case 4: //Queda
				mA.setUrlA("plano");
				andaime = new ImageIcon(mA.getUrlA());
				
				if (!vPC.getBaNovaSimulacao().isVisible()) 
					mA.setUrlGu("guindasteF");
				else
					mA.setUrlGu("guindasteA");
				
				guindaste = new ImageIcon(mA.getUrlGu());
				break;
			case 5: //Projétil
				mA.setUrlA("plano");
				andaime = new ImageIcon(mA.getUrlA());
				break;
		}
		g2d.drawImage(gravidade.getImage(), 0, 0, this);
		g2d.drawImage(andaime.getImage(), 0, 0, this);
		if (vPC.getCsAmbienteSimulacao().getSelectedIndex() == 4) 
			g2d.drawImage(guindaste.getImage(), 0, 0, this);
	}
}