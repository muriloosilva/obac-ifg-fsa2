package br.edu.ifg.formosa.obac.modelo;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;

public class ModeloPropulsao {

	//Variáveis
	//--Int
	private int translaX = 30;
	private int translaY = 470;
	
	//--Modelos
	private ModeloMola mM = null;
	
	//Métodos
	//--Construtor
	public ModeloPropulsao(ModeloAmbiente ma, ControlePainelInformacao cpi,
						   ControlePainelFormulas cpf, VisaoPainelFormulas vpf)
	{
		
		mM = new ModeloMola(ma, cpi, cpf, vpf);
	}
	
	//--Getters
	public ModeloMola getModeloMola(){return mM;}
	public int getTranslaX() {return translaX;}
	public int getTranslaY() {return translaY;}
}
