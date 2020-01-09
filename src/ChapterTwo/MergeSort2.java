package ChapterTwo;

/**
 * input a set S of n integers and another integer x
 * output: if there exist two elements in S whose sum is exactly x
 *            return true
 *         else
 *            return false
 */

public class MergeSort2 {
    public static void main(String args[]){
        int[] array = new int[]{32,28,19,56,24,10,9,8,6};
        mergeSort(array,0,array.length-1);
        for (int item:
             array) {
            System.out.print(item+" ");
        }
        //寻找两个数的和是否满足条件
        System.out.print("\n");
        System.out.println(searchSum(array,17));
    }

    public static void merge(int A[],int p,int q,int r){
        int n1 = q-p+1;
        int n2 = r-q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0;i<n1;i++){
            L[i] = A[p+i];
        }
        for(int j=0;j<n2;j++){
            R[j] = A[q+1+j];
        }

        int i = 0;
        int j = 0;
        int k = p;
        while(i!= n1 && j!=n2){
            if(L[i]<=R[j]){
                A[k] = L[i];
                i++;
            }else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        if(i == n1){
            for(int m = j;m<n2;m++){
                A[k] = R[m];
                k++;
            }
        }
        if(j == n2){
            for(int m = i;m<n1;m++){
                A[k] = L[m];
                k++;
            }
        }
    }

    public static void mergeSort(int A[],int p,int r){
        if(p<r){
            int q = (int)Math.floor((p+r)/2);
            mergeSort(A,p,q);
            mergeSort(A,q+1,r);
            merge(A,p,q,r);
        }
    }

    //寻找两个数的和
    public static boolean searchSum(int[] A,int x){
        int i = 0;
        int j = A.length - 1;
        mergeSort(A,0,A.length-1);
        while(i<j){
            if ((A[i]+A[j])==x)
                return true;
            else if((A[i]+A[j]) > x){
                j--;
            }else if ((A[i]+A[j] < x)){
                i++;
            }
        }
        return false;
    }
}
