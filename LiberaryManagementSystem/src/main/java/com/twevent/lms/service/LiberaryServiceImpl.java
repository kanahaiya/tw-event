package com.twevent.lms.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.twevent.lms.dao.LiberaryDAOImpl;
import com.twevent.lms.dao.LiberaryDao;
import com.twevent.lms.model.UserInfo;

public class LiberaryServiceImpl implements LiberaryService{
	LiberaryDao liberaryDaoImpl=new LiberaryDAOImpl();

	@Override
	public void registerUser(UserInfo useInfo)throws IOException{
		liberaryDaoImpl.registerUser(useInfo);
	}

	@Override
	public int update(UserInfo useInfo) {
		return liberaryDaoImpl.update(useInfo);
	}

	@Override
	public int delete(UserInfo useInfo) {
		return liberaryDaoImpl.delete(useInfo);
	}

	@Override
	public boolean reactivate(UserInfo useInfo) {
		return liberaryDaoImpl.reactivate(useInfo);
	}

	@Override
	public boolean deactivate(UserInfo useInfo) {
		return liberaryDaoImpl.deactivate(useInfo);
	}

	@Override
	public List<String> getSubsriptionPlan() throws Exception {
		List<String> subscriptionList= liberaryDaoImpl.getSubsriptionPlan();
		return subscriptionList!=null?subscriptionList:new ArrayList();
	}

}
