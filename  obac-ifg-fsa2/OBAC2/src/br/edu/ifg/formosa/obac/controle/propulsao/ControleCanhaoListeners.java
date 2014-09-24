package br.edu.ifg.formosa.obac.controle.propulsao;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeArredondamento;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPropulsao;

public class ControleCanhaoListeners implements MouseListener, MouseMotionListener, Runnable{

	//Variáveis
	//--Boolean
	private boolean rodaT = false;
	//--Visao
	private VisaoPropulsao vP = null;
	private VisaoPainelConfiguracao vPC = null;
	//--Modelo
	private ModeloAmbiente mA = null;
	//--Controle
	private ControleOBAC cOBAC = null;
	//--Thread
	private Thread t = null;
	
	//Métodos
	//--Construtor
	public ControleCanhaoListeners(VisaoPropulsao vP, ModeloAmbiente mA, ControleOBAC cOBAC, VisaoPainelConfiguracao vPC) {
		this.vP = vP;
		this.mA = mA;
		this.cOBAC = cOBAC;
		this.vPC = vPC;
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		redirecionaCanhao(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		redirecionaCanhao(e);
	}
	
	//Redirecionar canhão
	private void redirecionaCanhao(MouseEvent e) {
		mA.getmP().getmC().setVerAX(e.getX());
		mA.getmP().getmC().setVerAY(e.getY());
		mA.getmP().getmC().setVerBX(e.getX());
		
		mA.getmP().getmC().setCatOpo(mA.getmP().getmC().getVerBY() - mA.getmP().getmC().getVerAY());				
		mA.getmP().getmC().setCatAd(mA.getmP().getmC().getVerBX() - mA.getmP().getmC().getVerCX());
		mA.getmP().getmC().setHip(Math.sqrt(Math.pow(mA.getmP().getmC().getCatAd(), 2) + Math.pow(mA.getmP().getmC().getCatOpo(), 2)));
		
		double angulo = UtilidadeArredondamento.arredondamento(1, Math.toDegrees(Math.asin(mA.getmP().getmC().getCatOpo() / mA.getmP().getmC().getHip())));
		
		if (e.getX() < 145)
			angulo = 90;
		else if (angulo < 0)
			angulo = 0;
		
		String anguloS = angulo + "";
		
		vPC.getCtPropulsaoDado1().setText(anguloS.replace(".", ","));
	}

	@Override
	public void run() {
		double d;
		while (true) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException iE) {
				iE.printStackTrace();
			}
			
			if (getRodaT()) {
				try {					
					d = Double.parseDouble(vPC.getCtPropulsaoDado1().getText().replace(",", "."));
					if (d < 0) {
						mA.getmP().setAnguloRotacaoGraus(0);
						vPC.getCtPropulsaoDado1().setText("0");
					} else if (d > 90) {
						mA.getmP().setAnguloRotacaoGraus(-90);
						vPC.getCtPropulsaoDado1().setText("90");
					} else {
						mA.getmP().setAnguloRotacaoGraus(-d);
					}
				} catch (NumberFormatException nFE) {
					nFE.printStackTrace();
					mA.getmP().setAnguloRotacaoGraus(0);
					vPC.getCtPropulsaoDado1().setText("0");
				}  finally {
					cOBAC.repinta();
				}
			}
		}
	}

	@Override public void mouseEntered(MouseEvent arg0) {}
	@Override public void mouseExited(MouseEvent arg0) {}
	@Override public void mousePressed(MouseEvent arg0) {}
	@Override public void mouseReleased(MouseEvent arg0) {}
	@Override public void mouseMoved(MouseEvent arg0) {}
	
	//--Getters
	public boolean getRodaT() {return rodaT;}
	
	//--Setters
	public void setRodaT(boolean rT) {this.rodaT = rT;}
}