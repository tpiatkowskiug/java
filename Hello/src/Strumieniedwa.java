import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Strumieniedwa {

	public static void main(String[] args) {
		RandomAccessFile strumienie = null;
		int iloscbajtow = 0;
		try{
			strumienie = new RandomAccessFile("dane.txt" ,"rw");
		} catch(FileNotFoundException  e){
			System.out.println("Błąd otwierania strumienia");
		}
		try{
			strumienie.writeUTF("Może w końcu coś wyjdzdddd");
			strumienie.writeInt(2014);
			
			strumienie = new RandomAccessFile("dane.txt", "rw");
	            while (strumienie.read() != -1)
	            	 iloscbajtow++;
	        } catch (IOException e) {
	            System.out.println("Błąd wejścia-wyjścia");
	        }
	 
	        try {
	        	strumienie.close();
	        } catch (IOException e) {
	            System.out.println("Błąd zamykania strumeinia");
	        }
	 
	        System.out.println("Ilość bajtów wynosi: " + iloscbajtow);
	    }
	 
		
		

	}


