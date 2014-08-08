package br.edu.ifg.formosa.obac.modelo;

public class ModeloCanhao {
	//Variáveis
	//--Double
	private double anguloRotacao = 0.0;
	private double energia = 0;
	
	//--Int
	private int posX = 0;
	private int posY = 0;
	
	private int tamanhoXPixC = 0; //Posição do canhão
	private int tamanhoYPixC = 0;

	private int tamanhoXPixB = 0; //Posição da base
	private int tamanhoYPixB = 0;
	//Métodos
	//--Getters
	public double getAnguloRotacao() {return anguloRotacao;}
	public double getEnergia() {return energia;}
	public int getPosX() {return posX;}
	public int getPosY() {return posY;}
	public int getTamanhoXPixC() {return tamanhoXPixC;}
	public int getTamanhoYPixC() {return tamanhoYPixC;}
	public int getTamanhoXPixB() {return tamanhoXPixB;}
	public int getTamanhoYPixB() {return tamanhoYPixB;}
}