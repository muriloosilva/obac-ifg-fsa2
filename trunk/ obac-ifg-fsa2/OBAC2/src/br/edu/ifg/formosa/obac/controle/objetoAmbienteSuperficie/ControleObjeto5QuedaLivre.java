package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControleObjeto5QuedaLivre implements ControleObjeto0Generico, Runnable{

	//CONSTANTES
	private final int ATRASO_MS = 20;//Atraso da thread usado no Sleep (20 milisegundos)
	private final double ATRASO_PADRAO = 0.04;//Valor do tempo que � incrementado a cada nova posi��o
	private boolean continuar = true;///Vari�vel usada para pausar a simula��o
	private boolean queda = true;
	private double soma = 0.0;
	double escala = 0.0;

	private ModeloAmbiente ma;
	private VisaoPainelFormulas vpf;
	private ControleOBAC cOBAC;
	private ControleFormulasObjeto cfo;
	private ControleFormulasSuperficie cfs;
	//VARI�VEL DA THREAD
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
		cfs.calculaEscalaQueda();

		//Repinta o painel de f�rmulas
		vpf.repaint();
		
		
		ma.getmEV().setEscalaFimYM(1000);
		ma.getmO().setCoefRestituicao(0.0);
		escala = 1000 / 470;
		
		System.out.println("Escala: "+escala);
		System.out.println("Coeficiente de Restitui��o: "+ma.getmO().getCoefRestituicao());
		System.out.println("Fim da escala Pixel: "+ma.getmEV().getEscalaFimYPix());
		
		/*OBS.: O coeficiente de restitui��o n�o est� sendo passado
		 * para a vari�vel, o que acarreta em um coeficiente igual a 0
		 * 
		 */

		//In�cio da thread
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
				
				double velocidadeFinal1;
				
				if(ma.getmO().getPosicaoYPx() >= 470){
					System.out.println("soma: "+soma);
					if(ma.getmO().getAceleracao() < 0){
						ma.getmO().setAceleracao(ma.getmO().getAceleracao() *  (-1));
					}
					
					ma.getmO().setPosicaoYPx(470);
					
					int velocidadeFinal2 = 0;
					
					if(soma >= 0 && !queda){
						System.out.println("Primeiro");
						velocidadeFinal2 = (int)(0 + 2 * ma.getmO().getAceleracao() * (soma * escala));
					}
					else{
						System.out.println("SEGUNDA");
						velocidadeFinal2 = (int)((ma.getmO().getVelocidadeInicial() * ma.getmO().getVelocidadeInicial()) + 
								2 * ma.getmO().getAceleracao() * (1000 ));
																//Varia��o de espa�o
					}
					
					soma = 0;
					double vf = Math.sqrt(velocidadeFinal2);
					
					
					velocidadeFinal1 = vf*(ma.getmO().getMassa()- 1000000000 *ma.getmO().getCoefRestituicao())/
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
					
                	//novaPosic�o � igual ao solo - posicaoAtualYPixel
                	double novaPosicao = 470 - ma.getmO().getPosicaoYMetros() / escala;
     
                	
                	//- (environment.getObjeto().getPosicaoAtualY()/environment.getSurface().getEscala())
           
	                if(novaPosicao <= (ma.getmO().getPosicaoYPx())){
	           
	                	soma = (ma.getmO().getPosicaoYMetros() / escala);
	                }
	                
	                ma.getmO().setPosicaoYPx((int)novaPosicao);	
	                
				}
				
				//Repinta o painel para mostar o andamento da simula��o
				cOBAC.repinta();
				vpf.repaint();
				//Repinta o painel de f�rmulas
				vpf.repaint();
				
				try {
					t.sleep(ATRASO_MS);	
				}
				catch (InterruptedException e) {
					System.err.println("Execu��o Interrompida: "+e.getMessage());
				}
				//Atualiza o tempo
				ma.setTempoAtual(ma.getTempoAtual()+ATRASO_PADRAO);
			}
			else{parar();}
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

