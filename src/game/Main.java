package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static HashMap<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        locations.put(0, new Location(0, "You are sitting infront of the computer learning java"));
        locations.put(1, new Location(1, "You are at base location"));
        locations.put(2, new Location(2, "You are in snow"));
        locations.put(3, new Location(3, "You are in a desert"));
        locations.put(4, new Location(4, "You are in a Valley"));
        locations.put(5, new Location(5, "You are at a hill station"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
        locations.get(2).addExit("N", 5);
        locations.get(3).addExit("W", 1);
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("SOUTH", "S");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("QUIT", "Q");

        int loc = 1;
        int flag = 0;
        String test = null;
        while (true) {
            System.out.println(locations.get(loc).getDescription());

            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("The available exits are");
            for (String key : exits.keySet()) {
                System.out.print(key + ",");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            String[] splitArray = direction.split(" ");
            if(splitArray.length==1){
                test=splitArray[0];
            }

            for (int i = 0; i < splitArray.length; i++) {
                if (vocabulary.containsKey(splitArray[i])) {
                    test = Character.toString(splitArray[i].charAt(0));
                    break;
                }
//                if(splitArray[i].equalsIgnoreCase("east")||splitArray[i].equalsIgnoreCase("west")||splitArray[i].equalsIgnoreCase("north")||splitArray[i].equalsIgnoreCase("south")){
//                    flag=1;
//                    test=splitArray[i].charAt(0);
//                    System.out.println(test);
//                    break;
//                }
            }
//            if(direction.equals("S")||direction.equals("N")||direction.equals("E")||direction.equals("W")){
//                flag=1;
//
//            }
            //direction= Character.toString(test);


            if (exits.containsKey(test)) {
                loc = exits.get(test);
            } else {
                System.out.println("You cannot go in that direction");
            }

        }


    }
}