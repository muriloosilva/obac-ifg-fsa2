package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.controle.simulacao.ControleSimulacao;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControleFormulasSuperficie {

	private ModeloAmbiente ma = null;
	private VisaoPainelFormulas vPF = null;
	private ControlePainelFormulas cPF=null;
	
	//Construtor
	public ControleFormulasSuperficie(ModeloAmbiente ma,
			VisaoPainelFormulas vPF, ControlePainelFormulas cPF) {
		this.ma = ma;
		this.cPF = cPF;
		this.vPF = vPF;
	}
			
	//Atrito Padrão -> Fat = N * μ
	public void calculaForcaAtritoPadrao(){
		ma.getmS().setForcaAtrito((
			ma.getmO().getForcaNormal()*ma.getmS().getCoefAtritoSelecionado()
		));
		//Passa para o painel de fórmulas
		vPF.getAtAtrito().setText(
				cPF.atrito(ma.getmO().getForcaNormal(), ma.getmS().getCoefAtritoSelecionado()));
	}
	
	
	//Atrito na Queda -> Fat = N * μ -> μ=0
	public void calculaForcaAtritoQueda(){ma.getmS().setForcaAtrito(0);}
	
//Escalas
	//Calcula escala Padrão
		public void calculaEscalaPadrao(){
			long pontoFinalEscala=formulaEscala(ma.getmO().getPosFinalXMetros());
			//Passa o ponto final da escala para a escala real
				ma.getmEH().setEscalaFimXM(pontoFinalEscala);
				ma.getmEV().setEscalaFimXM(pontoFinalEscala);
				ControleSimulacao.mudaMarcadores(ma.getmEH(), (int)pontoFinalEscala);
				ControleSimulacao.mudaMarcadores(ma.getmEV(), (int)pontoFinalEscala);
		}
	//Calcula escala Padrão
		public void calculaEscalaDescida(){
			long pontoFinalEscala=formulaEscala(ma.getmO().getPosFinalXMetros()*-1);
			//Passa o ponto final da escala para a escala real
				ma.getmEH().setEscalaFimXM(pontoFinalEscala);
		}
	//---Trecho de código que calcula a escala - Como método evita repetição de código
		private long formulaEscala(double pfMetro){
			long pontoFinalEscala=0;
			//Laço de repetição que gera o tamanho da escala
				for(int i = 1; i<=pfMetro; i*=10){pontoFinalEscala=i;}
			//Uma ultima epansão no valor para dar mais dinamismo na simulação 
				pontoFinalEscala*=10;
			//Verificação realizada para que a escala não tenha um ponto final muito distante
			//Se o objeto parar antes da metade da escala, a escala é reduzida pela metade
				if(pontoFinalEscala > (2*ma.getmO().getPosFinalXMetros())){pontoFinalEscala = pontoFinalEscala/2;}
			//Teste que impede a escala de ter um valor menor que o seu valor mínimo(100m)
				if(pontoFinalEscala < 100){pontoFinalEscala = 100;}
			//Retorno do ponto final da escala
				return pontoFinalEscala;
		}
		
	//Calcula escala Queda Livre
	public void calculaEscalaQueda(){
		long pontoFinalEscala=1000;//Esta escala possui o tamanho fixo de 1000 Metros
		ma.getmEV().setEscalaFimYM(pontoFinalEscala);
		//Verificar o surface.setEscala() do OBAC original. Qual a utilidade dele
	}
	
	//Calcula Escala P&P
	public void escalaPlanoPrecipicio(){}
}