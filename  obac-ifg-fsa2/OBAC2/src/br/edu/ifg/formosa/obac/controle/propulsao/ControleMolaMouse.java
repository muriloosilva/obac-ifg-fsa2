package br.edu.ifg.formosa.obac.controle.propulsao;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoObjeto;
import br.edu.ifg.formosa.obac.visao.VisaoPropulsao;

public class ControleMolaMouse {
	
	//Referências usadas durante o uso da mola
	private ControleOBAC cOBAC;
	private final VisaoPropulsao vp;
	private final VisaoObjeto vo;
	private final ModeloAmbiente ma;
	
	//Booleana de controle - Só ativa o retorno da mola se ela foi arrastada na área permitida
	private boolean areaDaMola = false;
	
	//Mouse Listener
	//-----Reação da mola/objeto quando o objeto é solto
	private final MouseListener mListener =new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent arg0) {
			super.mouseReleased(arg0);
			
			//Retorna a mola e o objeto para a posição inicial antes de dá início a simulação
			//-----É necessário repintar a mola(do tamanho total até o incial) e mover o objeto de acordo com a expanção da mola
			//-----Também é preciso que confirmar que a soltura da mola ocorreu com a mola comprimida 
			if(areaDaMola && ma.getmM().getTamanhoMolaAtualPix()<ma.getmM().getTamanhoMolaTotalPix()){
				new ControleMolaSoltura(vo, vp, ma, cOBAC, ControleMolaMouse.this);
			}
						
			//É iniciada a simulação
		}
	};
		
	//Mouse Motion Listener
	//-----Realiza o puxar e arrastar do objeto, que implica na compressão da mola 
	private final MouseMotionListener mMotionListener = new MouseMotionAdapter() {
		@Override
		public void mouseDragged(MouseEvent e) {
			reposicionaObjeto(e.getX(), e.getY());
		}
	};
	
	//Método utilizado para reposicionar o objeto e comprimir a mola
	//Também indica quando ocorre a soltura do objeto, dando inicio a simulaçao 
	private void reposicionaObjeto(int x, int y){
		//Booleana de controle - Verifica se a posição do mouse está em uma área válida
		areaDaMola =
			((x>=55 && x<=130)//Confirma se a posição em que o mouse está é permitida no eixo x(30px do epaço vazio e mais 20px para a mola não desaparecer)
			 &&(y>=470 && y<=500));//Confirma se a posição do mouse no eixo Y está correta
			  
		if(areaDaMola){
			//Move o objeto
			ma.getmO().setPosicaoXPx(x);
			//Passa o Tamanho da mola de pixel para metros
			ma.getmM().setTamanhoMolaAtualPix(x-30);
			ma.getmM().setTamanhoMolaTotalM((UtilidadeConvercoesEscala.convertePixelMetro(ma.getmM().getTamanhoMolaTotalM(), ma.getmM().getTamanhoMolaAtualPix(), ma.getmM().getTamanhoMolaTotalPix())));
			//Altera o tamanho da imagem para ajustála a compressão
			vp.setImagemPropulsao(new ImageIcon(ma.getmM().getImagemMola().getImage().getScaledInstance(ma.getmM().getTamanhoMolaAtualPix(), 30, Image.SCALE_DEFAULT)));
			
			//Repinta o Painel de Repintar
			cOBAC.repinta();
		}
		else{
			//-----É preciso que confirmar que a soltura da mola ocorreu com a mola comprimida
			if (ma.getmM().getTamanhoMolaAtualPix()<ma.getmM().getTamanhoMolaTotalPix()) {
				//A simulação também ocorre quando o usuário sai da área delimitada para a interação com a mola 
				new ControleMolaSoltura(vo, vp, ma, cOBAC, this);
			}
		}
	}
	
	//Construtor
		public ControleMolaMouse(ControleOBAC cOBAC, VisaoPropulsao vp, VisaoObjeto vo,
								ModeloAmbiente ma)
		{
			this.cOBAC = cOBAC;
			this.vp = vp;
			this.vo = vo;
			this.ma = ma;
		}

		
	//"Getter" e "Setter" das ações do mouse
		//Adição dos mouse*Listeners
		public void ativaMolaMouse(){
			vp.addMouseMotionListener(mMotionListener);
			vp.addMouseListener(mListener);
		}
		//Remoção dos mouse*Listeners
		public void desativaMolaMouse(){
			vp.removeMouseMotionListener(mMotionListener);
			vp.removeMouseListener(mListener);
			areaDaMola = false;//E cancelamento da área legal da mola (Para previnir falhas)
		}
}
