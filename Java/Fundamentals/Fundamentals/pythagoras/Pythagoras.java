import java.lang.Math;

class Pythagoras {
    public static double calculateHypotenuse(int sideA, int sideB) {
        double hypotenuse = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
        return hypotenuse;
    }
}