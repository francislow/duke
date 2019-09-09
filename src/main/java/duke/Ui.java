package duke;

import duke.task.Task;

/**
 * A class to deal with interactions with the user
 */
public class Ui {

    /**
     * Construct and get the starting message when user launch duke
     *
     * @param tasks A list of current task that is saved by user during previous duke run
     * @return A string representation of starting message
     */
    public String getStartingMessage(TaskList tasks) {
        String message = "Hello! I'm Duke\nWhat can I do for you?\n";
        if (tasks.size() == 0) {
            message += "You do not have any stored tasks\n";
        } else {
            message += "This is your current list of tasks\n";
            for (int i = 0; i < tasks.size(); i++) {
                int currentItemNumber = i + 1;
                Task currentTask = tasks.get(i);
                message += currentItemNumber + "." + currentTask + "\n";
            }
        }
        return message;
    }

    /**
     * Get the error message for a particular duke exception
     *
     * @param e The specified duke exception during runtime
     * @return A string representation of the error
     */
    public String getErrorMessage(DukeException e) {
        return e.getMessage();
    }
}
