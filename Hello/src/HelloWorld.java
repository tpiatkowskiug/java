
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello World");
		String hello = "Witaj";
		String world = "Świecie";
		String powitanie = hello+world;
		System.out.println(powitanie);
		
		String czesc = powitanie.substring(0, 6)+ " uczniu";
		System.out.println(czesc);
	}
}