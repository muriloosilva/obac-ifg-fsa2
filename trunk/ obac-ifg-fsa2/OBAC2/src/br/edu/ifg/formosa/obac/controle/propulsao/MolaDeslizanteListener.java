package br.edu.ifg.formosa.obac.controle.propulsao;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie.ControleInicioSimulacoes;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class MolaDeslizanteListener implements ChangeListener, MouseListener{

	//Referencias
	private final VisaoPainelConfiguracao vPC;
	private final VisaoPainelSimulacao vPS;
	private final ModeloAmbiente mA;
	private final ControleOBAC cOBAC;
	private final ControleInicioSimulacoes cIS;
	private ControleMolaSolturaDeslizante cMSD = null;
	
	//Variável de controle
	private boolean mousePressionando = true; 
	
	public MolaDeslizanteListener(VisaoPainelConfiguracao vPC, VisaoPainelSimulacao vPS, ModeloAmbiente mA, ControleOBAC cOBAC, ControleInicioSimulacoes cIS) {
		this.vPC = vPC;
		this.vPS = vPS;
		this.mA = mA;
		this.cOBAC = cOBAC;
		this.cIS = cIS;
		
		this.vPS.getVisaoAuxiliar().getDeslizanteMola().setValue(this.vPS.getVisaoAuxiliar().getDeslizanteMola().getMaximum());
	}
	
	@Override
	public void mousePressed(MouseEvent e) {this.mousePressionando=true;}
	@Override
	public void mouseReleased(MouseEvent e) {testeLogico();}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void stateChanged(ChangeEvent e) {comandos();}
	
	
	private void comandos(){
		if (mousePressionando==true) {
			
			//Atualiza a imagem da mola com o tamnho adequado
			vPS.getVisaoPropulsao().setImagemPropulsao(new ImageIcon(mA.getmP().getImagemPropulsao().getImage().getScaledInstance(this.vPS.getVisaoAuxiliar().getDeslizanteMola().getValue(), 30, Image.SCALE_DEFAULT)));
			//Move o objeto para que ele acompanhe os novos tamanhos da mola
			mA.getmO().setPosicaoXPx(this.vPS.getVisaoAuxiliar().getDeslizanteMola().getValue()+31);
			//Seta o tamnho atual em pixels da mola
			mA.getmP().getModeloMola().setTamanhoMolaAtualPix(this.vPS.getVisaoAuxiliar().getDeslizanteMola().getValue());
			//Seta o tamnho atual em metros da mola
			mA.getmP().getModeloMola().setTamanhoMolaAtualM(
					(UtilidadeConvercoesEscala.convertePixelMetro(//COnversão de Pixel para Metros
							mA.getmP().getModeloMola().getTamanhoMolaTotalM(),//Tamanho total em M
							mA.getmP().getModeloMola().getTamanhoMolaAtualPix(),//Tamanho atual em PX
							mA.getmP().getModeloMola().getTamanhoMolaTotalPix())));//Tamanho Total Px

			//Label que exibe o tamnho atual da mola
			this.vPS.getVisaoAuxiliar().getRotuloCompressao().setText(this.vPS.getVisaoAuxiliar().getDeslizanteMola().getValue()+"%");
		}
		else{
			cMSD = new ControleMolaSolturaDeslizante(vPS.getVisaoPropulsao(), mA, cOBAC, cIS, vPC);
			mousePressionando=true;
		}
		this.cOBAC.repinta();
//		mousePressionando=true;
	}
	
	private void testeLogico(){
		if(this.vPS.getVisaoAuxiliar().getDeslizanteMola().getValue()<this.vPS.getVisaoAuxiliar().getDeslizanteMola().getMaximum()){
			this.mousePressionando=false;
			this.vPS.getVisaoAuxiliar().getpCompressor().setVisible(false);
			this.vPS.getVisaoAuxiliar().getpCompressor().setEnabled(true);
			comandos();
		}
	}
	
//Não usados_________________________________________________________
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}

}
