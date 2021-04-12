import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    //7
    public static String[] stringArray() {
        String[] stringArray = new String[10];
        for (int i=0; i<10; i++) {
            stringArray[i] = randomString();
        }
        return stringArray;
    }

    //6
    public static String randomString() {
        String randomString = "";
        Random r = new Random();
        for (int i=0; i<5; i++) {
            char randomLetter = (char)(r.nextInt(122-97) + 97);
            randomString += randomLetter;
        }
        return randomString;
    }
    
    //5
    public static ArrayList<Integer> sortRandomNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        Random r = new Random();
        for (int i=0; i<10; i++) {
            randomNumbers.add(r.nextInt(100 - 55) + 55);
        }
        Collections.sort(randomNumbers);
        System.out.println(randomNumbers.get(0));
        System.out.println(randomNumbers.get(9));
        return randomNumbers;
    }

    //4
    public static int[] randomNumbers() {
        int[] randomNumbers = new int[10];
        Random r = new Random();
        for (int i=0; i<10; i++) {
            randomNumbers[i] = r.nextInt(100 - 55) + 55;
        }
        return randomNumbers;
    }

    // 3
    public static void shuffleAlphabet() {
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char i=97; i<=122; i++) {
            alphabet.add(i);
        }
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Collections.shuffle(alphabet);
        System.out.println("First: " + alphabet.get(0));
        System.out.println("Last: " + alphabet.get(alphabet.size()-1));
        if (vowels.contains(alphabet.get(0))) {
            System.out.println("The first letter is a vowel");
        }
    }
    
    // 2
    public static ArrayList<String> secondExercise(String[] names) {
        Collections.shuffle(Arrays.asList(names));
        ArrayList<String> namesLongerThan5 = new ArrayList<>();
        for (int i=0; i<names.length; i++) {
            System.out.println(names[i]);
            if (names[i].length() > 5) {
                namesLongerThan5.add(names[i]);
            }
        }
        return namesLongerThan5;
    }

    // 1
    public static ArrayList<Integer> getGreaterThanTen(int[] arr) {
        ArrayList<Integer> greaterThanTen = new ArrayList<>();
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (arr[i] > 10) {
                greaterThanTen.add(arr[i]);
            }
        }
        System.out.println(sum);
        return greaterThanTen;
    }

    public static void main(String[] args) {
        //System.out.println(getGreaterThanTen(new int[]{3,5,1,2,7,9,8,13,25,32}));
        //System.out.println(secondExercise(new String[]{"asd", "asdasd", "asdasdasd"}));
        //shuffleAlphabet();
        // System.out.println(Arrays.toString(randomNumbers()));
        //System.out.println(sortRandomNumbers());
        //System.out.println(randomString());
        System.out.println(Arrays.toString(stringArray()));
    }
}