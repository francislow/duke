package duke.command;

import duke.Task;
import duke.TaskList;

public class DeleteCommand extends Command {
    public DeleteCommand(String[] parts) {
        super(parts);
    }

    @Override
    public String execute(TaskList tasks) {
        // Delete
        int itemId = Integer.parseInt(parts[1]);
        Task currentTask = tasks.get(itemId - 1);
        tasks.remove(currentTask);

        String response = "Noted. I've removed this task:" + currentTask + "\n" +
                "Now you have " + tasks.size() + " tasks in the list.";
        return response;
    }
}
