package DI;

public class Car {
    Tire tire;

    public Car(Tire tire) {
    	
    	this.tire = tire;
        //tire = new KoreaTire();
        //tire = new AmericaTire();
    }

    public String getTireBrand() {
        return "장착된 타이어: " + tire.getBrand();
    }
}