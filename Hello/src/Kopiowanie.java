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
import java.nio.file.StandardCopyOption;
import java.io.*;
import java.util.zip.*;
import java.sql.*;
public class Kopiowanie {

	public static void main(String[] args) {
		DataInputStream input = null;
		DataOutputStream output = null;
		int zlicznie = 0;
		try{
			input = new DataInputStream(new FileInputStream("Szyfrcezara.txt"));
			output = new DataOutputStream(new FileOutputStream("przekopiowanedane.txt"));
		}catch(FileNotFoundException e){
			System.out.println("nie znaleziono pliku");
		}
		int ilośćSczytanychBajtów = 0;
        int całkowitaIlośćBajtów = 0;
        byte[] bufor = new byte[1024];
        int c;
		try{
			while ((c=input.read()) != -1) {
				output.write(c);
            }
		}catch (IOException e) {
            System.out.println("Bład wejścia-wyjścia");
        }
//		try{
//			while ((ilośćSczytanychBajtów = input.read(bufor)) != -1) {
//                //output.write(bufor, 0, ilośćSczytanychBajtów);
//				output.write(bufor, 0, ilośćSczytanychBajtów);
//                całkowitaIlośćBajtów += ilośćSczytanychBajtów;
//            }
//		}catch (IOException e) {
//            System.out.println("Bład wejścia-wyjścia");
//        }
		try{
			input.close();
			output.close();
		}catch (IOException e) {
            System.out.println("Bład wejścia-wyjścia");
        }

	}

}