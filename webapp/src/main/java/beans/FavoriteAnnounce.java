package beans;

public class FavoriteAnnounce {

	private int id;
	private int UserID;
	private int AnnounceID;

	public FavoriteAnnounce() {
		this.UserID = 0;
		this.AnnounceID = 0;
	}

	public FavoriteAnnounce(int UserID, int AnnounceID) {
		this.UserID = UserID;
		this.AnnounceID = AnnounceID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getAnnounceID() {
		return AnnounceID;
	}

	public void setAnnounceID(int announceID) {
		AnnounceID = announceID;
	}

}
