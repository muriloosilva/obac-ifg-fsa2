package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControleObjeto5QuedaLivre implements ControleObjeto0Generico, Runnable{

	//CONSTANTES
	private final int atrasoMS = 20;//Atraso da thread usado no Sleep (20 milisegundos)
	private final double atrasoSPadrao = 0.04;//Valor do tempo que ï¿½ incrementado a cada nova posiï¿½ï¿½o
	private boolean continuar = true;///Variï¿½vel usada para pausar a simulaï¿½ï¿½o
	private boolean subida = false;
	private boolean primeiraQueda = true;
	//	private double soma = 0.0;
	//	private double tempoLocal = 0.0;
	double escala = 0.0;
	double cacheAltura = 0;

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

		this.primeiraQueda=true;

		//Repinta o painel de fórmulas
		vpf.repaint();

//		escala = ma.getmEV().getEscalaFimYM()/ 470;
		this.cacheAltura=ma.getmO().getPosicaoInicialYM();
		ma.getmO().setPosFinalYMetros(cacheAltura*ma.getmO().getCoefRestituicao());

		System.out.println("Escala: "+escala);
		System.out.println("Coeficiente de Restituição: "+ma.getmO().getCoefRestituicao());
		System.out.println("Fim da escala Pixel: "+ma.getmEV().getEscalaFimYPix());
		//		ma.getmO().setPosicaoYMetros(1000);Desnecessário isso
		//		ma.getmO().setPosicaoInicialYM(1000);E isso também
		
		//Início da thread
		t = new Thread(this);
		t.start();

		System.out.println("Aceleração: " +ma.getmO().getAceleracao());


		/*objectControl.calculaNormal(); --
		surfaceControl.calculaAtrito(); --
		objectControl.calculaAceleracaoFall(); --
		surfaceControl.calculaEscalaFall(); --
		objectControl.calculaCoefRestituicao(e); achei inutil rsrs*/
		
	}
	double h0 = 1000;
	@Override
	public void run() {
		while(true){
			if(continuar){				
					//Aceleração>0 = Final da queda (bateu)
				if(ma.getmO().getAceleracao()<0 && velocidadeZero()){
					System.out.println("There|Inico da queda");
					ma.getmO().setVelocidadeInicial(0);//V0=0
					ma.getmO().setVelocidade(0);
					acoesInversas();
					ma.getmO().setPosicaoInicialYM(ma.getmO().getPosicaoYMetros());
					h0=ma.getmO().getPosicaoYMetros();
					if(ma.getmO().getPosicaoYMetros()<1.5)	break;
				}
				
				if((ma.getmO().getAceleracao()>0 || !subida) && bateu()){// && ma.getmO().getPosicaoYMetros()<=this.cacheAltura){
						System.out.println("Here|Inicio subida");
//						double va=Math.sqrt(2*h0*ma.getGravSelecionada());
						ma.getmO().setVelocidadeInicial(
//								Math.sqrt(ma.getmO().getVelocidade())*(ma.getmO().getMassa()- 1000000000 *ma.getmO().getCoefRestituicao())/(ma.getmO().getMassa() + 1000000000)*(-1)
								ma.getmO().getCoefRestituicao()*ma.getmO().getVelocidade()//va
//								Math.sqrt(2*ma.getmO().getAceleracao()*h0)
						);//V0=V*CoefR.
						acoesInversas();
						cacheAltura=ma.getmO().getPosicaoYMetros();
						ma.getmO().setPosicaoInicialYM(0);
						ma.getmO().setPosicaoYMetros(0);
						
						System.out.println("getVelocidadeInicial(): " +ma.getmO().getVelocidadeInicial());
						//cfo.calculaNovaPosicaoY(0);//Subida
						//ma.getmO().setPosicaoYMetros(ma.getmO().getPosicaoYMetros() * (-1));

						if((int)ma.getmO().getVelocidade()<0)	break;

						//Calcula a altura máxima da próxima
//						ma.getmO().setPosFinalYMetros(cacheAltura*ma.getmO().getCoefRestituicao());
					}
					//Aceleração<0 = Final da Subida (caiu de novo)
					
					if(bateu() && velocidadeZero()){break;}
				
					//Systens
					System.out.println("getPosicaoYMetros(): " +ma.getmO().getPosicaoYMetros());
					System.out.println("getVelocidade(): " +ma.getmO().getVelocidade());
					System.out.println("getAceleracao(): " +ma.getmO().getAceleracao());
					System.out.println("________________________________________");

					//Movimentação do objeto
					ma.setTempoAtual(ma.getTempoAtual() + atrasoSPadrao);
					ma.getmO().setVelocidade(ma.getmO().getVelocidadeInicial()+ma.getmO().getAceleracao()*ma.getTempoAtual());

					cfo.calculaNovaPosicaoY();
//					cfo.calculaVelocidadeTorricelli(ma.getmO().getPosicaoYMetros());
					if(!subida && primeiraQueda)
						ma.getmO().setPosicaoYMetros(1000 - ma.getmO().getPosicaoYMetros());
					//else if(!subida && !primeiraQueda && ma.getmO().getPosicaoInicialYM()>=1000)
					//		ma.getmO().setPosicaoYMetros((1000+(1000-ma.getmO().getPosicaoYMetros())));
					else if(!subida && !primeiraQueda) //&& ma.getmO().getPosicaoInicialYM()<1000)
						ma.getmO().setPosicaoYMetros( ma.getmO().getPosicaoInicialYM()+(ma.getmO().getPosicaoInicialYM()-ma.getmO().getPosicaoYMetros()));

					//Parada no carregamento para dar o realismo da simulação
					//Esta ocorre no final para possibilitar a pausa da simulação
					try {	t.sleep(atrasoMS);	}
					catch (InterruptedException e) {System.err.println("Erro na Thread!");}
				}
			
			//Repinta o painel para mostar o andamento da simulação
			ma.getmO().setPosicaoYPx(UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), ma.getmO().getPosicaoYMetros())-30);
			//__> Aqui está subitraindo 30px pois os mesmos foram retirados da escala
			//____Por hora corrigiu o impacto com o solo, mas a parte da decida continua falha
			//____COm o coeficiente em 1 a simulação funciona bem, exceto por um glitch no momento da queda



			cOBAC.repinta();
			vpf.repaint();
			//Repinta o painel de fórmulas
			vpf.repaint();
		}
		ma.getmO().setPosicaoYMetros(0);
		ma.getmO().setPosicaoYPx(UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(),0)-30);
		cOBAC.repinta();
		vpf.repaint();
	}

	//Métodos privados
	//---Verifica o momento do impacto do objeto
	private boolean bateu(){
		if(ma.getmO().getPosicaoYPx()>(UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), 0) - 30)
			|| (int)ma.getmO().getPosicaoYMetros()<0
			){
			System.out.println("Hitted|Bateu");
			return true;
		}
		return false;
	}
	//---Verifica o ponto máximo da subida (ou a aprada total do objeto)
	private boolean velocidadeZero(){
		if(ma.getmO().getVelocidade()<=0.5){
			System.out.println("Zero|V<=0");
			
			return true;
		}
		return false;
	}
	//---Usado tanto na subida quanto na descida para quando realizam ações comuns nos momentos
	//-----em que as partes da simulação vão se inverter de queda para impacto e vice-versa
	//-----deve ser chamado após  o set da nova velocidade
	private void acoesInversas(){
		System.out.println("Change|Ações inversas");
		ma.getmO().setAceleracao(ma.getmO().getAceleracao()*(-1));//A=-A
		ma.getmO().setVelocidade(ma.getmO().getVelocidadeInicial());//V=V0
		ma.setTempoTotal(ma.getTempoTotal()+ma.getTempoAtual());//TempoT+=TempoA
		ma.setTempoAtual(0);//TempoA=0
		subida=!subida;
		
//		ma.getmO().setPosicaoYMetros(ma.getmO().getPosicaoYMetros());
				this.primeiraQueda=false;
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

