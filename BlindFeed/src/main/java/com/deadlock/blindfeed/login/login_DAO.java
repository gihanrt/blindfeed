package com.deadlock.blindfeed.login;

import java.util.List;



public interface login_DAO {
public String checker(String EMail);
public List<login> getpassword(String EMail);
}
