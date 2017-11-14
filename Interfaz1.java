import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class Interfaz1 extends GraphicsProgram {
	private int numDisk;
	private int sizeDisk;
	private GRoundRect d;
	
	public static final int hDisco = 10;
	
	public static final int bDisco = 20;
	
	public static final double cAstaX = 225;
	
	public static final int cAstaY= 290;
		
	public void run() {
		discosApilados(3);
		astas();
	}
	/**
	 * Método que crea un disco gráfico
	 * @param g Número de disco
	 * @return Retorna disco 
	 */
	public GRoundRect discosC (int g) {
		numDisk = g;
		sizeDisk = numDisk*bDisco;
		d = new GRoundRect(sizeDisk, hDisco);
		return d;
	}
	
	/**
	 * Método que crea una pila de discos de forma gráfica
	 * @param n Número de discos en la pila
	 */
	public void discosApilados(int n) {
		for (int i = n ; i>=0; i--) {
			d = discosC(i);
			d.setFilled(true);
			d.setFillColor(Color.RED);
			add(d, cAstaX - 10*i, cAstaY);
			d.move(0, -10);
		}	
	}
	public void astas () {
		GRect e = new GRect (125-2.5,0,5, 200);
		e.setFilled(true);
		e.setFillColor(Color.GRAY);
		GRect b = new GRect (0,200,240,10);
		b.setFilled(true);
		b.setFillColor(Color.GRAY);
		GCompound ast = new GCompound();
		ast.add(e);
		ast.add(b);
		add(ast,100,100);
		ast.sendToBack();
	}
	
///*100-2.5+(k*10)*/
}
