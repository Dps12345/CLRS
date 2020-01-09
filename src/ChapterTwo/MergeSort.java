package ChapterTwo;


public class MergeSort {
    public static void main(String[] args){
        int[] array = {3,41,52,26,38,57,9,49};
        int q = (int)Math.floor(array.length/2);
        MergeSort(array,0,array.length-1);
        for (int item:array) {
            System.out.print(item+" ");
        }
    }

    public static void merge(int A[],int p,int q,int r){
        int n1 = q-p+1;
        int n2 = r-q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for(int i=0;i<n1;i++){
            L[i] = A[p+i];
        }
        for(int i=0;i<n2;i++){
            R[i] = A[q+1+i];
        }
        L[n1] = (int)Double.POSITIVE_INFINITY;
        R[n2] = (int)Double.POSITIVE_INFINITY;
        int i = 0;
        int j = 0;
        for(int k = p;k<=r;k++){
            if(L[i] <= R[j]){
                A[k] = L[i];
                i++;
            }else {
                A[k] = R[j];
                j++;
            }
        }
    }

    public static void MergeSort(int A[],int p,int r){
        if(p<r){
            int q = (int) Math.floor((p+r)/2);
            MergeSort(A,p,q);
            MergeSort(A,q+1,r);
            merge(A,p,q,r);
        }
    }
}
