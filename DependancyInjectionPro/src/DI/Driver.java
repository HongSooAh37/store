package DI;

public class Driver {
    public static void main(String[] args) {
//    	'new'�� �������谡 �Ͼ�� �κ��̴�.
    	Tire tire = new KoreaTire();
//    	Tire tire = new AmericaTire();
        Car car = new Car(tire);

        System.out.println(car.getTireBrand());
    }
}