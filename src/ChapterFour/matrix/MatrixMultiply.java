package ChapterFour.matrix;

/**
 * 4.2_1套公式直接算
 */
public class MatrixMultiply {
    public static void main(String[] args){
        int[][] A = {{1,2,2},{3,4,4},{9,10,10}};
        int[][] B = {{5,6,6},{7,8,8},{11,12,12}};
        int[][] A1 = {{1,2,2,1},{3,4,4,2},{9,10,10,3},{1,2,3,4}};
        int[][] B1 = {{5,6,6,1},{7,8,8,2},{11,12,12,3},{1,2,3,4}};
        int[][] C = {{1}};
        matrix result = multiply(A1,B1);
        result.showElements();
    }
    //暴力求解法
    public static matrix multiply(int[][] A,int[][] B){
        matrix matrix1 = new matrix();
        matrix matrix2 = new matrix();
        matrix1.setMatrix(A);
        matrix2.setMatrix(B);

        int[][] result = new int[A.length][A.length];
        for(int i =0;i<A.length;i++){
            for(int j = 0;j<A.length;j++){
                for(int k =0;k<A.length;k++){
                    result[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        matrix matrix3 = new matrix();
        matrix3.setMatrix(result);
        return matrix3;
    }
}
