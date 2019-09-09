package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A storage class to handle loading and saving user data
 */

public class Storage {
    private static final String filePath = "data/duke.txt";

    /**
     * Add initial stored tasks into ArrayList and return it
     *
     * @return Returns an ArrayList containing the stored data
     */
    public static ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(filePath));
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] words = currentLine.split("\\|");
                boolean isDone;
                if (words[1].equals("1")) {
                    isDone = true;
                } else {
                    isDone = false;
                }
                if (words[0].equals("T")) {
                    tasks.add(new Todo(words[2], isDone));
                } else if (words[0].equals("D")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime formatDateTime = LocalDateTime.parse(words[3], formatter);
                    tasks.add(new Deadline(words[2], isDone, words[3], formatDateTime));
                } else if (words[0].equals("E")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime formatDateTime = LocalDateTime.parse(words[3], formatter);
                    tasks.add(new Event(words[2], isDone, words[3], formatDateTime));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file to get data from.");
            assert tasks.size() == 0 : "No files loaded, tasks list should be empty";
        }
        return tasks;
    }

    /**
     * Save stored tasks into text file
     *
     * @param tasks Tasklist reference where user current tasks is to be stored in
     */
    public static void save(TaskList tasks) {
        try {
            PrintWriter out = new PrintWriter(new File(filePath));
            for (int i = 0; i < tasks.size(); i++) {
                Task currentTask = tasks.get(i);
                if (currentTask instanceof Todo) {
                    out.print("T|");
                    if (currentTask.hasDone()) {
                        out.print("1|");
                    } else {
                        out.print("0|");
                    }
                    out.println(currentTask.getName());
                } else if (currentTask instanceof Deadline) {
                    out.print("D|");
                    if (currentTask.hasDone()) {
                        out.print("1|");
                    } else {
                        out.print("0|");
                    }
                    out.print(currentTask.getName());
                    out.print("|");
                    String recordingDateTimeString = ((Deadline) currentTask).getLocalDateTime().toString().replace("T", " ");
                    out.println(recordingDateTimeString);
                } else if (currentTask instanceof Event) {
                    out.print("E|");
                    if (currentTask.hasDone()) {
                        out.print("1|");
                    } else {
                        out.print("0|");
                    }
                    out.print(currentTask.getName());
                    out.print("|");
                    String recordingDateTimeString = ((Event) currentTask).getLocalDateTime().toString().replace("T", " ");
                    out.println(recordingDateTimeString);
                }
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("No such file to save data to.");
        }
    }
}
