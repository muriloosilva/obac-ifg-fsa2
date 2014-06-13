package br.edu.ifg.formosa.obac.utilidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilidadeArredondamento {
	
	//Este método é utilizado para diminuir o número de casas decimais nos números que serão
	//exibidos no painel de informações
	public static double arredondamento(int casas, double valor){
		return new BigDecimal(valor).setScale(casas, RoundingMode.HALF_DOWN).doubleValue();
	}
	
}
