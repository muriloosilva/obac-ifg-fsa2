package br.edu.ifg.formosa.obac.modelo;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ModeloMola {

	//Modelo do Objeto
	private ModeloAmbiente ma = null;

	//ControleInicioSimulacoes Do Painel deInforma��o
	private ControlePainelInformacao cpi = null;
	private ControlePainelFormulas cpf = null;
	private VisaoPainelFormulas vpf = null;

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
	private final int tamanhoMolaMinimoPix = 25;//Tamanho m�nimo em pixels que a mola pode assumir 
	private final int tamanhoMolaTotalPix = 100;//tamanho inicial em pixels 
	private int tamanhoMolaAtualPix=tamanhoMolaTotalPix;//tamanho final em pixels = Pos inicial do objeto
	private double tamanhoMolaTotalM;//tamanho inicial em metros
	private double tamanhoMolaAtualM;//tamanho final em metros
	//Taxa de deforma��o da mola
	private double x=0;
	//Constante el�stica(k)
	private double kAtual=30;//Atual


	//C�lculo de avelocidade - V0 = (K*x^2/m)
	public void calculaVelocidadeLancamento(){
		calculaX();
		ma.getmO().setVelocidadeInicial(
			Math.sqrt(
				((kAtual*Math.pow(x, 2))/ma.getmO().getMassa()))
		);

		//Manda para o painel de f�rmulas
		vpf.getAtVInicial().setText(cpf.propulsaoMola(kAtual,x,ma.getmO().getMassa()));
	}


	//Calculo de X
	//-----Subitrai o tamanho total da mola em metros pelo tamanho atual em metros da mesma
	public void calculaX(){
		this.x = (tamanhoMolaTotalM-tamanhoMolaAtualM);
		cpi.mudaValorTaxaDeDeformacao(x);
		
		System.out.println("X________________: "+x);
		System.out.println("tamanhoMolaTotalM: "+tamanhoMolaTotalM);
		System.out.println("tamanhoMolaAtualM: "+tamanhoMolaAtualM);
	}

	//Getters
	public int getTamanhoMolaMinimoPix() {return tamanhoMolaMinimoPix;}
	public int getTamanhoMolaAtualPix() {return tamanhoMolaAtualPix;}
	public double getTamanhoMolaAtualM() {return tamanhoMolaAtualM;}
	public double getX() {return x;}
	public double getkAtual() {return kAtual;}
	public int getTamanhoMolaTotalPix() {return tamanhoMolaTotalPix;}
	public double getTamanhoMolaTotalM(){return tamanhoMolaTotalM;}
	//Setters
	public void setTamanhoMolaAtualPix(int tamanhoMolaAtualPix) {this.tamanhoMolaAtualPix = tamanhoMolaAtualPix;}
	public void setTamanhoMolaTotalM(double tamanhoMolaTotalM) {this.tamanhoMolaTotalM= tamanhoMolaTotalM;}
	public void setTamanhoMolaAtualM(double tamanhoMolaAtualM) {this.tamanhoMolaAtualM = tamanhoMolaAtualM;}
	public void setkAtual(double kAtual) {
		this.kAtual = kAtual;
		cpi.mudaValorConstanteElastica(kAtual);
	}
	
}