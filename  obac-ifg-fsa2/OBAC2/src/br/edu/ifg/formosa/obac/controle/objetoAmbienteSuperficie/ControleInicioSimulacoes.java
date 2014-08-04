package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControleInicioSimulacoes {

	//Referências necessárias
	//-----Modelos
	private ModeloAmbiente mA = null;
	//-----Visões
	private VisaoPainelConfiguracao vpc = null;
	private VisaoPainelSimulacao vPS = null;
	private VisaoPainelFormulas vPF = null;
	//-----Controles
	private ControlePainelFormulas cpf = null;
	private ControleFormulasObjeto cfo = null;
	
	public ControleInicioSimulacoes(VisaoPainelConfiguracao vpc,
									ControlePainelFormulas cpf)
	{
		this.vpc = vpc;
		this.cpf = cpf;
	}
	//ma, vps, vpf, cfp, cfs
	
	
	public void iniciarSimulacao(){
		//Mudança no painel de fórmulas
		cpf.alteraTipoPainel();
		
		//Plano
//		if(vpc.getCsAmbienteSimulacao().getSelectedIndex()==0){new ControleObjeto1Plano;}
		//Subida
//		else if(vpc.getCsAmbienteSimulacao().getSelectedIndex()==1){new ControleObjeto2Subida();}
		//Descida
//		else if(vpc.getCsAmbienteSimulacao().getSelectedIndex()==2){new ControleObjeto3Descida();}
		//Queda Livre
//		else if(vpc.getCsAmbienteSimulacao().getSelectedIndex()==3){new ControleObjeto4PlanoPrecipicio();}
		//Plano e Precipício
//		else if(vpc.getCsAmbienteSimulacao().getSelectedIndex()==4){new ControleObjeto5QuedaLivre();}
		//Lançamento Oblíquo
//		else if(vpc.getCsAmbienteSimulacao().getSelectedIndex()==5){new ControleObjeto6LancamentoObliquo();}
	}
	
}
