
public class B extends A {
	int z;
	
	public B(){
		super();	//	A클래스 public A() 생성자 호출
		z = 30;
	}
	
	public B(int x){
		super(x);	//	A클래스의 public A(int x) 생성자 호출 
		z = 30;
	}
	
	public B(int x, int y){
		super(x,y);	//	A클래스의 public A(int x, int y) 생성자 호출
		z=30;
	}
	
	public B(int x, int y, int z){
		this(x,y);	//	자신의 클래스 B (int x, int y) 생성자 호출
		this.z=z;
	}

}
