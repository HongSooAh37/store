
public class B extends A {
	int z;
	
	public B(){
		super();	//	AŬ���� public A() ������ ȣ��
		z = 30;
	}
	
	public B(int x){
		super(x);	//	AŬ������ public A(int x) ������ ȣ�� 
		z = 30;
	}
	
	public B(int x, int y){
		super(x,y);	//	AŬ������ public A(int x, int y) ������ ȣ��
		z=30;
	}
	
	public B(int x, int y, int z){
		this(x,y);	//	�ڽ��� Ŭ���� B (int x, int y) ������ ȣ��
		this.z=z;
	}

}
