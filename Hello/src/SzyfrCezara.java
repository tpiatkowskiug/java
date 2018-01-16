import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SzyfrCezara {
	public static void main(String[] args) {
		char c = '\u235A';
		System.out.printf("wartość z char to %s %n", c);
		for(char i=32; i< 123; i++){
			System.out.print(i);
		}
		String in = SzyfrCezara.input();
		String a = SzyfrCezara.incrypt(in);
		System.out.println(a);
		try{
			PrintWriter zapisz = new PrintWriter("Szyfcezara.txt");
			zapisz.write(a);
			zapisz.close();
		}catch(IOException e){
			System.out.println("błąd zapisu do pliku dane.txt");
		}
		}

	public static String input(){
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLine());
		return sc.nextLine();
	}
	public static String incrypt(String message){
		StringBuilder sb = new StringBuilder(message);
		int d = 5;
		for(int i=0; i<sb.length(); i++){
		int c = sb.charAt(i);
		if(32+d>122){
			c = 32+(122-c+d);
		}else{
			c+=d;
		}
		sb.setCharAt(i, (char)c);
		}
		return sb.toString();	
	}
	}
		
	
		
//		String tekst = SzyfrCezara.wejście();
//		System.out.println(tekst);
//		String szyfr = SzyfrCezara.Szyfrowanie(tekst);
//		System.out.println(szyfr);
//		for(int i=32; i<123; i++){
//		System.out.print((char)i);
//	}	
//		
//	}
//	public static String wejście(){
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
//		sc.close();
//		return input;
//	}
//	public static String Szyfrowanie(String wiadomość){
//		StringBuilder sb = new StringBuilder(wiadomość);
//		int d = 5;
//		for(int i=0; i<sb.length(); i++){
//			int c = sb.charAt(i);
//			if(c+d>122){
//				c=31+(d-(122-c));
//			}else{
//				c+=d;
//			}
//			sb.setCharAt(i, (char)c);
//		}
//		return sb.toString();
//	}
