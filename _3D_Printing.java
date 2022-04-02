import java.util.Scanner;

public class _3D_Printing {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCases = Integer.parseInt(input.nextLine());
        for(int i = 0; i < testCases; i++){
            String printer1 = input.nextLine();
            String printer2 = input.nextLine();
            String printer3 = input.nextLine();
            String[] textInput = printer1.split(" ");
            int c1 = Integer.parseInt(textInput[0]);
            int m1 = Integer.parseInt(textInput[1]);
            int y1 = Integer.parseInt(textInput[2]);
            int k1 = Integer.parseInt(textInput[3]);

            textInput = printer2.split(" ");
            int c2 = Integer.parseInt(textInput[0]);
            int m2 = Integer.parseInt(textInput[1]);
            int y2 = Integer.parseInt(textInput[2]);
            int k2 = Integer.parseInt(textInput[3]);

            textInput = printer3.split(" ");
            int c3 = Integer.parseInt(textInput[0]);
            int m3 = Integer.parseInt(textInput[1]);
            int y3 = Integer.parseInt(textInput[2]);
            int k3 = Integer.parseInt(textInput[3]);

            int minC = Math.min(c1, Math.min(c2,c3));
            int minM = Math.min(m1, Math.min(m2,m3));
            int minY = Math.min(y1, Math.min(y2,y3));
            int minK = Math.min(k1, Math.min(k2,k3));

            System.out.print("Case #"+(i+1)+": ");

            int minSum = (minC + minM + minY + minK);
            if(minSum >= 1000000){
                int remain = minSum - 1000000;
                if(minC >= remain) {
                    minC -= remain;
                    remain = 0;
                }
                else{
                    remain -= minC;
                    minC = 0;
                }
                if(minM >= remain) {
                    minM -= remain;
                    remain = 0;
                }
                else{
                    remain -= minM;
                    minM = 0;
                }
                if(minY >= remain) {
                    minY -= remain;
                    remain = 0;
                }
                else{
                    remain -= minY;
                    minY = 0;
                }
                if(minK >= remain) {
                    minK -= remain;
                    remain = 0;
                }
                else{
                    remain -= minK;
                    minK = 0;
                }

                System.out.printf("%d %d %d %d", minC,minM,  minY, minK);
            }else
                System.out.print("IMPOSSIBLE");
            System.out.println();
        }
    }

}
