package ChapterFour.matrix;

public class matrix {
    private int[][] matrix;

    public void setMatrix(int[][] matrix){this.matrix = matrix;}
    public int[][] getMatrix(){return matrix;}
    public void showElements(){
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }
}
