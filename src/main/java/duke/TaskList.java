package duke;

import duke.task.Task;

import java.util.ArrayList;

/**
 * A custom list to manipulate arraylist
 */

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Add a new task to list
     *
     * @param newTask duke.task.Task to be added to list
     */
    public void add(Task newTask) {
        tasks.add(newTask);
    }

    /**
     * Remove a task from list
     *
     * @param newTask duke.task.Task to be removed from list
     */
    public void remove(Task newTask) {
        tasks.remove(newTask);
    }

    /**
     * Returns size of list
     *
     * @return Current size of list
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Get a specific task from list
     *
     * @param i Index of the task to be returned
     * @return Index i of task in list
     */
    public Task get(int i) {
        return tasks.get(i);
    }
}
