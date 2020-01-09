package ChapterFour.matrix;

/**
 * 该程序有个缺点吗，该程序的n必须满足是2的指数次，如果是奇数则失败
 */

public class Strassen {
    public static void main(String[] args){
        int[][] A = {{1,2,2,1},{3,4,4,2},{9,10,10,3},{1,2,3,4}};
        int[][] B = {{5,6,6,1},{7,8,8,2},{11,12,12,3},{1,2,3,4}};
        //A1 and B1 belongs to 3*3 matrix, where 3 is a odd number, not the power of 2,so the program fails
        int[][] A1 = {{1,2,2},{3,4,4},{9,10,10}};
        int[][] B1 = {{5,6,6},{7,8,8},{11,12,12}};
        int[][] C = strassen(A,B);
        matrix result = new matrix();
        result.setMatrix(C);
        result.showElements();
    }

    public static int[][] strassen(int[][] A,int[][] B){
        int n = A.length;
        int m = n/2;
        int[][] result = new int[n][n];
        if(n == 1){
            result[0][0] = A[0][0]*B[0][0];
        }
        else {
            //生成A11,A12,A21,A22
            matrix[] array_A = divide(A);
            //生成B11,B12,B21,B22
            matrix[] array_B = divide(B);
            int[][] s1 = substraction(array_B[1].getMatrix(),array_B[3].getMatrix());
            int[][] s2 = addition(array_A[0].getMatrix(),array_A[1].getMatrix());
            int[][] s3 = addition(array_A[2].getMatrix(),array_A[3].getMatrix());
            int[][] s4 = substraction(array_B[2].getMatrix(),array_B[0].getMatrix());
            int[][] s5 = addition(array_A[0].getMatrix(),array_A[3].getMatrix());
            int[][] s6 = addition(array_B[0].getMatrix(),array_B[3].getMatrix());
            int[][] s7 = substraction(array_A[1].getMatrix(),array_A[3].getMatrix());
            int[][] s8 = addition(array_B[2].getMatrix(),array_B[3].getMatrix());
            int[][] s9 = substraction(array_A[0].getMatrix(),array_A[2].getMatrix());
            int[][] s10 = addition(array_B[0].getMatrix(),array_B[1].getMatrix());
            //下面计算7个迭代
            int[][] P1 = strassen(array_A[0].getMatrix(),s1);
            int[][] P2 = strassen(s2,array_B[3].getMatrix());
            int[][] P3 = strassen(s3,array_B[0].getMatrix());
            int[][] P4 = strassen(array_A[3].getMatrix(),s4);
            int[][] P5 = strassen(s5,s6);
            int[][] P6 = strassen(s7,s8);
            int[][] P7 = strassen(s9,s10);
            //下面计算C的四个分支
            int[][] C11 = addition(substraction(addition(P5,P4),P2),P6);
            int[][] C12 = addition(P1,P2);
            int[][] C21 = addition(P3,P4);
            int[][] C22 = substraction(substraction(addition(P5,P1),P3),P7);
            for(int i=0;i<m;i++){
                for(int j = 0;j<m;j++){
                    result[i][j] = C11[i][j];
                }
            }
            for(int i=0;i<m;i++){
                for(int j=m;j<n;j++){
                    result[i][j] = C12[i][j-m];
                }
            }
            for(int i=m;i<n;i++){
                for(int j=0;j<m;j++){
                    result[i][j] = C21[i-m][j];
                }
            }
            for(int i = m;i<n;i++){
                for(int j=m;j<n;j++){
                    result[i][j] = C22[i-m][j-m];
                }
            }
        }
        return result;
    }

    //把给定数组拆分成四份
    public static matrix[] divide(int[][] A){
        int n = A.length;
        int m = (int)Math.floor(n/2);
        int[][] A11 = new int[m][m];
        int[][] A12 = new int[m][m];
        int[][] A21 = new int[m][m];
        int[][] A22 = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                A11[i][j] = A[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=m;j<n;j++){
                A12[i][j-m] = A[i][j];
            }
        }
        for(int i=m;i<n;i++){
            for(int j=0;j<m;j++){
                A21[i-m][j] = A[i][j];
            }
        }

        for(int i=m;i<n;i++){
            for(int j=m;j<n;j++){
                A22[i-m][j-m] = A[i][j];
            }
        }
        matrix[] matrixArray = new matrix[4];
        matrixArray[0] = new matrix();
        matrixArray[0].setMatrix(A11);
        matrixArray[1] = new matrix();
        matrixArray[1].setMatrix(A12);
        matrixArray[2] = new matrix();
        matrixArray[2].setMatrix(A21);
        matrixArray[3] = new matrix();
        matrixArray[3].setMatrix(A22);
        return matrixArray;
    }
    //数组相减
    public static int[][] substraction(int[][] A,int[][] B){
        int n = A.length;
        int[][] C = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }
    //数组相加
    public static int[][] addition(int[][] A,int[][] B){
        int n = A.length;
        int[][] C = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }
}
