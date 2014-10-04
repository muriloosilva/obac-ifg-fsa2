package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControleObjeto2Subida implements ControleObjeto0Generico, Runnable{
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
	
	//Construtor_________________________________
	public ControleObjeto2Subida(ModeloAmbiente ma,VisaoPainelFormulas vpf, 
		ControleOBAC cOBAC,	ControleFormulasObjeto cfo, ControleFormulasSuperficie cfs
	){
		//Passagem das refetrencias
			this.ma = ma;
			this.cOBAC = cOBAC;
			this.vpf = vpf;
			this.cfo = cfo;
		
		//Realização dos cálculos
			cfo.calculaForcaNormal();//FOrça Normal
			cfs.calculaForcaAtritoPadrao();//Força de Atrito
			cfo.calculaAceleracaoSubida();;//Aceleração
			cfo.calculaPosFinalPadrao();//Posição Final
			cfs.calculaEscalaPadrao();//Escala
			ma.getmO().setPosFinalXPix(130+UtilidadeConvercoesEscala.converteMetroEmPixelX(ma.getmEH().getComprimentoEscalaPX(), ma.getmO().getPosFinalXMetros(), ma.getmEH().getEscalaFimXM()));//Ponto fina em Pixel
			cfo.calculaTempo();//Tempo total de Simulação em segundos
			ma.setTempoAtual(0);//Seta o tempo inicial na variável
		
		//Início da Thread
			t = new Thread(this);
			t.start();
	}
	
	@Override
	public void run() {
		while(true){
			if(continuar){
				if(cfo.paradaSubida()==false){
					//Calcula nova posição em METROS
						cfo.calculaNovaPosicao();
					//Converte a posição em METROS para PIXEL para poder movimentar o objeto
						ma.getmO().setPosicaoXPx(130 +UtilidadeConvercoesEscala.converteMetroEmPixelX(ma.getmEH().getComprimentoEscalaPX(),ma.getmO().getPosicaoXMetros(),ma.getmEH().getEscalaFimXM()));
					//Repinta o painel para mostar o andamento da simulação
						cOBAC.repinta();
					//Repinta o painel de fórmulas
						vpf.repaint();
					//Atualiza o tempo
						ma.setTempoAtual(ma.getTempoAtual()+atrasoSPadrao);
				}
				else{parar();}
			}
			//Parada no carregamento para dar o realismo da simulação
			//Esta ocorre no final para possibilitar a pausa da simulação
				try {	t.sleep(atrasoMS);	}
				catch (InterruptedException e) {System.err.println("Erro na Thread!");}
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
	public void parar() {cOBAC.repinta(); pausar(); t.interrupt(); t.stop();}

}
