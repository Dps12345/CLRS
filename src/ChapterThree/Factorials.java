package ChapterThree;

public class Factorials {
    public static void main(String args[]){
        System.out.println(factorials(0));
        System.out.println(factorials(5));
    }
//    public static int factorials(int n){
//        int result = 1 ;
//        if(n == 0){
//            result = 1;
//        }
//        else{
//            for(int i = n;i>1;i--){
//                result = result*i;
//            }
//        }
//        return result;
//    }

    public static int factorials(int n){
        int result = n ;
        if(n == 0){
            result = 1;
        }
        else if(n>0){
                result*=factorials(n-1);
            }
        else {
            result = 0;
        }
        return result;
    }
}

