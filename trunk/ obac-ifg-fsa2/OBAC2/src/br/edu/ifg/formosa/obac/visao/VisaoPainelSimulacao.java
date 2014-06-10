package br.edu.ifg.formosa.obac.visao;

import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.modelo.ModeloEscala;

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
	public VisaoPainelSimulacao(ModeloEscala mE) {
		super(null);
		
		this.setSize(750, 600);
		this.setLocation(250, 0);
		
		vS = new VisaoSuperficie();
		vO = new VisaoObjeto();
		vP = new VisaoPropulsao();
		vE = new VisaoEscala(mE);
		
		this.add(vE);
		this.add(vP);
		this.add(vO);
		this.add(vS);
	}
	
	//--Getters
	public VisaoEscala getVisaoEscala() {return vE;}
}