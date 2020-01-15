package ChapterSix.Queue;
import ChapterSix.Heap.Heap;

public class Queue {
    private int heap_size;

    public Queue() { }

    public void setHeap_size(int heap_size){
        this.heap_size = heap_size;
    }

    public int heapMaximum(int[] A){
        return A[0];
    }
    public int parent(int i){
        return i/2;
    }

    public int heapExtractMax(int[] A){
        if(heap_size < 1){
            System.out.println("Something is wrong!");
            return 0;
        }else {
            int max = A[0];
            A[0] = A[heap_size - 1];
            heap_size --;
            Heap heap = new Heap();
            heap.maxHeapify(A,1);
            return max;
        }
    }

    public void heapIncreaseKey(int[] A,int i,int key){
        if(key < A[i-1]){
            System.out.println("Key must be larger than A[i-1]!");
        }else{
            A[i-1] = key;
        }
        while(i>1 && A[parent(i) - 1] < A[i-1]) {
            int temp;
            temp = A[i - 1];
            A[i - 1] = A[parent(i) - 1];
            A[parent(i) - 1] = temp;
            i = parent(i);
        }
    }

    public void maxHeapInsert(int[] A,int key){
        heap_size ++;
        A[heap_size - 1] = (int) Double.NEGATIVE_INFINITY;
        heapIncreaseKey(A,heap_size,key);
    }

    public void buildHeap(int[] A){
        heap_size = 1;
        for(int i=2;i<=A.length;i++){
            maxHeapInsert(A,A[i-1]);
        }
    }

    public void show(int[] A){
        System.out.println();
        for(int item: A){
            System.out.print(item+" ");
        }
    }
}
