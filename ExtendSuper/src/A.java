
public class A {
	int x;	//���� ����
	int y;
	
	public A(){
		x=1;	//��� ����
		y=2;
	}
	public A(int x){
		this();	//�ڽ� Ŭ���� A()������ ȣ��
		this.x=x;
	}
	public A(int x, int y){
		this(x);	//�ڽ��� Ŭ���� A(int x)������ ȣ��
		this.y=y;
	}
}
