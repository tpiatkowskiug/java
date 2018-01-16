//Zadanie 1.  Max 10 punktow
//Dany jest nastepujacy kod programu w Javie:
//
///******** Poczatek pliku Test.java ***********/
//abstract class A {
//   abstract void metodaA();
//            void metodaB(){}
//}
//class B extends A {
//   private int z;
//   static void metodaC(){}
//          void metodaA(){}
//   B(int i) {
//      z = i;
//   }
//   B(){
//      z = 0;
//   }
//}
//public class Test {
//   public static void main(String[] args){
//   /*1*/ A a = new A();
//   /*2*/ B b = new B();
//   /*3*/ A c = new B();
//   /*4*/ A d = new B(0);
//   /*5*/ B e = new B(8);
//   /*6*/ B.metodaA();
//   /*7*/ B.metodaB();
//   /*8*/ B f = new B(-1); f.metodaA();
//   /*9*/ B g = new B( 0); g.metodaC();
//  /*10*/ A h = new A();   h.metodaB();
//   }
//}
///****** Koniec pliku Test.java ***************/
//
//Dla kazdej z zaznaczonych lini kodu /*liczba*/ w powyzszym programie okresl
//czy jest poprawna (wpisz TAK), czy nie np. powoduje blad kompilacji (wpisz NIE).
//
// /*1*/  _____
// /*2*/  _____
// /*3*/  _____
// /*4*/  _____
// /*5*/  _____
// /*6*/  _____
// /*7*/  _____
// /*8*/  _____
// /*9*/  _____
///*10*/  _____
//
//
//
//
//
//
//--------------------------------------------------
//Zadanie 2.
//Max 10 punktow
//Napisz jakie komunikaty zostana wyswietlone na ekranie po uruchomieniu
//ponizszego programu.
//
///******** Poczatek pliku Test.java ***********/
//class A {
//   void f(){
//     System.out.print("A ");
//   }
//   void g(){
//     this.f();
//   }
//}
//class B extends A {
//   void f(){
//     System.out.print("B ");
//   }
//   void h(){
//     super.f();
//   }
//}
//class C extends B {
//   void f(){
//     System.out.print("C ");
//     super.h();
//   }
//   void g(){
//     super.g();
//   }
//}
//class Test {
//   public static void main(String[] args){
//   A a = new A();  a.f(); a.g();
//   B b = new B();  b.f(); b.g(); b.h();
//   C c = new C();  c.f(); c.g(); c.h();
//   }
//}
///****** Koniec pliku Test.java ***************/
//
//Odpowiedz:
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//--------------------------------------------------
//Zadanie 3.
//Max 10 punktow
//Napisz jakie komunikaty zostana wyswietlone na ekranie po uruchomieniu
//ponizszego programu.
//
///******** Poczatek pliku Test.java ***********/
//class A {
//    A(int i) {
//    	System.out.println("A: " + i);
//    }
//    A(int i, int j) {
//    	System.out.println("A: " + i * j);
//    }
//    A() {
//	System.out.println("A:");
//    }
//}
//class B extends A {
//    B(int i) {
//    	super(i+2, i);
//        System.out.println("B: " + (i+i));
//    }
//    B(){
//    	super(1, 3);
//	System.out.println("B: " + 5);
//    }
//}
//class C extends B {
//    C(int i) {
//	super(i + 2);
//        System.out.println("C: " + (i + i));
//    }
//}
//class Test {
//    public static void main (String args[]) {
//	C c = new C(2);
//    }
//}
///****** Koniec pliku Test.java ***************/
//
//Odpowiedz:
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//--------------------------------------------------
//Zadanie 4.
//Max 10 punktow
//Napisz jakie komunikaty zostana wyswietlone na ekranie po uruchomieniu
//ponizszego programu.
//
///******** Poczatek pliku Test.java ***********/
//class Liczby{
//    static  int a = 0;
//    private int b = 1;
//    Liczby(int i){
//	a = a * i + 1;
//	b = i;
//    }
//    Liczby(){
//	b = a + 2;
//	a = b / 2;
//    }
//    void wyswietl(){
//	System.out.println("a = " + a + " b = " + b);
//    }
//    static{
//      a = a + 1;
//    }
//}
//
//class Test{
//    public static void main(String[] args){
//    	System.out.println(Liczby.a);
//	Liczby.a++;
//	Liczby licz1 = new Liczby(4);
//	licz1.wyswietl();
//	Liczby licz2 = new Liczby(3);
//	licz2.wyswietl();
//	Liczby licz3 = new Liczby();
//	licz3.wyswietl();
//    }
//}
///****** Koniec pliku Test.java ***************/
//Odpowiedz:
//
//

class X {
String qq = "";
X(String s) {
qq = qq + " X" + s;
}
X(String s, String p) {
qq = qq + " X" + s + p;
}
X() {
qq = qq + " X";
}
}
class Y extends X {
Y(String s) {
super(" Q", s);
qq = qq + " Y" + s;
}
Y(){
super(" A", " B");
qq = qq + " Y";
}
}
class Z extends Y {
Z(String s) {
qq = qq + " Z" + s;
}
Z() {
qq = qq + " Z";
}
Z(String s, String p) {
qq = qq + " Z" + s +p;
}
}
class Test {
public static void main (String args[]) {
Z z = new Z(" Test");
System.out.println(z.qq);
//X z1 = new X("Test");
//System.out.println(z1.qq);
//Y z2 = new Y(" test1 ");
//System.out.println(z2.qq);

}
}

//class A {
//  void met() {
//    System.out.println("Raz");
//  }
//}
//class B extends A {
//  void met() {
//    System.out.println("Dwa");
//  }
//}
//class C {
// static A met(int i) {
//    if (i > 1 )
//      return new B();
//    return new A();
// }
//}
//public class Test {
//  public static void main(String[] args) {
//    C.met(2).met();
//    new B().met();
//    C.met(1).met();
//  }
//}
