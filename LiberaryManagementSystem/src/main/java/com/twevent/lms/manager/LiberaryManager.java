package com.twevent.lms.manager;

import java.util.List;

import com.twevent.lms.model.UserInfo;

public interface LiberaryManager {
	void registerUser(UserInfo useInfo) throws Exception;

	boolean update(UserInfo useInfo);

	boolean delete(UserInfo useInfo);

	boolean reactivate(UserInfo useInfo);

	boolean deactivate(UserInfo useInfo);
	List<String> getSubsriptionPlan() throws Exception;

}
