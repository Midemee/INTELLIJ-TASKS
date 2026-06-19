package airConditioner;

public class AirConditioner {
    private boolean airConditionerIsOn = false;
    private int temperature = 24;

    public boolean isAirConditionerOn(){
        return airConditionerIsOn;
    }

    public void turnOn(){
        airConditionerIsOn = true;
    }

    public void turnOff(){
        airConditionerIsOn = false;
    }

    public int getTemperature(){
        return temperature;
    }

    public void increaseTemperature(){
        if(temperature < 30){
            temperature = temperature + 1;
        }
    }

    public void reduceTemperature(){
        if(temperature > 16){
            temperature = temperature - 1;
        }
    }

}