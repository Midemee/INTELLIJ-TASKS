public class ArraySort {
    int [] numbers = {2, 4, 3, 8, 2, 1};
    public int [] getNumberSorted(int [] numbers){
        for (int index = 0; index < numbers.length - 1; index +=2 ) {
            int sum = numbers[index] + numbers[index + 1];
                if( sum % 2 == 1){
                    int temp = numbers[index];
                    numbers[index] = numbers[index + 1];
                    numbers[index + 1] = temp;
                }
            }
        return numbers;
    }
}






