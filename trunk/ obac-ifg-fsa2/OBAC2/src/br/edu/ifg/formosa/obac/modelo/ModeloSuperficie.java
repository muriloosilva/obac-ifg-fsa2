package br.edu.ifg.formosa.obac.modelo;

public class ModeloSuperficie {
	//Constantes
	//--Double
	public static final double atritoMadeira = 0.62;
	public static final double atritoAluminio = 1.4;
	public static final double atritoAsfalto = 0.8;
	private double coefAtrito = 0;
	
	public static final double larguraSuperficie = 500; //Valor em px - OBAC1
	public static final double alturaSuperficie = 420; //Valor em px - OBAC1
	
	public static final double anguloInclinacaoGraus = 45; //Valor ainda nao definido - Utilizado para subida e descida
	
	//Atrito --- Get e Set
	public void setCoefAtrito(double coefAtrito){this.coefAtrito = coefAtrito;}
	public double getCoefAtrito(){return coefAtrito;}
}