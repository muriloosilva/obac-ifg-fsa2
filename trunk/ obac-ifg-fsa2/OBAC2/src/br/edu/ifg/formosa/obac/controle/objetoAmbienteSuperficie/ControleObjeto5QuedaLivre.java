package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import javax.swing.JOptionPane;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControleObjeto5QuedaLivre implements ControleObjeto0Generico, Runnable{

	//CONSTANTES
	private final int ATRASO_MS = 20;//Atraso da thread usado no Sleep (20 milisegundos)
	private final double ATRASO_PADRAO = 0.04;//Valor do tempo que ï¿½ incrementado a cada nova posiï¿½ï¿½o
	private boolean continuar = true;///Variï¿½vel usada para pausar a simulaï¿½ï¿½o
	private boolean subida = false;
	private boolean descida = true;
	private double soma = 0.0;
	private double tempoLocal = 0.0;
	double escala = 0.0;

	private ModeloAmbiente ma;
	private VisaoPainelFormulas vpf;
	private ControleOBAC cOBAC;
	private ControleFormulasObjeto cfo;
	private ControleFormulasSuperficie cfs;
	//VARIï¿½VEL DA THREAD
	private Thread t;


	public ControleObjeto5QuedaLivre(ModeloAmbiente ma, VisaoPainelFormulas vpf, ControleOBAC cOBAC, ControleFormulasObjeto cfo,
			ControleFormulasSuperficie cfs) {

		this.ma = ma;
		this.vpf = vpf;
		this.cOBAC = cOBAC;
		this.cfo = cfo;
		this.cfs = cfs;

		cfo.calculaForcaNormal();
		cfs.calculaForcaAtritoQueda();
		cfo.calculaAceleracaoQueda();
		cfs.calculaEscalaVerticalPadrao();

		//Repinta o painel de fórmulas
		vpf.repaint();
		
		escala = ma.getmEV().getEscalaFimYM()/ 470;
		
		System.out.println("Escala: "+escala);
		System.out.println("Coeficiente de Restituição: "+ma.getmO().getCoefRestituicao());
		System.out.println("Fim da escala Pixel: "+ma.getmEV().getEscalaFimYPix());
		ma.getmO().setPosicaoYMetros(1000);
		
		//Início da thread
		t = new Thread(this);
		t.start();




		/*objectControl.calculaNormal(); --
		surfaceControl.calculaAtrito(); --
		objectControl.calculaAceleracaoFall(); --
		surfaceControl.calculaEscalaFall(); --
		objectControl.calculaCoefRestituicao(e); achei inutil rsrs*/
	}

	@Override
	public void run() {

		while(true){
			
			if(continuar){
				
				/*double velocidadeFinal1;
				//1ª Queda Livre
				if(ma.getmO().getPosicaoYPx() >= 470){
					System.out.println("soma: "+soma);
					//Inverte o valor da aceleração
					if(ma.getmO().getAceleracao() < 0){
						ma.getmO().setAceleracao(ma.getmO().getAceleracao() *  (-1));
					}
					
					ma.getmO().setPosicaoYPx(470);
					int velocidadeFinal2 = 0;
					
					if(soma>=0 && !queda){
						System.out.println("Primeiro");
						velocidadeFinal2 = (int)(0 + 2 * ma.getmO().getAceleracao() * (soma * escala));
					}
					else{
						System.out.println("SEGUNDA");
						velocidadeFinal2 = (int)((ma.getmO().getVelocidadeInicial() * ma.getmO().getVelocidadeInicial()) + 
								2 * ma.getmO().getAceleracao() * (ma.getmEV().getEscalaFimYM()));
																//Variaï¿½ï¿½o de espaï¿½o
					}
					
					soma = 0;
					double vf = Math.sqrt(velocidadeFinal2);
					
					velocidadeFinal1 =
							vf*(ma.getmO().getMassa()- 1000000000 *ma.getmO().getCoefRestituicao())/
							(ma.getmO().getMassa() + 1000000000)*(-1);
					
					if(velocidadeFinal1 <=0)
						continuar = false;
					
					ma.getmO().setVelocidadeInicial(velocidadeFinal1);
					ma.getmO().setAceleracao(ma.getmO().getAceleracao() * (-1));
					ma.setTempoAtual(0.04);
					queda = false;			
					
				}
				
				if(queda){
					
					cfo.calculaNovaPosicaoY();
					
					ma.getmO().setPosicaoYPx(604 -
							UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), ma.getmO().getPosicaoYMetros()));
					
				}
				else{
					cfo.calculaNovaPosicaoY();
					
                	//novaPosicï¿½o ï¿½ igual ao solo - posicaoAtualYPixel
                	double novaPosicao = 470 - ma.getmO().getPosicaoYMetros() / escala;
                	//- (environment.getObjeto().getPosicaoAtualY()/environment.getSurface().getEscala())
	                if(novaPosicao <= (ma.getmO().getPosicaoYPx())){
	                	System.out.println("PY: "+ma.getmO().getPosicaoYMetros());
	                	soma = (ma.getmO().getPosicaoYMetros() / escala);
	                }
	                ma.getmO().setPosicaoYPx((int)novaPosicao);	
	                
				}*/
				
				/*if(ma.getmO().getPosicaoYPx() < (UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), 0) - 30)){
					ma.getmO().setVelocidade(ma.getGravSelecionada() * tempoLocal);
					ma.getmO().setPosicaoYMetros(1000 - (ma.getmO().getVelocidade() * Math.pow(ma.getTempoAtual(), 2) * 0.5));
				}*/
				
				//Atualiza o tempo
				ma.setTempoAtual(ma.getTempoAtual()+ATRASO_PADRAO);
				ma.setTempoTotal(ma.getTempoTotal()+ma.getTempoTotal());
				tempoLocal += ATRASO_PADRAO;
				
//				ma.getmO().setVelocidade(ma.getGravSelecionada() * tempoLocal);
//				System.out.println("Velocidade: " +ma.getmO().getVelocidade());
//				cfo.calculaVelocidadeTorricelli(ma.getmO().getPosicaoYMetros());
//				ma.getmO().setPosicaoYMetros(1000 - (ma.getmO().getVelocidade() * Math.pow(ma.getTempoAtual(), 2) * 0.5));	
				
				//DESCIDA++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if(descida && ma.getmO().getPosicaoYPx() < (UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), 0) - 30)){
//					ma.getmO().setVelocidade(ma.getGravSelecionada() * tempoLocal);
					cfo.calculaVelocidadeTorricelli(ma.getmO().getPosicaoYMetros());
					ma.getmO().setPosicaoYMetros(1000 - (ma.getmO().getVelocidade() * Math.pow(ma.getTempoAtual(), 2) * 0.5));	
					System.out.println("Here|Descendo --- " +ma.getmO().getPosicaoYMetros());
				}else if(descida && ma.getmO().getPosicaoYPx() >= (UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), 0) - 30)){
					descida = false;	subida = true;
					tempoLocal = ATRASO_PADRAO;
					ma.setTempoAtual(tempoLocal);
//					ma.getmO().setAceleracao(ma.getmO().getAceleracao() * ma.getmO().getCoefRestituicao() * (-1));
					ma.getmO().setVelocidadeInicial(ma.getmO().getVelocidade()*ma.getmO().getCoefRestituicao());;
					
					if(ma.getmO().getAceleracao() > 0)
						ma.getmO().setAceleracao(ma.getmO().getAceleracao() * (-1));
					
					ma.getmO().setPosicaoYPx((UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), 0) - 30));
					ma.getmO().setPosicaoYMetros(0);
					
					if(ma.getmO().getVelocidadeInicial()<=0){System.err.println("Fim QL!");break;}
					System.out.println("Bateu");
				}else{
					System.err.println("E?");
//					break;
				}
				
				//SUBIDA+++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if(subida && ma.getmO().getVelocidade() > 0){
					ma.getmO().setVelocidade(ma.getmO().getAceleracao() * tempoLocal);
//					cfo.calculaVelocidadeTorricelli(ma.getmO().getPosicaoYMetros());
					ma.getmO().setPosicaoYMetros(-1*(ma.getmO().getVelocidade() * Math.pow(ma.getTempoAtual(), 2) * 0.5));
					System.out.println("Subida --- " +ma.getmO().getPosicaoYMetros());
					try {	t.sleep(500);	}
					catch (InterruptedException e) {System.err.println("Erro na Thread!");}
				} else if(subida && ma.getmO().getVelocidade() <= 0){
					subida = false;		descida = true;
					tempoLocal = 0;
					if(ma.getmO().getAceleracao() < 0)
						ma.getmO().setAceleracao(ma.getmO().getAceleracao() * (-1));
					System.out.println("Descendo");
				}
				
				//Repinta o painel para mostar o andamento da simulaï¿½ï¿½o
				ma.getmO().setPosicaoYPx(UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), ma.getmO().getPosicaoYMetros()));
				cOBAC.repinta();
				vpf.repaint();
				//Repinta o painel de fï¿½rmulas
				vpf.repaint();
//				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
				
				//Parada no carregamento para dar o realismo da simulação
				//Esta ocorre no final para possibilitar a pausa da simulação
					try {	t.sleep(ATRASO_MS);	}
					catch (InterruptedException e) {System.err.println("Erro na Thread!");}
			}
				//Repinta o painel para mostar o andamento da simulaï¿½ï¿½o
				ma.getmO().setPosicaoYPx(UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), ma.getmO().getPosicaoYMetros()));
				cOBAC.repinta();
				vpf.repaint();
				//Repinta o painel de fï¿½rmulas
				vpf.repaint();
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

