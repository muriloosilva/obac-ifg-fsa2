package br.edu.ifg.formosa.obac.modelo;

public class ModeloMola {
	
	//Medidas da MOLA
	private final double tamanhoMolaIniPix = 100;//tamanho inicial em pixels 
	private double tamanhoMolaFinPix;//tamanho final em pixels = Pos inicial do objeto
	private double tamanhoIniMolaM;//tamanho inicial em metros
	private double tamanhoMolaFinM;//tamanho final em metros
	
	//Taxa de deformação da mola
	private double x;
	
	//Constante elástica(k)
	private double kAtual;//Atual
	
	//Modelo do Objeto
	private ModeloObjeto mo = null;//OBS Matheus: A posição original dos objetos no eixo x não altera na subida, descida e P&P. Ela gira sozinha com a rotação do painel, sem alterações no valor xPix dela.
								   //Por isso eu peço que considere a opção de haver apenas uma variável e uma constante para a posição em pixel do objeto
								  //Tbm aproveito a deixa para pedir uma forma de vc alocar as variáveis que são citadas em controlePainelInformação 
	
	//Construtor
	public ModeloMola(ModeloObjeto mo) {this.mo = mo;}
	
	//Cálculo de avelocidade - V0 = (K+x^2/m)
	public double velocidadeLancamento(){return ((kAtual+Math.pow(x, 2))/mo.getMassa());}
	
	//Calculo de X
//	public calculaX(/*Recebe a posição atual do objeto*/){
		//SUBTRAI O TAMNHO DA MULA PELO TAMNHO FINAL DA MOLA (POSIÇÃO INICIAL DO OBJETO NO EIXO X OU Y NO CASO DA QUEDA LIVRE)
//		(tamanhoIniMolaM-tamanhoIniMolaM)
		//O TAMANHO DE X É DADO EM METROS, MAS AKI AINDA ESTÁ EM PIXEL, LOGO, TEM QUE EXISTIR UM MÉTODO ESTÁTICO PARA ISSO SER FEITO
//		return X;
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
//	public void setX(double x) {this.x = x;} - Pode não ser viável a sua aplicação, já que o calculo dele é feito anesta classe
	public void setkAtual(double kAtual) {this.kAtual = kAtual;}

}
