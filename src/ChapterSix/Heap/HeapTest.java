package ChapterSix.Heap;

public class HeapTest {
    public static void main(String[] args){
        int[] A = {1,15,2,8,7,9,3,14,10,16};
        int[] B = {3,2,1,4,5};
        Heap heap = new Heap();
        heap.setHeap_size(A.length);
        //对A进行建堆
        heap.buildHeap(A);
        System.out.println();
        for(int item: A){
            System.out.print(item+" ");
        }
        //对A进行排序
        System.out.println();
        heap.heapSort(A);
        for(int item: A){
            System.out.print(item+" ");
        }
        //建立堆，争对B
        heap.setHeap_size(B.length);
        heap.buildHeap(B);
        System.out.println();
        for(int item: B){
            System.out.print(item+" ");
        }
        //排序B
        heap.heapSort(B);
        System.out.println();
        for(int item: B){
            System.out.print(item+" ");
        }
    }
}
