package ChapterFour;
/**
 * 4.1-1
 * 返回绝对值最小的负数
 */
/**
 * 4.1-2
 * 1 2 3 ........n
 * pseudocode
 * left = 1
 * right = 1
 * maxSum = A[1]
 * sum = 0
 * for i=1 to n
 *    sum = 0
 *    for j = i to n
 *       sum+=A[j]
 *       if sum > maxSum
 *          maxSum = sum
 *          left = i
 *          right = j
 * return (left,right,maxSum)
 */

public class BruteSolutionForStockPrice {
    public static void main(String[] args){
        int[] A = {-10,-4,-5,-6};
        Triplet temp = bruteSolution(A);
        System.out.println(temp);
    }

    public static Triplet bruteSolution(int[] A){
        int left = 0 ;
        int right = 0 ;
        int maxSum = A[0];
        int curSum = 0;
        for(int i=0;i<A.length;i++){
            curSum = 0;
            for(int j=i;j<A.length;j++){
                curSum += A[j];
                if(curSum > maxSum){
                    maxSum = curSum;
                    left = i;
                    right = j;
                }
            }
        }
        return new Triplet(left,right,maxSum);
    }
}



