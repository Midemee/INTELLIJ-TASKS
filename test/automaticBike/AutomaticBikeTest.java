package automaticBike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutomaticBikeTest {
    AutomaticBike bike;

    @BeforeEach
    public void resetDate(){
        bike = new AutomaticBike();
    }

    @Test
    public void testThatIHaveABikeAndItIsOff(){
        assertFalse(bike.isBikeOn());
    }
    @Test
    public void testThatIHaveABikeItisOnWhenITurnInItOn(){
        bike.turnOn();
        assertTrue(bike.isBikeOn());
    }

    @Test
    public void testThatIHaveABikeItisOffWhenITurnInItOff(){
        bike.turnOn();
        bike.turnOff();
        assertFalse(bike.isBikeOn());
    }

    @Test
    public void testThatWhenBikeIsOnGearOneItAcceleratesByOne(){
        bike.turnOn();
        bike.accelerate();


//    for(int index = 1; index <= 15; index++){
//        bike.accelerate();
//    }
//        bike.accelerate();
        assertEquals(1, bike.getSpeed());
        assertEquals(1, bike.getGear());

    }

    @Test
    public void testThatWhenBikeIsOnGearTwoItAcceleratesByTwo(){
        bike.turnOn();
        for(int index = 1; index <= 22; index++){
            bike.accelerate();
        }
        int initialSpeed = bike.getSpeed();
        bike.accelerate();
        assertEquals(initialSpeed + 2, bike.getSpeed());
        assertEquals(2, bike.getGear());
    }

    @Test
    public void testThatWhenBikeIsOnGearThreeItAcceleratesByThree(){
        bike.turnOn();
        for(int index = 1; index <= 26; index++){
            bike.accelerate();
        }
        int initialSpeed = bike.getSpeed();
        bike.accelerate();
        assertEquals(initialSpeed + 3, bike.getSpeed());
        assertEquals(3, bike.getGear());
    }

    @Test
    public void testThatWhenBikeIsOnGearFourItAcceleratesByFour(){
        bike.turnOn();
        for(int index = 1; index <= 41; index++){
            bike.accelerate();
        }
        int initialSpeed = bike.getSpeed();
        bike.accelerate();
        assertEquals(initialSpeed + 4, bike.getSpeed());
        assertEquals(4, bike.getGear());
    }

    @Test
    public void testThatBikeDeceleratesAtGearOneByOne(){
        bike.turnOn();
        for(int index = 1; index <= 15; index++){
            bike.accelerate();
        }
        bike.decelerate();
        assertEquals(14, bike.getSpeed());
        assertEquals(1, bike.getGear());
    }

    @Test
    public void testThatBikeDeceleratesAtGearTwoByTwo(){
        bike.turnOn();
        for(int index = 1; index <= 22; index++){
            bike.accelerate();
        }
        int initialSpeed = bike.getSpeed();
        bike.decelerate();
        assertEquals(initialSpeed - 2, bike.getSpeed());
        assertEquals(2, bike.getGear());
    }

    @Test
    public void testThatBikeDeceleratesAtGearThreeByThree(){
        bike.turnOn();
        for(int index = 1; index <= 27; index++){
            bike.accelerate();
        }
        int initialSpeed = bike.getSpeed();
        bike.decelerate();
        assertEquals(initialSpeed - 3, bike.getSpeed());
        assertEquals(3, bike.getGear());
    }

    @Test
    public void testThatBikeDeceleratesAtGearFourByFour(){
        bike.turnOn();
        for(int index = 1; index <= 32; index++){
            bike.accelerate();
        }
        int initialSpeed = bike.getSpeed();
        bike.decelerate();
        assertEquals(initialSpeed - 4, bike.getSpeed());
        assertEquals(4, bike.getGear());
    }

    @Test
    public void testThatGearChangesFromOneToTwoWhenTheSpeedExceeds20(){
        bike.turnOn();
        for(int index = 1; index <= 21; index++){
            bike.accelerate();
        }
        assertEquals(2, bike.getGear());
    }

    @Test
    public void testThatGearChangesFromTwoToThreeWhenTheSpeedExceeds30(){
        bike.turnOn();
        for(int index = 1; index <= 26; index++){
            bike.accelerate();
        }
        assertEquals(3, bike.getGear());
    }

    @Test
    public void testThatGearChangesFromThreeToFourWhenTheSpeedExceeds40(){
        bike.turnOn();
        for(int index = 1; index <= 30; index++){
            bike.accelerate();
        }
        assertEquals(4, bike.getGear());
    }

    @Test
    public void testThatGearChangesFromTwoToOneWhenTheSpeedIsBelow21(){
        bike.turnOn();
        for(int index = 1; index <= 21; index++){
            bike.accelerate();
        }
        bike.decelerate();
        assertEquals(1, bike.getGear());
    }

    @Test
    public void testThatGearChangesFromThreeToTwoWhenTheSpeedIsBelow31(){
        bike.turnOn();
        for(int index = 1; index <= 26; index++){
            bike.accelerate();
        }
        assertEquals(3, bike.getGear());
        bike.decelerate();
        assertEquals(2, bike.getGear());
    }

    @Test
    public void testThatGearChangesFromFourToThreeWhenTheSpeedIsBelow41(){
        bike.turnOn();
        for(int index = 1; index <= 30; index++){
            bike.accelerate();
        }
        bike.decelerate();
        assertEquals(3, bike.getGear());
    }
}
