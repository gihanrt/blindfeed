package com.deadlock.blindfeed.login;

public class login {
	String EMail;
	public String getEMail() {
		return EMail;
	}
	public void setEMail(String eMail) {
		EMail = eMail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	String Password;
int User_ID;
public int getUser_ID() {
	return User_ID;
}
public void setUser_ID(int user_ID) {
	User_ID = user_ID;
}
public String getFName() {
	return FName;
}
public void setFName(String fName) {
	FName = fName;
}
String FName;

int TrustedUser_Flag;
public int getTrustedUser_Flag() {
	return TrustedUser_Flag;
}
public void setTrustedUser_Flag(int trustedUser_Flag) {
	TrustedUser_Flag = trustedUser_Flag;
}
}
