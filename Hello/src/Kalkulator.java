
public class Kalkulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5;
		int b=3;
		System.out.println("a+b = "+(a+b));
		boolean prawda = a>b;
		boolean falsz = a<b;
		System.out.println(prawda);
		System.out.println(falsz);
		
		    for(int i=1; i<=10; i++){
		         System.out.print("\n");
		         for(int j=1; j<=10; j++){
		            System.out.print("\t"+(i * j));
		         }
		}
	}

}
