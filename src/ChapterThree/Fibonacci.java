package ChapterThree;

public class Fibonacci {
    public static void main(String args[]){
        System.out.println(fabonacci(4));
        faonacciNumbers(20);
    }
    //第n个斐波那契数
    public static int fabonacci(int n){
        int result = 0;
        if(n <= 0){
            System.out.println("Wrong input!");
        }
        else if(n == 1){
            result = 0;
        }
        else if(n ==2){
            result = 1;
        }else{
            result = fabonacci(n-1)+fabonacci(n-2);
        }
        return result;
    }
    //show all the elements from 1st to nth
    //前n个斐波那契数全部显示
    public static void faonacciNumbers(int n){
        for(int i = 1;i<=n;i++){
            System.out.print(fabonacci(i)+" ");
        }
    }
}
