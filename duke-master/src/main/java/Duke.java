import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask initial user input
        String userinput = scanner.nextLine();

        while (!userinput.equals("bye")) {
            System.out.println(userinput);
            userinput = scanner.nextLine();
        }

        // At this point userinput equals "bye"
        System.out.println("Bye. Hope to see you again soon!");
    }
}
