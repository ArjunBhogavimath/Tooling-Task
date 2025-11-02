import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ToolingTask {
    public static void main(String[] args) {
        String fileName = "src/input.txt";
        int totalPriority = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                Character common = findCommon(line);
                if (common != null) {
                    int priority = getPriority(common);
                    totalPriority += priority;
                    System.out.println("Common: " + common + " -> Priority: " + priority);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println();
        System.out.println("Total Priority Sum: " + totalPriority);
    }

    //Continuation task (Priority)
    private static int getPriority(Character common) {
        if(Character.isLowerCase(common)){
            return common - 'a' + 1;
        } else {
            return common - 'A' + 27;
        }
    }

    public static Character findCommon(String items) {
        Set<Character> firstCompartment = new HashSet<>();

        //If the item length is odd, then make the 1st compartment 1 size smaller
        int half = items.length() % 2 == 0 ? items.length()/2 : items.length()/2 - 1;

        for (int i = 0; i < half; i++) {
            firstCompartment.add(items.charAt(i));
        }

        for (char c : items.substring(half).toCharArray()) {
            if (firstCompartment.contains(c)) {
                return c;
            }
        }
        return null;
    }
}
