class FizzBuzz {
    public static String fizzBuzz(int num) {
        String result = "";
        if (num % 3 == 0) {
            result = result + "Fizz";
        } 
        
        if (num % 5 == 0) {
            result = result + "Buzz";
        }
                
        return result.length() > 0 ? result : String.valueOf(num);
    }
}