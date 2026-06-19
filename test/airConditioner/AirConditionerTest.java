package airConditioner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest {
    AirConditioner airCondition;
    @BeforeEach
    public void resetData(){
        airCondition = new AirConditioner();
    }

    @Test
    public void testThatWhenITurnOnTheAirConditionerItIsOn(){
        airCondition.turnOn();
        assertTrue(airCondition.isAirConditionerOn());
    }

    @Test
    public void testThatWhenITurnOffTheAirConditionerItIsOff(){
        airCondition.turnOn();
        airCondition.turnOff();
        assertFalse(airCondition.isAirConditionerOn());
    }

    @Test
    public void testThatWhenTheAirConditionerIsOnAndTheTemperatureIncreasesItIsIncreasedByOne(){
        airCondition.turnOn();
        airCondition.increaseTemperature();
        assertEquals(25, airCondition.getTemperature());
    }

    @Test
    public void testThatWhenTheAirConditionerIsOnAndTheTemperatureReducesItIsReducedByOne(){
        airCondition.turnOn();
        airCondition.reduceTemperature();
        assertEquals(23, airCondition.getTemperature());
    }

    @Test
    public void testThatWhenTheAirConditionerIsOnAndTheTemperatureIsIncreasedOver30ItRemains30(){
        airCondition.turnOn();
        for(int index = 1; index <= 7; index++){
            airCondition.increaseTemperature();
        }
        assertEquals(30, airCondition.getTemperature());
    }

    @Test
    public void testThatWhenTheAirConditionerIsOnAndTheTemperatureIsReducedBelow16ItRemains16(){
        airCondition.turnOn();
        for(int index = 1; index <= 9; index++){
            airCondition.reduceTemperature();
        }
        assertEquals(16, airCondition.getTemperature());
    }

}