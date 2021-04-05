import java.lang.Math;

class Pythagoras {
    public static double calculateHypotenuse(int sideA, int sideB) {
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }
}