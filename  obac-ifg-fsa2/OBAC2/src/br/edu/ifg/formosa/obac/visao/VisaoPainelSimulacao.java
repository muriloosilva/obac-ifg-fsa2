package br.edu.ifg.formosa.obac.visao;

import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;

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
	private VisaoEscala vEPri = null;
	private VisaoEscala vESec = null;
	
	//Metodos
	//--Construtor
	public VisaoPainelSimulacao(ModeloAmbiente mA) {
		super(null);
		
		this.setSize(750, 600);
		this.setLocation(250, 0);
		
		vS = new VisaoSuperficie();
		vO = new VisaoObjeto();
		vP = new VisaoPropulsao();
		vEPri = new VisaoEscala(mA.getmEPri());
		vESec = new VisaoEscala(mA.getmESec());
		
		this.add(vEPri);
		this.add(vESec);
		this.add(vP);
		this.add(vO);
		this.add(vS);
		
		vESec.setVisible(false); //A escala sec. só aparece no Projetil e no P&P
	}
	
	//--Getters
	public VisaoEscala getVisaoEscalaPri() {return vEPri;}
	public VisaoEscala getVisaoEscalaSec() {return vESec;}
}