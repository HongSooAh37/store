package DI;

import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest {
    @Test
    public void �ڵ���_����_Ÿ�̾�귣��_�׽�Ʈ() {
        Car car = new Car();

        assertEquals("������ Ÿ�̾�: �ڸ��� Ÿ�̾�", car.getTireBrand());
    }
}