package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.controle.simulacao.ControleSimulacao;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControleObjeto4PlanoPrecipicio implements ControleObjeto0Generico, Runnable{	
	//Constantes
	private final int atrasoMS = 20;//Atraso da thread usado no Sleep (20 milisegundos)
	private final double atrasoSPadrao = 0.04;//Valor do tempo que é incrementado a cada nova posição
	
	//Variáveis
	private boolean iniciouPrecipicio = false;
	private boolean continuar = true;///Variável usada para pausar a simulação
	private double posInicialXQueda = 0;
	private double tempoLocal = 0;
	private double incrementoQueda = 0;
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
			ControleFormulasObjeto cfo, ControleFormulasSuperficie cfs
			)
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
		cfs.calculaEscalaVerticalPadrao();//Escala Vertical - 1000m
		ma.getmO().setPosFinalXPix(130+UtilidadeConvercoesEscala.converteMetroEmPixelX(ma.getmEH().getComprimentoEscalaPX(), ma.getmO().getPosFinalXMetros(), ma.getmEH().getEscalaFimXM()));//Ponto final em Pixel
		cfo.calculaTempo();//Tempo total de Simulação em segundos
		ma.setTempoAtual(0);//Seta o tempo inicial na variável
		//Repinta o painel de fórmulas
		vpf.repaint();

		ControleSimulacao.mudaMarcadores(ma.getmEH(), 2000);
		ma.getmO().setPosicaoYMetros(ma.getmEV().getMarcadoresEscala()[ModeloEscala.qtdMarcadores]);

		//Início da thread
		t = new Thread(this);
		t.start();
	}

	//Rodar
	private boolean torriceli = false;
	@Override
	public void run() {

		//Laço de repetição para a executar a movimentação do objeto
		while (true) {
			if (continuar) {
				if (!cfo.paradaPlanoPrecipicio()) {
					//Movimento na parte do plano
					if(ma.getmO().getPosicaoXPx()<=329){
						if(torriceli)
						//Atualiza a velocidade
						cfo.calculaVelocidadeTorricelli();
						//Calcula nova posição em METROS
						cfo.calculaNovaPosicao();
						//Converte a posição em METROS para PIXEL para poder movimentar o objeto
						ma.getmO().setPosicaoXPx(UtilidadeConvercoesEscala.metroParaPixelH(ma.getmEH(), ma.getmO().getPosicaoXMetros()));
						//Atualiza o tempo
						ma.setTempoAtual(ma.getTempoAtual()+atrasoSPadrao);
						torriceli = true;
					}
					// Movimento na parte do precipício
					else{
						if(!iniciouPrecipicio){
							ma.getmO().setPosicaoXPx(331);
							ma.getmO().setPosicaoYMetros(0);
							ma.getmO().setVelocidadeY(0);
							ma.getmO().setVelocidadeInicial(ma.getmO().getVelocidade());
							ma.setTempoTotal(ma.getTempoAtual());
							ma.setTempoAtual(0);
							
							double metro = UtilidadeConvercoesEscala.pixelParaMetroH(ma.getmEH(), 202);
							tempoLocal = metro / ma.getmO().getVelocidadeInicial();
									
							iniciouPrecipicio = true;
						}						
						
						ma.getmO().setPosicaoXMetros(ma.getmO().getVelocidadeInicial() * tempoLocal);
						
						ma.getmO().setVelocidadeY(ma.getGravSelecionada() * ma.getTempoAtual());
						ma.getmO().setPosicaoYMetros(ma.getmO().getVelocidadeY() * ma.getTempoAtual() * 0.5);
						
						
						ma.getmO().setPosicaoXPx(UtilidadeConvercoesEscala.metroParaPixelH(ma.getmEH(), ma.getmO().getPosicaoXMetros()));
						ma.getmO().setPosicaoYPx(UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), ma.getmO().getPosicaoYMetros()));
						
						cOBAC.repinta();
						
						//Atualiza o tempo
						ma.setTempoAtual(ma.getTempoAtual() + atrasoSPadrao);
						tempoLocal += atrasoSPadrao;
						System.out.println("Tempo: " + tempoLocal);
					}
					//Comandos abaixo ficam fora das condições pois pertencem a ambas
					//Repinta o painel para mostar o andamento da simulação
					cOBAC.repinta();
					//Repinta o painel de fórmulas
					vpf.repaint();
				}
				else {parar();}
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
	public void parar() {cOBAC.repinta(); pausar();	t.interrupt(); 	t.stop();}

}

