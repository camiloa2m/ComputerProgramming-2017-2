import acm.graphics.*;
import acm.program.*;

public class Interfaz1 extends GraphicsProgram {
	private int numDisk;
	private int sizeDisk;
	private GRoundRect d;
	
	public void run() {
		discosApilados(3);
	}
	public GRoundRect discosC (int g) {
		numDisk = g;
		sizeDisk = numDisk*20;
		d = new GRoundRect(sizeDisk,10);
		return d;
	}
	public void discosApilados(int n) {
		for (int i = 1;i<=n; i++) {
			d = discosC(i);
			add(d, n*10 - i*10, 10*i);
		}
	}

}
