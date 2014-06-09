package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class VisaoPainelSimulacao extends JPanel {
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;
	
	//Variaveis
	//--Superficie
	private VisaoSuperficie vS = null;
	//--Objeto
	private VisaoObjeto vO = null;
	//--Propulsao
	private VisaoPropulsao vP = null;
	//--Escala
	private VisaoEscala vE = null;
	
	//Metodos
	//--Construtor
	public VisaoPainelSimulacao() {
		super(null);
		
		this.setSize(750, 600);
		this.setLocation(250, 0);
		this.setBackground(Color.white);
		
		vS = new VisaoSuperficie();
		vO = new VisaoObjeto();
		vP = new VisaoPropulsao();
		vE = new VisaoEscala(100, 600, 564, 564, 5);
		
		this.add(vE);
		this.add(vP);
		this.add(vO);
		this.add(vS);
	}
}