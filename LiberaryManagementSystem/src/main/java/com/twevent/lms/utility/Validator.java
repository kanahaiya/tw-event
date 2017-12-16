package com.twevent.lms.utility;

import com.twevent.lms.constants.LiberaryManagerConstants;
import com.twevent.lms.model.UserInfo;

public class Validator {
	

	public boolean validateDistanceRange(String distance) {
		int main = distance.charAt(1)-'0';
		int cross = distance.charAt(3)-'0';
		double radius = Math.sqrt(Math.pow(main, 2) + Math.pow(cross, 2));
		return radius <= LiberaryManagerConstants.RAIDUS_RANGE;

	}

	public boolean validate(UserInfo userInfo) {
		return validateDistanceRange(userInfo.getUserAddress());
	}

}
