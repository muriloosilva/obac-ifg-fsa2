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
				pCompressor.setBounds(30, 565, 690, 30);
				pCompressor.setBackground(Color.white);
				pCompressor.setBorder(new LineBorder(Color.black, 1));
				pCompressor.setVisible(false);
			this.add(pCompressor);
			//Rotulo
			rotuloCompressao = new JLabel("0%", JLabel.RIGHT);
				rotuloCompressao.setSize(100, 30);
				rotuloCompressao.setFont(new Font(null, 0, 20));
				rotuloCompressao.setForeground(Color.black);
			pCompressor.add(rotuloCompressao);
			//Deslizante
			deslizanteMola = new JSlider(JSlider.HORIZONTAL, 1, 100, 100);
				deslizanteMola.setOpaque(false);
				deslizanteMola.setBounds(100, 1, 589, 28);
			pCompressor.add(deslizanteMola);
		//Fim Deslizante da mola
	}
	
	//--Paint
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//Base do canhao - Só é desenhada aqui, pois ela não pode rotacionar, como rotaciona o VisaoPropulsao.
		if (vPC.getCsPropulsao().getSelectedIndex() == 0) {
			g2d.drawImage(mA.getmP().getImagemBaseCanhao().getImage(), mA.getmP().getPosXB(), mA.getmP().getPosYB(), this);
		}
	}
	public JPanel getpCompressor() {return pCompressor;}
	public JSlider getDeslizanteMola() {return deslizanteMola;}
	public JLabel getRotuloCompressao() {return rotuloCompressao;}
}