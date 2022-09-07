import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        list.add("Milk");           //list.add("Sex");
        list.add("Bread");          //list.add("Drags");
        list.add("Cheese");         //list.add("Rock'n'Roll");


        while (true) {
            System.out.println(
                    "Choice operation:\n" +
                            "1. Add\n" +
                            "2. Show\n" +
                            "3. Remove\n" +
                            "4. Find\n" +
                            "5. end"
            );
            String input = scanner.nextLine();
            if ("end".equals(input) || "5".equals(input)) {
                System.out.println("Program's end");
                break;
            }

            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    System.out.println("That do you want buy?");
                    String inputBuy = scanner.nextLine();
                    list.add(inputBuy);
                    int size = list.size();
                    System.out.println("Total in shopping list: " + size);
                    separator();
                    break;
                case 2:
                    System.out.println("Shopping list: ");
                    shopList(list);
                    separator();
                    break;
                case 3:
                    System.out.println("Shopping list: ");
                    shopList(list);
                    System.out.println("That do you want remove? Input number or name...");
                    String rm = scanner.nextLine();
                    deleteListItem(rm, list);
                    shopList(list);
                    separator();
                    break;
                case 4:
                    System.out.println("Enter text to search: ");
                    String item = scanner.nextLine();
                    System.out.println("Finded... ");
                    searchListItem(item, list);
                    separator();
                    break;
                case 5:
                    System.out.println("Program's end, bye!");
                    break;
                default:
                    System.out.println("Incorrect input");
                    separator();
            }
        }
    }

    static void shopList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1)
                    + ". " + list.get(i));
        }
    }

    static void separator() { System.out.println("********************"); }

    static boolean tryParseInt(String rm) {
        try {
            Integer.parseInt(rm);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static void deleteListItem(String rm, List<String> list) {
        if (tryParseInt(rm)) {
            int num = Integer.parseInt(rm) - 1;
            String removedStrNum = list.remove(num);
            removedStr(removedStrNum);
        } else if (!tryParseInt(rm)) {
            String removedStrName = list.remove(list.indexOf(rm));
            removedStr(removedStrName);
        }
    }

    static void removedStr(String removedStr) {
        System.out.println("Purchase " + removedStr + " deleted. Shopping list is... ");
    }

    static void searchListItem(String item, List<String> list) {
        String queryLower = item.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            String itemLower = list.get(i).toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((i + 1) + ". " + list.get(i));
            } else {
                System.out.println("No objects found!");
            }
        }
    }
}

