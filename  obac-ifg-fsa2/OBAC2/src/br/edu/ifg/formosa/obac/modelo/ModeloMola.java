package br.edu.ifg.formosa.obac.modelo;

import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.principal.OBAC;

public class ModeloMola {
	
	//Modelo do Objeto
	private ModeloObjeto mo = null;
	
	//Controle Do Painel deInformação
	private ControlePainelInformacao cpi = null;
	
	//Imagem
	private ImageIcon imagemMola = new ImageIcon(this.getClass().getClassLoader().getResource("br/edu/ifg/formosa/obac/imagens//propulsao/mola100px.png"));
	private int imagemTamanhoYPix = 30;
	private int imagemPosicaoYPix = 0;
	
	//Construtor
	public ModeloMola(ModeloObjeto mo, ControlePainelInformacao cpi) {
		this.mo = mo;
		this.cpi = cpi;
	}
	
	//Medidas da MOLA
	private final int tamanhoMolaMinimoPix = 25;//Tamanho mínimo em pixels que a mola pode assumir 
	private final int tamanhoMolaTotalPix = 100;//tamanho inicial em pixels 
	private int tamanhoMolaAtualPix=tamanhoMolaTotalPix;//tamanho final em pixels = Pos inicial do objeto
	private double tamanhoMolaTotalM;//tamanho inicial em metros
	private double tamanhoMolaAtualM;//tamanho final em metros
	//Taxa de deformação da mola
	private double x;
	//Constante elástica(k)
	private double kAtual;//Atual
	
	//Posição da Mola - pixels
	private int posX = 30;
	private int posY = 470;
	
	
	//Cálculo de avelocidade - V0 = (K+x^2/m)
	public void velocidadeLancamento(){
		mo.setVelocidadeInicial(((kAtual+Math.pow(x, 2))/mo.getMassa()));
	}
	
	
	//Calculo de X
	//-----Subitrai o tamanho total da mola em metros pelo tamanho atual em metros da mesma
	public void calculaX(){
		this.x = (tamanhoMolaTotalM-tamanhoMolaAtualM);
		cpi.mudaValorTaxaDeDeformacao(x);
	}
	
//Getters
	public int getTamanhoMolaMinimoPix() {return tamanhoMolaMinimoPix;}
	public int getTamanhoMolaAtualPix() {return tamanhoMolaAtualPix;}
	public double getTamanhoMolaAtualM() {return tamanhoMolaAtualM;}
	public double getX() {return x;}
	public double getkAtual() {return kAtual;}
	public int getTamanhoMolaTotalPix() {return tamanhoMolaTotalPix;}
	public double getTamanhoMolaTotalM(){return tamanhoMolaTotalM;}
	public ImageIcon getImagemMola(){return imagemMola;}
	public int getPosX() {return posX;}
	public int getPosY() {return posY;}
//Setters
	public void setTamanhoMolaAtualPix(int tamanhoMolaAtualPix) {this.tamanhoMolaAtualPix = tamanhoMolaAtualPix;}
	public void setTamanhoMolaTotalM(double tamanhoMolaTotalM) {this.tamanhoMolaTotalM = tamanhoMolaTotalM;}
	public void setTamanhoMolaAtualM(double tamanhoMolaAtualM) {this.tamanhoMolaAtualM = tamanhoMolaAtualM;}
	public void setkAtual(double kAtual) {
		this.kAtual = kAtual;
		cpi.mudaValorConstanteElastica(kAtual);
	}
	public void setPosX(int posX) {this.posX = posX;}
	public void setPosY(int posY) {this.posY = posY;}
}
