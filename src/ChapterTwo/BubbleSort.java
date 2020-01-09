package ChapterTwo;

public class BubbleSort {
    public static void main(String[] args){
        int[] array = {45,34,27,16,19,18,4};
        bubbleSort(array);
        for (int item:array
             ) {
            System.out.print(item+" ");
        }
    }

    public static void bubbleSort(int[] A){
        for(int i = 0;i<A.length-1;i++){
            for(int j = A.length-1;j>=i+1;j--){
                if(A[j]<A[j-1]){
                    int temp;
                    temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
            }
        }
    }
}
