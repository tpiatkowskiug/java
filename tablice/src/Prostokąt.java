
public class Prostokąt implements ObliczPole {
double a;
double b;

public Prostokąt(double a, double b){
	this.a=a;
	this.b=b;
		
}
public double obliczPole(){
	return a*b;
}

}
