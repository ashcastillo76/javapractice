public class Bat extends Mammal{
    int energyLevel = 300;
    public void fly(){
        energyLevel += 50;
        System.out.println("woooooshhh");
}

public void eatHumans(){
    energyLevel += 25;
}

public void attackTown(){
    energyLevel -= 100;
    System.out.println("AHHH! ::crackle crackle pop pop:: aaaaahhh!!");
}
}