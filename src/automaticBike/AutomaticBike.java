package automaticBike;

public class AutomaticBike {
    private boolean bikeIsOn = false;
    private int speed = 0;
    private int gear = 1;

    public int getSpeed (){
        return speed;
    }

    public int getGear(){
        return gear;
    }

    public boolean isBikeOn(){
        return bikeIsOn;
    }

    public void accelerate(){
        if(bikeIsOn){
            speed = speed + gear;
            updateGear();
        }
    }

    public void decelerate(){
        if(bikeIsOn && speed > 0){
            speed = speed - gear;
            if(speed < 0){
                speed = 0;
            }
            updateGear();
        }
    }

    public void turnOn(){
        bikeIsOn = true;
    }

    public void turnOff(){
        bikeIsOn = false;
    }

    private void updateGear(){
        if(speed <= 20){
            gear = 1;
        }else if(speed <= 30){
            gear = 2;
        }else if(speed <= 40){
            gear = 3;
        }else{
            gear = 4;
        }
    }
}
