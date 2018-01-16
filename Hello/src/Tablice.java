import java.util.Scanner;


public class Tablice {

	public static void main(String[] args) {
		String tabimion[] = new String[5];
		for(int i=0; i<tabimion.length; i++){
			Scanner imie = new Scanner(System.in);
			String c = imie.nextLine();
			tabimion[i]=c;
		}
		for(String z : tabimion){
			System.out.println("Twoje imie to	"+z);
		}
		System.out.println("Podaj razmiar tablicy");
		Scanner rozmiar = new Scanner(System.in);
		int tabliczb[] = new int[rozmiar.nextInt()];
//		for(int i=0; i<tabliczb.length; i++){
//			tabliczb[i]=i+1;
//		}
		int i =0;
		while(i < tabliczb.length){
				tabliczb[i]=i+1;
				i++;
		}
		for(int z:tabliczb){
			System.out.println(z);
		}
		int licznik=0;
		int tabwielow[][] = new int[2][3];
		for(int ii=0; ii<tabwielow.length;ii++ ){
			for(int j=0; j<tabwielow[ii].length; j++){
				tabwielow[ii][j]=licznik++;
				System.out.printf("tab[%d][%d]=%d \n",ii, j,tabwielow[ii][j]);
			}
//			for(int i=0; i< tabwielow.length; i++)
//		          for(int j=0; j< tabwielow[i].length; j++)
//		              System.out.printf("tab[%d][%d]=%d \n", i, j, tabwielow[i][j]);
		}
	}

}
