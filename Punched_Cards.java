import java.util.Scanner;

public class Punched_Cards {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int testCases = Integer.parseInt(input.nextLine());
        for(int i = 0; i < testCases; i++){
            String text = input.nextLine();
            String[] textInput = text.split(" ");
            int row = Integer.parseInt(textInput[0]);
            int column = Integer.parseInt(textInput[1]);

            row += row + 1;
            column += column + 1;

            System.out.println("Case #"+(i+1)+":");
            for(int r = 1; r <= row; r++){
                for(int c = 1; c <= column; c++){
                    if((r == 1 && c == 1) || (r == 1 && c == 2) || (r == 2 && c == 1) || (r%2 == 0 && c%2 == 0))
                        System.out.print(".");
                    else if(r%2 == 0 && c%2 == 1)
                        System.out.print("|");
                    else if(r%2 == 1 && c%2 == 1)
                        System.out.print("+");
                    else if(r%2 == 1 && c%2 == 0)
                        System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}
