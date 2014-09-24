package taskbar.helpers;

public class Task {
	public Task(String discription, String[] labels, int importance) {
		super();
		Discription = discription;
		this.labels = labels;
		this.importance = importance;
	}
	
	private String Discription;
	private boolean isDone;
	private String[] labels;
	private int importance;
	
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public String[] getLabels() {
		return labels;
	}
	public void setLabels(String[] labels) {
		this.labels = labels;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
}
