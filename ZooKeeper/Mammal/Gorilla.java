public class Gorilla extends Mammal{
        public void throwSomething(){
            energyLevel -= 5;
            System.out.println("The Gorilla has thrown a rock at you!");
        }
        
        public void eatBananas(){
            energyLevel += 10;
            System.out.println("MMmmm BANANA Yummy!");
        }

        public void climb(){
            energyLevel -= 10;
            System.out.println("The Gorilla climbed a tree.");
        }

    }

