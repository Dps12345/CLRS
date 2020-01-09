package ChapterTwo;

/**
 * while循环语句，小于号时候是降序排列，大于号就是升序排列
 */
public class InsertionSort {
    public static void main(String args[]){
        int[] arrays = {30,18,23,15,10,9};
        System.out.println(arrays.length+" "+arrays[5]);
        for(int j=1;j<arrays.length;j++){
            int key = arrays[j];
            int i = j-1;
            while(i>=0 && arrays[i]>key){ //<就是降序排列，>就是升序排列
                arrays[i+1] = arrays[i];
                i--;
            }
            arrays[i+1] = key;
        }
        for (int item: arrays) {
            System.out.print(item+" ");
        }
    }
}

