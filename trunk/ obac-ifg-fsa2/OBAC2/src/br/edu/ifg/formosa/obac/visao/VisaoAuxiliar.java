package br.edu.ifg.formosa.obac.visao;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;

public class VisaoAuxiliar extends JPanel{
	//Variáveis
	//--Modelo
	private ModeloAmbiente mA = null;
	//--Visão
	private VisaoPainelConfiguracao vPC = null;
	
	//Métodos
	//--Construtor
	public VisaoAuxiliar(ModeloAmbiente mA, VisaoPainelConfiguracao vPC) {
		super(null);
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mA = mA;
		this.vPC = vPC;
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//Base do canhao - Só é desenhada aqui, pois ela não pode rotacionar, como rotaciona o VisaoPropulsao.
		if (vPC.getCsPropulsao().getSelectedIndex() == 0) {
			g2d.drawImage(mA.getmP().getImagemBaseCanhao().getImage(), mA.getmP().getPosXB(), mA.getmP().getPosYB(), this);
		}
	}
}