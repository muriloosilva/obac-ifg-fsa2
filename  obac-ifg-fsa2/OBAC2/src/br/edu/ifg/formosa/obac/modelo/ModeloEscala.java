package br.edu.ifg.formosa.obac.modelo;

public class ModeloEscala {
	//Variaveis
	//--Inteiro
	private int escalaInicioX = 100; //Inicio da escala X (px)
	private int escalaInicioY = 564; //Inicio da escala Y (px)
	
	private int escalaFimX = 700; //Fim da escala X (px)
	private int escalaFimY = 564; //Fim da escala Y (px)
	
	private int espacamentoMarcadores = 0; //Espacamento entre os marcadores (px)	
	private int qtdMarcadores = 5; //Numero de marcadores existentes na escala
	
	//--Double
	private double angulo = 0; //Angulo para rotacionar a escala;
	
	//Metodos
	//--Getters
	public int getEscalaInicioX() {return escalaInicioX;}
	public int getEscalaInicioY() {return escalaInicioY;}
	public int getEscalaFimX() {return escalaFimX;}
	public int getEscalaFimY() {return escalaFimY;}
	public int getEspacamentoMarcadores() {return espacamentoMarcadores;}
	public int getQtdMarcadores() {return qtdMarcadores;}
	public double getAngulo() {return angulo;}
	
	//--Setters
	public void setEscalaInicioX(int escalaInicioX) {this.escalaInicioX = escalaInicioX;}
	public void setEscalaInicioY(int escalaInicioY) {this.escalaInicioY = escalaInicioY;}
	public void setEscalaFimX(int escalaFimX) {this.escalaFimX = escalaFimX;}
	public void setEscalaFimY(int escalaFimY) {this.escalaFimY = escalaFimY;}	
	public void setEspacamentoMarcadores(int espacamentoMarcadores) {this.espacamentoMarcadores = espacamentoMarcadores;}
	public void setQtdMarcadores(int qtdMarcadores) {this.qtdMarcadores = qtdMarcadores;}
	public void setAngulo(double angulo) {this.angulo = angulo;}
}