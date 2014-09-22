package br.edu.ifg.formosa.obac.modelo;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ModeloCanhao {
	//Variáveis
	
	//--Angulação do canhao
	//----Double
	private double verAX = 0;
    private double verAY = 0;
    private double verBX = 0;
    private double catOpo = 0;
    private double catAd = 0;
    private double hip = 0;
    //----Double e final
    private final double verBY = 478;
    private final double verCX = 145;
    private final double verCY = 478;
    
	//--Double
	private double energia = 0;
	
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
	
	//--Calculo de velocidade
	public void calculaVelocidade() {
		
	}
	
	//--Getters
	public double getEnergia() {return energia;}
	public double getVerAX() {return verAX;}
	public double getVerAY() {return verAY;}
	public double getVerBX() {return verBX;}
	public double getVerBY() {return verBY;}
	public double getVerCX() {return verCX;}
	public double getVerCY() {return verCY;}
	public double getCatOpo() {return catOpo;}
	public double getCatAd() {return catAd;}
	public double getHip() {return hip;}
	
	//--Setters
	public void setEnergia(double energia) {
		this.energia = energia;
		cPI.mudaValorEnergia(energia);
	}
	public void setVerAX(double verAX) {this.verAX = verAX;}
	public void setVerAY(double verAY) {this.verAY = verAY;}
	public void setVerBX(double verBX) {this.verBX = verBX;}
	public void setCatOpo(double catOpo) {this.catOpo = catOpo;}
	public void setCatAd(double catAd) {this.catAd = catAd;}
	public void setHip(double hip) {this.hip = hip;}
}