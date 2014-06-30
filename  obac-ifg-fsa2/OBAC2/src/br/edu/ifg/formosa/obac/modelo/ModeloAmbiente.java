package br.edu.ifg.formosa.obac.modelo;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;

public class ModeloAmbiente {
	
	//Controle Painel de Configuração - atualizar dados referente ao ambiente
	private static ControlePainelInformacao cpi = null;
	
	//Construtor
	public ModeloAmbiente(ControlePainelInformacao cpi) {
		ModeloAmbiente.cpi = cpi;
	}
	
	//Constantes
	//--Double
	public static final double gravidadeTerra = 9.8;
	public static final double gravidadeLua = 1.6;
	public static final double gravidadeMarte = 3.7;
	
	//Variáveis
	//--Double
	public static double coefAtrito; //Recebe ou o atrito da madeira, ou do asfalto ou do aluminio
	private double gravSelecionada; // Recebe ou a gravidade da Terra, da Lua ou de Marte
	
	private double tempo; //OBAC1
	
	//--Objeto, Escala e Superficie
	private ModeloEscala mE = new ModeloEscala();
	private ModeloObjeto mO = new ModeloObjeto();
	private ModeloSuperficie mS = new ModeloSuperficie();
	
	//Metodos
	//--Getters
//	public static double getGravidadeterra() {return gravidadeTerra;} - Variáveis estáticas não precisam de getters
//	public static double getGravidadelua() {return gravidadeLua;}
//	public static double getGravidademarte() {return gravidadeMarte;}
	public static double getCoefAtrito() {return coefAtrito;}
	public double getGravSelecionada() {return gravSelecionada;}
	public double getTempo() {return tempo;}
	public ModeloEscala getmE() {return mE;}
	public ModeloObjeto getmO() {return mO;}
	public ModeloSuperficie getmS() {return mS;}
	
	//--Setters
	public static void setCoefAtrito(double coefAtrito) {
		ModeloAmbiente.coefAtrito = coefAtrito;
//		cpi.mudaValorCoefAtrito(ModeloAmbiente.coefAtrito);//Altera o valor do Coeficiente de atrito no painel de informções
	}
	public void setGravSelecionada(double gravSelecionada) {
		this.gravSelecionada = gravSelecionada;
//		cpi.mudaValorGravidade(ModeloAmbiente.gravSelecionada);//Altera a gravidade no painel de informações
	}
	public void setTempo(double tempo) {
		this.tempo = tempo;
//		cpi.mudaValorTempo(this.tempo);//Altualiza o valor do tempo no painel de informações
	}
	public void setmE(ModeloEscala mE) {this.mE = mE;}  //Pq vc não setou isso no construtor matheus??
	public void setmO(ModeloObjeto mO) {this.mO = mO;}
	public void setmS(ModeloSuperficie mS) {this.mS = mS;}
	
}