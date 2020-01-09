package ChapterFour;

public class ComplexNumber {
    public static void main(String[] args){
        String result = realAndImagine(1,2,3,4);
        System.out.println(result);
    }

    public static String realAndImagine(int a,int b,int c,int d){
        int temp1 = a*c;
        int temp2 = b*d;
        int P1 = temp1 - temp2;
        int P2 = (a+b)*(c+d);
        int P3 = temp1 + temp2;
        int imagine= P2 - P3;
        return "The real is: "+P1+" and the imagine is: "+imagine;
    }
}
