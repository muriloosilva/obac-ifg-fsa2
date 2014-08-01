package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;

public class ControleFormulasSuperficie {

	private ModeloAmbiente ma = null;
	
	//Construtor
	public ControleFormulasSuperficie(ModeloAmbiente ma) {
		this.ma = ma;
	}
			
	//Atrito Padrão -> Fat = N * μ
	public void calculaForcaAtritoPadrao(){
		ma.getmS().setForcaAtrito((
			ma.getmO().getForcaNormal()*ma.getmS().getCoefAtritoSelecionado()
		));
	}
	
	
	//Atrito na Queda -> Fat = N * μ -> μ=0
	public void calculaForcaAtritoQueda(){ma.getmS().setForcaAtrito(0);}
	
	//Calcula escala Padrão
	public void calculaEscala(){
		long pontoFinalEscala=0;
		
		//Laço de repetição que gera o tamanho da escala
		for(int i = 1; i<=ma.getmO().getPosFinalXMetros(); i*=10){pontoFinalEscala=i;}
		//Uma ultima epansão no valor para dar mais dinamismo na simulação 
		pontoFinalEscala*=10;
		
		//Verificação realizada para que a escala não tenha um ponto final muito distante
		//Se o objeto parar antes da metade da escala, a escala é reduzida pela metade
		if(pontoFinalEscala > (2*ma.getmO().getPosFinalXMetros())){pontoFinalEscala = pontoFinalEscala/2;}
		
		//Teste que impede a escala de ter um valor menor que o seu valor mínimo(100m)
		if(pontoFinalEscala < 100){pontoFinalEscala = 100;}
		
		//Passa o ponto final da escala para a escala real
		ma.getmE().setEscalaFimXM(pontoFinalEscala);
	}
	
	//Calcula escala Queda Livre
	public void calculaEscalaQueda(){
		long pontoFinalEscala=1000;//Esta escala possui o tamanho fixo de 1000 Metros
		ma.getmE().setEscalaFimYM(pontoFinalEscala);
		//Verificar o surface.setEscala() do OBAC original. Qual a utilidade dele
	}
	
	//Calcula Escala P&P
	public void escalaPlanoPrecipicio(){
		
	}
}