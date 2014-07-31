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
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPropulsao;

public class ControleMolaMouse {
	
	//Referências usadas durante o uso da mola
	private ControleOBAC cOBAC;
	private final VisaoPropulsao vp;
	private final VisaoObjeto vo;
	private final VisaoPainelConfiguracao vpc;
	private final ModeloAmbiente ma;
	
	//Booleana de controle - Só ativa o retorno da mola se ela foi arrastada na área permitida
	private boolean restricaoHorizontal = false;
	private boolean restricaoVetical = false;
	
	//Mouse Listener
	//-----Reação da mola/objeto quando o objeto é solto
	private final MouseListener mListener = new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent arg0) {
			super.mouseReleased(arg0);
			
			//Retorna a mola e o objeto para a posição inicial antes de dá início a simulação
			//-----É necessário repintar a mola(do tamanho total até o incial) e mover o objeto de acordo com a expanção da mola
			//-----Também é preciso que confirmar que a soltura da mola ocorreu com a mola comprimida 
			if(restricaoHorizontal && restricaoVetical && ma.getmM().getTamanhoMolaAtualPix()<ma.getmM().getTamanhoMolaTotalPix()){
				new ControleMolaSoltura(vo, vp, ma, cOBAC, ControleMolaMouse.this, ajusteV);
			}
						
			//É iniciada a simulação
		}
	};
	
	
	
	//Mouse Motion Listener
	//-----Realiza o puxar e arrastar do objeto, que implica na compressão da mola 
	private final MouseMotionListener mMotionListener = new MouseMotionAdapter() {
		@Override
		public void mouseDragged(MouseEvent e) {
			//Correção no eixo Y
			corrigeAreaPegavel();
			reposicionaObjeto(e.getX(), e.getY());
		}
	};
	
	
	//Taxa de ajuste
	private int ajusteV = 0;
	//Método usado para ralizar os ajustes nas variáveis que referen-se a área pegável da mola
	public void corrigeAreaPegavel(){
		if(vpc.getCsAmbienteSimulacao().getSelectedIndex()==0
			||vpc.getCsAmbienteSimulacao().getSelectedIndex()==3){//Plano ou P&P 
			ajusteV = 0;
		}
		else if(vpc.getCsAmbienteSimulacao().getSelectedIndex()==1){//Subida
			ajusteV = -25;
		}
		else if(vpc.getCsAmbienteSimulacao().getSelectedIndex()==2){//Descida
			ajusteV = 20;
		}
	}
	
	//Método utilizado para reposicionar o objeto e comprimir a mola
	//Também indica quando ocorre a soltura do objeto, dando inicio a simulaçao 
	@SuppressWarnings("static-access")
	private void reposicionaObjeto(int x, int y){
		//Booleanas de controle - Verifica se a posição do mouse está em uma área válida
			//Confirma se a posição em que o mouse está é permitida no eixo x(30px do epaço vazio e mais 20px para a mola não desaparecer)
			restricaoHorizontal =((x>=(ma.getmM().getPosX()+ma.getmM().getTamanhoMolaMinimoPix())
					  && x<=(ma.getmM().getPosX()+ma.getmM().getTamanhoMolaTotalPix())));
			//Confirma se a posição do mouse no eixo Y está correta
			restricaoVetical=(y>=(ma.getmM().getPosY()+this.ajusteV)
					  && y<=(ma.getmM().getPosY()+ma.getmO().alturaLargura+this.ajusteV));
			  
		if(restricaoHorizontal && restricaoVetical){
			//Move o objeto
			ma.getmO().setPosicaoXPx(x);
			//Passa o Tamanho da mola de pixel para metros
			ma.getmM().setTamanhoMolaAtualPix(x-ma.getmM().getPosX());
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
				new ControleMolaSoltura(vo, vp, ma, cOBAC, this, ajusteV);
			}
		}
	}
	
	//Construtor
		public ControleMolaMouse(ControleOBAC cOBAC, VisaoPropulsao vp, VisaoObjeto vo,
								VisaoPainelConfiguracao vpc, ModeloAmbiente ma)
		{
			this.cOBAC = cOBAC;
			this.vp = vp;
			this.vo = vo;
			this.vpc = vpc;
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
			//E cancelamento da área legal da mola (Para previnir falhas)
			restricaoHorizontal = false;
			restricaoVetical = false;
		}
}
