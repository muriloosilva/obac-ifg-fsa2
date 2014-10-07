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
	public static final int pontoFinalObjetoSubidaPix = 130; 
	
	//--Int
	public static final int pXPadPx = 130; //Posição X de quase todas as simulações
	
	public static final int pQueXPx = 361; //Posição X da QL
	
	public static final int pPlaYPx = 470; //Posição Y do plano

	public static final int pSubYPx = 430; //Posição Y da subida

	public static final int pDesYPx = 466; //Posição Y da descida

	public static final int pPepYPx = 166; //Posição Y do PEP

	public static final int pQueYPx = 104; //Posição Y da QL

	public static final int pOblYPx = 470; //Posição Y do LO
	
	//Variaveis
	//--Double	
	private double massa=10;
	private double coefRestituicao;
	
	private double velocidade;//Esta se torna desnecessária se a velocidade não mudar
	private double velocidadeInicial = 0;
	
	private double aceleracao;
	private double aceleracaoY;
	
	private double posicaoXMetros = 0;	//Posicao em Metros
	private double posicaoYMetros = 0;
	
	private double posFinalXMetros = 0;//Posição final do objeto em metros no eixo X
	private double posFinalYMetros = 0;//Posição final do objeto em metros no eixo Y
	
	private double forcaNormal = 0;//Força normal agindo no objeto
	
	//--Int
	//Posicao em Pixels
	private int posicaoXPx = 130;
	private int posicaoYPx = 470;
	
	private int posFinalXPix = 0;//Posição final do objeto em Pixels no eixo X
	private int posFinalYPix = 0;//Posição final do objeto em Pixels no eixo Y 
	
	//Metodos
	//--Getters
	public int getPosFinalXPix(){return posFinalXPix;}
	public int getPosFinalYPix(){return posFinalYPix;}
	public int getPosicaoXPx() {return posicaoXPx;}
	public int getPosicaoYPx() {return posicaoYPx;}
	public double getMassa() {return massa;}
	public double getCoefRestituicao() {return coefRestituicao;}
	public double getVelocidade() {return velocidade;}
	public double getVelocidadeInicial() {return velocidadeInicial;}
	public double getAceleracao() {return aceleracao;}
	public double getAceleracaoY() {return aceleracaoY;}
	public double getPosicaoXMetros() {return posicaoXMetros;}
	public double getPosicaoYMetros() {return posicaoYMetros;}
	public double getForcaNormal(){return forcaNormal;}
	public double getPosFinalXMetros(){return posFinalXMetros;}
	public double getPosFinalYMetros(){return posFinalYMetros;}
	
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
//		cpi.mudaValorVelocidadePosColisao(velocidade);
		cpi.mudaValorVelocidade(velocidade);
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
		
		if(this.posFinalXMetros<0)
			cpi.mudaValorPosFinalX(this.posFinalXMetros*-1);
		else
			cpi.mudaValorPosFinalX(this.posFinalXMetros);
	}	
}