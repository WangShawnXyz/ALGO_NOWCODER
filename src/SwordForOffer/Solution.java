package SwordForOffer;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null) return res;
        if(input.length <= k){
            for(int i = 0; i < input.length; i ++){
                res.add(input[i]);
            }
            return res;
        }
        //
        int[] Q = new int[k+1];
        for(int i = 0; i < input.length; i ++){
            Q[i] = input[i];
        }
        bubbleSort(Q);
        for(int i = k; i < input.length; i ++){
            Q[k] = input[i];
            bubbleSort(Q);
        }
        for(int i = 0; i < k; i ++){
            res.add(Q[i]);
        }
        return res;
    }

    public void bubbleSort(int[] arr){
        for(int j = 0; j < arr.length; j ++){
            for(int i = 1; i < arr.length; i ++){
                if(arr[i] < arr[i-1]){
                    int tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                }
            }
        }
    }
}

