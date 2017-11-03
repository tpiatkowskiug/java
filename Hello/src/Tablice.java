
public class Tablice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] tablica = new int[10];
        
        for (int i = 0; i < 10; i++)
            tablica[i] = i + 1;
 
        int zmienna = tablica[3];
 
        for (int i = 0; i < 10; i++)
            System.out.println("Kolejna komórka to: " + tablica[i]);
	}

}
