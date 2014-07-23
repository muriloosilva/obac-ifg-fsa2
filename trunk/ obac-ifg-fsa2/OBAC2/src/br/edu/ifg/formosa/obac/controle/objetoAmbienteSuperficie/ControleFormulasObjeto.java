package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;

public class ControleFormulasObjeto {

	//Modelos
	private ModeloAmbiente ma = null;
	
	//Construtor
	public ControleFormulasObjeto(ModeloAmbiente ma) {
		this.ma = ma;
	}
	
	//Força Normal -> N = Massa*Gravidade
	public void calculaForcaNormal(){
		ma.getmO().setForcaNormal(
			(ma.getmO().getMassa()*ma.getGravSelecionada())
		);
	}
	
	//Aceleração no Plano -> a = Fat/massa * -1
	public void aceleracaoPlano(){
		ma.getmO().setAceleracao(
			(ma.getmS().getCoefAtritoSelecionado()/ma.getmO().getMassa())
		);
	}
	
	//Aceleração na Queda -> a = g
	public void calculaAceleracaoQueda(){
		ma.getmO().setAceleracao(ma.getGravSelecionada());
	}
	
	//Aceleração na Subida -> a = [(g * Sen(θ)) + (μ * g * Cos(θ))]*(-1)
	public void calculaAceleracaoSubida(){
		ma.getmO().setAceleracao(
			((ma.getGravSelecionada()*Math.sin(Math.toRadians(ma.getmS().anguloInclinacaoGraus)))
			 + (ma.getmS().getCoefAtritoSelecionado()*ma.getGravSelecionada()*Math.cos(Math.toRadians(ma.getmS().anguloInclinacaoGraus)))
			)
			
		);
	}
	
	//Aceleração na Descida -> a = [(g * Sen(θ)) + (μ * g * Cos(θ))]
	public void calculaAceleracaoDescida(){
		ma.getmO().setAceleracao(((
		 (ma.getGravSelecionada()*Math.sin(Math.toRadians(ma.getmS().anguloInclinacaoGraus)))
		 + (ma.getmS().getCoefAtritoSelecionado()*ma.getGravSelecionada()*Math.cos(Math.toRadians(ma.getmS().anguloInclinacaoGraus))*(-1))
		)));
	}
	
	//Calcula Posição Final Padrão -> Sf = (V0^2 * -1)/(2 * a)*(-1)
	public void calculaPosFinalPadrao(){
		calculaPosFinalDescida();
		ma.getmO().setPosFinalXMetros((ma.getmO().getPosFinalXMetros()*-1));
	}
	
	//Calcula Posição Final na Descida -> Sf = (V0^2 * -1)/(2 * a)
	public void calculaPosFinalDescida(){
		ma.getmO().setPosFinalXMetros(
			(ma.getmO().getVelocidadeInicial()*ma.getmO().getVelocidadeInicial())
			/(2*ma.getmO().getAceleracao())
		);
	}
	
	//Calcula Tempo -> t = (Vf - V0)/a
	public void calculaTempo(){
		ma.setTempo(
			((0-ma.getmO().getVelocidadeInicial())/ma.getmO().getAceleracao())
		);
	}
	
	//Calcula posição final Pixel
		//Por ser muito utilizada, esta função poderia ser mandada para uma classe de utilidades de forma genérica
	public void calculaPosFinalPix(){
		ma.getmO().setPosFinalXPix(
			(ma.getmO().getPosFinalXMetros()/ma.getmEPri().getEscalaFimXM())
		);
	}
	
	//Calcula Novas posições do objeto - s=s0+v0*t+(a*t^2)/2
	public void calculaNovaPosicao(){
		ma.getmO().setPosicaoXMetros(
			//S0 = 0
			(ma.getmO().getVelocidadeInicial()*ma.getTempo())
			+((ma.getmO().getAceleracao()*ma.getTempo()*ma.getTempo())/2)
		);
	}
	
	//Velocidade após colisão do objeto - V²=V02+2*a*ΔS
	public void calculaVelocidadePosColisao(){
		ma.getmO().setVelocidade(Math.sqrt(
			((ma.getmO().getVelocidadeInicial()*2)
			+(2*ma.getmO().getAceleracao()*ma.getmO().getPosicaoXMetros()))
		));
	}
	
	//Calcula coeficiente de restituição
		//---Este método existe no obac original, ma não vejo uma aplicação dele nesta revisão do projeto
		//---Já que ele é apenas um set do coeficiente de restituição que está em uma classe diferente
	
	//Testes lógicos para definirem a parada do objeto de acordo com a simulação
		//Plano
		public boolean paradaPlano(){
			if(ma.getmO().getPosicaoXPx() >= ma.getmO().getPosFinalXPix()) return true;
			else return false;
		}
		//Plano e Precipício
		public boolean paradaPlanoPrecipicio(){
			//Condição de parada caso o Objeto não caia
			if(ma.getmO().getPosicaoXPx() >= ma.getmO().getPosFinalXPix()
			  && ma.getmO().getPosFinalXPix() <= ma.getmEPri().getTamanhoPrecipicioPix()){
				return true;
			}
			//Condição de para caso o objeto caia
			else if(ma.getmO().getPosicaoYPx() >= ma.getmEPri().getFimAmbienteYPix()){
				return true;
			}
			//Exceção - O bojeto ainda se movimenta
			else/**/return false;
		}
		
		//Subida
		public boolean paradaSubida(){
			if (ma.getmO().getPosicaoXPx() >= ModeloObjeto.pontoFinalObjetoSubidaPix) {
				return false;
			}
			else{
				//Este valor é repassado para o OBJETO com o fim de evitar que o objeto retorne
				ma.getmO().setPosicaoXPx(ModeloObjeto.pontoFinalObjetoSubidaPix);
				return true;
			}
		}
		
		//Descida
		public boolean paradaDescida(){
			if (ma.getmO().getPosicaoXPx() >= ModeloObjeto.pontoFinalObjetoDescidaPix) {
				//Este valor é repassado para o OBJETO com o fim de evitar que o objeto retorne
				ma.getmO().setPosicaoXPx(ModeloObjeto.pontoFinalObjetoDescidaPix);
				return true;
			}
			else{return false;}
		}
}
