import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class tablica {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		String imie = scanner.nextLine();
//		System.out.println(imie);
//		System.out.println("Moje imie" + imie);
		
//		int tabela[] = new int[6];
//		for(int i=0; i<tabela.length; i++){
//			tabela[i]=i+1;
//		}
//		for(int i=0; i<tabela.length; i++){
//			System.out.print(tabela[i]+" ");
//		}
		
		
//		
//		for(int i=0; i<=10; i++){
//			for(int j=0; j<=10; j++){
//				if(i==0 && j==0){
//					System.out.print("*\t");
//				}
//				else if(i!=0 && j==0){
//					System.out.print(i + (j==10 ? "\n":"\t"));
//				}
//				else if(i==0 && j!=0){
//					System.out.print(j+(j==10 ? "\n":"\t"));
//				}
//				else{
//			System.out.print((i*j) + (j==10 ? "\n": "\t" ));
//			}
//			}
//		}
		
//	for(int i=0; i<=10; i++){
//		System.out.print("\n");
//		for(int j=0; j<=10; j++){
//			System.out.print("\t"+i*j);
//		}
//	}	
		
		
//		Napisz program, w którym zadeklarujesz i utworzysz pięcioelementową 
//		tablicę odpowiedniego typu. W pętli pobierzesz od użytkownika 5 imion
//		i je w niej zapiszesz. 
//		Następnie wyświetl na ekranie powiadomienia
//		"Witaj imie_z_tablicy" dla każdego z podanych parametrów. 
//		String tabelaimion[]=new String[4];
//		for(int i=0; i<tabelaimion.length; i++){
//		Scanner scanner = new Scanner(System.in);
//		String imie = scanner.nextLine();
//		tabelaimion[i]=imie;
//		//System.out.println(tabelaimion[i]);
//		}
//		for(int i=0; i<tabelaimion.length; i++){
//		System.out.println("cześć " + tabelaimion[i]);}
		
		
//		Utwórz tablicę typu int przechowującą n elementów - gdzie n 
//		jest parametrem pobieranym od użytkownika. Następnie wypełnij ją 
//		liczbami od 1 do n i wyświetl zawartość na ekranie przy pomocy 
//		pętli while. 
//		System.out.println("podaj długość tablicy, którą chcesz utworzyć");
//		Scanner scanner = new Scanner(System.in);
//		int dlugosctablicy = scanner.nextInt();
//		int tabelaliczb[] = new int[dlugosctablicy]; 
//		for(int i=0; i<tabelaliczb.length; i++){
//			tabelaliczb[i]=i+1;
//			System.out.println("zawartość tableli to "+tabelaliczb[i]);
//		}
		
		
		
//		Przy użyciu pętli i tablic 
//		przechowujących liczby całkowite zaprezentuj poniższą treść
//		tab[0,0] = 0;
//		tab[0,1] = 1;
//		tab[0,2] = 2;
//		tab[1,0] = 3;
//		tab[1,1] = 4;
//		tab[1,2] = 5; 
//		int tabela1[][] = new int[2][3];
//		int licznik = 0;
//		for(int i=0; i<tabela1.length; i++){
//			for(int j=0; j<tabela1[i].length; j++){
//				if(i==0 && j!=3){
//					tabela1[i][j]=j;}
//				else if(i!=0 && j!=3){
//					tabela1[i][j] = j+3;}
//				tabela1[i][j]=licznik++;
//			}
//		}
//		for(int i=0; i< tabela1.length; i++){
//		    for(int j=0; j< tabela1[i].length; j++)
//		        System.out.print(tabela1[i][j]);
//		    System.out.println();
//		    	//System.out.("tab[%d][%d]=%d \n", i, j, tabela1[i][j]);}
//		
//	}
		
//		Do pliku daneBinarne.txt zapisz swoje imię, aktualny rok i 
//		wynik dzielenia 50/4. Następnie z tego samego pliku odczytaj 
//		ile znajduje się w nim bajtów. 
		
		DataOutputStream strumień = null;
		int ilośćSczytanychBajtów = 0;
		
        try {
            strumień = new DataOutputStream(new FileOutputStream("daneBinarne.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
 
        try {
           Scanner scanner = new Scanner(System.in);
           System.out.println("podaj swoje imie, aktualny rok i wynik dzielenia 50/4");
           String imie = scanner.nextLine();
           strumień.writeUTF(imie);
           int rok = scanner.nextInt();
           strumień.write(rok);
           double wynik = 50/4;
           strumień.writeDouble(wynik);
           
           DataInputStream strumieńin = new DataInputStream(new FileInputStream("daneBinarne.txt"));
           while(strumieńin.read() != -1)
        	   ilośćSczytanychBajtów++;
        	   strumieńin.close();
        	   System.out.println("Ilość bajtów wynosi: " + ilośćSczytanychBajtów + " Imie: "+ imie +" Wynik: "+ wynik + " Rok: "+ rok);
        } catch (IOException e) {
        	System.out.println("błąd bloku");
        }
 
        try {
            if (strumień != null)
                strumień.close();
        } catch (IOException e) {
            System.out.println("Błąd zamykania strumienia");
        }
        System.out.println("Ilość bajtów wynosi: " + ilośćSczytanychBajtów);
	}}


