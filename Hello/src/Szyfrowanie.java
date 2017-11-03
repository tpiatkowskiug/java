import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.*;
import java.util.zip.*;
import java.sql.*;

public class Szyfrowanie {
public static void main(String[] args)  throws FileNotFoundException{
		// TODO Auto-generated method stub
		FileInputStream wejscie = null;
		FileOutputStream wyjscie = null;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Podaj zdanie które chcesz szyfrować");
		String napisz = in.nextLine();
		System.out.println(napisz);
		
		String encrypted = Szyfrowanie.encrypt(napisz);
		System.out.println(encrypted);
			
		try{
			PrintWriter zapisz = new PrintWriter("dane.txt");
			zapisz.write(napisz);
			zapisz.close();
		}catch(IOException e){
			System.out.println("błąd zapisu do pliku dane.txt");
		}
		
		String decrypted = Szyfrowanie.decrypt(encrypted);
		System.out.println(decrypted);
		
		try{
			wejscie = new FileInputStream("dane.txt");
			wyjscie = new FileOutputStream("szyfrowanedane.txt");
		}catch(FileNotFoundException e){
			System.out.println("Nie znaleziono pliku");
		}
		try{
            int c;
            while((c=wejscie.read())!= -1)
			wyjscie.write(c);
		}catch(IOException e){
			System.out.println("błąd bloku"); //Stream.copy można też??
		}
		try{
			wejscie.close();
			wyjscie.close();
		}catch(IOException e){
			System.out.println("Błąd zamykania strumeinia");
		}
		
	//	Files.copy(Paths.get("skąd"), Paths.get("dokąd"), StandardCopyOption.REPLACE_EXISTING);
		try{
			ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("dane.zip"));
			DataOutputStream dout = new DataOutputStream(zip);
			
			ZipEntry ze = new ZipEntry("dane.txt");
			zip.putNextEntry(ze);
			
			dout.writeUTF(decrypted);  // zapis
			
			zip.closeEntry(); // zamknij zipowany plik
			dout.close();      // zamknij zipa
			
			// treaz czytamy
			ZipInputStream zin = new ZipInputStream(new FileInputStream("dane.zip"));
			DataInputStream din = new DataInputStream(zin);

			ze = zin.getNextEntry();
			
			String b = din.readUTF();
			System.out.println("zawartość zipa = " +b);
			}catch(IOException e){
				System.out.println("Błąd zamykania strumeinia");
				}
		try{
		 ZipInputStream  zis = new  ZipInputStream(new BufferedInputStream(new FileInputStream("dane.zip")));
		 ZipEntry ze; // element archiwum
		 while((ze = zis.getNextEntry()) != null) {
	            String ename = ze.getName(); // nazwa elementu archiwum
	            System.out.println("nazwa odzipowanego pliku "+ze);
	         }
		 File file = new File("dane.txt");
	     Scanner w = new Scanner(file);
	     String zdanie = w.nextLine();
	     System.out.println("zawartość odzipowana "+zdanie);
		}catch(IOException e){
			System.out.println("Błąd zamykania strumeinia");
			}
				}
		
		
public static String encrypt(String message){
	StringBuilder sb = new StringBuilder(message);
	int distance = 5;
	for(int i=0; i<sb.length(); i++){
		int c = (int)sb.charAt(i);
		if(c+distance>122){
			c=31+(distance - (122-c));
		}else{
			c+= distance;
		}
		sb.setCharAt(i, (char)c);
	}
	return sb.toString();
}
public static String decrypt(String message){
	StringBuilder sb = new StringBuilder(message);
	int distance = 5;
	for(int i=0; i<sb.length(); i++){
		int c = (int)sb.charAt(i);
		if(c-distance<32){
			c=123-(distance - (c-32));
		}else{
			c-= distance;
		}
		sb.setCharAt(i, (char)c);
	}
	return sb.toString();
}
}

