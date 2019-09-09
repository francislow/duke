package duke.command;

import duke.DukeException;
import duke.TaskList;

public abstract class Command {
    protected String[] parts;

    public Command(String[] parts) {
        this.parts = parts;
    }

    /**
     * Execute command given
     *
     * @param task Current updated task list
     * @return A string representation of to be shown to user after command is executed
     * @throws DukeException Detects wrong command and empty todotask name
     */
    public abstract String execute(TaskList task) throws DukeException;
}
