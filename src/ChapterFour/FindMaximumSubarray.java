package ChapterFour;

/**
 * 4.1-3
 * 见下面程序
 * 4.1-4
 * 题目说明可以返回空数组，表示所有元素和为0，问怎么修改原有算法
 * if 输入数组存在正数
 *     按照原有算法进行
 * else
 *     直接输出空数组
 */
public class FindMaximumSubarray {
    public static void main(String[] args){
        int[] A = {-10,-4,-3,-4};
        Triplet result = findMaximumSubarray(A,0,A.length-1);
        System.out.println(result);
    }
    //跨越中间点
    public static Triplet findMaxCrossingSubarray(int[] A,int low,int mid,int high){
        int leftSum = (int) Double.NEGATIVE_INFINITY;
        int curSum = 0;
        int left = 0;
        int right = 0;
        for(int i = mid;i>=low;i--){
            curSum += A[i];
            if(curSum > leftSum){
                leftSum = curSum;
                left = i;
            }
        }
        curSum = 0;
        int rightSum = (int) Double.NEGATIVE_INFINITY;
        for(int j = mid+1;j<=high;j++){
            curSum += A[j];
            if(curSum > rightSum){
                rightSum = curSum;
                right = j;
            }
        }
        int sum = leftSum + rightSum;
        return new Triplet(left,right,sum);
    }
    //整体的最小值
    public static Triplet findMaximumSubarray(int[] A,int low,int high){
        if(low == high){
            return new Triplet(low,high,A[low]);
        }
        else {
            int mid = (int) Math.floor((low+high)/2);
            Triplet left = findMaximumSubarray(A,low,mid);
            Triplet right = findMaximumSubarray(A,mid+1,high);
            Triplet middle = findMaxCrossingSubarray(A,low,mid,high);
            if(left.getMaxSum()>= right.getMaxSum() && left.getMaxSum() >= middle.getMaxSum()){
                return left;
            }
            else if(right.getMaxSum()>=left.getMaxSum() && right.getMaxSum()>=middle.getMaxSum()){
                return right;
            }
            else
                return middle;
        }
    }
}
