package br.edu.ifg.formosa.obac.modelo;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
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
	private double alcanceMaximo = 0;
	private double alturaMaxima = 0;
	
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
		mA.getmO().setVelocidadeInicial(Math.sqrt((2 * energia) / mA.getmO().getMassa()));
		/*				  _____________________
		 * Velocidade = -/(2 * energia) / massa
		 */
		vPF.getAtVInicial().setText(cPF.propulsaoCanhao(energia, mA.getmO().getMassa()));
	}
	
	//--Tempo total
	public void tempoTotal() {
		mA.setTempoTotal(
					(2 * mA.getmO().getVelocidadeInicial() * 
					Math.sin(Math.toRadians(mA.getmP().getAnguloRotacaoGraus())) / 
					mA.getGravSelecionada()));
		/*
		 * TempoTotal = (2 * velocidade * sin(angulo)) / gravidade
		 */
		vPF.getAtTempo().setText(cPF.tempoTotal(mA.getmO().getVelocidadeInicial(), mA.getmP().getAnguloRotacaoGraus(), mA.getGravSelecionada()));
	}
	
	//--Alcance máximo
	public void alcanceMaximo() {
		this.alcanceMaximo = (Math.pow(mA.getmO().getVelocidadeInicial(), 2) * 
							  Math.sin(Math.toRadians(2 * mA.getmP().getAnguloRotacaoGraus())) / 
							  mA.getGravSelecionada());
		/*
		 * AlcanceTotal = (Vo² * sin(2 * teta)) / gravidade
		 */
		vPF.getAtAlcanceTotalHorizontal().setText(
			cPF.alcanceTHorizontal(mA.getmO().getVelocidadeInicial(), mA.getmP().getAnguloRotacaoGraus(), mA.getGravSelecionada()));
	}
	
	//--AlturaMaxima
	public void alturaMaxima() {
		this.alturaMaxima = (Math.pow(mA.getmO().getVelocidadeInicial() * 
							Math.sin(Math.toRadians(mA.getmP().getAnguloRotacaoGraus())), 2)) / 
							2 * mA.getGravSelecionada();
		/*
		 * AlturaMaxima = (Vo * sin(teta))² / 2 * gravidade
		 */
		vPF.getAtAlcanceTotalVertical().setText(
			cPF.alturaTVertical(mA.getmO().getVelocidadeInicial(), mA.getmP().getAnguloRotacaoGraus(), mA.getGravSelecionada()));
	}
	
	//--Novo X
	public void novoX() {
		mA.getmO().setPosicaoXMetros((mA.getmO().getVelocidadeInicial() * 
									Math.cos(Math.toRadians(mA.getmP().getAnguloRotacaoGraus())) * 
									mA.getTempoAtual()));
		/*
		 * Novo X = (Vo * cos(teta)) * tempo
		 */
		vPF.getAtMovimentoHorizontal().setText(
				cPF.movimentoHorizontal(mA.getmO().getVelocidadeInicial(), mA.getmP().getAnguloRotacaoGraus(), mA.getGravSelecionada()));
	}
	
	//--Novo Y
	public void novoY() {
		mA.getmO().setPosicaoYMetros(((
									mA.getmO().getVelocidadeInicial() * 
									Math.sin(Math.toRadians(mA.getmP().getAnguloRotacaoGraus()))) * mA.getTempoAtual()) - 
									((mA.getGravSelecionada() / 2) * Math.pow(mA.getTempoAtual(), 2)));
		/*
		 * Novo Y = ((Vo * sin(teta)) * tempo) - (grav / 2 * tempo²)
		 */
		vPF.getAtMovimentoVertical().setText(
				cPF.movimentoVetical(mA.getmO().getVelocidadeInicial(), mA.getmP().getAnguloRotacaoGraus(), mA.getTempoAtual(), mA.getGravSelecionada()));
	}
	
	/*public void encontrarAngulo(){		
		double angulo = Math.asin(Math.sqrt(2 * mA.getGravSelecionada() * UtilidadeConvercoesEscala.pixelParaMetroV(mA.getmEV(), mA.getmEV().getEscalaFimYPix())) / mA.getmO().getVelocidade());
		/*					  _________
		 * angulo = arcsin( -/2 * y * g' / Vo )
		 */
		/*System.out.println("Seno: " + Math.sqrt(2 * mA.getGravSelecionada() * UtilidadeConvercoesEscala.pixelParaMetroV(mA.getmEV(), mA.getmEV().getEscalaFimYPix())) / mA.getmO().getVelocidade());
		System.out.println("Angulo Radianos: " + angulo);
		System.out.println("Angulo Graus: " + Math.toDegrees(angulo));
		//mA.getmP().setAnguloRotacaoGraus(Math.toDegrees(angulo));
	}*/
	
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
	public double getAlcanceMaximo() {return alcanceMaximo;}
	public double getAlturaMaxima() {return alturaMaxima;}
	
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
	public void setAlturaMaxima(double alturaMaxima) {this.alturaMaxima = alturaMaxima;}
}