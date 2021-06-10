
public class HumanTest {
    public static void main(String[] args){
        Human h1 = new Human();
        Human h2 = new Human();
        Human h3 = new Human();
        h1.attack(h2);
        h1.attack(h3);
        Ninja n1 = new Ninja();
        n1.steal(h1);

        Wizard w1 = new Wizard();
        Wizard w2 = new Wizard();

        n1.steal(w1);
        w2.fireball(n1);

        Samurai s1 = new Samurai();
        System.out.println(s1.health);

        s1.deathBlow(n1);
        System.out.println(s1.health);
        s1.meditate();


        System.out.println(w1.health);
        System.out.println(n1.health);
        System.out.println(s1.health);
    }
    }

