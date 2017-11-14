import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class Interfaz1 extends GraphicsProgram {
	private int numDisk;
	private int sizeDisk;
	private GRoundRect d;
	private GRect e;
	
	public void run() {
		discosApilados(8);
		astas();
	}
	/**
	 * Método que crea un disco gráfico
	 * @param g Número de disco
	 * @return Retorna disco 
	 */
	public GRoundRect discosC (int g) {
		numDisk = g;
		sizeDisk = numDisk*20;
		d = new GRoundRect(sizeDisk,10);
		return d;
	}
	
	/**
	 * Método que crea una pila de discos de forma gráfica
	 * @param n Número de discos en la pila
	 */
	public void discosApilados(int n) {
		for (int i = 1;i<=n; i++) {
			d = discosC(i);
			add(d, 100+(n*10 - i*10), 100+(10*i));
		}
	}
	public void astas () {
		e = new GRect (5, 200);
		e.setFilled(true);
		e.setFillColor(Color.GRAY);
		add(e);
	}
	

}
