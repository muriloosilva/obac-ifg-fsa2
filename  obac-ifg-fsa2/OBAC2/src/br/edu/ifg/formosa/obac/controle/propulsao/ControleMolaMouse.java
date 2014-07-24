package br.edu.ifg.formosa.obac.controle.propulsao;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloMola;
import br.edu.ifg.formosa.obac.principal.OBAC;
import br.edu.ifg.formosa.obac.visao.VisaoObjeto;
import br.edu.ifg.formosa.obac.visao.VisaoPropulsao;

public class ControleMolaMouse {
	
	//Referências usadas durante o uso da mola
	private OBAC obac;
	private final VisaoPropulsao vp;
	private final VisaoObjeto vo;
	private final ModeloAmbiente ma;
	private final ModeloMola mm;
	
	
	
	//Construtor
	public ControleMolaMouse(OBAC obac, VisaoPropulsao vp, VisaoObjeto vo,
							ModeloAmbiente ma, ModeloMola mm)
	{
		this.obac = obac;
		this.vp = vp;
		this.vo = vo;
		this.ma = ma;
		this.mm = mm;
	}
	
	//Apagar esta variável
	private final ImageIcon mola = new ImageIcon(obac.getImage(obac.getCodeBase(), "imagens/mola/mola100px.png"));
			
			
	//Mouse Listener
	//-----Reação da mola/objeto quando o objeto é solto
	private final MouseListener mListener =new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent arg0) {
			super.mouseReleased(arg0);
			
			//Retorna a mola e o objeto para a posição inicial antes de dá início a simulação
			//-----É necessário repintar a mola(do tamanho total até o incial) e mover o objeto de acordo com a expanção da mola 
			
			
			//Criar método para trocar a imagem da mola
				//Repitar em seguida
			
			//Chama o método ativaMola para que a interaçãocom a mola seja removida enquanto a excução ocorre
			
			//É iniciada a simulação 
		}
	};
		
	//Mouse Motion Listener
	//-----Realiza o puxar e arrastar do objeto, que implica na compressão da mola 
	private final MouseMotionListener mMotionListener = new MouseMotionAdapter() {
		@Override
		public void mouseDragged(MouseEvent e) {
			ma.getmO().setPosicaoXPx(e.getX());
		}
	};
}
