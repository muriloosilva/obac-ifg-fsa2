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
	
	//Primeira Linha---------------------------------------
		//Gravidade
		private UtilidadeRotuloTransparente rGravidade;
		private UtilidadeRotuloTransparente rGravidadeValor;
		//Coeficiente de Atrito
		private UtilidadeRotuloTransparente rCoefAtrito;
		private UtilidadeRotuloTransparente rCoefAtritoValor;
		//Aceleração
		private UtilidadeRotuloTransparente rAceleracao;
		private UtilidadeRotuloTransparente rAceleracaoValor;
		//Posição Final no Eixo X
		private UtilidadeRotuloTransparente rPosFinalX;
		private UtilidadeRotuloTransparente rPosFinalXValor;
		//Posição Final no Eixo Y
		private UtilidadeRotuloTransparente rPosFinalY;
		private UtilidadeRotuloTransparente rPosFinalYValor;
	//Segunda Linha----------------------------------------
		//Força Normal
		private UtilidadeRotuloTransparente rForcaNormal;
		private UtilidadeRotuloTransparente rForcaNormalValor;
		//Força de Atrito
		private UtilidadeRotuloTransparente rForcaAtrito;
		private UtilidadeRotuloTransparente rForcaAtritoValor;
		//Velocidade
		private UtilidadeRotuloTransparente rVelocidade;
		private UtilidadeRotuloTransparente rVelocidadeValor;
		//Posição no Eixo X
		private UtilidadeRotuloTransparente rPosAtualEixoX;
		private UtilidadeRotuloTransparente rPosAtualEixoXValor;
		//Posição no Eixo Y
		private UtilidadeRotuloTransparente rPosAtualEixoY;
		private UtilidadeRotuloTransparente rPosAtualEixoYValor;
	//Terceira Linha---------------------------------------
		//Tempo
		private UtilidadeRotuloTransparente rTempo;
		private UtilidadeRotuloTransparente rTempoValor;
		//Mola Taxa de Deformação
		private UtilidadeRotuloTransparente rX;
		private UtilidadeRotuloTransparente rXValor;
		//Mola Constante Elástica
		private UtilidadeRotuloTransparente rK;
		private UtilidadeRotuloTransparente rKValor;
		//Canhão Energia
		private UtilidadeRotuloTransparente rJ;
		private UtilidadeRotuloTransparente rJValor;
		//Canhão Ângulo
		private UtilidadeRotuloTransparente rA;
		private UtilidadeRotuloTransparente rAValor;
		//Velocidade Pós Colisão
		private UtilidadeRotuloTransparente rVelocidadePosColisao;
		private UtilidadeRotuloTransparente rVelocidadePosColisaoValor;
		
	//Layout
		private GridBagLayout layout = null;
		private GridBagConstraints gbc = null;
	
	public VisaoPainelInformacao() {
		this.setOpaque(false);
		this.setSize(750, 60);
		this.setBackground(Color.DARK_GRAY);
		
		//Layout
		layout = new GridBagLayout();
		this.setLayout(layout);//O painel passa a utilizar o layout automático
		
		//Variável responsável pelo posicionamento e alocação dos componentes
		gbc = new GridBagConstraints();
			gbc.insets = new Insets(2, 10, 0, 0);
			gbc.weighty = 1;
			this.gbc.weightx = 0;
			gbc.fill = GridBagConstraints.NONE;
			gbc.anchor = GridBagConstraints.WEST;
			gbc.ipadx =10;
			gbc.ipady = 20;
			//Configura gridwidth e gridheight (quadros ocupados nos eixos x e y)
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
		
		//Rótulo
			//Primeira Linha---------------------------------------
				//Gravidade
				rGravidade = new UtilidadeRotuloTransparente("Gravidade:");
					rGravidade.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rGravidade, 1, 0);
				//Coeficiente de Atrito
				rCoefAtrito = new UtilidadeRotuloTransparente("Coef. de Atrito:");
					rCoefAtrito.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rCoefAtrito, 1, 2);
				//Acelereação
				rAceleracao = new UtilidadeRotuloTransparente("Aceleração:");
					rAceleracao.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rAceleracao, 1, 4);
				//Posição Final no Eixo X
				rPosFinalX = new UtilidadeRotuloTransparente("Pos. Final:");
					rPosFinalX.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rPosFinalX, 1, 6);
				//Posição Final no Eixo X
				rPosFinalY = new UtilidadeRotuloTransparente("Pos. Final:");
					rPosFinalY.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rPosFinalY, 1, 8);
			//Segunda Linha---------------------------------------
				//Força de Atrito
				rForcaAtrito = new UtilidadeRotuloTransparente("Força de Atrito:");
					rForcaAtrito.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rForcaAtrito, 2, 0);
				//Força Normal
				rForcaNormal = new UtilidadeRotuloTransparente("Força Normal:");
					rForcaNormal.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rForcaNormal, 2, 2);
				//Velocidade
				rVelocidade = new UtilidadeRotuloTransparente("Velocidade:");
					rVelocidade.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rVelocidade, 2, 4);
				//Posição no Eixo X
				rPosAtualEixoX = new UtilidadeRotuloTransparente("Pos. Atual Eixo X:");
					rPosAtualEixoX.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rPosAtualEixoX, 2, 6);
				//Posição no Eixo Y
				rPosAtualEixoY = new UtilidadeRotuloTransparente("Pos. Atual Eixo Y:");
					rPosAtualEixoY.setHorizontalAlignment(JLabel.RIGHT);
					addComponent(rPosAtualEixoY, 2, 8);
			//Terceira Linha---------------------------------------
				//Tempo
				rTempo = new UtilidadeRotuloTransparente("Tempo:");
					rTempo.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rTempo, 3, 0);
				//Mola Taxa de Deformação
				rX = new UtilidadeRotuloTransparente("Taxa de Deformação:");
					rX.setHorizontalAlignment(JLabel.RIGHT);
					rX.setVisible(false);
				addComponent(rX, 3, 2);
				//Mola Constante Elástica
				rK = new UtilidadeRotuloTransparente("Const. Elástica:");
					rK.setHorizontalAlignment(JLabel.RIGHT);
					rK.setVisible(false);
				addComponent(rK, 3, 4);
				//Canhão Energia
				rJ = new UtilidadeRotuloTransparente("Energia:");
					rJ.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rJ, 3, 2);
				//Canhão Ângulo
				rA = new UtilidadeRotuloTransparente("Ângulo:");
					rA.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rA, 3, 4);
				//Velocidade Pós Colisão
				rVelocidadePosColisao = new UtilidadeRotuloTransparente("V. Pós Colisão:");
					rVelocidadePosColisao.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rVelocidadePosColisao, 3, 6);
			
		//Alteração nos valores de espaçamento dos componentes
			gbc.insets = new Insets(2, 5, 0, 10);
			
		//Valores
			//Primeira Linha---------------------------------------
				//Gravidade	
				rGravidadeValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rGravidadeValor, 1, 1);
				//Coeficiente de Atrito
				rCoefAtritoValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rCoefAtritoValor, 1, 3);
				//Acelereação
				rAceleracaoValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rAceleracaoValor, 1, 5);
				//Posição Final no eixo X
				rPosFinalXValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rPosFinalXValor, 1, 7);
				//Posição Final no eixo Y
				rPosFinalYValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rPosFinalYValor, 1, 9);
			//Primeira Linha---------------------------------------
				//Força Normal
				rForcaNormalValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rForcaNormalValor, 2, 1);
				//Força de Atrito
				rForcaAtritoValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rForcaAtritoValor, 2, 3);
				//Velocidade
				rVelocidadeValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rVelocidadeValor, 2, 5);
				//Posição no Eixo X
				rPosAtualEixoXValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rPosAtualEixoXValor, 2, 7);
				//Posição no Eixo Y
				rPosAtualEixoYValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rPosAtualEixoYValor, 2, 9);
			//Terceira Linha---------------------------------------
				//Tempo
				rTempoValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rTempoValor, 3, 1);
				//Mola Taxa de Deformação
				rXValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rXValor, 3, 3);
				//Mola Constante Elástica
				rKValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rKValor, 3, 5);
				//Canhão Energia
				rJValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rJValor, 3, 3);
				//Canhão Ângulo
				rAValor = new UtilidadeRotuloTransparente("0.0");
				addComponent(rAValor, 3, 5);
				//Velocidade Pós Colisão
				rVelocidadePosColisaoValor = new UtilidadeRotuloTransparente("0.0");
					rVelocidadePosColisaoValor.setHorizontalAlignment(JLabel.RIGHT);
				addComponent(rVelocidadePosColisaoValor, 3, 7);
	}
	
	//Posiciona os componentes
	private void addComponent(Component c, int linha, int coluna){
		//Configura gridX e gridY
			gbc.gridx = coluna;
			gbc.gridy = linha;
		//Configura restrições e adiciona componentes
			this.add(c, gbc);
	}
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color ppColor = new Color(0, 0, 0, 115); //r,g,b,alpha
        g.setColor(ppColor);
        g.fillRect(0,0,750,60); //x,y,width,height
    }

	//Getters
	public UtilidadeRotuloTransparente getrPosFinalXValor() {return rPosFinalXValor;}
	public UtilidadeRotuloTransparente getrPosFinalYValor() {return rPosFinalYValor;}
	public UtilidadeRotuloTransparente getrGravidadeValor() {return rGravidadeValor;}
	public UtilidadeRotuloTransparente getrCoefAtritoValor() {return rCoefAtritoValor;}
	public UtilidadeRotuloTransparente getrAceleracaoValor() {return rAceleracaoValor;}
	public UtilidadeRotuloTransparente getrForcaNormalValor() {return rForcaNormalValor;}
	public UtilidadeRotuloTransparente getrForcaAtritoValor() {return rForcaAtritoValor;}
	public UtilidadeRotuloTransparente getrVelocidadeValor() {return rVelocidadeValor;}
	public UtilidadeRotuloTransparente getrPosAtualEixoXValor() {return rPosAtualEixoXValor;}
	public UtilidadeRotuloTransparente getrPosAtualEixoYValor() {return rPosAtualEixoYValor;}
	public UtilidadeRotuloTransparente getrTempoValor() {return rTempoValor;}
	public UtilidadeRotuloTransparente getrXValor() {return rXValor;}
	public UtilidadeRotuloTransparente getrKValor() {return rKValor;}
	public UtilidadeRotuloTransparente getrJValor() {return rJValor;}
	public UtilidadeRotuloTransparente getrAValor() {return rAValor;}
	public UtilidadeRotuloTransparente getrVelocidadePosColisaoColisao(){return rVelocidadePosColisaoValor;}
	
	//Setters especiais
	public void setVisivelMola(){
		//Tona as variáveis relacionadas a MOLA visível
		rK.setVisible(true);
		rKValor.setVisible(true);
		rX.setVisible(true);
		rXValor.setVisible(true);
		//Tona as variáveis relacionadas ao CANHÃO invisíveis
		rJ.setVisible(false);
		rJValor.setVisible(false);
		rA.setVisible(false);
		rAValor.setVisible(false);
	}
	
	public void setVisivelCanhao(){
		//Tona as variáveis relacionadas a CANHÃO visível
		rJ.setVisible(true);
		rJValor.setVisible(true);
		rA.setVisible(true);
		rAValor.setVisible(true);
		//Tona as variáveis relacionadas a MOLA invisíveis
		rK.setVisible(false);
		rKValor.setVisible(false);
		rX.setVisible(false);
		rXValor.setVisible(false);
	}
	
	public void setVisivelColisao(boolean colisao){
		rVelocidadePosColisao.setVisible(colisao);
		rVelocidadePosColisaoValor.setVisible(colisao);
	}
}