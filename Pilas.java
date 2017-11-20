package InicioProyecto;
import acm.graphics.*;
import java.awt.Color;

public class Pilas {
	public static final double cAstaX = 225;
	public static final int cAstaY= 290;
	
	public Pilas(int n) {
		for (int i = n ; i>=0; i--) {
			Disk d = new Disk(i);
			d.setFilled(true);
			d.setFillColor(Color.RED);
			d.move(cAstaX - 10*i, cAstaY- 10*(n-i));
		}	
	}
}
