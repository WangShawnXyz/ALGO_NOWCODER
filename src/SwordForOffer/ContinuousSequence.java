package SwordForOffer;

public class ContinuousSequence {
    public boolean isContinuous(int [] numbers) {
        int index = 0;
        for(int i = 0; i < numbers.length; i ++){
            for(int j = 1; j < numbers.length; j ++){
                if(numbers[j] < numbers[j-1]){
                    int tmp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j] = tmp;
                }
            }
        }

        for(int i = 0; i < numbers.length; i ++){
            if(numbers[i] == 0){
                index ++;
            }else{
                break;
            }
        }
        if(index >= 4) return true;
        int diffSum = 0;
        for(int i = index; i < numbers.length-1; i ++){
            int diff = numbers[i + 1] - numbers[i];
            if(diff == 0){
                return false;
            }else{
                diffSum += diff - 1;
            }
        }
        System.out.println(numbers.toString());
        for (int i = 0; i < numbers.length; i ++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        System.out.println(index + " " + diffSum);
        if(index >= diffSum){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSequence s = new ContinuousSequence();
        System.out.println(s.isContinuous(new int[]{1, 2, 3, 4, 5}));
        System.out.println(s.isContinuous(new int[]{1,3 , 2, 4, 6}));

    }
}
