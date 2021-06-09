public class HumanTest {
    public static void main(String[] args){
        Human h1 = new Human();
        Human h2 = new Human();
        Human h3 = new Human();
        h1.attack(h2);
        h1.attack(h3);
        System.out.println(h1.health);


    }
}
