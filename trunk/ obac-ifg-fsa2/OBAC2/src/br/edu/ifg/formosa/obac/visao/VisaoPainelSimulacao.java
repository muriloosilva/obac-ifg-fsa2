package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

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
	//--Obstáculo
	private VisaoObstaculo vObs = null;
	//--Escala
	private VisaoEscala vEH = null; //Visao Escala Horizontal - Utilizada em: Plano, Subida, Descida, P&P e Projétil
	private VisaoEscala vEV = null; //Visao Escala Vertical - Utilizada em: Queda e Projétil
	//--Auxiliar
	private VisaoAuxiliar vA = null;
	
	//Metodos
	//--Construtor
	public VisaoPainelSimulacao(ModeloAmbiente mA, VisaoPainelConfiguracao vPC) {
		super(null);
		
		this.setSize(750, 600);
		
		vS = new VisaoSuperficie(vPC, mA);
		vO = new VisaoObjeto(mA, vPC);
		vP = new VisaoPropulsao(mA, vPC);
		vObs = new VisaoObstaculo(mA);
		vEH = new VisaoEscala(mA.getmEH(), mA, vPC);
		vEV = new VisaoEscala(mA.getmEV(), mA, vPC);
		vA = new VisaoAuxiliar(mA, vPC);

		this.add(vEH);
		this.add(vEV);
		this.add(vA);
		this.add(vObs);
		this.add(vP);
		this.add(vO);
		this.add(vS);
		
		vEV.setVisible(false); //A Escala Vertical só é utilizada na Queda e no Projétil
	}
	
	//--Getters
	public VisaoObjeto getVisaoObjeto(){return vO;}
	public VisaoPropulsao getVisaoPropulsao(){return vP;}
	public VisaoObstaculo getVisaoObstaculo() {return vObs;}
	public VisaoEscala getVisaoEscalaH() {return vEH;}
	public VisaoEscala getVisaoEscalaV() {return vEV;}
	public VisaoSuperficie getVisaoSuperficie() {return vS;}
	public VisaoAuxiliar getVisaoAuxiliar() {return vA;}
}