package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.utilidades.UtilidadeRotuloTransparente;

public class VisaoPainelInformacao extends JPanel{
	
	//Serial
	private static final long serialVersionUID = 1L;
	
	//Gravidade
	private UtilidadeRotuloTransparente rGravidade;
	private UtilidadeRotuloTransparente rGravidadeValor;
	//Coeficiente de Atrito
	private UtilidadeRotuloTransparente rCoefAtrito;
	private UtilidadeRotuloTransparente rCoefAtritoValor;
	//Força de Atrito
	private UtilidadeRotuloTransparente rForcaAtrito;
	private UtilidadeRotuloTransparente rForcaAtritoValor;
	//Força Normal
	private UtilidadeRotuloTransparente rForcaNormal;
	private UtilidadeRotuloTransparente rForcaNormalValor;
	//Posição Final
	private UtilidadeRotuloTransparente rPosFinal;
	private UtilidadeRotuloTransparente rPosFinalValor;
	//Aceleração
	private UtilidadeRotuloTransparente rAceleracao;
	private UtilidadeRotuloTransparente rAceleracaoValor;
	//Posição no Eixo X
	private UtilidadeRotuloTransparente rPosAtualEixoX;
	private UtilidadeRotuloTransparente rPosAtualEixoXValor;
	//Posição no Eixo Y
	private UtilidadeRotuloTransparente rPosAtualEixoY;
	private UtilidadeRotuloTransparente rPosAtualEixoYValor;
	//Tempo
	private UtilidadeRotuloTransparente rTempo;
	private UtilidadeRotuloTransparente rTempoValor;
	
	//Layout
		private GridBagLayout layout = null;
		private GridBagConstraints gbc = null;
	
	public VisaoPainelInformacao() {
		this.setOpaque(false);
		this.setBounds(250, 0, 750, 40);
		this.setBackground(Color.DARK_GRAY);
		
		//Layout
		layout = new GridBagLayout();
		this.setLayout(layout);//O painel passa a utilizar o layout automático
		
		//Variável responsável pelo posicionamento e alocação dos componentes
		gbc = new GridBagConstraints();
			gbc.insets = new Insets(2, 20, 0, 0);
			gbc.weighty = 1;
			this.gbc.weightx = 0;
			gbc.fill = GridBagConstraints.NONE;
			gbc.anchor = GridBagConstraints.WEST;
			gbc.ipadx =10;
			gbc.ipady = 20;
		
		//Rótulo
			//Gravidade
			rGravidade = new UtilidadeRotuloTransparente("Gravidade:");
				rGravidade.setHorizontalAlignment(JLabel.RIGHT);
			addComponent(rGravidade, 0, 0, 1, 1);
			//Coeficiente de Atrito
			rCoefAtrito = new UtilidadeRotuloTransparente("Coef. de Atrito:");
				rCoefAtrito.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rCoefAtrito, 1, 0, 1, 1);
			//Força de Atrito
			rForcaAtrito = new UtilidadeRotuloTransparente("Força de Atrito:");
				rForcaAtrito.setHorizontalAlignment(JLabel.RIGHT);
			addComponent(rForcaAtrito, 0, 3, 1, 1);
			//Força Normal
			rForcaNormal = new UtilidadeRotuloTransparente("Força Normal:");
				rForcaNormal.setHorizontalAlignment(JLabel.RIGHT);
			addComponent(rForcaNormal, 1, 3, 1, 1);			
			//Posição Final
			rPosFinal = new UtilidadeRotuloTransparente("Pos. Final:");
				rPosFinal.setHorizontalAlignment(JLabel.RIGHT);
			addComponent(rPosFinal, 0, 5, 1, 1);			
			//Acelereação
			rAceleracao = new UtilidadeRotuloTransparente("Aceleração:");
				rAceleracao.setHorizontalAlignment(JLabel.RIGHT);
			addComponent(rAceleracao, 1, 5, 1, 1);			
			//Posição no Eixo X
			rPosAtualEixoX = new UtilidadeRotuloTransparente("Pos. Atual Eixo X:");
				rPosAtualEixoX.setHorizontalAlignment(JLabel.RIGHT);
			addComponent(rPosAtualEixoX, 0, 7, 1, 1);			
			//Posição no Eixo Y
			rPosAtualEixoY = new UtilidadeRotuloTransparente("Pos. Atual Eixo Y:");
				rPosAtualEixoY.setHorizontalAlignment(JLabel.RIGHT);
			addComponent(rPosAtualEixoY, 1, 7, 1, 1);			
			//Tempo
			rTempo = new UtilidadeRotuloTransparente("Tempo:");
				rTempo.setHorizontalAlignment(JLabel.RIGHT);
			addComponent(rTempo, 0, 9, 1, 1);
			
		//Alteração nos valores de espaçamento dos componentes
			gbc.insets = new Insets(2, 5, 0, 20);
			
		//Valores
			//Gravidade	
			rGravidadeValor = new UtilidadeRotuloTransparente("0.0");
			addComponent(rGravidadeValor, 0, 1, 1, 1);
			//Coeficiente de Atrito
			rCoefAtritoValor = new UtilidadeRotuloTransparente("0.0");
			addComponent(rCoefAtritoValor, 1, 1, 1, 1);
			//Força de Atrito
			rForcaAtritoValor = new UtilidadeRotuloTransparente("0.0");
			addComponent(rForcaAtritoValor, 0, 4, 1, 1);
			//Força Normal
			rForcaNormalValor = new UtilidadeRotuloTransparente("0.0");
			addComponent(rForcaNormalValor, 1, 4, 1, 1);
			//Posição Final
			rPosFinalValor = new UtilidadeRotuloTransparente("0.0");
			addComponent(rPosFinalValor, 0, 6, 1, 1);
			//Acelereação
			rAceleracaoValor = new UtilidadeRotuloTransparente("0.0");
			addComponent(rAceleracaoValor, 1, 6, 1, 1);
			//Posição no Eixo X
			rPosAtualEixoXValor = new UtilidadeRotuloTransparente("0.0");
			addComponent(rPosAtualEixoXValor, 0, 8, 1, 1);
			//Posição no Eixo Y
			rPosAtualEixoYValor = new UtilidadeRotuloTransparente("0.0");
			addComponent(rPosAtualEixoYValor, 1, 8, 1, 1);
			//Tempo
			rTempoValor = new UtilidadeRotuloTransparente("0.0");
			addComponent(rTempoValor, 0, 10, 1, 1);
	}
	
	//Posiciona os componentes
	private void addComponent(Component c, int linha, int coluna, int largura, int altura){
		//Configura gridX e gridY
			gbc.gridx = coluna;
			gbc.gridy = linha;
		//Configura gridwidth e gridheight
			gbc.gridwidth = largura;
			gbc.gridheight = altura;
		//Configura restrições e adiciona componentes
			this.add(c, gbc);
	}
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color ppColor = new Color(0, 0, 0, 115); //r,g,b,alpha
        g.setColor(ppColor);
        g.fillRect(0,0,750,40); //x,y,width,height
    }

//Getters dos Valores
	public UtilidadeRotuloTransparente getrGravidadeValor() {return rGravidadeValor;}
	public UtilidadeRotuloTransparente getrCoefAtritoValor() {return rCoefAtritoValor;}
	public UtilidadeRotuloTransparente getrForcaAtritoValor() {return rForcaAtritoValor;}
	public UtilidadeRotuloTransparente getrForcaNormalValor() {return rForcaNormalValor;}
	public UtilidadeRotuloTransparente getrPosFinalValor() {return rPosFinalValor;}
	public UtilidadeRotuloTransparente getrAceleracaoValor() {return rAceleracaoValor;}
	public UtilidadeRotuloTransparente getrPosAtualEixoXValor() {return rPosAtualEixoXValor;}
	public UtilidadeRotuloTransparente getrPosAtualEixoYValor() {return rPosAtualEixoYValor;}
	public UtilidadeRotuloTransparente getrTempoValor() {return rTempoValor;}

}
