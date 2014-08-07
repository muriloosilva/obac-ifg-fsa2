package br.edu.ifg.formosa.obac.modelo;

public class ModeloEscala {
	
	//Constantes
	//--Inteiro
	public final int tamanhoPrecipicioPix = 286;//Este valor é usado porque assim é considerado que 50% + 1pix do tamanho do objeto estará por cima do plano, de forma que o equilíbrio dele seja mantido(Tamnho_do_plano(330)-Tamho_do_objeto(30)-50%+1_do_Objeto_Pix(16))
	public final int fimAmbienteYPix = 600;
	public final static int qtdMarcadores = 4; //Numero de marcadores existentes nas escalas
	
	//Variaveis
	//--Inteiro
	private int escalaInicioX = 130; //Inicio da escala X (px)
	private int escalaInicioY = 520; //Inicio da escala Y (px)
	
	private int escalaFimXPix = 700; //Fim da escala X (px)
	private int escalaFimYPix = 520; //Fim da escala Y (px)
	
	private long escalaFimXM = 0; //Fim da escala X (m)
	private long escalaFimYM = 0; //Fim da escala Y (m)
	
	private int espacamentoMarcadores = 0; //Espacamento entre os marcadores (px)
	
	private int comprimentoEscalaPx = escalaFimXPix - escalaInicioX;
		
	//--Double
	private double anguloRotacaoGraus = 0; //Utilizado somente na Escala Horizontal - subida e descida incluso
	
	public static final double marcadorInicial = 0.0; //É Constante, mas deixei aqui para um melhor entendimento
	private double[] marcadoresEscala = new double[qtdMarcadores + 1]; //0-Menor / 4-Maior
	/* Explicação do 'qtdMarcadores + 1'
	 * -O qtdMarcadores indica os marcadores desenhados 'dentro' da escala, 
	 * não conta os das extremidades, por isso o '+1' devido ao inicial ser uma constante
	 */
	
	//--Boolean
	private boolean isPEP = false;
	
	//Metodos
	//--Getters
	public int getEscalaInicioX() {return escalaInicioX;}
	public int getEscalaInicioY() {return escalaInicioY;}
	public int getEscalaFimXPix() {return escalaFimXPix;}
	public int getEscalaFimYPix() {return escalaFimYPix;}	
	public int getEspacamentoMarcadores() {return espacamentoMarcadores;}
	public int getComprimentoEscalaPx() {return comprimentoEscalaPx;}
	public long getEscalaFimXM() {return escalaFimXM;}
	public long getEscalaFimYM() {return escalaFimYM;}	
	public double getAnguloRotacaoGraus() {return anguloRotacaoGraus;}
	public double[] getMarcadoresEscala() {return marcadoresEscala;}
	public boolean isPEP() {return isPEP;}
	
	//--Setters
	public void setEscalaInicioX(int escalaInicioX) {this.escalaInicioX = escalaInicioX;}
	public void setEscalaInicioY(int escalaInicioY) {this.escalaInicioY = escalaInicioY;}
	public void setEscalaFimXPix(int escalaFimXPix) {this.escalaFimXPix = escalaFimXPix;}
	public void setEscalaFimYPix(int escalaFimYPix) {this.escalaFimYPix = escalaFimYPix;}	
	public void setEspacamentoMarcadores(int espacamentoMarcadores) {this.espacamentoMarcadores = espacamentoMarcadores;}
	public void setEscalaFimXM(long escalaFimXM) {this.escalaFimXM = escalaFimXM;}
	public void setEscalaFimYM(long escalaFimYM) {this.escalaFimYM = escalaFimYM;}
	public void setAnguloRotacaoGraus(double anguloRotacaoGraus) {this.anguloRotacaoGraus = anguloRotacaoGraus;}
	public void setIsPEP(boolean isPEP) {this.isPEP = isPEP;}
}