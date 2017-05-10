package com.cd.poc.microservices.services.person;

import com.cd.poc.microservices.exceptions.PersonNotFoundException;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	protected Logger logger = Logger.getLogger(PersonController.class.getName());

	protected PersonRepository personRepository;

	public PersonController() {
		logger.info(" ******* Person Controller is instantiated.....");
		// this.personRepository = accountRepository;

		// logger.info("PersonRepository says system has " +
		// accountRepository.countAccounts() + " persons");
	}

	// @Autowired
	// public PersonController(PersonRepository accountRepository) {
	// //this.personRepository = accountRepository;
	//
	// //logger.info("PersonRepository says system has " +
	// accountRepository.countAccounts() + " persons");
	// }

	@RequestMapping("/persons/{accountNumber}")
	public Person byNumber(@PathVariable("accountNumber") String accountNumber) {

		System.out.println("service executed : accountNumber : " + accountNumber);
		return new Person();
		// logger.info("accounts-service byNumber() invoked: " + accountNumber);
		// Person person = personRepository.findByNumber(accountNumber);
		// logger.info("accounts-service byNumber() found: " + person);
		//
		// if (person == null)
		// throw new PersonNotFoundException(accountNumber);
		// else {
		// return person;
		// }
	}

	@RequestMapping("/persons/owner/{name}")
	public List<Person> byOwner(@PathVariable("name") String partialName) {
		logger.info(
				"accounts-service byOwner() invoked: " + personRepository.getClass().getName() + " for " + partialName);

		List<Person> accounts = personRepository.findByOwnerContainingIgnoreCase(partialName);
		logger.info("accounts-service byOwner() found: " + accounts);

		if (accounts == null || accounts.size() == 0)
			throw new PersonNotFoundException(partialName);
		else {
			return accounts;
		}
	}

}
