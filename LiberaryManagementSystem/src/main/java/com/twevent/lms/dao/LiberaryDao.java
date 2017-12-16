package com.twevent.lms.dao;

import java.io.IOException;
import java.util.List;

import com.twevent.lms.model.UserInfo;

public interface LiberaryDao {
	void registerUser(UserInfo useInfo) throws IOException;

	int update(UserInfo useInfo);

	int delete(UserInfo useInfo);

	boolean reactivate(UserInfo useInfo);

	boolean deactivate(UserInfo useInfo);
	List<String> getSubsriptionPlan() throws Exception;


}
