package DI;

public class Driver {
    public static void main(String[] args) {
//    	'new'가 의존관계가 일어나는 부분이다.
    	Tire tire = new KoreaTire();
//    	Tire tire = new AmericaTire();
        Car car = new Car(tire);

        System.out.println(car.getTireBrand());
    }
}