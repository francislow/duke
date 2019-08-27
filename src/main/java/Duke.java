import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Greet user
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");

        // Ask initial user input
        String userinput = scanner.nextLine();

        while (!userinput.equals("bye")) {
            // List
            if (userinput.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                // Output current items in list
                for (int i = 0; i < tasks.size(); i++) {
                    int currentItemNumber = i + 1;
                    Task currentTask = tasks.get(i);
                    System.out.println(currentItemNumber + "." + currentTask);
                }
            } else {
                String[] words = userinput.split(" ");

                // Done
                if (words[0].equals("done")) {
                    int itemId = Integer.parseInt(words[1]);
                    Task currentTask = tasks.get(itemId - 1);
                    currentTask.setDone(true);
                    System.out.println("Nice! I've marked this task as done:\n[✓] " + currentTask.getName());
                }
                // Delete
                else if (words[0].equals("delete")) {
                    int itemId = Integer.parseInt(words[1]);
                    Task currentTask = tasks.get(itemId - 1);
                    tasks.remove(currentTask);

                    System.out.println("Noted. I've removed this task:");
                    System.out.println(currentTask);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                }
                // Add
                else {
                    try {
                        // to do
                        if (words[0].equals("todo")) {
                            // Remaining words
                            String remainingWords = userinput.replaceFirst("todo", "").trim();
                            if (remainingWords.equals("")) {
                                throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                            }

                            // Add new task to list
                            Todo newTodo = new Todo(remainingWords, false);
                            tasks.add(newTodo);
                        }
                        // deadline
                        else if (words[0].equals("deadline")) {
                            // Remaining words
                            String remainingWords = userinput.replaceFirst("deadline ", "");
                            String[] remainingWords2 = remainingWords.split(" /by ", 2);

                            LocalDateTime localDateTime = changeToDateTimeFormat(remainingWords2[1]);

                            // Add new task to list
                            Deadline newDeadline = new Deadline(remainingWords2[0], false, remainingWords2[1], localDateTime);
                            tasks.add(newDeadline);
                        }
                        // event
                        else if (words[0].equals("event")) {
                            // Remaining words
                            String remainingWords = userinput.replaceFirst("event ", "");
                            String[] remainingWords2 = remainingWords.split(" /at ", 2);

                            LocalDateTime localDateTime = changeToDateTimeFormat(remainingWords2[1]);

                            // Add new task to list
                            Event newEvent = new Event(remainingWords2[0], false, remainingWords2[1], localDateTime);
                            tasks.add(newEvent);
                        }
                        // default
                        else {
                            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                        }

                        // Print output of ADD
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks.get(tasks.size() - 1));
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            // Ask for next userinput again
            userinput = scanner.nextLine();
        }

        // At this point userinput equals "bye"
        System.out.println("Bye. Hope to see you again soon!");
    }

    /* Change format to LocalDateTime format given String time of 2/12/2019 1800 format */
    public static LocalDateTime changeToDateTimeFormat(String dateTime) {
        String date = dateTime.split(" ")[0];
        String time = dateTime.split(" ")[1];
        LocalDate localDate = LocalDate.of(Integer.parseInt(date.split("/")[2]),
                Integer.parseInt(date.split("/")[1]),
                Integer.parseInt(date.split("/")[0]));

        LocalTime localTime = LocalTime.of(Integer.parseInt(time.substring(0, 2)), Integer.parseInt(time.substring(2, 4)));
        return LocalDateTime.of(localDate, localTime);
    }
}
