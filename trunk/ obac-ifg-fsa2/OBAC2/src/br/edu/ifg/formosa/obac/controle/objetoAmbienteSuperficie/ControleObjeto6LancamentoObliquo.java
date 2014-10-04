package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.controle.simulacao.ControleSimulacao;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeArredondamento;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControleObjeto6LancamentoObliquo implements ControleObjeto0Generico, Runnable{
	
	public ControleObjeto6LancamentoObliquo() {}
	
	//Constantes
			private final int atrasoMS = 20; //Atraso da thread usado no Sleep (20 milisegundos)
			private final double atrasoSPadrao = 0.04;//Valor do tempo que é incrementado a cada nova posição
		//Variáveis
			private boolean continuar = true; //Variável usada para pausar a simulação
			private Thread t = null; //Thread
		//Variáveis do OBAC
			//-----Modelos
			private ModeloAmbiente ma = null;
			//-----Visões
			private VisaoPainelFormulas vpf = null;
			//-----Controles
			private ControleOBAC cOBAC = null;
			private ControleFormulasObjeto cfo = null;
		
		
		//Controle______________________________
		public ControleObjeto6LancamentoObliquo(ModeloAmbiente ma,VisaoPainelFormulas vpf, ControleOBAC cOBAC,
									ControleFormulasObjeto cfo, ControleFormulasSuperficie cfs)
		{
			//Passagem das refetrencias
				this.ma = ma;
				this.cOBAC = cOBAC;
				this.vpf = vpf;
				this.cfo = cfo;
			
			//Cáclculos referentes a esta simulação
			ma.getmP().getmC().tempoTotal();
			ma.getmP().getmC().alcanceMaximo();
			ma.getmO().setPosFinalXMetros(ma.getmP().getmC().getAlcanceMaximo());
			ma.getmP().getmC().alturaMaxima();
			ma.setTempoAtual(0);
			
			//Repinta o painel de fórmulas
			vpf.repaint();
			
			//Início da thread
			t = new Thread(this);
			t.start();
		}
		
		//Rodar
		@Override
		public void run() 
		{
			//Laço de repetição para a executar a movimentação do objeto
			while (true) {
				if (continuar) {
					if (ma.getTempoAtual() < ma.getTempoTotal()) {
						ma.getmP().getmC().novoX();
						ma.getmP().getmC().novoY();
						
						//Atualizar pixels  
						ma.getmO().setPosicaoXPx(
								UtilidadeConvercoesEscala.metroParaPixelH(ma.getmEH(), ma.getmO().getPosicaoXMetros()));
						
						ma.getmO().setPosicaoYPx(
								UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), ma.getmO().getPosicaoYMetros()) - 29);
						
						try {	
							t.sleep(atrasoMS);	
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						cOBAC.repinta();
						
						//Atualiza o tempo
						ma.setTempoAtual(ma.getTempoAtual() + atrasoSPadrao);
						
					} else {
						parar();
					}
				} else 
					parar();
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
