package edu.boa;

import java.math.BigDecimal;

import edu.boa.bo.Account;
import edu.boa.constants.AccountType;
import edu.boa.exceptions.AccountNotFoundException;
import edu.boa.exceptions.NotSameCurrencyException;
import edu.boa.exceptions.SaveFailedException;
import edu.boa.exceptions.UnbalancedTransactionException;
import edu.boa.service.AccountManagementService;
import edu.boa.utils.Money;

public class BoaTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SaveFailedException, AccountNotFoundException, UnbalancedTransactionException, NotSameCurrencyException {

		//simulate launching account management service
		AccountManagementService ams 	= AccountManagementService.getInstance();
		//AccountManagementDAO dao 		= AccountManagementDAO.getInstance();

		//demo for use case: create account
		// Id for the account is auto-generated by the ORM like Hibernate when it persists
		// the account object to the database. (This feature is not available with this simulation)
		Account checking 		= ams.createAccount("checking", AccountType.ASSET);
		Account equipment 		= ams.createAccount("equipment", AccountType.ASSET);
		Account inventory 		= ams.createAccount("inventory", AccountType.ASSET);
		Account receivables 	= ams.createAccount("receivables", AccountType.ASSET);
		Account creditCard 		= ams.createAccount("creditcard", AccountType.LIABILITY);
		Account utilities 		= ams.createAccount("utilities", AccountType.EXPENSE);
		Account payroll 		= ams.createAccount("payroll", AccountType.EXPENSE);
		Account deprecation 	= ams.createAccount("deprecation", AccountType.EXPENSE);
		Account laptopSales 	= ams.createAccount("laptop sales", AccountType.REVENUE);
		Account tabletSales 	= ams.createAccount("tablet sales", AccountType.REVENUE);
		Account investments 	= ams.createAccount("investments", AccountType.STOCKHOLDERS_EQUITY);
		Account oldAccount 		= ams.createAccount("oldAccount", AccountType.ASSET);

		//demo for use case: reverse account
		System.out.println(oldAccount.getName() + " is Reversed? " + oldAccount.getIsReversed());
		ams.reverseAccount(oldAccount.getID());
		System.out.println(oldAccount.getName() + " is Reversed? " + oldAccount.getIsReversed());

		//demo for use case: One at a time funds transfer
		ams.transferFund(checking, investments, new Money("USD", new BigDecimal(100000), "Dollars"));

		System.out.println(investments); // debit asset +10000
		System.out.println(checking);	// credit equity +10000 
	}
}
