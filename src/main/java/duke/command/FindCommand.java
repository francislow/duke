package duke.command;

import duke.task.Task;
import duke.TaskList;

public class FindCommand extends Command {
    public FindCommand(String[] parts) {
        super(parts);
    }

    @Override
    public String execute(TaskList tasks) {
        String response = "Here are the matching tasks in your list:\n";
        String keyPhrase = parts[1];
        boolean hasMatch = false;
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            int currentItemNumber = 0;
            if (currentTask.getName().contains(keyPhrase)) {
                hasMatch = true;
                currentItemNumber += 1;

                response += currentItemNumber + "." + currentTask + "\n";
            }
        }
        if (!hasMatch) {
            response += "Nothing matches :(";
        }
        return response;
    }
}
