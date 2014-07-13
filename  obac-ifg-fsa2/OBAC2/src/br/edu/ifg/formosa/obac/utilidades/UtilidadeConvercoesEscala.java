package br.edu.ifg.formosa.obac.utilidades;

public class UtilidadeConvercoesEscala {
	
	//Construtor
	public UtilidadeConvercoesEscala() {
		/*Legenda das variáveis utilizadas nos métodos abaixo:
		 *---pTotal -> Tamanho/Posição total em Pixel (Tamanho da escala/mola em PIXELS)
		 *---pAtual -> Tamanho/Posição atual em Pixel (Tamanho da mola/Posição do Objeto em PIXEL)
		 *---mTotal -> Tamanho/Posição total em Metro (Tamanho da escala/mola em METROS)
		 *---mAtual -> Tamanho/Posição atual em Metro (Tamanho da mola/Posição do Objeto em METROS)
		 */
	}
	
	//Método usado para converter METRO em PIXEL -> p'=m'*p/m 
	public static int converteMetroEmPixelX(double pTotal, double mAtual, double mTotal){
		int pAtual = (int)((mTotal*mAtual)/mTotal);
		return pAtual;
    }//Fim converteMetroEmPixelX
	
	
	//Método usado para converter PIXEL em METRO -> m'=m*p'/p
	public static int convertePixelMetro(double mTotal, double pAtual, double pTotal){
		int mAtual = (int)(mTotal*pAtual/pTotal);
		return mAtual;
	}//Fim convertePixelMetro
	
}
