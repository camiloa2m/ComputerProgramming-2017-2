
import acm.program.ConsoleProgram;

public class Hanoi extends ConsoleProgram{

	public void run() {
		//prueba del método
		torresH(8, 'A','B', 'C');
		println("El numero de pasos fueron: " + nPasos(8));
		
	}
	/**
	 * Método que pasa los discos de la torre inical a la torre final
	 * @param numd Número de discos, tipo de dato int
	 * @param torrei Nombre de la torre inicial en chart, se recomienda 'A'
	 * @param torreaux Nombre de la torre auxiliar en chart, se recomienda 'B'
	 * @param torref Nombre de la torre final en chart, se recomienda 'C'
	 */
	public void torresH(int numd,char torrei,char torreaux, char torref) {
		if (numd == 1) {
			println("Mueva disco "+numd+ " de " + torrei + " a " + torref);
		} else {
			torresH(numd - 1, torrei, torref, torreaux);
			println("Mueva disco "+numd+" de " + torrei + " a " + torref);
			torresH(numd - 1, torreaux, torrei, torref);
		}
	}
	public int nPasos(int numd) {
		int nPasos = (int)(Math.pow(2, numd) - 1);
		return nPasos;
	}
}
