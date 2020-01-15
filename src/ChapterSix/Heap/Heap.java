package ChapterSix.Heap;

public class Heap {
    private int heap_size;

    public Heap(){}
    public void setHeap_size(int heap_size){
        this.heap_size = heap_size;
    }

    public int left(int i) {return 2*i;}
    public int right(int i) { return 2*i + 1; }

    public void maxHeapify(int[] A,int i){
        int l = left(i);
        int r = right(i);
        int largest;
        //索引是从1开始的，对应到数组都要减去1
        if(l <= heap_size && A[l-1] > A[i-1]){
            largest = l;
        }else {
            largest = i;
        }
        if( r <= heap_size && A[r-1] > A[largest-1]){
            largest = r;
        }
        if(largest != i){
            int temp;
            temp = A[largest-1];
            A[largest-1] = A[i-1];
            A[i-1] = temp;
            maxHeapify(A,largest);
        }
    }

    public void buildHeap(int[] A){
        heap_size = A.length;
        for( int i = (int)Math.floor(heap_size/2);i >= 1;i--){
            maxHeapify(A,i);
        }
    }

    public void heapSort(int[] A){
        buildHeap(A);
        for(int i = A.length;i>=2;i--){
            int temp;
            temp = A[i-1];
            A[i-1] = A[0];
            A[0] = temp;
            heap_size --;;
            maxHeapify(A,1);
        }
    }
}
