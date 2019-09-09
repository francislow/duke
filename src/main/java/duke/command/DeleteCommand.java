package duke.command;

import duke.task.Task;
import duke.TaskList;

public class DeleteCommand extends Command {
    public DeleteCommand(String[] parts) {
        super(parts);
    }

    @Override
    public String execute(TaskList tasks) {
        int itemId = Integer.parseInt(parts[1]);
        Task currentTask = tasks.get(itemId - 1);
        tasks.remove(currentTask);

        String response = "Noted. I've removed this task:" + currentTask + "\n" +
                "Now you have " + tasks.size() + " tasks in the list.";
        return response;
    }
}
