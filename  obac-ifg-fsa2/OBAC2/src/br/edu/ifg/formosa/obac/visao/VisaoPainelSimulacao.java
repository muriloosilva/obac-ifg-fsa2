package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
	public VisaoPainelSimulacao(ModeloAmbiente mA, VisaoPainelConfiguracao vPC) {
		super(null);
		
		this.setSize(750, 600);
		
		vS = new VisaoSuperficie(vPC, mA);
		vO = new VisaoObjeto(mA);
		vP = new VisaoPropulsao(mA);
		vEPri = new VisaoEscala(mA.getmEPri(), mA.getmO());
		vESec = new VisaoEscala(mA.getmESec(), mA.getmO());
		
		this.add(vEPri);
		this.add(vESec);
		this.add(vP);
		this.add(vO);
		this.add(vS);
		
		vESec.setVisible(false); //A escala sec. só aparece no Projetil e no P&P
	}
	
	//--Getters
	public VisaoObjeto getVisaoObjeto(){return vO;}
	public VisaoPropulsao getVisaoPropulsao(){return vP;}
	public VisaoEscala getVisaoEscalaPri() {return vEPri;}
	public VisaoEscala getVisaoEscalaSec() {return vESec;}
	public VisaoSuperficie getVisaoSuperficie() {return vS;}
}