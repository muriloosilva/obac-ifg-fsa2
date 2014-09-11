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
	public final int posXC = 30; //Posição do Canhão - pixels
	public final int posYC = 465;	
	
	public final int posXM = 30; //Posição da Mola - pixels
	public final int posYM = 470;
	
	//Variáveis
	//--URL
	private URL urlProp = this.getClass().getClassLoader().getResource("br/edu/ifg/formosa/obac/imagens/propulsaoObstaculo/");
	//--Imagem
	private ImageIcon imagemPropulsao = null;
	//--Int
	private int translaX = 30; //Variáveis utilizadas para rotacionar o canhão
	private int translaY = 470;
	
	private int posXProp = posXM;
	private int posYProp = posYM;
	
	//--Modelos
	private ModeloMola mM = null;
	private ModeloCanhao mC = null;
	
	//Métodos
	//--Construtor
	public ModeloPropulsao(ModeloAmbiente ma, ControlePainelInformacao cpi,
						   ControlePainelFormulas cpf, VisaoPainelFormulas vpf)
	{
		mM = new ModeloMola(ma, cpi, cpf, vpf);
		mC = new ModeloCanhao(ma, cpi, cpf, vpf);
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
	public int getTranslaX() {return translaX;}
	public int getTranslaY() {return translaY;}
	public int getPosXM() {return posXM;}
	public int getPosYM() {return posYM;}
	public int getPosXC() {return posXC;}
	public int getPosYC() {return posYC;}
	public int getPosXProp() {return posXProp;}
	public int getPosYProp() {return posYProp;}
	
	//--Seters
	public void setPosXProp(int posXProp) {this.posXProp = posXProp;}
	public void setPosYProp(int posYProp) {this.posYProp = posYProp;}
}