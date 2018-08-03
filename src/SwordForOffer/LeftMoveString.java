package SwordForOffer;

public class LeftMoveString {
    public String LeftRotateString(String str,int n) {
        String right = str.substring(n);
        String left = str.substring(0, n);
        return right + left;
    }

    public static void main(String[] args) {
        LeftMoveString s = new LeftMoveString();
        System.out.println(s.LeftRotateString("wangshawn", 3));
    }
}
