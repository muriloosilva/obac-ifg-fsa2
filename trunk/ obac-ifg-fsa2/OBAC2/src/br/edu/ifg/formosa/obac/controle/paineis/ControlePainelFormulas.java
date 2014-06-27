package br.edu.ifg.formosa.obac.controle.paineis;

import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;
import br.edu.ifg.formosa.obac.modelo.ModeloSuperficie;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ControlePainelFormulas {
	
	private VisaoPainelFormulas vpi = null;
	private VisaoPainelConfiguracao vpc = null;
	private ModeloAmbiente ma = null;
	private ModeloObjeto mo = null;
	private ModeloSuperficie ms = null;
	
	//Esta classe vai para o controle do painel de configurações para que a mudança dos paineis ocorra
	public ControlePainelFormulas(VisaoPainelFormulas vpi, VisaoPainelConfiguracao vpc, ModeloAmbiente ma, ModeloObjeto mo, ModeloSuperficie ms) {
		this.vpi = vpi;
		this.vpc = vpc;
		this.ma = ma;
		this.mo = mo;
		this.ms = ms;
	}
	
//	public static String velocidadeInicialMola(){}
//	public static String velocidadeInicialCanhao(){}
//	public static String forcaNomal(){}
//	public static String aceleracao(){}
//	public static String posicaoFinal(){}
//	public static String tempo(){}
//	public static String novaPosicao(){}
//	public static String colisao(){}
	
	public void alteraTipoPainel(int formaPFormulas){//Ativado quando é dado inicio a simulação
		//Normal
		if(vpc.getBoColisaoNao().isSelected()==true)  configuracaoNormal();
		//Colisão
		else if(vpc.getBoColisaoSim().isSelected()==true)  configuracaoColisao();
		//Lançamento Obliquo
		else  if(vpc.getCsAmbienteSimulacao().getSelectedIndex()==6)configuracaoLancamentoObliquo();
	}
	
	//Os três métodos a seguir configuram quais paineis de formulas serão exibidos de acordo com o
	//tipo de simulação 
	private void configuracaoNormal(){
		vpi.setPVInicial(true);
		vpi.setPFNormal(true);
		vpi.setPAtrito(true);
		vpi.setPAceleracao(true);
		vpi.setPPosFinal(true);
		vpi.setPTempo(true);
		vpi.setPNovaPos(true);
		vpi.setPColisao(false);
		vpi.setPNovaPosColisao(false);
		vpi.setpAlcanceTotalHorizontal(false);
		vpi.setpAlcanceTotalVertical(false);
		vpi.setpMovimentoHorizontal(false);
		vpi.setpMovimentoVertical(false);
		
		vpi.modificaPTempo(false);
	}
	private void configuracaoColisao(){
		vpi.setPVInicial(true);
		vpi.setPFNormal(true);
		vpi.setPAtrito(true);
		vpi.setPAceleracao(true);
		vpi.setPPosFinal(true);
		vpi.setPTempo(true);
		vpi.setPNovaPos(true);
		vpi.setPColisao(true);
		vpi.setPNovaPosColisao(true);
		vpi.setpAlcanceTotalHorizontal(false);
		vpi.setpAlcanceTotalVertical(false);
		vpi.setpMovimentoHorizontal(false);
		vpi.setpMovimentoVertical(false);
		
		vpi.modificaPTempo(false);
	}
	private void configuracaoLancamentoObliquo(){
		vpi.setPVInicial(false);
		vpi.setPFNormal(false);
		vpi.setPAtrito(false);
		vpi.setPAceleracao(false);
		vpi.setPPosFinal(false);
		vpi.setPTempo(true);
		vpi.setPNovaPos(false);
		vpi.setPColisao(false);
		vpi.setPNovaPosColisao(false);
		vpi.setpAlcanceTotalHorizontal(true);
		vpi.setpAlcanceTotalVertical(true);
		vpi.setpMovimentoHorizontal(true);
		vpi.setpMovimentoVertical(true);
		
		vpi.modificaPTempo(true);
	}
}
