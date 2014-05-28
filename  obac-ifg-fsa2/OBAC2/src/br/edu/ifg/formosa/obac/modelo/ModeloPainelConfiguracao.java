package br.edu.ifg.formosa.obac.modelo;


public class ModeloPainelConfiguracao {
	
	//Array de String usado nos tipos de propulsão 
	private final String [] propulsoes = {"Canhão", "Mola"};
	
	//Array de String usado nos tipos de simulação
	private final String [] simulacoesPadrao = {"Plano", "Subida", "Decida", "Plano e Precipício", "Queda Livre"};
	//String que completa o array acima quando a propulsão canhão é selecionada, sendo també utilizada em ControlePainelConfiguracaoAtualizacoes
	private final String lancamentoObliquo = "Lançamento Oblíquo";
	
	//Array de String usado nos tipos de atrito
	private final String [] atritos = {"Asfalto", "Alumínio", "Madeira"};
	
	//Array de String usado nos tipos de gravidade
	private final String [] gravidade = {"Terra", "Lua", "Marte"};
	
	//Strings utilizadas no botão bIniciarPausa em VisaoPainelConfiguracao e em ControlePainelConfiguracaoExecucao
	private String botaoIniciar = "Iniciar Simulação";
	private String botaoPausar = "Pausar Simulação";
	
	//Strings utilizadas em uma codição de ControlePainelConfiguracaoAtualizacoes
	private final String canhao = "Canhão";
	private final String mola = "Mola";
	
	//Strings usadas em rótulos que são alterados no painel de informações
	private final String dado1Canhao = "Ângulo (°)"; 
	private final String dado2Canhao = "Energia (J)";
	private final String dado1Mola = "Tamaho da Mola(m)";
	private final String dado2Mola = "Constante Elástica (N/m)";
	
//Getters
	public String getCanhao() {
		return canhao;
	}
	public String getMola() {
		return mola;
	}
	public String getDado1Canhao() {
		return dado1Canhao;
	}
	public String getDado2Canhao() {
		return dado2Canhao;
	}
	public String getDado1Mola() {
		return dado1Mola;
	}
	public String getDado2Mola() {
		return dado2Mola;
	}
	public String[] getSimulacoesPadrao() {
		return simulacoesPadrao;
	}
	public String getLancamentoObliquo() {
		return lancamentoObliquo;
	}
	public String[] getAtritos() {
		return atritos;
	}
	public String[] getGravidade() {
		return gravidade;
	}
	public String[] getPropulsoes() {
		return propulsoes;
	}
	public String getBotaoIniciar() {
		return botaoIniciar;
	}
	public void setBotaoIniciar(String botaoIniciar) {
		this.botaoIniciar = botaoIniciar;
	}
	public String getBotaoPausar() {
		return botaoPausar;
	}
	public void setBotaoPausar(String botaoPausar) {
		this.botaoPausar = botaoPausar;
	}
	
}
