package br.edu.ifg.formosa.obac.modelo;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;

public class ModeloSuperficie {
	
	private ControlePainelInformacao cPI = null;
	
	//Construtor
	public ModeloSuperficie(ControlePainelInformacao cPI) {
		this.cPI = cPI;
	}
	
	//Constantes
	//--Double
	public static final double atritoMadeira = 0.62;
	public static final double atritoAluminio = 1.4;
	public static final double atritoAsfalto = 0.8;
	
	public static final double larguraSuperficie = 500; //Valor em px - OBAC1
	public static final double alturaSuperficie = 420; //Valor em px - OBAC1
		
	//Variaveis
	//--Double
	private double coefAtritoSelecionado = atritoAsfalto;	
	private double forcaAtrito;	
	
	//Metodos
	//--Setters
	public void setCoefAtritoSelecionado(double coefAtritoSelecionado){
		this.coefAtritoSelecionado = coefAtritoSelecionado;
		cPI.mudaValorCoefAtrito(this.coefAtritoSelecionado);
	}
	public void setForcaAtrito(double forcaAtrito){
		this.forcaAtrito = forcaAtrito;
		cPI.mudaValorForcaAtrito(this.forcaAtrito);
	}
	
	//--Getters
	public double getCoefAtritoSelecionado(){return coefAtritoSelecionado;}
	public double getForcaAtrito(){return forcaAtrito;}
}