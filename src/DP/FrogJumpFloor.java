package DP;

import static java.lang.Thread.sleep;

public class FrogJumpFloor {
    public void jump() throws InterruptedException {
        int n = 35;
        System.out.println(jumpNotebook(n));
//        sleep(3000);
        System.out.println(jumpBruteForce(n));
//        sleep(3000);
        System.out.println(jumpDp(n));
    }
    public int jumpBruteForce(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        return jumpBruteForce(n-1) + jumpBruteForce(n-2);
    }
    public int jumpNotebook(int n){
        int[] notebook = new int[n+1];
        notebook[0] = 0;
        notebook[1] = 1;
        notebook[2] = 2;
        jumpNotebookCore(notebook, n);
        return notebook[n];
    }

    private int jumpNotebookCore(int[] notebook, int n){
        if (notebook[n] != 0) return notebook[n];
        int res = jumpNotebookCore(notebook, n -1) + jumpNotebookCore(notebook, n-2);
        notebook[n] = res;
        return res;
    }

    public int jumpDp(int n){
        int a = 1, b = 1;
        int c = 0;

        for (int i = 1; i <= n; i ++){
//            System.out.println(a + "  " + b);
            c = a + b;
            b = a;
            a = c;

        }
        return b;
    }

    public static void main(String[] args) throws InterruptedException {
        FrogJumpFloor s = new FrogJumpFloor();
        s.jump();
    }
}
