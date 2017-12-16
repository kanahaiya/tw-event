package com.twevent.lms;

import java.util.List;
import java.util.Scanner;

import com.twevent.lms.dao.LiberaryDAOImpl;
import com.twevent.lms.manager.LiberaryManager;
import com.twevent.lms.manager.LiberaryManagerImpl;
import com.twevent.lms.model.UserInfo;
import com.twevent.lms.utility.Validator;

public class LiberaryManagementSystem {

	public static void main(String[] args) throws Exception {
		LiberaryManagementSystem executor = new LiberaryManagementSystem();
		LiberaryManager liberaryManager = new LiberaryManagerImpl();

		displayMenu();
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				UserInfo userInfo = executor.takeUserInput();
				liberaryManager.registerUser(userInfo);
				break;
			case 2:
				//liberaryManager.update(userInfo);
				break;
			case 3:
				List<String> subscriptinList=liberaryManager.getSubsriptionPlan();
				System.out.println("Available subsription plans are\n"+subscriptinList);
			case 4:
				System.out.println("Thanks for visiting :)");
				System.exit(0);
			default:
				System.out.println("Please enter the correct choice");
			}
		} while (choice > 4);
	}

	private UserInfo takeUserInput() throws Exception {
		System.out.println("enter the user details by space seperated");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String userDetails[] = line.split(" ");
		String userName = userDetails[0];
		long mobileNumber = Long.parseLong(userDetails[1]);
		String emailId = userDetails[2];
		String userAddress = userDetails[3];
		String subscriptionPlan=userDetails[4];

		UserInfo userInfo = new UserInfo();
		userInfo.setEmailId(emailId);
		userInfo.setMobileNumber(mobileNumber);
		userInfo.setUserAddress(userAddress);
		userInfo.setUserName(userName);
		userInfo.setSubscriptionPlan(subscriptionPlan);

		Validator dataValidator = new Validator();
		if (dataValidator.validate(userInfo)) {
			return userInfo;
		} else {
			System.out.println("user does not lie in our covrage area.");
		}
		return null;
	}

	private static void displayMenu() {
		System.out.println("|How may i assit you?  		 |");
		System.out.println("|--------------------------------|");
		System.out.println("|1.| New Registration  		 |");
		System.out.println("|2.| Existing user    		 |");
		System.out.println("|3.| Get subscription plans	 |");
		System.out.println("|4.| Quit             		 |");
		System.out.println("----------------------------------");
		System.out.println(" Please enter your choice ?");
	}

}
