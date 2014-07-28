package br.edu.ifg.formosa.obac.modelo;

import java.awt.Color;
import java.net.URL;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;

public class ModeloAmbiente {	
	//Constantes
	//--Double
	public static final double gravidadeTerra = 9.8;
	public static final double gravidadeLua = 1.6;
	public static final double gravidadeMarte = 3.7;

	//--String
	public static final String modeloURL = "br/edu/ifg/formosa/obac/imagens/";
	
	//Variáveis
	//--Double
	public static double anguloInclinacaoGraus = 0;
	private double gravSelecionada; // Recebe ou a gravidade da Terra, da Lua ou de Marte	
	private double tempo; //OBAC1
	
	//--URL
	private URL urlGr = this.getClass().getClassLoader().getResource(modeloURL + "ambiente/" + "terra" + ".png"); //gravidade
	private URL urlA = this.getClass().getClassLoader().getResource(modeloURL + "andaimes/" + "plano" + ".png"); //andaime
	private URL urlGu = this.getClass().getClassLoader().getResource(modeloURL + "andaimes/" + "guindasteF" + ".png"); //guindaste
	
	//--Controle Painel de Configuração - atualizar dados referente ao ambiente
	private static ControlePainelInformacao cpi = null;
	
	//--Objeto, Escala e Superficie
	private ModeloEscala mEPri = null; //Escala utilizada em todas as simulações
	private ModeloEscala mESec = null; //Escala utilizada somente em Projetil e P&P
	private ModeloObjeto mO = null;
	private ModeloSuperficie mS = null;
	private ModeloMola mM = null;
	
	//--Color
	public static Color cor = Color.black; //Utilizado pra desenhar a escala de maneira que fique bem visivel nas simuações
	
	//Metodos	
	//--Construtor
	public ModeloAmbiente(ControlePainelInformacao cpi, ModeloEscala mEPri, ModeloEscala mESec,
						  ModeloObjeto mO, ModeloSuperficie mS, ModeloMola mM)
	{
		ModeloAmbiente.cpi = cpi;
		this.mEPri = mEPri;
		this.mESec = mESec;
		this.mO = mO;
		this.mS = mS;
		this.mM = mM;
	}
	
	//--Getters
	public double getGravSelecionada() {return gravSelecionada;}
	public double getTempo() {return tempo;}
	public ModeloEscala getmEPri() {return mEPri;}
	public ModeloEscala getmESec() {return mESec;}
	public ModeloObjeto getmO() {return mO;}
	public ModeloSuperficie getmS() {return mS;}
	public ModeloMola getmM(){return mM;}
	public URL getUrlGr() {return urlGr;}
	public URL getUrlA() {return urlA;}
	public URL getUrlGu() {return urlGu;}
	
	//--Setters
	public void setUrlGr(String urlGr) {this.urlGr = this.getClass().getClassLoader().getResource(modeloURL + "ambiente/" + urlGr + ".png");}
	public void setUrlA(String urlA) {this.urlA = this.getClass().getClassLoader().getResource(modeloURL + "andaimes/" + urlA + ".png");}
	public void setUrlGu(String urlGu) {this.urlGu = this.getClass().getClassLoader().getResource(modeloURL + "andaimes/" + urlGu + ".png");}
	
	//--Setters relacionados ao Painel de Informação
	public void setGravSelecionada(double gravSelecionada) {
		this.gravSelecionada = gravSelecionada;
		cpi.mudaValorGravidade(this.gravSelecionada); //Altera a gravidade no painel de informações
	}
	public void setTempo(double tempo) {
		this.tempo = tempo;
		cpi.mudaValorTempo(this.tempo); //Altualiza o valor do tempo no painel de informações
	}
}