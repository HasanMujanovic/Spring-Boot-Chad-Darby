package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao theAccountDAO,
											   MembershipDao theMembershipDao,
											   TrafficFortuneService trafficFortuneService){
		return runner ->{
//			demoTheBeforeAdvice(theAccountDAO, theMembershipDao);
//			demoTheAfterReturnAdvice(theAccountDAO);
//			demoTheAfterThrowingAdvice(theAccountDAO);
//			demoTheAfterAdvice(theAccountDAO);
//			demoTheAroundAdvice(trafficFortuneService);
//			demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain program: demoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Fisished");
	}

	private void demoTheAfterAdvice(AccountDao theAccountDAO) {
		// call method to find accounts
		List<Account> accounts = null;
		try {
			boolean tripWire = false;
			accounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception exc){
			System.out.println("\n\nMain Program ... we caught an exception: " + exc);
		}

		// display the accounts
		System.out.println("\n\nMain Program demoTheAfterThrowingAdvice");
		System.out.println("-----");

		System.out.println(accounts);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDao theAccountDAO) {
		// call method to find accounts
		List<Account> accounts = null;
		try {
			boolean tripWire = true;
			accounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception exc){
			System.out.println("\n\nMain Program ... we caught an exception: " + exc);
		}

		// display the accounts
		System.out.println("\n\nMain Program demoTheAfterThrowingAdvice");
		System.out.println("-----");

		System.out.println(accounts);

		System.out.println("\n");

	}

	private void demoTheAfterReturnAdvice(AccountDao theAccountDAO) {
		// call method to find accounts
		List<Account> accounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program demoTheAfterReturnAdvice");
		System.out.println("-----");

		System.out.println(accounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDao theAccountDAO, MembershipDao theMembershipDao) {
		// call the business method
		theAccountDAO.addAccount(new Account("Hasan","Platinum"),true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter method
		theAccountDAO.setServiceCode("silver");
		theAccountDAO.setName("foobar");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();


		// call the membership business model
		theMembershipDao.addSillyMember();
		theMembershipDao.goToSleep();
	}


}
