package beans;

public class Photo {

	private int id;
	private String dir;
	private String text;
	private int announceID;

	public Photo() {
		this.dir = "";
		this.text = "";
	}

	public Photo(String dir, String text) {
		this.dir = dir;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getAnnounceID() {
		return announceID;
	}

	public void setAnnounceID(int announceID) {
		this.announceID = announceID;
	}

}
