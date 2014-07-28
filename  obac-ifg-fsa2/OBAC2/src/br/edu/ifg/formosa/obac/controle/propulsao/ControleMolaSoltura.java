package br.edu.ifg.formosa.obac.controle.propulsao;

import java.awt.Image;

import javax.swing.ImageIcon;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.visao.VisaoObjeto;
import br.edu.ifg.formosa.obac.visao.VisaoPropulsao;

public class ControleMolaSoltura implements Runnable{
	
	private VisaoObjeto vo = null;
	private VisaoPropulsao vp = null;
	private ModeloAmbiente ma = null;
	private ControleOBAC cOBAC = null;
	private Thread t = null;
	
	public ControleMolaSoltura(VisaoObjeto vo, VisaoPropulsao vp, ModeloAmbiente ma, ControleOBAC cOBAC, ControleMolaMouse cmm) {
		this.vo = vo;
		this.vp = vp;
		this.ma = ma;
		this.cOBAC = cOBAC;
		
		//Remoção dos mouse*listeners
//		cmm.desativaMolaMouse();
		
		t = new Thread(this);
		t.start();
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	@Override
	public void run() {
		//É calculada a taxa de deformação e a velocidade de lançamento do objeto
		ma.getmM().calculaX();
//		ma.getmP().velocidadeLancamento();
		//###Retornar com a velocidade assim que o controle principal da simulação estiver funcionando
		
		//Variáveis usadas no retorno da mola
			double cont = 0.5;
			int atraso = 20;
		//Laço de repetição que traz a mola para a posição inicial
		for (double i = ma.getmM().getTamanhoMolaAtualPix();
			i < ma.getmM().getTamanhoMolaTotalPix();
			i+=cont)
		{
			//Altera o tamanho da imagem para ajustála a compressão
			vp.setImagemPropulsao(new ImageIcon(ma.getmM().getImagemMola().getImage().getScaledInstance((int)i, 30, Image.SCALE_DEFAULT)));
			//Corrige o valor na variável do tamanho da mola localizado no modelo
			ma.getmM().setTamanhoMolaAtualPix((int)i);
			//Move o objeto (valor de i+posição inicial do objeto+ 1 pixel para o objeto ficar na frente da mola)
			ma.getmO().setPosicaoXPx((int)i+ma.getmM().getPosX()+1);
			//Repaint
			cOBAC.repinta();
			//Sleep - pausas no carregamento
			try {t.sleep(atraso);}
			catch (InterruptedException e) {e.printStackTrace();}
			//Incremento do segundo contador para dá a impressão de aceleração da mola
			cont+=0.5;
		}
		
		//Correção dos valores do tamnho da mola e da posição do objeto para evitar o desconforto visual
		//Ocorre apenas quando a imagem não está no tamanho correto
		if(ma.getmM().getTamanhoMolaAtualPix()<ma.getmM().getTamanhoMolaTotalPix()){
			//Retorna a mola para a posição original (primeiro no modelo depois na imagem)
			ma.getmM().setTamanhoMolaAtualPix(ma.getmM().getTamanhoMolaTotalPix());
			vp.setImagemPropulsao(ma.getmM().getImagemMola());
			//Posiciona o Objeto na posição original
			ma.getmO().setPosicaoXPx(130);
			//Repaint
			cOBAC.repinta();
		}
			
		//Para esta Thrad
		t.stop();
	}
	
}
