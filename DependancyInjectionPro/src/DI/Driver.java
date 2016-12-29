package DI;

public class Driver {
    public static void main(String[] args) {
//    	6의 줄에서 'new'가 의존관계가 일어나는 부분이다.
        Car car = new Car();

        System.out.println(car.getTireBrand());
    }
}