package br.edu.ifg.formosa.obac.modelo;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ModeloCanhao {
	//Variáveis
	//--Double
	private double anguloRotacao = 0.0;
	private double energia = 0;
	
	//--Int
	private int posX = 0;
	private int posY = 0;
	
	private int tamanhoXPixC = 0; //Posição do canhão
	private int tamanhoYPixC = 0;

	private int tamanhoXPixB = 0; //Posição da base
	private int tamanhoYPixB = 0;
	
	//--Modelo
	private ModeloAmbiente mA = null;
	
	//--Controles
	private ControlePainelInformacao cPI = null;
	private ControlePainelFormulas cPF = null;
	
	//--Visao
	private VisaoPainelFormulas vPF = null;
	
	//Métodos
	//--Construtor
	public ModeloCanhao(ModeloAmbiente mA, ControlePainelInformacao cPI, 
						ControlePainelFormulas cPF, VisaoPainelFormulas vPF) {
		this.mA = mA;
		this.cPI = cPI;
		this.cPF = cPF;
		this.vPF = vPF;
	}
	
	//--Getters
	public double getAnguloRotacao() {return anguloRotacao;}
	public double getEnergia() {return energia;}
	public int getPosX() {return posX;}
	public int getPosY() {return posY;}
	public int getTamanhoXPixC() {return tamanhoXPixC;}
	public int getTamanhoYPixC() {return tamanhoYPixC;}
	public int getTamanhoXPixB() {return tamanhoXPixB;}
	public int getTamanhoYPixB() {return tamanhoYPixB;}
	
	//--Setters
	public void setAnguloRotacao(double anguloRotacao) {
		this.anguloRotacao = anguloRotacao;
		cPI.mudaValorAngulo(anguloRotacao);
	}
	public void setEnergia(double energia) {
		this.energia = energia;
		cPI.mudaValorEnergia(energia);
	}
}