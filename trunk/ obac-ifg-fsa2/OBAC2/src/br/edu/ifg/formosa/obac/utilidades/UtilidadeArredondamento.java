package br.edu.ifg.formosa.obac.utilidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilidadeArredondamento {
	
	public static double arredondamento(int casas, double valor){
		return new BigDecimal(valor).setScale(casas, RoundingMode.HALF_DOWN).doubleValue();
	}
	
}
