package ChapterFour;

/**
 * 4.1-5
 * pseudocode
 * 1,2,3.....n(位置)
 * 7，8，-16，37（真实的数组）
 * maxSum = -oo;
 * sum = 0;
 * left = 0;
 * right = 0;
 * flag = 1;
 * for i =1 to n
 *    sum+=A[i]
 *    if sum > maxSum
 *       maxSum = sum
 *       left = flag;
 *       right = i;
 *    if sum < 0
 *       sum = 0
 *       flag = i+1
 * return(left,right,maxSum)
 */
public class Nonrecursive {
    public static void main(String args[]){
        int[] A = {7,8,-16,15,-1};
        Triplet result = findMaximumSubarray(A);
        System.out.println(result);
    }

    public static Triplet findMaximumSubarray(int[] A){
        int maxSum = (int) Double.NEGATIVE_INFINITY;
        int sum = 0;
        int flag = 0;
        int left = 0;
        int right = 0;
        for(int i = 0;i<A.length;i++){
            sum += A[i];
            if(sum > maxSum){
                maxSum = sum;
                left = flag;
                right = i;
            }
            if(sum < 0){
                sum = 0;
                flag = i + 1;
            }
        }
        return new Triplet(left,right,maxSum);
    }
}
