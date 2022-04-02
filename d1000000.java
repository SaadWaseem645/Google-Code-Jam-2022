import java.util.*;

public class d1000000 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCases = Integer.parseInt(input.nextLine());
        for(int i = 0; i < testCases; i++){
            int nDice = Integer.parseInt(input.nextLine());
            String diceVal = input.nextLine();
            String[] diceArr = diceVal.split(" ");

            SortedMap<Integer, Integer> vals = new TreeMap<>();
            for(String dice: diceArr)
                if(vals.containsKey(Integer.parseInt(dice)))
                    vals.put(Integer.parseInt(dice), vals.get(Integer.parseInt(dice))+1);
                else
                    vals.put(Integer.parseInt(dice), 1);

            int straightVal = 0;
            for(Integer key: vals.keySet()){
                int num = vals.get(key);
                while(straightVal < key && num != 0){
                    straightVal++;
                    num--;
                }
            }

            System.out.println("Case #"+(i+1)+": "+straightVal);

        }
    }

}
