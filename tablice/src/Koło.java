
public class Koło implements ObliczPole {

	double promień;
	public Koło(double promień){
		this.promień=promień;
	}
	
	public double obliczPole(){
		return 2*Math.PI*promień;
	}
}
