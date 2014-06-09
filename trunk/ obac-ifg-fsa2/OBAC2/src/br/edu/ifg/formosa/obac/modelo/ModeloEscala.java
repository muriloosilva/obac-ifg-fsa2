package br.edu.ifg.formosa.obac.modelo;

public class ModeloEscala {
	//Variaveis
	//--Inteiro
	private int tipoSimulacao = 0; // 0 = plano; 1 = subida/descida; 2 = plano + precipicio; 3 = queda; 4 = projetil
	
	private int escalaInicioX = 0; //Inicio da escala X (px)
	private int escalaInicioY = 0; //Inicio da escala Y (px)
	
	private int escalaFimX = 0; //Fim da escala X (px)
	private int escalaFimY = 0; //Fim da escala Y (px)
	
	private int metadeEscala = 0; //Metade da escala (px)
	
	//Metodos
	//--Getters
	public int getTipoSimulacao() {return tipoSimulacao;}
	public int getEscalaInicioX() {return escalaInicioX;}
	public int getEscalaInicioY() {return escalaInicioY;}
	public int getEscalaFimX() {return escalaFimX;}
	public int getEscalaFimY() {return escalaFimY;}
	public int getMetadeEscala() {return metadeEscala;}
	
	//--Setters
	public void setTipoSimulacao(int tipoSimulacao) {this.tipoSimulacao = tipoSimulacao;}
	public void setEscalaInicioX(int escalaInicioX) {this.escalaInicioX = escalaInicioX;}
	public void setEscalaInicioY(int escalaInicioY) {this.escalaInicioY = escalaInicioY;}
	public void setEscalaFimX(int escalaFimX) {this.escalaFimX = escalaFimX;}
	public void setEscalaFimY(int escalaFimY) {this.escalaFimY = escalaFimY;}	
	public void setMetadeEscala(int metadeEscala) {this.metadeEscala = metadeEscala;}
	
}