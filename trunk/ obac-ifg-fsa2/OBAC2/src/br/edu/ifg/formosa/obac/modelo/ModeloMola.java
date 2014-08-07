package br.edu.ifg.formosa.obac.modelo;

import javax.swing.ImageIcon;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ModeloMola {

	//Modelo do Objeto
	private ModeloAmbiente ma = null;

	//ControleInicioSimulacoes Do Painel deInformação
	private ControlePainelInformacao cpi = null;
	private ControlePainelFormulas cpf = null;
	private VisaoPainelFormulas vpf = null;

	//Imagem
	private ImageIcon imagemMola = new ImageIcon(this.getClass().getClassLoader().getResource("br/edu/ifg/formosa/obac/imagens/propulsaoObstaculo/mola100px.png"));

	//Construtor
	public ModeloMola(ModeloAmbiente ma, ControlePainelInformacao cpi,
			ControlePainelFormulas cpf,  VisaoPainelFormulas vpf)
	{
		this.ma = ma;
		this.cpi = cpi;
		this.cpf = cpf;
		this.vpf = vpf;
	}

	//Medidas da MOLA
	private final int tamanhoMolaMinimoPix = 25;//Tamanho mínimo em pixels que a mola pode assumir 
	private final int tamanhoMolaTotalPix = 100;//tamanho inicial em pixels 
	private int tamanhoMolaAtualPix=tamanhoMolaTotalPix;//tamanho final em pixels = Pos inicial do objeto
	private double tamanhoMolaTotalM;//tamanho inicial em metros
	private double tamanhoMolaAtualM;//tamanho final em metros
	//Taxa de deformação da mola
	private double x=0;
	//Constante elástica(k)
	private double kAtual;//Atual

	//Posição da Mola - pixels
	private int posX = 30;
	private int posY = 470;


	//Cálculo de avelocidade - V0 = (K+x^2/m)
	public void calculaVelocidadeLancamento(){
		calculaX();
		ma.getmO().setVelocidadeInicial(
			Math.sqrt((kAtual*Math.pow(x, 2))/ma.getmO().getMassa())
		);

		//Manda para o painel de fórmulas
		vpf.getAtVInicial().setText(cpf.propulsaoMola(kAtual,x,ma.getmO().getMassa()));
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
	
	//Setter de modelo ambiente
}