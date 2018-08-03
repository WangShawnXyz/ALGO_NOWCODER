package SwordForOffer;

public class CountOneOfBinaryInteger {
    public int numberOf1(int n){
        int count = 0;
        while (n > 0){
            count ++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountOneOfBinaryInteger s = new CountOneOfBinaryInteger();
        System.out.println(s.numberOf1(255));
    }
}
