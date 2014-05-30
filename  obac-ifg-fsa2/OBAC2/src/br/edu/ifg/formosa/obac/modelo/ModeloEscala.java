package br.edu.ifg.formosa.obac.modelo;

public class ModeloEscala {
	//Variaveis
	//--String
	private String[] valorMarcadores = new String[4];
	private String valorMarcadorInicial = "0";
	
	//--Int
	private int[] posXInicioMarcadores = new int[4];
	private int[] posYInicioMarcadores = new int[4];
	private int[] posXFimMarcadores = new int[4];
	private int[] posYFimMarcadores = new int[4];
	
	private int posXMarcadorInicial = 0;
	private int posYMarcadorInicial = 0;
	
	//Getters
	public String[] getValorMarcadores() {return this.valorMarcadores;}
	public String getValorMarcadorInicial() {return this.valorMarcadorInicial;}
	
}