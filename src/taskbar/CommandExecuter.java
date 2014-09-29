package taskbar;

import java.util.ArrayList;

/**
 * This class, when used, must be instantiated and stick to a single instance 
 * for a single GUI session.
 * @author suheti
 *
 */
public class CommandExecuter {
	//Instant field variables
	private Task selectedTask;
	private ArrayList<Task> currentList;
	private Display currentDisplay;
	private SelectionMode selectionMode = SelectionMode.DEFAULT;
	
	
	private boolean isResultLocked = false;
	
	public enum SelectionMode{
		DEFAULT, DELETE, UPDATE, COMPLETE
	}
	
	public Display runCommand(String command){
		if(isResultLocked){
			if(isEndWithEnter(command)){
				commanType ct = interpretCommand(command);
				ct(selectedTask); //TODO: command execution end with clearing selectedTask
			}else{
				//do nothing.
			}
		}else{
			if(isEndWithEnter(command)){
				/*TODO: 
				 * 1: default: instant search result list, lockResult
				 * 2: moatched keywork: 2.1 addInterpret
				 * 						2.2 other keyword: action the first of list
				 */
				
			}else{
				/*TODO:
				 * 1: default: IS return result list
				 * 2: mathed keyword: 2.1 no IS, empty display
				 * 					  2.2 other: IS
				 */
			}
		}
		//default return the same Display as the current one.
		return currentDisplay;
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
	
	private boolean isEndWithEnter(String command){
		return command.charAt(command.length() - 1) == '\n';
	}
}
