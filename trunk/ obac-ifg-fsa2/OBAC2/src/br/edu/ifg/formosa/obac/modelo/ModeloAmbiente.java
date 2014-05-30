package br.edu.ifg.formosa.obac.modelo;

public class ModeloAmbiente {
	//Constantes
	//--Double
	public static final double gravidadeTerra = 9.8;
	public static final double gravidadeLua = 1.6;
	public static final double gravidadeMarte = 3.7;
	
	//Variáveis
	//--Double
	public static double coefAtrito; //Recebe ou o atrito da madeira, ou do asfalto ou do aluminio
	public static double gravSelecionada; // Recebe ou a gravidade da Terra, da Lua ou de Marte
	
	private double tempo; //OBAC1
	
	//--Objeto, Escala e Superficie
	private ModeloEscala mE = new ModeloEscala();
	private ModeloObjeto mO = new ModeloObjeto();
	private ModeloSuperficie mS = new ModeloSuperficie();
	
	//Metodos
	//--Getters
	public static double getGravidadeterra() {return gravidadeTerra;}
	public static double getGravidadelua() {return gravidadeLua;}
	public static double getGravidademarte() {return gravidadeMarte;}
	public static double getCoefAtrito() {return coefAtrito;}
	public static double getGravSelecionada() {return gravSelecionada;}
	public double getTempo() {return tempo;}
	public ModeloEscala getmE() {return mE;}
	public ModeloObjeto getmO() {return mO;}
	public ModeloSuperficie getmS() {return mS;}
	
	//--Setters
	public static void setCoefAtrito(double coefAtrito) {ModeloAmbiente.coefAtrito = coefAtrito;}
	public static void setGravSelecionada(double gravSelecionada) {ModeloAmbiente.gravSelecionada = gravSelecionada;}
	public void setTempo(double tempo) {this.tempo = tempo;}
	public void setmE(ModeloEscala mE) {this.mE = mE;}
	public void setmO(ModeloObjeto mO) {this.mO = mO;}
	public void setmS(ModeloSuperficie mS) {this.mS = mS;}
	
}