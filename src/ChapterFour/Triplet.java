package ChapterFour;

public class Triplet{
    private int left;
    private int right;
    private int maxSum;

    public Triplet(){}

    public Triplet(int left,int right,int maxSum){
        this.left = left;
        this.right = right;
        this.maxSum = maxSum;
    }

    public int getMaxSum(){
        return maxSum;
    }

    public String toString(){
        return "("+left+","+right+","+maxSum+")";
    }
}
