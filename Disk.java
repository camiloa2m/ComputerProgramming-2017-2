package proyecto_final;

public class Disk {
	private int numDisk;
	private int sizeDisk; 
	
	/**
	 * Constructor que crea un objeto de tipo Disco. El objeto ademas tiene como atributo sizeDisk que
	 * representa el tamaño del disco en tipo int dado por numDisk*20
	 * @param numDisk Parametro de tipo int que representa el número del disco
	 */
	public Disk(int numDisk) {
		this.numDisk = numDisk; 
		sizeDisk = numDisk*20;
	}
	
	/**
	 * Método para retornar el número del disco
	 * @return Número de disco
	 */
	public int getNumDisk() {
		return numDisk;
	}
	
	/**
	 * Método para retornar el tamaño del disco, su valor esta dado por numDisk*20 
	 * @return Tamaño del disco dado por el valor resultante de numDisk*20 
	 */
	public int getSizeDisk() {
		return sizeDisk;
	}
	
}
