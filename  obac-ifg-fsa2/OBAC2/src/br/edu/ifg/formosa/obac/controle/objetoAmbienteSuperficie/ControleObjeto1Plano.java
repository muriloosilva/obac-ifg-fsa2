package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControleObjeto1Plano implements ControleObjeto0Generico, Runnable{
	
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
	
	
	//Controle______________________________
	public ControleObjeto1Plano(ModeloAmbiente ma,VisaoPainelFormulas vpf, 
								ControleOBAC cOBAC,
								ControleFormulasObjeto cfo, ControleFormulasSuperficie cfs)
	{
		//Passagem das refetrencias
			this.ma = ma;
			this.cOBAC = cOBAC;
			this.vpf = vpf;
			this.cfo = cfo;
		
		//Cáclculos referentes a esta simulação
			cfo.calculaForcaNormal();//Força normal
			cfs.calculaForcaAtritoPadrao();//Força de Atrito
			cfo.calculaAceleracaoPlano();//Aceleração
			cfo.calculaPosFinalPadrao();//Posição final em Metros
			cfs.calculaEscala();//Escala
			ma.getmO().setPosFinalXPix(UtilidadeConvercoesEscala.converteMetroEmPixelX(ma.getmEH().getComprimentoEscalaPx(), ma.getmO().getPosFinalXMetros(), ma.getmEH().getEscalaFimXM()));//Ponto fina em Pixel
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
				
				if (cfo.paradaPlano()==false) {
					
					//Calcula nova posição em METROS
					cfo.calculaNovaPosicao();
					//Converte a posição em METROS para PIXEL para poder movimentar o objeto
					ma.getmO().setPosicaoXPx(130 +
							UtilidadeConvercoesEscala.converteMetroEmPixelX(
									ma.getmEH().getComprimentoEscalaPx(),
									ma.getmO().getPosicaoXMetros(),
									ma.getmEH().getEscalaFimXM()));
					
					//System.out.println(ma.getmO().getPosicaoXPx());
					//Repinta o painel para mostar o andamento da simulação
					cOBAC.repinta();
					vpf.repaint();
					//Repinta o painel de fórmulas
					vpf.repaint();
					//Parada no carregamento para dar o realismo da simulação
					try {	t.sleep(atrasoMS);	}
					catch (InterruptedException e) {}
					//Atualiza o tempo
					ma.setTempoAtual(ma.getTempoAtual()+atrasoSPadrao);
					
					//System.out.println("PX M Atual: "+ma.getmO().getPosicaoXMetros());
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
	public void parar() {pausar();	t.interrupt(); 	t.stop();}
	
}
