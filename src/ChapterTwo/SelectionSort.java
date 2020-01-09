package ChapterTwo;
/**
 * 每次选出余下数组的最小值
 */

public class SelectionSort {
    public static void main(String[] args){
        int[] arrays = new int[]{45,23,19,18,13,10};
        for(int i = 0;i<arrays.length-1;i++){
            int min = i;
            for(int j = i+1;j<arrays.length;j++){
                if(arrays[min] > arrays[j]){
                    min = j;
                }
            }
            int temp;
            temp = arrays[min];
            arrays[min] = arrays[i];
            arrays[i] = temp;
        }
        for(int item:arrays){
            System.out.print(item+" ");
        }
    }
}
