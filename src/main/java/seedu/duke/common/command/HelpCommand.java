package seedu.duke.common.command;

import seedu.duke.Duke;

import java.util.ArrayList;

/**
 * A command to display all help information.
 */
public class HelpCommand extends Command {
    private ArrayList<CommandInfo> commandInfoList = new ArrayList<>();

    /**
     * Initializes help command with pre-determined values.
     */
    public HelpCommand() {
        initCommandInfoList();
    }

    /**
     * Formulates a string containing all the command help message.
     *
     * @return the long text of help message to be displayed to the user
     */
    public String toString() {
        String output = "Note: only A-Z a-z 0-9 \'_\' and \' \' are allowed for user input!\n";
        ArrayList<String> categories = divideCategories();
        String commandStrings = formatCommandStrings(categories);
        output += commandStrings;
        return output;
    }

    private String formatCommandStrings(ArrayList<String> categories) {
        String commandStrings = "";
        for (String category : categories) {
            commandStrings += category + " command: \n";
            for (CommandInfo commandInfo : commandInfoList) {
                if (commandInfo.getCategory() == category) {
                    commandStrings += commandInfo.toString() + "\n\n";
                }
            }
            commandStrings += "\n";
        }
        return commandStrings;
    }

    private ArrayList<String> divideCategories() {
        ArrayList<String> categories = new ArrayList<>();
        for (CommandInfo commandInfo : commandInfoList) {
            boolean found = false;
            for (String category : categories) {
                if (category.equals(commandInfo.getCategory())) {
                    found = true;
                }
            }
            if (!found) {
                categories.add(commandInfo.getCategory());
            }
        }
        return categories;
    }

    @Override
    public boolean execute() {
        responseMsg = this.toString();
        Duke.getUI().showTextPopup(responseMsg);
        return true;
    }

    private void initCommandInfoList() {
        commandInfoList.add(new CommandInfo("Common", "help", "Help command to display all available "
                + "commands. "));
        commandInfoList.add(new CommandInfo("Common", "flip", "Change between task or email commands"));
        commandInfoList.add(new CommandInfo("Common", "bye", "Safely exits the program"));

        commandInfoList.add(new CommandInfo("Task", "list", "List all tasks"));
        commandInfoList.add(new CommandInfo("Task", "done \'index\'", "Mark a task at the given index as "
                + "done. "));
        commandInfoList.add(new CommandInfo("Task", "delete \'index\'", "Delete a task at the given index"));
        commandInfoList.add(new CommandInfo("Task", "find \'keyword\'", "Find the tasks containing the "
                + "given keyword. "));
        commandInfoList.add(new CommandInfo("Task", "reminder [\'daylimit\']", "Show the tasks that are "
                + "near, which is closer than the number of days (daylimit) given. If the daylimit is not "
                + "given, the default of 3 days will be used."));
        commandInfoList.add(new CommandInfo("Task", "doafter \'index\'\n"
                + "\t-msg \'message\'\t\t(Must) The event/time when the task is to be do after", "Mark a "
                + "task with the given index as to be done after the given description"));
        commandInfoList.add(new CommandInfo("Task", "snooze \'index\'\n"
                + "\t-by \'duration\'\t\t(Optional) The duration to snooze the task by", "Snooze "
                + "the task at the given index according to the duration. If no duration is keyed, task "
                + "would be snoozed by 3 days"));
        commandInfoList.add(new CommandInfo("Task", "set \'index\'\n"
                + "\t-priority \'priority\'\t\t(Must) The priority level of the task in string", "Set a "
                + "task to the given priority"));
        commandInfoList.add(new CommandInfo("Task", "todo \'name\'\n"
                + "\t[-tag \'tag content\']\t\t(Optional) Add a tag to the task created. Multiple tags can "
                + "be added to a single todo. "
                + "\n\t[-doafter \'message\']\t\t(Optional) Add the event/time after which the task should "
                + "be done", "Create a todo. "));
        commandInfoList.add(new CommandInfo("Task", "deadline \'name\'\n"
                + "\t-time \'dd/MM/uuuu HHmm\'\t\t (Must) The time of the deadline\n"
                + "or\t-time \'day HHmm\'\t\t (Optional) The time of the deadline\n"
                + "\t[-tag \'tag content\']\t\t(Optional) Add a tag to the task created. Multiple tags "
                + "can be added to a single deadline. "
                + "\n\t[-doafter \'message\']\t\t(Optional) Add the event/time after which the task should "
                + "be done", "Create a deadline."));
        commandInfoList.add(new CommandInfo("Task", "event \'name\'\n"
                + "\t-time \'dd/MM/uuuu HHmm\'\t\t (Must) The time of the event\n"
                + "or\t-time \'day HHmm\'\t\t (Optional) The time of the event\n"
                + "\t[-tag \'tag content\']\t\t(Optional) Add a tag to the task created. Multiple tags "
                + "can be added to a single event. "
                + "\n\t[-doafter \'message\']\t\t(Optional) Add the event/time after which the task should "
                + "be done", "Create a event."));

        commandInfoList.add(new CommandInfo("Email", "list", "List all the emails."));
        commandInfoList.add(new CommandInfo("Email", "show \'index\'", "Show a email content at the given "
                + "index. "));
        commandInfoList.add(new CommandInfo("Email", "fetch", "Fetch emails from the Outlook server"));
        commandInfoList.add(new CommandInfo("Email", "update \'index\'"
                + "\t-tag \'tag name\'\t\t(Must) Name of the tag", "Tag an email with a tag name"));
    }

    /**
     * A class of the syntax and relevant information of each command.
     */
    public class CommandInfo {
        private String category;
        private String format;
        private String description;

        /**
         * Constructor instantiate all attributes of a command type.
         *
         * @param category    command category
         * @param format      format of a command
         * @param description description of the command
         */
        public CommandInfo(String category, String format, String description) {
            this.category = category;
            this.format = format;
            this.description = description;
        }

        public String getCategory() {
            return this.category;
        }

        public String getFormat() {
            return this.format;
        }

        public String getDescription() {
            return this.description;
        }

        /**
         * Converts all the information of the command into a string.
         *
         * @return String with information formatted
         */
        public String toString() {
            String output = "";
            output += "\t$" + description + "\n";
            output += "\t" + format;
            return output;
        }
    }
}
