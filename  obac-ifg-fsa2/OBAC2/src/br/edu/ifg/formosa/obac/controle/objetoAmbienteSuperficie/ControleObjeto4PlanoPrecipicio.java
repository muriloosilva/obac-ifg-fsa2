package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControleObjeto4PlanoPrecipicio implements ControleObjeto0Generico, Runnable{	
	//Constantes
		private final int atrasoMS = 20;//Atraso da thread usado no Sleep (20 milisegundos)
		private final double atrasoSPadrao = 0.04;//Valor do tempo que é incrementado a cada nova posição
	//Variáveis
		private boolean continuar = true;///Variável usada para pausar a simulação
		private Thread t = null;//Thread
	//Variáveis do OBAC
		//-----Modelos
		private ModeloAmbiente ma = null;
		//-----Visões
		private VisaoPainelFormulas vpf = null;
		//-----Controles
		private ControleOBAC cOBAC = null;
		private ControleFormulasObjeto cfo = null;
	
	
	//Construtor______________________________
	public ControleObjeto4PlanoPrecipicio(ModeloAmbiente ma,VisaoPainelFormulas vpf, 
								ControleOBAC cOBAC,
								ControleFormulasObjeto cfo, ControleFormulasSuperficie cfs)
	{
		//Passagem das refetrencias
			this.ma = ma;
			this.cOBAC = cOBAC;
			this.vpf = vpf;
			this.cfo = cfo;
		//Cáclculos referentes a parte plana desta simulação
			cfo.calculaForcaNormal();//Força normal
			cfs.calculaForcaAtritoPadrao();//Força de Atrito
			cfo.calculaAceleracaoPlano();//Aceleração
			cfo.calculaPosFinalPadrao();//Posição final em Metros
			cfs.calculaEscalaPadrao();//Escala
			ma.getmO().setPosFinalXPix(130+UtilidadeConvercoesEscala.converteMetroEmPixelX(ma.getmEH().getComprimentoEscalaPX(), ma.getmO().getPosFinalXMetros(), ma.getmEH().getEscalaFimXM()));//Ponto fina em Pixel
			cfo.calculaTempo();//Tempo total de Simulação em segundos
			ma.setTempoAtual(0);//Seta o tempo inicial na variável
			//Repinta o painel de fórmulas
			vpf.repaint();
		
		//Início da thread
		t = new Thread(this);
		t.start();
	}
	
	//Rodar
	@Override
	public void run() {
		
		//Laço de repetição para a executar a movimentação do objeto
		while (true) {
			if (continuar) {
				if (cfo.paradaPlanoPrecipicio()==false) {
					//Movimento na parte do plano
					if(ma.getmO().getPosicaoXPx()<=329){
						//Calcula nova posição em METROS
						cfo.calculaNovaPosicao();
						//Converte a posição em METROS para PIXEL para poder movimentar o objeto
						ma.getmO().setPosicaoXPx(130 +UtilidadeConvercoesEscala.converteMetroEmPixelX(ma.getmEH().getComprimentoEscalaPX(),ma.getmO().getPosicaoXMetros(),ma.getmEH().getEscalaFimXM()));
						//Atualiza o tempo
						ma.setTempoAtual(ma.getTempoAtual()+atrasoSPadrao);
					}
					// Movimento na parte do precipício
					else{
						
					}
					//Comandos abaixo ficam fora das condições pois pertencem a ambas
						//Repinta o painel para mostar o andamento da simulação
						cOBAC.repinta();
						//Repinta o painel de fórmulas
						vpf.repaint();
						//Parada no carregamento para dar o realismo da simulação
						try {	t.sleep(atrasoMS);	}
						catch (InterruptedException e) {System.err.println("Erro na Thread!");}
				}
				else {parar();}
			}
			else {parar();}
		}
		
	}
	
	//Continuar
	@Override
	public void continuar() {continuar=true;}
	
	//Pausar
	@Override
	public void pausar() {continuar=false;}
	
	//Parar
	@Override
	@SuppressWarnings("deprecation")
	public void parar() {cOBAC.repinta(); pausar();	t.interrupt(); 	t.stop();}

}

