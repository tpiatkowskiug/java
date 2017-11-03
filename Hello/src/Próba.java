import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Próba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataInputStream strumienWejsciowy = null;
		DataOutputStream strumienWyjściowy = null;
		try{
			strumienWejsciowy = new DataInputStream(new FileInputStream("dane.txt"));
			strumienWyjściowy = new DataOutputStream(new FileOutputStream("przekopiowanedane.txt"));
		}catch(FileNotFoundException e){
			System.out.println("Nie znaleziono pliku");
		}
		int ilośćSczytanychBajtów = 0;
        int całkowitaIlośćBajtów = 0;
        byte[] bufor = new byte[1024];
		try{
			while ((ilośćSczytanychBajtów = strumienWejsciowy.read(bufor)) != -1) {
                strumienWyjściowy.write(bufor, 0, ilośćSczytanychBajtów);
                całkowitaIlośćBajtów += ilośćSczytanychBajtów;
            }
		}catch(IOException e){
			System.out.println("błąd bloku");
		}
		try{
			strumienWejsciowy.close();
			strumienWyjściowy.close();
		}catch(IOException e){
			System.out.println("Błąd zamykania strumeinia");
		}
		System.out.println(całkowitaIlośćBajtów);
	}

}

/*
String szyfr(String str)
{

    char x[ ] = str.toCharArray( );

    for( int i=0 ; i!=x.length ; i++)
    {
        int n = x[i];
        n+=3;
        x[i]=(char)n; }
    return new String(x); 

} 
 * 
 * */

