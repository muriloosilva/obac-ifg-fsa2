package br.edu.ifg.formosa.obac.modelo;

public class ModeloMola {
	
	//Modelo do Objeto
	private ModeloObjeto mo = null;
	
	//Construtor
	public ModeloMola(ModeloObjeto mo) {
		this.mo = mo;
	}
	
	//Medidas da MOLA
	private final double tamanhoMolaIniPix = 100;//tamanho inicial em pixels 
	private double tamanhoMolaFinPix;//tamanho final em pixels = Pos inicial do objeto
	private double tamanhoIniMolaM;//tamanho inicial em metros
	private double tamanhoMolaFinM;//tamanho final em metros
	//Taxa de deformação da mola
	private double x;
	//Constante elástica(k)
	private double kAtual;//Atual
	
	
	//Cálculo de avelocidade - V0 = (K+x^2/m)
	public void velocidadeLancamento(){
		mo.setVelocidadeInicial(((kAtual+Math.pow(x, 2))/mo.getMassa()));
	}
	
	
	//Calculo de X
//	public calculaX(/*Recebe a posição atual do objeto*/){
		//SUBTRAI O TAMNHO DA MULA PELO TAMNHO FINAL DA MOLA (POSIÇÃO INICIAL DO OBJETO NO EIXO X OU Y NO CASO DA QUEDA LIVRE)
//		
		//O TAMANHO DE X É DADO EM METROS, MAS AKI AINDA ESTÁ EM PIXEL, LOGO, TEM QUE EXISTIR UM MÉTODO ESTÁTICO PARA ISSO SER FEITO
//		return (tamanhoIniMolaM-tamanhoIniMolaM);
//	}
	
//Getters
	public double getTamanhoMolaFinPix() {return tamanhoMolaFinPix;}
	public double getTamanhoMolaFinM() {return tamanhoMolaFinM;}
	public double getX() {return x;}
	public double getkAtual() {return kAtual;}
	public double getTamanhoMolaIniPix() {return tamanhoMolaIniPix;}
//Setters
	public void setTamanhoMolaFinPix(double tamanhoMolaFinPix) {this.tamanhoMolaFinPix = tamanhoMolaFinPix;}
	public void setTamanhoIniMolaM(double tamanhoIniMolaM) {this.tamanhoIniMolaM = tamanhoIniMolaM;}
	public void setTamanhoMolaFinM(double tamanhoMolaFinM) {this.tamanhoMolaFinM = tamanhoMolaFinM;}
	public void setkAtual(double kAtual) {this.kAtual = kAtual;}

}
