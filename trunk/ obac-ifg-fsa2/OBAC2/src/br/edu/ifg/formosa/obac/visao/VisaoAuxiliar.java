package br.edu.ifg.formosa.obac.visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;

public class VisaoAuxiliar extends JPanel{
	//Variáveis
	//--Modelo
	private ModeloAmbiente mA = null;
	//--Visão
	private VisaoPainelConfiguracao vPC = null;
	//--Partes o Deslisante da mola
		private JPanel pCompressor = null;
		private JSlider deslizanteMola = null;
		private JLabel rotuloCompressao = null;
	//--Variável de posicionamento vertical do painel de compressão
	private int posYCompressor = 550;
	
	//Métodos
	//--Construtor
	public VisaoAuxiliar(ModeloAmbiente mA, VisaoPainelConfiguracao vPC) {
		super(null);
		this.setSize(750, 600);
		this.setOpaque(true);
		
		this.mA = mA;
		this.vPC = vPC;
		//Deslizante da mola
			//Painel
			pCompressor = new JPanel(null);
				pCompressor.setBounds(30, posYCompressor, 200, 40);
				pCompressor.setBackground(Color.white);
				pCompressor.setBorder(new LineBorder(Color.black, 1));
				pCompressor.setVisible(false);
			this.add(pCompressor);
			//Rotulo
			rotuloCompressao = new JLabel("100%", JLabel.LEFT);
				rotuloCompressao.setBounds(10, 20, 80, 20);
//				rotuloCompressao.setSize(100, 30);
				rotuloCompressao.setFont(new Font(null, 0, 20));
				rotuloCompressao.setForeground(Color.black);
			pCompressor.add(rotuloCompressao);
			//Deslizante
			deslizanteMola = new JSlider(JSlider.HORIZONTAL, 1, 100, 100);
				deslizanteMola.setOpaque(false);
				deslizanteMola.setBounds(0, 0, 200, 30);
			pCompressor.add(deslizanteMola);
		//Fim Deslizante da mola
	}
	
	//--Paint
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//Base do canhao
		if (vPC.getCsPropulsao().getSelectedIndex() == 0) {
			g2d.rotate(Math.toRadians(mA.anguloInclinacaoGraus), mA.getmP().getPosXBase(), mA.getmP().getPosYBase());
			
			g2d.drawImage(mA.getmP().getImagemBaseCanhao().getImage(), mA.getmP().getPosXBase(), mA.getmP().getPosYBase(), this);
		}
	}
	
	//--Getters
	public JPanel getpCompressor() {return pCompressor;}
	public JSlider getDeslizanteMola() {return deslizanteMola;}
	public JLabel getRotuloCompressao() {return rotuloCompressao;}
	//--Setters
	public void setPosYCompressor(int posYCompressor) {this.posYCompressor = posYCompressor;}
}