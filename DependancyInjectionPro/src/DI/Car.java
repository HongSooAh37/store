package DI;

public class Car {
    Tire tire;

    public Car(Tire tire) {
    	
    	this.tire = tire;
        //tire = new KoreaTire();
        //tire = new AmericaTire();
    }

    public String getTireBrand() {
        return "������ Ÿ�̾�: " + tire.getBrand();
    }
}