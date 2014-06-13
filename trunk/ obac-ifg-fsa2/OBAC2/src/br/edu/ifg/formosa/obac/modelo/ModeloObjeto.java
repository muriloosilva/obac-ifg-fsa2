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
	
	public final double posXPlano = 0; //As 12 variaveis que se seguem orientam a posicao inical do objeto em pixels nas diferetes simulacoes. Valores devem ser preenchidos corretamete
	public final double posYPlano = 0;
	
	public final double posXSubida = 0;
	public final double posYSubida = 0;
	
	public final double posXDescida = 0;
	public final double posYDescida = 0;
	
	public final double posXPrecipicio = 0;
	public final double posYPrecipicio = 0;
	
	public final double posXQueda = 0;
	public final double posYQueda = 0;
	
	public final double posXLancamento = 0;
	public final double posYLancamento = 0;
	//Variaveis
	//--Double	
	private double massa;
	private double coefRestituicao;
	
	private double velocidade;
	private double velocidadeInicial;
	
	private double aceleracao;
	private double aceleracaoY;
	
	private double posicaoX = 0;	//Posicao em Metros
	private double posicaoY = 0;
	
	private double posicaoXPx; //Posicao em Pixels
	private double posicaoYPx;
	
	
	//Metodos
	//--Getters
	public static double getAltura() {return altura;}
	public static double getLargura() {return largura;}
	public double getMassa() {return massa;}
	public double getCoefRestituicao() {return coefRestituicao;}
	public double getVelocidade() {return velocidade;}
	public double getVelocidadeInicial() {return velocidadeInicial;}
	public double getAceleracao() {return aceleracao;}
	public double getAceleracaoY() {return aceleracaoY;}
	public double getPosicaoX() {return posicaoX;}
	public double getPosicaoY() {return posicaoY;}
	public double getPosicaoXPx() {return posicaoXPx;}
	public double getPosicaoYPx() {return posicaoYPx;}
	
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
	public void setPosicaoX(double posicaoX) {
		this.posicaoX = posicaoX;
//		cpi.mudaValorPosAtualX(this.posicaoX);//Atualiza posição em metros do eixo X no PInfo
	}
	public void setPosicaoY(double posicaoY) {
		this.posicaoY = posicaoY;
//		cpi.mudaValorPosAtualY(this.posicaoY);//Atualiza posição em metros do eixo Y no PInfo
	}
	public void setPosicaoXPx(double posicaoXPx) {this.posicaoXPx = posicaoXPx;}
	public void setPosicaoYPx(double posicaoYPx) {this.posicaoYPx = posicaoYPx;}
	
}