package duke.command;

import duke.task.Task;
import duke.TaskList;

public class ListCommand extends Command {
    public ListCommand(String[] parts) {
        super(parts);
    }

    @Override
    public String execute(TaskList tasks) {
        if (tasks.size() == 0) {
            return "You have no tasks at hand :)";
        }

        String response = "Here are the tasks in your list:\n";
        for (int i = 0; i < tasks.size(); i++) {
            int currentItemNumber = i + 1;
            Task currentTask = tasks.get(i);

            response += currentItemNumber + "." + currentTask + "\n";
        }
        return response;
    }
}
