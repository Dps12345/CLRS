package ChapterSix.Queue;

public class QueueTest {
    public static void main(String[] args){
        int[] B = {1,15,2,8,7,9,3,14,10,16};
        Queue queue = new Queue();
        queue.setHeap_size(B.length);
        //建立堆B
        queue.buildHeap(B);
        queue.show(B);

        //建立堆C
        int[] C = {3,2,1,4,5};
        queue.setHeap_size(C.length);
        queue.buildHeap(C);
        System.out.println();
        for(int item: C){
            System.out.print(item+" ");
        }
    }
}
