import java.util.*;

public class _Chain_Reaction {

    public static class Link{

        public long ownVal;
        public long minVal;
        public long direction;

        public Link(long funVal, long direction){
            this.ownVal = funVal;
            this.direction = direction;
        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int testCases = Integer.parseInt(input.nextLine());
        for(int i = 0; i < testCases; i++){
            int moduleNum = Integer.parseInt(input.nextLine());
            String modulesText = input.nextLine();
            String directionText = input.nextLine();
            String[] modules = modulesText.split(" ");
            String[] direction = directionText.split(" ");

            List<Link> links = new ArrayList<>();
            Map<Integer, Link> linkMap = new HashMap<>();

            for(int j = 0; j < moduleNum; j++) {
                Link link = new Link(Long.parseLong(modules[j]), Long.parseLong(direction[j]));
                linkMap.put(j+1, link);
                links.add(link);
            }

            links.sort(Comparator.comparingLong(o -> o.direction));

            long sum = 0;
            for(int j = moduleNum-1; j >= 0; j--){
                Link link = links.get(j);
                if(link.ownVal < link.minVal)
                    link.ownVal = link.minVal;
                if(link.direction == 0)
                    sum += link.ownVal;
                else{
                    Link nextLink = linkMap.get((int) link.direction);
                    if(nextLink.minVal == 0)
                        nextLink.minVal = link.ownVal;
                    else {
                        if(nextLink.minVal > link.ownVal){
                            sum += nextLink.minVal;
                            nextLink.minVal = link.ownVal;
                        }else
                            sum += link.ownVal;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+sum);

        }
    }

}
