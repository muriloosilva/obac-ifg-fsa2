package br.edu.ifg.formosa.obac.modelo;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ModeloPropulsao {

	//Constantes
	//--Int	
	public final int posXC = 125; //Posição do Canhão - pixels
	public final int posYC = 463;	
	
	public final int posXM = 30; //Posição da Mola - pixels
	public final int posYM = 470;
	
	public final int posXB = 118; //Posição da base do Canhão - pixels
	public final int posYB = 465;
	
	//Variáveis
	//--URL
	private URL urlProp = this.getClass().getClassLoader().getResource("br/edu/ifg/formosa/obac/imagens/propulsaoObstaculo/");
	//--Imagem
	private ImageIcon imagemPropulsao = null;
	private ImageIcon imagemBaseCanhao = null;
	//--Int
	private int translaX = 30; //Variáveis utilizadas para rotacionar o canhão
	private int translaY = 470;
	
	private int posXProp = posXC; //Variáveis de posicionamento da propulsão
	private int posYProp = posYC;
	
	private int posXBase = posXB; //Variáveis de posicionamento da Base do canhão
	private int posYBase = posYB;
	
	//--Modelos
	private ModeloMola mM = null;
	private ModeloCanhao mC = null;
	
	//--Controle
	ControlePainelInformacao cPI = null;
	
	//--double
	private double anguloRotacaoGraus = 0; // Utilizado para rotacionar as propulsoes, tanto mola quanto canhao;
	
	//Métodos
	//--Construtor
	public ModeloPropulsao(ModeloAmbiente ma, ControlePainelInformacao cpi,
						   ControlePainelFormulas cpf, VisaoPainelFormulas vpf)
	{
		mM = new ModeloMola(ma, cpi, cpf, vpf);
		mC = new ModeloCanhao(ma, cpi, cpf, vpf);
		imagemBaseCanhao = new ImageIcon(this.getClass().getClassLoader().getResource("br/edu/ifg/formosa/obac/imagens/propulsaoObstaculo/base.png"));
		imagemBaseCanhao = new ImageIcon(imagemBaseCanhao.getImage().getScaledInstance(54, 40, Image.SCALE_DEFAULT));
		this.cPI = cpi;
		trocaImagemProp(true);
	}
	//--Troca de Imagens
	public void trocaImagemProp(boolean canhao){
		if (canhao) {//Imagem do canhão
			imagemPropulsao = new ImageIcon(this.getClass().getClassLoader().getResource("br/edu/ifg/formosa/obac/imagens/propulsaoObstaculo/canhao.png"));
			imagemPropulsao = new ImageIcon(imagemPropulsao.getImage().getScaledInstance(100, 40, Image.SCALE_DEFAULT));
		}else//Imagem da mola
			imagemPropulsao = new ImageIcon(this.getClass().getClassLoader().getResource("br/edu/ifg/formosa/obac/imagens/propulsaoObstaculo/mola100px.png"));
	}
	
	//--Getters
	public ModeloMola getModeloMola(){return mM;}
	public ModeloCanhao getmC() {return mC;}
	public ImageIcon getImagemPropulsao(){return imagemPropulsao;}
	public ImageIcon getImagemBaseCanhao(){return imagemBaseCanhao;}
	public int getTranslaX() {return translaX;}
	public int getTranslaY() {return translaY;}
	public int getPosXM() {return posXM;}
	public int getPosYM() {return posYM;}
	public int getPosXC() {return posXC;}
	public int getPosYC() {return posYC;}
	public int getPosXB() {return posXB;}
	public int getPosYB() {return posYB;}
	public int getPosXProp() {return posXProp;}
	public int getPosYProp() {return posYProp;}
	public int getPosXBase() {return posXBase;}
	public int getPosYBase() {return posYBase;}
	public double getAnguloRotacaoGraus() {return anguloRotacaoGraus;}
	
	//--Seters
	public void setPosXProp(int posXProp) {this.posXProp = posXProp;}
	public void setPosYProp(int posYProp) {this.posYProp = posYProp;}
	public void setAnguloRotacaoGraus(double anguloRotacaoGraus) {
		this.anguloRotacaoGraus = anguloRotacaoGraus;
		cPI.mudaValorAngulo(anguloRotacaoGraus);
	}
	public void setPosXBase(int posXBase) {this.posXBase = posXBase;}
	public void setPosYBase(int posYBase) {this.posYBase = posYBase;}
}