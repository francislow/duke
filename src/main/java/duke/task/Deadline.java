package duke.task;

import java.time.LocalDateTime;

/**
 * Represents a duke.task.Task with a deadline time attached
 */

public class Deadline extends Task {
    private String time;
    private LocalDateTime localDateTime;

    public Deadline(String name, boolean isDone, String time, LocalDateTime localDateTime) {
        super(name, isDone);
        this.time = time;
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return "[D][" + getStatusIcon() + "] " + getName() + " (by: " + localDateTime.toString()  + ")";    }
}
