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

	//--String
	public static final String modeloURL = "br/edu/ifg/formosa/obac/imagens/";
	
	//Variáveis	
	//--Double
	private double gravSelecionada; // Recebe ou a gravidade da Terra, da Lua ou de Marte
	
	private double tempo; //OBAC1
	
	//--String
	public static String gravidadeSel = "terra"; //Utilizada para mudar a imagem de fundo
	public static String andaimeSel = "plano"; //Utilizada para mudar a imagem de fundo
	
	//--Objeto, Escala e Superficie
	private ModeloEscala mEPri = new ModeloEscala(); //Escala utilizada em todas as simulações
	private ModeloEscala mESec = new ModeloEscala(); //Escala utilizada somente em Projetil e P&P
	private ModeloObjeto mO = new ModeloObjeto();
	private ModeloSuperficie mS = new ModeloSuperficie();
	
	//Metodos
	//--Getters
	public double getGravSelecionada() {return gravSelecionada;}
	public double getTempo() {return tempo;}
	public ModeloEscala getmEPri() {return mEPri;}
	public ModeloEscala getmESec() {return mESec;}
	public ModeloObjeto getmO() {return mO;}
	public ModeloSuperficie getmS() {return mS;}
	
	//--Setters
	public void setGravSelecionada(double gravSelecionada) {
		this.gravSelecionada = gravSelecionada;
//		cpi.mudaValorGravidade(ModeloAmbiente.gravSelecionada);//Altera a gravidade no painel de informações
	}
	public void setTempo(double tempo) {
		this.tempo = tempo;
//		cpi.mudaValorTempo(this.tempo);//Altualiza o valor do tempo no painel de informações
	}
}