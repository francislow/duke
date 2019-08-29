/**
 * Represents a basic task to be done by user
 */

public class Todo extends Task {
    public Todo(String name, boolean isDone) {
        super(name, isDone);
    }

    @Override
    public String toString() {
        return "[T][" + getStatusIcon() + "] " + getName();
    }
}
