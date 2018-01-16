
public class Punkt {

private int x;
private int y;

void setX(int x){
	this.x=x;
}
void setY(int y){
	this.y=y;
}
void setXY(int x, int y){
	this.x=x;
	this.y=y;}

int getX(){
	return x;
}
int getY(){
	return y;
}
int getXX(){
	return x++;
}
int getYYY(){
	return y++;
}
int get(){
	return x + y;
}
}
