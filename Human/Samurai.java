public class Samurai extends Human {
    public static int numberOfSamurai = 0;
    public Samurai(){
        super(3);
        this.health = 200;
        numberOfSamurai++;
    }

    public void deathBlow(Human target){
        target.health = 0;
        this.health *= 0.5;
    }

    public void meditate(){
        this.health += (this.health *(50/100));
    }

    public static int howMany(){
        return numberOfSamurai;
    }
}
