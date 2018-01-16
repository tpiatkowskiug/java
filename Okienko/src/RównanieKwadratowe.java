
public class RównanieKwadratowe {
private int a;
private int b;
private int c;

public RównanieKwadratowe(int a, int b, int c) {
	super();
	this.a = a;
	this.b = b;
	this.c = c;
}
public int getA() {
return a;
}
public void setA(int a) {
	this.a = a;
}
public int getB() {
	return b;
}
public void setB(int b) {
	this.b = b;
}
public int getC() {
	return c;
}
public void setC(int c) {
	this.c = c;
}
public String rozwiąż(){
	String rozwiązanie = "";
	double delta = ((b*b)-(4*a*c));
	if(delta>0){
		delta = Math.sqrt(delta);
		double x1 = -b - delta/2*a;
		double x2 = -b + delta/2*a;
		rozwiązanie = "dwa pierwiasti rzeczywiste" + x1 + "oraz " +x2;
	}else if (delta == 0){
		double x0 = -b/2*a;
		rozwiązanie = "eden pierwiastek rzeczywisty" + x0;
	}else if (delta < 0){
		rozwiązanie = "brak pierwiastków rzeczywistych";
	}
	
	return rozwiązanie;
}
public String toString(){
	return "Równanie kwadratwoe to: "+a+"x^2+ " + b + "x+ "+c;
}
	public static void main(String[] args) {
		RównanieKwadratowe rw = new RównanieKwadratowe(2,4, 2);
		System.out.println(rw.toString());
		System.out.println(rw.rozwiąż());

	}

}
