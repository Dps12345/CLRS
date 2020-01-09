package ChapterTwo;

/**
 * input two n-element arrays A and B containing the binary digis of two numbers a and b
 * output an (n+1)-element array C containing the binary digits of a+b
 */

public class BinaryIntegers {
    public static void main(String[] args) {
        int[] A = {1, 0, 1, 1};
        int[] B = {1, 1, 1, 1};
        int[] C = new int[A.length + 1];
        int carry = 0;
        for(int i = A.length-1;i>=0;i--){
            C[i+1] = (A[i] + B[i] + carry) % 2;
            carry = (A[i] + B[i] + carry) /2;
        }
        C[0] = carry;
        for (int item : C){
            System.out.print(item+" ");
        }
    }
}
