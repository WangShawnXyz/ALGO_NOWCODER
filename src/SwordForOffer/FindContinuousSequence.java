package SwordForOffer;

import java.util.ArrayList;
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > List = new ArrayList<>();
        for (int i = 1; i < sum; i ++){
            int tmpSum = 0;
            int j = i;
            ArrayList<Integer> tmpList = new ArrayList<>();
            while (j < sum && tmpSum < sum){
                tmpSum += j;
                tmpList.add(j);
                j ++;
            }
            if (tmpSum == sum){
                List.add(tmpList);
            }
        }
        return List;
    }

    public static void main(String[] args) {
        FindContinuousSequence s = new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> list = s.FindContinuousSequence(10);
        for (ArrayList l : list){
            System.out.println(l);
        }
    }
}