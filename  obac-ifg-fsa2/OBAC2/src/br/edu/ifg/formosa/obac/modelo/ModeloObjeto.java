package br.edu.ifg.formosa.obac.modelo;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;

public class ModeloObjeto {
	
	//ControleInicioSimulacoes Painel de Configuração - atualizar dados referente ao ambiente
	private ControlePainelInformacao cpi = null;
	
	//Construtor - To deixando desativado para vc arrumar o modelo ambiente depois
		//Os controles do CPI tbm estão comentados para evitar problimas no funcionamento
	public ModeloObjeto(ControlePainelInformacao cpi) {
		this.cpi = cpi;
	}
	
	//Constantes
	//--Double
	public static final int alturaLargura = 30; //Os valores de alt e larg sao para inicializar as variaveis
	
	public static final int pontoFinalObjetoDescidaPix = 518;
	public static final int pontoFinalObjetoSubidaPix = 0;
	
	//Variaveis
	//--Double	
	private double massa;
	private double coefRestituicao;
	
	private double velocidade;//Esta se torna desnecessária se a velocidade não mudar
	private double velocidadeInicial = 0;
	
	private double aceleracao;
	private double aceleracaoY;
	
	private double posicaoXMetros = 0;	//Posicao em Metros
	private double posicaoYMetros = 0;
	
	private double posFinalXMetros = 0;//Posição final do objeto em metros no eixo X
	private int posFinalXPix = 0;//Posição final do objeto em Pixels no eixo X
	private double posFinalYMetros = 0;//Posição final do objeto em metros no eixo Y
	private int posFinalYPix = 0;//Posição final do objeto em Pixels no eixo Y 
	
	private double forcaNormal = 0;//Força normal agindo no objeto
	
	//--Int
	//Posicao em Pixels
	private int posicaoXPx = 130; 
	private int posicaoYPx = 470;
	
	//Metodos
	//--Getters
	public double getMassa() {return massa;}
	public double getCoefRestituicao() {return coefRestituicao;}
	public double getVelocidade() {return velocidade;}
	public double getVelocidadeInicial() {return velocidadeInicial;}
	public double getAceleracao() {return aceleracao;}
	public double getAceleracaoY() {return aceleracaoY;}
	public double getPosicaoXMetros() {return posicaoXMetros;}
	public double getPosicaoYMetros() {return posicaoYMetros;}
	public int getPosicaoXPx() {return posicaoXPx;}
	public int getPosicaoYPx() {return posicaoYPx;}
	public double getForcaNormal(){return forcaNormal;}
	public double getPosFinalXMetros(){return posFinalXMetros;}
	public int getPosFinalXPix(){return posFinalXPix;}
	public double getPosFinalYMetros(){return posFinalYMetros;}
	public int getPosFinalYPix(){return posFinalYPix;}
	
	//Setters
	public void setMassa(double massa) {this.massa = massa;}
	public void setCoefRestituicao(double coefRestituicao) {this.coefRestituicao = coefRestituicao;}
	public void setAceleracaoY(double aceleracaoY) {this.aceleracaoY = aceleracaoY;}
	public void setPosicaoXPx(int posicaoXPx) {this.posicaoXPx = posicaoXPx;}
	public void setPosicaoYPx(int posicaoYPx) {this.posicaoYPx = posicaoYPx;}
	public void setPosFinalXPix(int posFinalXPix){this.posFinalXPix = posFinalXPix;}
	public void setPosFinalYPix(int posFinalYPix){this.posFinalYPix = posFinalYPix;}
	
	//Setters relacionados ao Painel de Informação
	public void setPosFinalYMetros(double posFinalYMetros){
		this.posFinalYMetros = posFinalYMetros;
		cpi.mudaValorPosFinalY(posFinalYMetros);
	}
	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
		cpi.mudaValorVelocidadePosColisao(velocidade);
	}
	public void setVelocidadeInicial(double velocidadeInicial) {
		this.velocidadeInicial = velocidadeInicial;
		cpi.mudaValorVelocidade(velocidadeInicial);
	}
	public void setAceleracao(double aceleracao) {
		this.aceleracao = aceleracao;
		cpi.mudaValorAceleracao(this.aceleracao);//Altera o valor da aceleração no PInfo
	}
	public void setPosicaoXMetros(double posicaoXMetros) {
		this.posicaoXMetros = posicaoXMetros;
		cpi.mudaValorPosAtualX(this.posicaoXMetros);//Atualiza posição em metros do eixo X no PInfo
	}
	public void setPosicaoYMetros(double posicaoYMetros) {
		this.posicaoYMetros = posicaoYMetros;
		cpi.mudaValorPosAtualY(this.posicaoYMetros);//Atualiza posição em metros do eixo Y no PInfo
	}
	public void setForcaNormal(double forcaNormal){
		this.forcaNormal = forcaNormal;
		cpi.mudaValorForcaNormal(this.forcaNormal);
	}
	public void setPosFinalXMetros(double posFinalXMetros){
		this.posFinalXMetros = posFinalXMetros;
		cpi.mudaValorPosFinalX(this.posFinalXMetros);
	}
	
}
