package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.controle.simulacao.ControleSimulacao;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;
import br.edu.ifg.formosa.obac.modelo.ModeloPropulsao;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeArredondamento;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;

public class VisaoEscala extends JPanel{
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;
	
	//Variaveis
	//--Modelos
	private ModeloAmbiente mA = null;
	private ModeloEscala mE = null;
	//Vis�es
	private VisaoPainelConfiguracao vPC = null;
	
	//Metodos
	//--Construtor #01
	public VisaoEscala(ModeloEscala mE, ModeloAmbiente mA, VisaoPainelConfiguracao vPC) {
		super(null);
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mE = mE;
		this.mA = mA;
		this.vPC = vPC;
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.rotate(Math.toRadians(mA.anguloInclinacaoGraus), mA.getTranslateX(), mA.getTranslateY());
				
		g2d.setColor(ModeloAmbiente.cor);
		g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaFimXPix(), mE.getEscalaFimYPix());
		
		//Desenha Marcadores - Horizontal
		if (mE.getEscalaInicioY() == mE.getEscalaFimYPix()) { 
		
			mE.setEspacamentoMarcadores(ControleSimulacao.retornaPedaco(mE.getEscalaInicioX(), mE.getEscalaFimXPix()));
			
			g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaInicioX(), mE.getEscalaInicioY() + 15);
			g2d.drawLine(mE.getEscalaFimXPix(), mE.getEscalaFimYPix(), mE.getEscalaFimXPix(), mE.getEscalaFimYPix() + 15);
			
			for (int i=0;i<ModeloEscala.qtdMarcadores;i++) {
				int auxiliarX = mE.getEscalaInicioX() + ((i+1) * mE.getEspacamentoMarcadores());
	
				g2d.drawLine(auxiliarX, mE.getEscalaInicioY(), auxiliarX, mE.getEscalaInicioY() + 8);
				g2d.drawString(mE.getMarcadoresEscala()[i] + "m", auxiliarX - 15, mE.getEscalaInicioY() + 26);
			}
			g2d.drawString(ModeloEscala.marcadorInicial + "m", mE.getEscalaInicioX() - 9, mE.getEscalaInicioY() + 26);
			g2d.drawString(mE.getMarcadoresEscala()[4] + "m", mE.getEscalaFimXPix() - 15, mE.getEscalaFimYPix() + 26);
		} else
		//Desenha Marcadores - Vertical
		if (mE.getEscalaInicioX() == mE.getEscalaFimXPix()) {
			
			mE.setEspacamentoMarcadores(ControleSimulacao.retornaPedaco(mE.getEscalaInicioY(), mE.getEscalaFimYPix()));
			
			g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaInicioX() - 15, mE.getEscalaInicioY());
			g2d.drawLine(mE.getEscalaFimXPix(), mE.getEscalaFimYPix(), mE.getEscalaFimXPix() - 15, mE.getEscalaFimYPix());
			
			for (int i=3;i>=0;i--) {
				int auxiliarY = mE.getEscalaInicioY() + ((i+1) * mE.getEspacamentoMarcadores());
	
				g2d.drawLine(mE.getEscalaInicioX(), auxiliarY,  mE.getEscalaInicioX() - 8, auxiliarY);
				g2d.drawString(mE.getMarcadoresEscala()[i] + "m", mE.getEscalaInicioX() - 50, auxiliarY - 1);
			}
			g2d.drawString(ModeloEscala.marcadorInicial + "m", mE.getEscalaInicioX() - 50, mE.getEscalaInicioY() - 1);
			g2d.drawString(mE.getMarcadoresEscala()[4] + "m", mE.getEscalaFimXPix() - 50, mE.getEscalaFimYPix() - 1);
		}
	}
}