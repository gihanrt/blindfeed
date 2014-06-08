package com.deadlock.blindfeed.validation;

public class Paragraph {

	String para_text;
	public String getPara_text() {
		return para_text;
	}
	public void setPara_text(String para_text) {
		this.para_text = para_text;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getParagraph_ID() {
		return Paragraph_ID;
	}
	public void setParagraph_ID(int paragraph_ID) {
		Paragraph_ID = paragraph_ID;
	}
	public boolean isAudio_Flag() {
		return Audio_Flag;
	}
	public void setAudio_Flag(boolean audio_Flag) {
		Audio_Flag = audio_Flag;
	}
	public int getAuthenticateUser_ID() {
		return AuthenticateUser_ID;
	}
	public void setAuthenticateUser_ID(int authenticateUser_ID) {
		AuthenticateUser_ID = authenticateUser_ID;
	}
	public boolean isAuthenticat_Flag() {
		return Authenticat_Flag;
	}
	public void setAuthenticat_Flag(boolean authenticat_Flag) {
		Authenticat_Flag = authenticat_Flag;
	}
	public int getUser_authenticat_User_ID() {
		return User_authenticat_User_ID;
	}
	public void setUser_authenticat_User_ID(int user_authenticat_User_ID) {
		User_authenticat_User_ID = user_authenticat_User_ID;
	}
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	
	int Book_Book_ID;
	public int getBook_Book_ID() {
		return Book_Book_ID;
	}
	public void setBook_Book_ID(int book_Book_ID) {
		Book_Book_ID = book_Book_ID;
	}
	String location;
	int Paragraph_ID;
	boolean Audio_Flag;
	int AuthenticateUser_ID;
	boolean Authenticat_Flag ;
	int User_authenticat_User_ID;
	int UserID;
	
	
	

}
