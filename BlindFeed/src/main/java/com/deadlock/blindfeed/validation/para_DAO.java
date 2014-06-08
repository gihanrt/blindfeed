package com.deadlock.blindfeed.validation;

import java.util.List;
public interface para_DAO {
	public List<Paragraph> getpara();
	public void accept_upadate1(int para_id,int book_id); 
	public void accept_upadate2(int para_id,int book_id); 
	public void reject_upadate(int para_id,int book_id); 
	public void audio_delete(int para_id,int book_id);
	public void mp3_delete(String path);
}
