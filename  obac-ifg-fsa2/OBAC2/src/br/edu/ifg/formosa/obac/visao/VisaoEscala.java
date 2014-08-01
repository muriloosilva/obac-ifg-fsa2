package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.controle.escala.ControleEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;

public class VisaoEscala extends JPanel{
	//Constantes
	//--Long
	private static final long serialVersionUID = 1L;
	
	//Variaveis
	//--Modelos
	private ModeloEscala mE = null;
	private ModeloObjeto mO = null;
	
	//Metodos
	//--Construtor #01
	public VisaoEscala(ModeloEscala mE, ModeloObjeto mO) {
		super(null);		
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mE = mE;
		this.mO = mO;
	}
	
	//--Paint
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.translate(mE.getEscalaInicioX(), mE.getEscalaInicioY());
		g2d.rotate(Math.toRadians(mE.getAnguloRotacaoGraus()));
		g2d.translate(-mE.getEscalaInicioX(), -mE.getEscalaInicioY());
		
		mE.setEspacamentoMarcadores(ControleEscala.retornaPedaco(mE.getEscalaInicioX(), mE.getEscalaFimXPix(), mE.qtdMarcadores));
		
		g2d.setColor(ModeloAmbiente.cor);
		g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaFimXPix(), mE.getEscalaFimYPix());
				
		g2d.drawLine(mE.getEscalaInicioX(), mE.getEscalaInicioY(), mE.getEscalaInicioX(), mE.getEscalaInicioY() + 15);
		g2d.drawLine(mE.getEscalaFimXPix(), mE.getEscalaFimYPix(), mE.getEscalaFimXPix(), mE.getEscalaFimYPix() + 15);

		//for -> desenha os marcadores
		for (int i=1;i<=mE.qtdMarcadores;i++) {
			int auxiliar = mE.getEscalaInicioX() + (i * mE.getEspacamentoMarcadores());

			g2d.drawLine(auxiliar, mE.getEscalaInicioY(), auxiliar, mE.getEscalaInicioY() + 8);
			g2d.drawString(mE.marcadoresEscala[i] + "m", auxiliar - 15, mE.getEscalaInicioY() + 26);
		}
		g2d.drawString(mE.marcadoresEscala[0] + "m", mE.getEscalaInicioX() - 15, mE.getEscalaInicioY() + 26);
		g2d.drawString(mE.marcadoresEscala[5] + "m", mE.getEscalaFimXPix() - 15, mE.getEscalaFimYPix() + 26);
		
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