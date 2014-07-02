package br.edu.ifg.formosa.obac.modelo;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;

public class ModeloObjeto {
	
	//Controle Painel de Configuração - atualizar dados referente ao ambiente
	private static ControlePainelInformacao cpi = null;
	
	//Construtor - To deixando desativado para vc arrumar o modelo ambiente depois
		//Os controles do CPI tbm estão comentados para evitar problimas no funcionamento
//	public ModeloObjeto(ControlePainelInformacao cpi) {
//		ModeloObjeto.cpi = cpi;
//	}
	
	//Constantes
	//--Double
	public static final double altura = 10; //Os valores de alt e larg sao para inicializar as variaveis
	public static final double largura = 10;
	
	public final double posXIniPlano = 0; //As 12 variaveis que se seguem orientam a posicao inical do objeto em pixels nas diferetes simulacoes. Valores devem ser preenchidos corretamete
	public final double posYIniPlano = 0;
	
	public final double posXIniSubida = 0;
	public final double posYIniSubida = 0;
	
	public final double posXIniDescida = 0;
	public final double posYIniDescida = 0;
	
	public final double posXIniPrecipicio = 0;
	public final double posYIniPrecipicio = 0;
	
	public final double posXIniQueda = 0;
	public final double posYIniQueda = 0;
	
	public final double posXLancamento = 0;
	public final double posYLancamento = 0;
	//Variaveis
	//--Double	
	private double massa;
	private double coefRestituicao;
	
	private double velocidade;//Esta se torna desnecessária se a velocidade não mudar
	private double velocidadeInicial;
	
	private double aceleracao;
	private double aceleracaoY;
	
	private double posicaoXMetros = 0;	//Posicao em Metros
	private double posicaoYMetros = 0;
	
	private double posicaoXPx; //Posicao em Pixels
	private double posicaoYPx;
	
	private double posFinalMetros = 0;//Posição final do objeto em metros
	private double posFinalPix = 0;//Posição final do objeto em Pixels
	
	private double forcaNormal = 0;//Força normal agindo no objeto
	
	
	//Metodos
	//--Getters
//	public static double getAltura() {return altura;}---Variáveis estáticas não precisam de getters
//	public static double getLargura() {return largura;}
	public double getMassa() {return massa;}
	public double getCoefRestituicao() {return coefRestituicao;}
	public double getVelocidade() {return velocidade;}
	public double getVelocidadeInicial() {return velocidadeInicial;}
	public double getAceleracao() {return aceleracao;}
	public double getAceleracaoY() {return aceleracaoY;}
	public double getPosicaoXMetros() {return posicaoXMetros;}
	public double getPosicaoYMetros() {return posicaoYMetros;}
	public double getPosicaoXPx() {return posicaoXPx;}
	public double getPosicaoYPx() {return posicaoYPx;}
	public double getForcaNormal(){return forcaNormal;}
	public double getPosFinalMetros(){return posFinalMetros;}
	public double getPosFinalPix(){return posFinalPix;}
	
	//Setters
	public void setMassa(double massa) {this.massa = massa;}
	public void setCoefRestituicao(double coefRestituicao) {this.coefRestituicao = coefRestituicao;}
	public void setVelocidade(double velocidade) {this.velocidade = velocidade;}
	public void setVelocidadeInicial(double velocidadeInicial) {this.velocidadeInicial = velocidadeInicial;}
	public void setAceleracao(double aceleracao) {
		this.aceleracao = aceleracao;
//		cpi.mudaValorAceleracao(this.aceleracao);//Altera o valor da aceleração no PInfo
	}
	public void setAceleracaoY(double aceleracaoY) {this.aceleracaoY = aceleracaoY;}
	public void setPosicaoXMetros(double posicaoXMetros) {
		this.posicaoXMetros = posicaoXMetros;
//		cpi.mudaValorPosAtualX(this.posicaoX);//Atualiza posição em metros do eixo X no PInfo
	}
	public void setPosicaoYMetros(double posicaoYMetros) {
		this.posicaoYMetros = posicaoYMetros;
//		cpi.mudaValorPosAtualY(this.posicaoY);//Atualiza posição em metros do eixo Y no PInfo
	}
	public void setPosicaoXPx(double posicaoXPx) {this.posicaoXPx = posicaoXPx;}
	public void setPosicaoYPx(double posicaoYPx) {this.posicaoYPx = posicaoYPx;}
	public void setForcaNormal(double forcaNormal){this.forcaNormal = forcaNormal;}
	public void setPosFinalMetros(double posFinalMetros){this.posFinalMetros = posFinalMetros;}
	public void setPosFinalPix(double posFinalPix){this.posFinalPix = posFinalPix;}
	
}
