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
	
	//Metodos
	//--Construtor
	public VisaoSuperficie(VisaoPainelConfiguracao vPC, ModeloAmbiente mA) {
		super(null);
		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.vPC = vPC;
		this.mA = mA;

		//ImageIcon
		gravidade = new ImageIcon(mA.getUrlG());
		andaime = new ImageIcon(mA.getUrlA());
	}
	
	//--Paint
	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		switch (vPC.getCsAmbienteGravidade().getSelectedIndex()) {
			case 0:
				mA.setUrlG("terra");
				gravidade = new ImageIcon(mA.getUrlG());
				break;
			case 1:
				mA.setUrlG("lua");
				gravidade = new ImageIcon(mA.getUrlG());
				break;
			case 2:
				mA.setUrlG("marte");
				gravidade = new ImageIcon(mA.getUrlG());
				break;
		}
		g2d.drawImage(gravidade.getImage(), 0, 0, this);
		g2d.drawImage(andaime.getImage(), 0, 0, this);
	}
}