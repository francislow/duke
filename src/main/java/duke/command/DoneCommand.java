package duke.command;

import duke.task.Task;
import duke.TaskList;

public class DoneCommand extends Command {
    public DoneCommand(String[] parts) {
        super(parts);
    }

    @Override
    public String execute(TaskList tasks) {
        int itemId = Integer.parseInt(parts[1]);
        Task currentTask = tasks.get(itemId - 1);
        currentTask.setDone(true);

        String response = "Nice! I've marked this task as done:\n[1] " + currentTask.getName();
        return response;
    }
}
