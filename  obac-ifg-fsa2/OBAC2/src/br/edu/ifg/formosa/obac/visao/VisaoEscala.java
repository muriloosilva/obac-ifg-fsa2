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

public class VisaoEscala extends JPanel{
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;
	
	//Variaveis
	//--Modelos
	private ModeloEscala mE = null;
	private ModeloObjeto mO = null;
	private ModeloPropulsao mP = null;
	
	//Metodos
	//--Construtor #01
	public VisaoEscala(ModeloEscala mE, ModeloObjeto mO, ModeloPropulsao mP) {
		super(null);		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mE = mE;
		this.mO = mO;
		this.mP = mP;
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//g2d.rotate(Math.toRadians(mE.getAnguloRotacaoGraus()));
				
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
				int auxiliarY = mE.getEscalaFimYPix() - ((i+1) * mE.getEspacamentoMarcadores());
	
				g2d.drawLine(mE.getEscalaInicioX(), auxiliarY,  mE.getEscalaInicioX() - 8, auxiliarY);
				g2d.drawString(mE.getMarcadoresEscala()[i] + "m", mE.getEscalaInicioX() - 50, auxiliarY - 1);
			}
			g2d.drawString(mE.getMarcadoresEscala()[4] + "m", mE.getEscalaInicioX() - 50, mE.getEscalaInicioY() - 1);
			g2d.drawString(ModeloEscala.marcadorInicial + "m", mE.getEscalaFimXPix() - 28, mE.getEscalaFimYPix() - 1);			
		}
		//Marcador dinâmico para indicar a posição do objeto no P&P
		if (mE.isPEP()) {
			g2d.setColor(Color.yellow);
			
			if (mO.getPosicaoXPx() + 30 >= mE.getEscalaInicioX()) { //Colocar em uma Thread de modo que so atualize com essa condição
				g2d.fillOval(mO.getPosicaoXPx() + 26, mE.getEscalaInicioY() - 4, 8, 8);
				g2d.drawString(mO.getPosicaoXMetros() + "m", mO.getPosicaoXPx() + 20, mE.getEscalaInicioY() - 8);
			}
		}
	}
}