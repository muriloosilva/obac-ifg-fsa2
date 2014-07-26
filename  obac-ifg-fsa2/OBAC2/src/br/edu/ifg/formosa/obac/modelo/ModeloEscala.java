package br.edu.ifg.formosa.obac.modelo;

public class ModeloEscala {
	
	//Constantes
	private final int tamanhoPrecipicioPix = 286;//Este valor é usado porque assim é considerado que 50% + 1pix do tamanho do objeto estará por cima do plano, de forma que o equilíbrio dele seja mantido(Tamnho_do_plano(330)-Tamho_do_objeto(30)-50%+1_do_Objeto_Pix(16))
	private final int fimAmbienteYPix = 600;
	
	//Variaveis
	//--Inteiro
	private int escalaInicioX = 100; //Inicio da escala X (px)
	private int escalaInicioY = 564; //Inicio da escala Y (px)
	
	private int escalaFimXPix = 700; //Fim da escala X (px)
	private int escalaFimYPix = 564; //Fim da escala Y (px)
	
	private long escalaFimXM = 0; //Fim da escala X (m)
	private long escalaFimYM = 0; //Fim da escala Y (m)
	
	private int espacamentoMarcadores = 0; //Espacamento entre os marcadores (px)	
	private int qtdMarcadores = 5; //Numero de marcadores existentes na escala
	
	//Metodos
	//--Getters
	public int getTamanhoPrecipicioPix() {return tamanhoPrecipicioPix;}
	public int getFimAmbienteYPix() {return fimAmbienteYPix;}
	public int getEscalaInicioX() {return escalaInicioX;}
	public int getEscalaInicioY() {return escalaInicioY;}
	public int getEscalaFimXPix() {return escalaFimXPix;}
	public int getEscalaFimYPix() {return escalaFimYPix;}	
	public long getEscalaFimXM() {return escalaFimXM;}
	public long getEscalaFimYM() {return escalaFimYM;}	
	public int getEspacamentoMarcadores() {return espacamentoMarcadores;}
	public int getQtdMarcadores() {return qtdMarcadores;}
	
	//--Setters
	public void setEscalaInicioX(int escalaInicioX) {this.escalaInicioX = escalaInicioX;}
	public void setEscalaInicioY(int escalaInicioY) {this.escalaInicioY = escalaInicioY;}
	public void setEscalaFimXPix(int escalaFimXPix) {this.escalaFimXPix = escalaFimXPix;}
	public void setEscalaFimYPix(int escalaFimYPix) {this.escalaFimYPix = escalaFimYPix;}	
	public void setEscalaFimXM(long escalaFimXM) {this.escalaFimXM = escalaFimXM;}
	public void setEscalaFimYM(long escalaFimYM) {this.escalaFimYM = escalaFimYM;}	
	public void setEspacamentoMarcadores(int espacamentoMarcadores) {this.espacamentoMarcadores = espacamentoMarcadores;}
	public void setQtdMarcadores(int qtdMarcadores) {this.qtdMarcadores = qtdMarcadores;}
}