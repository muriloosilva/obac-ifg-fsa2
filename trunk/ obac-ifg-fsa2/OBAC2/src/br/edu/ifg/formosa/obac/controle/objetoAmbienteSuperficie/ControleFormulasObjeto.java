package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControleFormulasObjeto {

	//Modelos
	private ModeloAmbiente ma = null;
	private VisaoPainelFormulas vpf = null;
	private ControlePainelFormulas cpf = null;
	
	//Construtor
	public ControleFormulasObjeto(ModeloAmbiente ma, VisaoPainelFormulas vpf, ControlePainelFormulas cpf) {
		this.ma = ma;
		this.vpf = vpf;
		this.cpf = cpf;
	}
	
	//Força Normal -> N = Massa*Gravidade
	public void calculaForcaNormal(){
		ma.getmO().setForcaNormal(
			(ma.getmO().getMassa()*ma.getGravSelecionada())
		);
		//Manda para o painel de fórmulas
		vpf.getAtFNormal().setText(
				cpf.forcaNormal(ma.getmO().getMassa(), ma.getGravSelecionada()));
	}
	
	//Aceleração no Plano -> a = Fat/massa * -1
	public void calculaAceleracaoPlano(){
		ma.getmO().setAceleracao(
			((ma.getmS().getForcaAtrito()/ma.getmO().getMassa() * (-1)))
		);
		//Manda para o painel de fórmulas
		vpf.getAtAceleracao().setText(
				cpf.aceleracaoPlano(ma.getmS().getCoefAtritoSelecionado(), ma.getmO().getMassa()));
	}
	
	//Aceleração na Queda -> a = g
	public void calculaAceleracaoQueda(){
		ma.getmO().setAceleracao(ma.getGravSelecionada());
		//Manda para o painel de fórmulas
		vpf.getAtAceleracao().setText(
				cpf.aceleracaoQueda(ma.getGravSelecionada()));
	}
	
	//Aceleração na Subida -> a = [(g * Sen(θ)) + (μ * g * Cos(θ))]*(-1)
	public void calculaAceleracaoSubida(){
		ma.getmO().setAceleracao(
			((ma.getGravSelecionada()*Math.sin(Math.toRadians(ModeloAmbiente.anguloInclinacaoGraus)))
			 + (ma.getmS().getCoefAtritoSelecionado()*ma.getGravSelecionada()*Math.cos(Math.toRadians(ModeloAmbiente.anguloInclinacaoGraus))*-1)
			)
			
		);
		//Manda para o painel de fórmulas
		vpf.getAtAceleracao().setText(
				cpf.aceleracaoSubida(ma.getGravSelecionada(), ModeloAmbiente.anguloInclinacaoGraus, ma.getmS().getCoefAtritoSelecionado()));
	}
	
	//Aceleração na Descida -> a = [(g * Sen(θ)) + (μ * g * Cos(θ))]
	public void calculaAceleracaoDescida(){
		ma.getmO().setAceleracao(((
		 (ma.getGravSelecionada()*Math.sin(Math.toRadians(ModeloAmbiente.anguloInclinacaoGraus)))
		 + (ma.getmS().getCoefAtritoSelecionado()*ma.getGravSelecionada()*Math.cos(Math.toRadians(ModeloAmbiente.anguloInclinacaoGraus))*(-1))
		)));
		//Manda para o painel de fórmulas
		vpf.getAtAceleracao().setText(
				cpf.aceleracaoDescida(ma.getGravSelecionada(), ModeloAmbiente.anguloInclinacaoGraus, ma.getmS().getCoefAtritoSelecionado()));
	}
	
	//Calcula Posição Final Padrão -> Sf = (V0^2 * -1)/(2 * a)*(-1)
	public void calculaPosFinalPadrao(){
		calculaPosFinalDescida();
		ma.getmO().setPosFinalXMetros((ma.getmO().getPosFinalXMetros()*-1));
		//Manda para o painel de fórmulas
		vpf.getAtPosFinal().setText(
				cpf.posicaoFinalPadrao(ma.getmO().getVelocidadeInicial(), ma.getmO().getAceleracao()));
	}
	
	//Calcula Posição Final na Descida -> Sf = (V0^2 * -1)/(2 * a)
	public void calculaPosFinalDescida(){
		ma.getmO().setPosFinalXMetros(
			(ma.getmO().getVelocidadeInicial()*ma.getmO().getVelocidadeInicial())
			/(2*ma.getmO().getAceleracao())
		);
		//Manda para o painel de fórmulas
		vpf.getAtPosFinal().setText(
				cpf.posicaoFinalDescida(ma.getmO().getVelocidadeInicial(), ma.getmO().getAceleracao()));
	}
	
	//Calcula Tempo -> t = (Vf - V0)/a
	public void calculaTempo(){
		ma.setTempoTotal(
			((0-ma.getmO().getVelocidadeInicial())/ma.getmO().getAceleracao())
		);
		//Manda para o painel de fórmulas
		vpf.getAtTempo().setText(
				cpf.tempo(ma.getmO().getVelocidadeInicial(), ma.getmO().getAceleracao()));
	}
	
	//Calcula Novas posições do objeto - s=s0+v0*t+(a*t^2)/2
	public void calculaNovaPosicao(){
		ma.getmO().setPosicaoXMetros(
			//S0 = 0
			(ma.getmO().getVelocidadeInicial()*ma.getTempoAtual())
			+((ma.getmO().getAceleracao()*ma.getTempoAtual()*ma.getTempoAtual())/2)
		);
		//Manda para o painel de fórmulas
		vpf.getAtNovaPos().setText(
				cpf.novaPosicao(0, ma.getmO().getVelocidadeInicial(), ma.getTempoAtual(), ma.getmO().getAceleracao()));
	}
	
	//Calcula Novas posições Y do objeto - s=s0+v0*t+(a*t^2)/2
	public void calculaNovaPosicaoY(){
		ma.getmO().setPosicaoYMetros(
				//S0 = 0
				(ma.getmO().getVelocidadeInicial()*ma.getTempoAtual())
				+((ma.getmO().getAceleracao()*ma.getTempoAtual()*ma.getTempoAtual())/2)
				);
		//Manda para o painel de fórmulas
		vpf.getAtNovaPos().setText(
				cpf.novaPosicao(0, ma.getmO().getVelocidadeInicial(), ma.getTempoAtual(), ma.getmO().getAceleracao()));
	}
	
	//Velocidade após colisão do objeto - V²=V0^2+2*a*ΔS
	public void calculaVelocidadeTorricelli(double posicaoM){
		double v;
		try{
			v=Math.sqrt(((ma.getmO().getVelocidadeInicial()*ma.getmO().getVelocidadeInicial())+(2*ma.getmO().getAceleracao()*posicaoM)));
		}catch(NumberFormatException e){
			v=0;
		}
		ma.getmO().setVelocidade(v);
		//Manda para o painel de fórmulas
//Criar esquema para ser usado em dois paineis (normal e pos colisão)
		vpf.getAtNovaV().setText(
				cpf.equTorricceli(ma.getmO().getVelocidadeInicial(), ma.getmO().getAceleracao(), ma.getmO().getPosicaoXMetros()));
	}
	
	//Calcula coeficiente de restituição
		//---Este método existe no obac original, ma não vejo uma aplicação dele nesta revisão do projeto
		//---Já que ele é apenas um set do coeficiente de restituição que está em uma classe diferente
	
	//Testes lógicos para definirem a parada do objeto de acordo com a simulação
		//Plano
		public boolean paradaPlano(){
			if(ma.getmO().getPosicaoXPx() >= (ma.getmO().getPosFinalXPix())){
				//Este valor é repassado para o OBJETO com o fim de evitar que o objeto retorne
				ma.getmO().setPosicaoXPx(ma.getmO().getPosFinalXPix());
				ma.getmO().setPosicaoXMetros(ma.getmO().getPosFinalXMetros());
				return true;
			}else return false;
		}
		//Plano e Precipício
		public boolean paradaPlanoPrecipicio(){
			//Condição de parada caso o Objeto não caia
			if(ma.getmO().getPosicaoXPx() >= ma.getmO().getPosFinalXPix()
			  && ma.getmO().getPosFinalXPix() <= ma.getmEH().tamanhoPrecipicioPix){
				return true;
			}
			//Condição de para caso o objeto caia
			else if(ma.getmO().getPosicaoYPx() >= ma.getmEV().fimAmbienteYPix){
				return true;
			}
			//Exceção - O bojeto ainda se movimenta
			else/**/return false;
		}
		
		//Subida
		public boolean paradaSubida(){
			if (ma.getmO().getPosicaoXPx() >= ModeloObjeto.pontoFinalObjetoSubidaPix) {
				//Este valor é repassado para o OBJETO com o fim de evitar que o objeto retorne
				ma.getmO().setPosicaoXPx(ModeloObjeto.pontoFinalObjetoSubidaPix+1);
//				ma.getmO().setPosicaoXMetros(ma.getmO().getPosFinalXMetros());
				return false;
			}
			else{
				//Este valor é repassado para o OBJETO com o fim de evitar que o objeto retorne
				return true;
			}
		}
		
		//Descida
		public boolean paradaDescida(){
			/*Uma forma de fazer o objeto descer até o final seria testar
			 * para ver se ele atingiu o ponto final, neste momento algum valor deveria ser multiplicado
			 * por -1 para q o objeto continue a descer
			 */
			if (ma.getmO().getPosicaoXPx() >= ModeloObjeto.pontoFinalObjetoDescidaPix
				|| ma.getmO().getPosicaoXPx() >= ma.getmO().getPosFinalXPix()
			){
				//Este valor é repassado para o OBJETO com o fim de evitar que o objeto retorne
//				ma.getmO().setPosicaoXPx(ModeloObjeto.pontoFinalObjetoDescidaPix);
				ma.getmO().setPosicaoXMetros(ma.getmO().getPosFinalXMetros()*-1);
				return true;
			}
			else{return false;}
		}
		
		//LO
		public boolean paradaLO() {
			if (ma.getTempoAtual() <= ma.getTempoTotal()) {
				return true;
			} else
				ma.getmO().setPosicaoYMetros(0);			
				ma.getmO().setPosicaoYPx(UtilidadeConvercoesEscala.metroParaPixelV(ma.getmEV(), 0) - 29);
				return false;
		}
}
