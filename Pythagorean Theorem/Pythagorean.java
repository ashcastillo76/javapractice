public class Pythagorean {
    
    public double calculateHypotenuse(int legA, int legB){
        double legsSquare = (legA * legA) + (legB * legB);
        double squareRoot = Math.sqrt(legsSquare);
        return squareRoot; 
    }
}