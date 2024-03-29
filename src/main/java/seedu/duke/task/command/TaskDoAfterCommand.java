package seedu.duke.task.command;

import seedu.duke.CommandParseHelper;
import seedu.duke.Duke;
import seedu.duke.common.command.Command;
import seedu.duke.task.TaskList;

/**
 * Add a task which do after another task.
 */
public class TaskDoAfterCommand extends Command {

    private int index;
    private String doAfterDescription;

    /**
     * Instantiation of do after command.
     *
     * @param index              index of task.
     * @param doAfterDescription of task.
     */
    TaskDoAfterCommand(int index, String doAfterDescription) {
        this.index = index;
        this.doAfterDescription = doAfterDescription;
    }

    /**
     * Set do after task.
     *
     * @return true.
     */
    @Override
    public boolean execute() {
        TaskList taskList = Duke.getModel().getTaskList();
        try {
            String msg = taskList.setDoAfter(index, doAfterDescription);
            if (!silent) {
                responseMsg = msg;
                Duke.getUI().showResponse(responseMsg);
            }
            return true;
        } catch (CommandParseHelper.UserInputException e) {
            Duke.getUI().showError(e.getMessage());
            return false;
        }
    }
}
