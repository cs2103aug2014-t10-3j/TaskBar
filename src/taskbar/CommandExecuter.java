package taskbar;

import java.util.ArrayList;

/**
 * This class, when used, must be instantiated and stick to a single instance 
 * for a single GUI session.
 * @author suheti
 *
 */
public class CommandExecuter {
	//Instant field variables.
	private ArrayList<Task> currentList;
	private Display currentDisplay;
	private StorageManager sm;
	
	/*
	 * These variables below are used to deal with information whose lifetime 
	 * transcend through multiple times of method call to runCommand() and select().
	 */
	private Task selectedTask = null;
	private SelectionMode selectionMode = SelectionMode.DEFAULT;
	private boolean isResultLocked = false;
	private boolean isUpdating = false;
	private TaskUpdater updater;
	
	private enum SelectionMode{
		DEFAULT, DELETE, UPDATE, COMPLETE
	}
	
	private enum CommandType{
		ADD, DELETE, UPDATE, COMPLETE
	}
	
	public CommandExecuter(){
		sm = new StorageManager();
	}
	
	/*
	 * This method is called by GUI to pass in text input field content.
	 * One of the 2 public methods utilized by the GUI component.
	 */
	public Display processInput(String userInput){
		//for updating a Task
		if(isUpdating){
			if(updater.needMore()){
				return updater.input(userInput);
			}else{
				isUpdating = false;
			}
		}
		
		Display result; //the Display to be return.
		selectionMode = SelectionMode.DEFAULT; //TODO check this toggle logic. Might be faulty.
		//for all other operations
		//TODO: legality check needs to be added whenever a change is to be made;
		if(isResultLocked){
			//TODO There is a possibility that even the result is locked, the user still typed add command. Amend code to deal with this situation.
			if(isEndingWithEnter(userInput)){
				if(firstWordMatchingACommandType(userInput)){
					if(selectionHasBeenMade()){
						result = executeCommand(getCommandType(userInput), selectedTask);
						//TODO this executeCommand polymorph is for "command"-only type, used exclusively when taskSelected==true
						selectedTask = null;
					}else{
						result = executeCommand(getCommandType(userInput), 
								getCommandParameter(userInput));
						//TODO this executeCommand polymorph is for "command + serial number" type
						//TODO the display returned here should have an empty list and a success message. 
					}
				}else{
					//TODO illegal message here. To be implemented.
				}
			}else{
				result = currentDisplay; //maintain the latest Display.
			}
		}else{
			if(isEndingWithEnter(userInput)){
				if(firstWordMatchingACommandType(userInput)){
					executeCommand(userInput);
					//TODO this executeCommand polymorph is for "command + param" type, used only for general add OR operation on the first item of the current list.
				}else{
					isResultLocked = true;
					result = promptUserForCommandInput();
					//TODO the displayed list should remain the same as the currentList (lock search result). 
				}
			}else{
				if(firstWordMatchingACommandType(userInput)){
					if(getCommand(userInput) == CommandType.ADD){
						result = getEmptyDisplay();
					}else{
						toggleSelectionMode(getCommand(userInput));
						result = instantSearch(getParameter(userInput));
					}
				}else{
					result = instantSearch(userInput);
				}
			}
		}
		
		currentDisplay = result;
		return result;
	}
	
	private boolean selectionHasBeenMade() {
		return selectedTask != null;
	}

	public Display selectTask(int number){
		switch(selectionMode){
		case DEFAULT:
		case DELETE:
		case UPDATE:
		case COMPLETE:
		}
		//default return a empty display
		return getEmptyDisplay();
	}
	
	private boolean isEndingWithEnter(String command){
		return command.charAt(command.length() - 1) == '\n';
	}
	
	private class TaskUpdater{
		//TODO: to be completed
		public tus(){
			
		}
	}
}
