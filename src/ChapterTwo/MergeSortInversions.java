package ChapterTwo;

public class MergeSortInversions {
    public static void main(String args[]){
        int[] array = new int[] {4,3,2,1};
        int number = mergeSort(array,0,array.length -1);
        System.out.println("the number of inversions is: "+number);
        for (int item:array) {
            System.out.print(item+" ");
        }
    }

    public static int merge(int[] A,int p,int q,int r){
        int n1 = q-p+1;
        int n2 = r-q;
        int counter = 0;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0;i<L.length;i++){
            L[i] = A[p+i];
        }
        for(int j = 0;j<R.length;j++){
            R[j] = A[q+j+1];
        }

        int i = 0;
        int j = 0;
        int k = p;
        while (i!=n1 && j!=n2){
            if(L[i]<=R[j]){
                A[k] = L[i];
                i++;
            }else{
                A[k] = R[j];
                counter+=(n1-i);
                j++;
            }
            k++;
        }
        if(i == n1){ //左边先耗完了
            for(int m = j;m<n2;m++){
                A[k] = R[m];
                k++;
            }
        }
        if(j == n2){//右边先耗完了
            for(int m = i;m<n1;m++){
                A[k] = L[m];
                k++;
            }
        }
        return counter;
    }

    public static int mergeSort(int[] A,int p,int r){
        int sum = 0;
        if(p<r){
            int q = (int)Math.floor((p+r)/2);
            int left = mergeSort(A,p,q);
            int right = mergeSort(A,q+1,r);
            sum = merge(A,p,q,r)+left+right;
        }
        return sum;
    }
}
