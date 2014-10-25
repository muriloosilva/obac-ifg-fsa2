package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
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
								ControleFormulasObjeto cfo, ControleFormulasSuperficie cfs
								)
	{
		//Passagem das refetrencias
			this.ma = ma;
			this.cOBAC = cOBAC;
			this.vpf = vpf;
			this.cfo = cfo;
			
		//Cáclculos referentes a parte plana desta simulação
			ma.setTempoAY(0);
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
				if (cfo.paradaPlanoPrecipicio()==false) {
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
						//0int finalPlanoMetros = UtilidadeConvercoesEscala.metroParaPixelH(ma.getmEH(), 330);
						//ma.getmO().setPosFinalXMetros(finalPlanoMetros);
						ma.getmO().setAceleracao(0);
						//System.out.println("Tempo++:" + ma.getTempoAtual());						
						//cfo.calculaNovaPosicao();
						
						ma.getmP().getmC().novoXPEP();
						//ma.getmO().setVelocidadeInicial(ma.getmO().getVelocidade());
						
						System.out.println("XMetros: " + ma.getmO().getPosicaoXMetros());
						
						ma.getmO().setPosicaoYMetros(ma.getmO().getPosicaoYMetros() - 
								ma.getmP().getmC().novoYPEP());
						
						//Atualizar pixels  
						if(ma.getmP().getmC().getEnergia()!=0){
							ma.getmO().setPosicaoXPx(
								UtilidadeConvercoesEscala.metroParaPixelH(ma.getmEH(), ma.getmO().getPosicaoXMetros()) - 118);
						} else {
							ma.getmO().setPosicaoXPx(
									UtilidadeConvercoesEscala.metroParaPixelH(ma.getmEH(), ma.getmO().getPosicaoXMetros()) - 128);
						}
						ma.getmO().setPosicaoYPx(
								UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), ma.getmO().getPosicaoYMetros()) + 3);
						
						cOBAC.repinta();
						
						//Atualiza o tempo
						ma.setTempoAY(ma.getTempoAY() + atrasoSPadrao);
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

