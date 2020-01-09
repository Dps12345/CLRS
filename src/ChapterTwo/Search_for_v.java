package ChapterTwo;

import java.util.Scanner;

public class Search_for_v {
    public static void main(String[] args){
        int[] arrays =new int[]{12,23,42,32,124,32};
        Scanner read = new Scanner(System.in);
        System.out.println("Please input the number: ");
        int number = read.nextInt();
        boolean choice = false;
        for(int i=0;i<arrays.length;i++){
            if(arrays[i] == number){
                choice = true;
                System.out.println(i);
            }
        }
        if(!choice){
            System.out.println("null");
        }
    }
}
