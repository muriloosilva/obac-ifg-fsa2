package br.edu.ifg.formosa.obac.visao;

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
		
		vS = new VisaoSuperficie();
		vO = new VisaoObjeto();
		vP = new VisaoPropulsao();
		vE = new VisaoEscala();
		
		this.add(vE);
		this.add(vP);
		this.add(vO);
		this.add(vS);
	}
}