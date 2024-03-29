package seedu.duke.task.command;

import seedu.duke.Duke;
import seedu.duke.common.command.Command;
import seedu.duke.task.TaskList;

/**
 * ListCommand is a specific kind of command used to display all task in a task list.
 */
public class TaskListCommand extends Command {

    /**
     * Instantiation of the list command with the target task list.
     */
    TaskListCommand() {

    }

    /**
     * Executes the list command by calling the UI to display the target task list.
     *
     * @return true after display is completed.
     */
    @Override
    public boolean execute() {
        TaskList taskList = Duke.getModel().getTaskList();
        if (!silent) {
            responseMsg = taskList.toString();
            Duke.getUI().showResponse(responseMsg);
        }
        return true;
    }
}
