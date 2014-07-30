package br.edu.ifg.formosa.obac.modelo;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ModeloPropulsao {

	private ModeloMola mm = null;
	
	public ModeloPropulsao(ModeloAmbiente ma, ControlePainelInformacao cpi,
						   ControlePainelFormulas cpf, VisaoPainelFormulas vpf)
	{
		
		mm = new ModeloMola(ma, cpi, cpf, vpf);
	}
	
	public ModeloMola getModeloMola(){return mm;}
	
}
