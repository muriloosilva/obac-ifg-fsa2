package br.edu.ifg.formosa.obac.modelo;

import javax.swing.ImageIcon;

public class ModeloObstaculo {
	
	private final int POSINIXOBS = 253;
	private final int POSINIYOBS = 400;
	
	private int posicaoXPx = POSINIXOBS;
	private int posicaoYPx = POSINIYOBS;
	public static final long MASSA = 1000000000;
	public static final int TAMANHOX = 50;
	public static final int TAMANHOY = 100;
	

	private final ImageIcon imagemObstaculo = new ImageIcon(
			this.getClass().getClassLoader().getResource("br/edu/ifg/formosa/obac/imagens/propulsaoObstaculo/obstaculo_colisao.png"));

	//GETTERS E SETTERS
	public int getPosicaoXPx() {return posicaoXPx;}
	public int getPosicaoYPx() {return posicaoYPx;}
	public ImageIcon getImagemObstaculo() {return imagemObstaculo;}
	
	public void setPosicaoYPx(int posicaoYPx) {this.posicaoYPx = posicaoYPx;}
	public void setPosicaoXPx(int posicaoXPx) {this.posicaoXPx = posicaoXPx;}

}
