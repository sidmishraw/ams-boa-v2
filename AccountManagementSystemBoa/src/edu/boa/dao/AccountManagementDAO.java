package edu.boa.dao;

import java.util.*;

import edu.boa.bo.Account;
import edu.boa.bo.Transaction;
import edu.boa.exceptions.AccountNotFoundException;
import edu.boa.exceptions.SaveFailedException;
import edu.boa.utils.time.Time;

/**
 * @author sidmishraw
 */
public class AccountManagementDAO {

	private static AccountManagementDAO accountManagementDAO = null;

	/**
	 * Static datastructures to hold the Accounts and transactions
	 * since no DB or IO is being used
	 * Just of the demo
	 */
	private static Map<String, Account> accountStore 		= new HashMap<>();
	private static Set<Transaction> transactionStore 		= new HashSet<>();

	/**
	 * Default constructor
	 */
	private AccountManagementDAO() {}

	/**
	 * Singleton instance of the DAO
	 * 
	 * @return AccountManagementDAO
	 */
	public static AccountManagementDAO getInstance() {

		if ( null == accountManagementDAO ) {
			
			return new AccountManagementDAO();
		}

		return accountManagementDAO;
	}

	/**
	 * @param account 
	 * @return boolean
	 */
	public boolean saveAccount(Account account) throws SaveFailedException {

		accountStore.put(account.getID(), account);

		return true;
	}

	/**
	 * @param transaction 
	 * @return boolean
	 */
	public boolean saveTransaction(Transaction transaction) throws SaveFailedException {

		transactionStore.add(transaction);

		return true;
	}

	/**
	 * @param accountID
	 * @return Account
	 */
	public Account getAccount(String accountID) throws AccountNotFoundException {

		if ( null == accountStore.get(accountID) ) {

			throw new AccountNotFoundException("Account was not found.");
		}

		return accountStore.get(accountID);
	}

	/**
	 * @param fromDate 
	 * @param toDate 
	 * @return Set<Transaction>
	 */
	public Set<Transaction> getTransactions(Time fromDate, Time toDate) throws Exception {

		Set<Transaction> transactions = new HashSet<>();

		for ( Transaction transaction : transactionStore ) {

			if ( transaction.getDate().compareTo(fromDate) >= 0 && transaction.getDate().compareTo(toDate) <= 0 ) {

				transactions.add(transaction);
			}
		}

		return transactions;
	}

	/**
	 * gets all the accounts 
	 * 
	 * @return Set<Account>
	 */
	public Set<Account> getAllAccounts() {

		Set<Account> allAccounts = new HashSet<>();

		for ( Map.Entry<String, Account> entry : accountStore.entrySet() ) {

			allAccounts.add(entry.getValue());
		}

		return allAccounts;
	}

	/**
	 * 
	 * @return Set<Transaction>
	 */
	public Set<Transaction> getAllTransactions() {

		Set<Transaction> allTransactions = new HashSet<>(transactionStore);

		return allTransactions;
	}
}