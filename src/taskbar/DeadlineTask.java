package taskbar;

import java.time.LocalDateTime;

public class DeadlineTask extends Task {
	private LocalDateTime deadline;
	
	public DeadlineTask(String discription, String[] labels, int importance, LocalDateTime deadline) {
		super(discription, labels, importance);
		this.deadline = deadline; 
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}
}
