import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;
import java.util.Scanner;
public class moje {
	public static void main(String[] args){
        RandomAccessFile strumień = null;
        int ilośćSczytanychBajtów = 0;
 
        try {
            strumień = new RandomAccessFile("daneBinarne.txt", "rw");
        } catch (FileNotFoundException e) {
            System.out.println("Błąd otwierania strumienia");
        }
 
        try {
            strumień.writeUTF("Dawid");
            strumień.writeInt(2014);
            strumień.writeDouble(50 / 4);
            //File file = new File("daneBinarne.txt");
           // Scanner in = new Scanner(file);
           // String zdanie = in.nextLine();
           // System.out.println(zdanie);
 
            strumień = new RandomAccessFile("daneBinarne.txt", "rw");
            while (strumień.read() != -1)
                ilośćSczytanychBajtów++;
        } catch (IOException e) {
            System.out.println("Błąd wejścia-wyjścia");
        }
 
        try {
            strumień.close();
        } catch (IOException e) {
            System.out.println("Błąd zamykania strumeinia");
        }
 
        System.out.println("Ilość bajtów wynosi: " + ilośćSczytanychBajtów);
    }
 
}