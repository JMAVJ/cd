import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class BasicJava {
    public static int[] swapValues(int[] array) {
        int[] newArray = new int[array.length];
        newArray[array.length-1] = 0;
        for (int i=0; i<array.length; i++) {
            if (i == array.length-1) {
                break;
            }
            newArray[i] = array[i+1];
        }
        return newArray;
    }
    
    public static int[] maxMinAvg(int[] nums){
        return new int[]{findMax(nums), findMin(nums), (int)calculateAverage(nums)};
    }
    
    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    public static ArrayList<Integer> deleteNegatives(ArrayList<Integer> nums) {
        ArrayList<Integer> newNums = new ArrayList<>();
        for (int i=0; i<nums.size(); i++) {
            Integer num = nums.get(i);
            if (num < 0) {
                newNums.add(0);
            } else {
                newNums.add(num);
            }
        }
        return newNums;
    }

    public static ArrayList<Integer> squareValues(ArrayList<Integer> nums) {
        ArrayList<Integer> squaredNumbers = new ArrayList<>();
        for (int i = 0; i<nums.size(); i++) {
            squaredNumbers.add((int)Math.pow(nums.get(i), 2));
        }
        return squaredNumbers;
    }

    public static int greaterThan(int x, int[] nums) {
        int counter = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > x) {
                counter++;
            }
        }
        return counter;
    }

    public static ArrayList<Integer> oddArray() {
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        for (int i=1; i<=255; i++) {
            if (i % 2 != 0) {
                oddNumbers.add(i);
            }
        }
        return oddNumbers;
    }
    
    public static double calculateAverage(int[] nums) {
        int sum = 0;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
        }
        return sum/nums.length;
    }

    public static int findMax(int[] nums) {
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void iterateArray(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void printSum() {
        int sum = 0;
        for (int i = 0; i<=255; i++) {
            sum += i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }
    
    public static void printOdd() {
        for (int i=1; i<=255; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void print1to255() {
        for (int i=1; i<=255; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        //print1to255();
        //printOdd();
        //printSum();
        //iterateArray(new int[]{1, 2, 3, 4, 5});
        //System.out.println(findMax(new int[]{1, -1, 2, 10}));
        //System.out.println(calculateAverage(new int[]{1, 2, 3, 4, 5}));
        //System.out.println(oddArray());
        //System.out.println(greaterThan(3, new int[]{1, 3, 5, 7}));
        //System.out.println(squareValues(new ArrayList<Integer>(Arrays.asList(2, 3, 4))));
        //System.out.println(deleteNegatives(new ArrayList<Integer>(Arrays.asList(2, 3, -4))));
        //System.out.println(Arrays.toString(maxMinAvg(new int[]{1, 5, 10, -2})));
        System.out.println(Arrays.toString(swapValues(new int[]{1, 2, 3})));
    }
}
