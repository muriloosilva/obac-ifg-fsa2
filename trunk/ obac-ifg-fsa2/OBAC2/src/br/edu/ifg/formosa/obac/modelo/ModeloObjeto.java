package br.edu.ifg.formosa.obac.modelo;

public class ModeloObjeto {
	//Constantes
	//--Double
	public static final double altura = 10; //Os valores de alt e larg sao para inicializar as variaveis
	public static final double largura = 10;
	
	//Variaveis
	//--Double	
	private double massa;
	private double coefRestituicao;
	
	private double velocidade;
	private double velocidadeInicial;
	
	private double aceleracao;
	private double aceleracaoY;
	
	private double posicaoX;
	private double posicaoY;
	
	private double posicaoXPx;
	private double posicaoYPx;
	
	
	//Metodos
	//--Getters
	public static double getAltura() {return altura;}
	public static double getLargura() {return largura;}
	public double getMassa() {return massa;}
	public double getCoefRestituicao() {return coefRestituicao;}
	public double getVelocidade() {return velocidade;}
	public double getVelocidadeInicial() {return velocidadeInicial;}
	public double getAceleracao() {return aceleracao;}
	public double getAceleracaoY() {return aceleracaoY;}
	public double getPosicaoX() {return posicaoX;}
	public double getPosicaoY() {return posicaoY;}
	public double getPosicaoXPx() {return posicaoXPx;}
	public double getPosicaoYPx() {return posicaoYPx;}
	
	//Setters
	public void setMassa(double massa) {this.massa = massa;}
	public void setCoefRestituicao(double coefRestituicao) {this.coefRestituicao = coefRestituicao;}
	public void setVelocidade(double velocidade) {this.velocidade = velocidade;}
	public void setVelocidadeInicial(double velocidadeInicial) {this.velocidadeInicial = velocidadeInicial;}
	public void setAceleracao(double aceleracao) {this.aceleracao = aceleracao;}
	public void setAceleracaoY(double aceleracaoY) {this.aceleracaoY = aceleracaoY;}
	public void setPosicaoX(double posicaoX) {this.posicaoX = posicaoX;}
	public void setPosicaoY(double posicaoY) {this.posicaoY = posicaoY;}
	public void setPosicaoXPx(double posicaoXPx) {this.posicaoXPx = posicaoXPx;}
	public void setPosicaoYPx(double posicaoYPx) {this.posicaoYPx = posicaoYPx;}
	
}