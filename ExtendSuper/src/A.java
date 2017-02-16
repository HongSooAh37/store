
public class A {
	int x;	//변수 선언
	int y;
	
	public A(){
		x=1;	//상수 선언
		y=2;
	}
	public A(int x){
		this();	//자신 클래스 A()생성자 호출
		this.x=x;
	}
	public A(int x, int y){
		this(x);	//자신의 클래스 A(int x)생성자 호출
		this.y=y;
	}
}
