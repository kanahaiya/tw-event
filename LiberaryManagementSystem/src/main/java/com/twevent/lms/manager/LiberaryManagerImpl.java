package com.twevent.lms.manager;

import java.util.List;

import com.twevent.lms.model.UserInfo;
import com.twevent.lms.service.LiberaryService;
import com.twevent.lms.service.LiberaryServiceImpl;

public class LiberaryManagerImpl implements LiberaryManager{
	LiberaryService liberaryService=new LiberaryServiceImpl();
	@Override
	public void registerUser(UserInfo useInfo) throws Exception {
		liberaryService.registerUser(useInfo);
	}

	@Override
	public boolean update(UserInfo useInfo) {
		return liberaryService.update(useInfo)>0;
	}

	@Override
	public boolean delete(UserInfo useInfo) {
		return liberaryService.delete(useInfo)>0;
	}

	@Override
	public boolean reactivate(UserInfo useInfo) {
		return liberaryService.reactivate(useInfo);
	}

	@Override
	public boolean deactivate(UserInfo useInfo) {
		return liberaryService.deactivate(useInfo);
	}

	@Override
	public List<String> getSubsriptionPlan() throws Exception {
		return liberaryService.getSubsriptionPlan();
	}

}
