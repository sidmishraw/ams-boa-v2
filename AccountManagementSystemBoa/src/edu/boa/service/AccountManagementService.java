package edu.boa.service;

import java.io.File;

import edu.boa.bo.Account;
import edu.boa.constants.AccountType;
import edu.boa.dto.AccountSummary;
import edu.boa.dto.BalanceSheet;
import edu.boa.dto.Journal;
import edu.boa.dto.Ledger;
import edu.boa.dto.ProfitLossStatement;
import edu.boa.exceptions.UnbalancedTransactionException;
import edu.boa.utils.Money;
import edu.boa.utils.time.Time;

/**
 * @author Boa
 */
public class AccountManagementService {

	/**
	 * Default constructor
	 */
	public AccountManagementService() {
	}

	/**
	 * @param accountName 
	 * @param accountType 
	 * @return
	 */
	public Account createAccount(String accountName, AccountType accountType) {
		// TODO implement here
		return null;
	}

	/**
	 * @param accountName 
	 * @return
	 */
	public boolean reverseAccount(String accountName) {
		// TODO implement here
		return false;
	}

	/**
	 * @param debitAccount 
	 * @param creditAccount 
	 * @param amount 
	 * @return
	 */
	public boolean transferFund(Account debitAccount, Account creditAccount, Money amount) throws UnbalancedTransactionException {
		// TODO implement here
		return false;
	}

	/**
	 * @param file 
	 * @return
	 */
	public boolean transferFund(File file) throws UnbalancedTransactionException {
		// TODO implement here
		return false;
	}

	/**
	 * @param fromDate 
	 * @param toDate 
	 * @return
	 */
	public Journal viewJournal(Time fromDate, Time toDate) {
		// TODO implement here
		return null;
	}

	/**
	 * @param account 
	 * @param toDate 
	 * @param fromDate 
	 * @return
	 */
	public AccountSummary viewTransactionsAndBalanceOfAccount(Account account, Time toDate, Time fromDate) {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public Ledger viewLedger() {
		// TODO implement here
		return null;
	}

	/**
	 * @param fromDate 
	 * @param toDate 
	 * @return
	 */
	public ProfitLossStatement generateProfitLossStatement(Time fromDate, Time toDate) {
		// TODO implement here
		return null;
	}

	/**
	 * @param fromDate 
	 * @param toDate 
	 * @return
	 */
	public BalanceSheet generateBalanceSheet(Time fromDate, Time toDate) {
		// TODO implement here
		return null;
	}
}