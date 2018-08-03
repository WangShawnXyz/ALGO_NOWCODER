package SwordForOffer;

public class ReverseString {
    public String ReverseSentence(String str) {
        String[] s = str.split(" ");
        if (s.length <= 1) return str;
        int len = s.length;
        String res = s[len-1];
        for (int i = len-2; i > -1; i --){
            res += " " + s[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseString s = new ReverseString();
        System.out.println(s.ReverseSentence("1 2 3 4 5 6 7"));
        System.out.println(s.ReverseSentence("student. a am I"));
        System.out.println(s.ReverseSentence(""));

    }
}
