package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao theAccountDAO, MembershipDao theMembershipDao){
		return runner ->{
			demoTheBeforeAdvice(theAccountDAO, theMembershipDao);
		};
	}

	private void demoTheBeforeAdvice(AccountDao theAccountDAO, MembershipDao theMembershipDao) {
		// call the business method
		theAccountDAO.addAccount(new Account(),true);
		theAccountDAO.doWork();

		// call the membership business model
		theMembershipDao.addSillyMember();
		theMembershipDao.goToSleep();
	}


}
