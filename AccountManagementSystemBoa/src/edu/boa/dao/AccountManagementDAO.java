package edu.boa.dao;

import java.util.*;

import edu.boa.bo.Account;
import edu.boa.bo.Transaction;
import edu.boa.exceptions.AccountNotFoundException;
import edu.boa.exceptions.SaveFailedException;
import edu.boa.utils.time.Time;

/**
 * @author Boa
 */
public class AccountManagementDAO {

	/**
	 * Default constructor
	 */
	public AccountManagementDAO() {
	}

	/**
	 * @param account 
	 * @return
	 */
	public boolean saveAccount(Account account) throws SaveFailedException {
		// TODO implement here
		return false;
	}

	/**
	 * @param transaction 
	 * @return
	 */
	public boolean saveTransaction(Transaction transaction) throws SaveFailedException {
		// TODO implement here
		return false;
	}

	/**
	 * @param accountName 
	 * @return
	 */
	public Account getAccount(String accountName) throws AccountNotFoundException {
		// TODO implement here
		return null;
	}

	/**
	 * @param fromDate 
	 * @param toDate 
	 * @return
	 */
	public Set<Transaction> getTransactions(Time fromDate, Time toDate) throws Exception {
		// TODO implement here
		return null;
	}

}