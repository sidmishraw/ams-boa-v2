package edu.boa.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.boa.bo.Account;
import edu.boa.bo.Transaction;
import edu.boa.constants.AccountType;
import edu.boa.dto.AccountSummary;
import edu.boa.dto.BalanceSheet;
import edu.boa.dto.Journal;
import edu.boa.dto.Ledger;
import edu.boa.dto.ProfitLossStatement;
import edu.boa.exceptions.NotSameCurrencyException;
import edu.boa.exceptions.SaveFailedException;
import edu.boa.exceptions.UnbalancedTransactionException;
import edu.boa.utils.Money;
import edu.boa.utils.time.Time;
import edu.boa.dao.AccountManagementDAO;
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
   public boolean createAccount(String accountName, AccountType accountType)
   {
      Account a = new Account(accountName,
            new Money("USD", new BigDecimal(0), "Dollars"), accountType);
      //check for unique name and save account
      try
      {
         AccountManagementDAO.getInstance().getAccount(accountName);
         AccountManagementDAO.getInstance().saveAccount(a);
      } catch (Exception e)
      {
         return false;
      }
      return true;
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
   public boolean transferFund(Account debitAccount, Account creditAccount,
         Money amount) throws UnbalancedTransactionException
   {
      Transaction t = new Transaction(debitAccount, creditAccount, amount,
            new Time(Calendar.getInstance().getTimeInMillis()));
      AccountManagementDAO d = AccountManagementDAO.getInstance();
      //check 'equity = assets - liabilities'

      
      try
      {
         d.saveTransaction(t);
      } catch (SaveFailedException e)
      {
         return false;
      }
      
      return true;
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
	   return new  ProfitLossStatement( fromDate,  toDate, new HashMap<Account, Money>(), new HashMap<Account, Money>(),
            new Money("USD", new BigDecimal(0), "Dollars"), new Money("USD", new BigDecimal(0), "Dollars") );
	}

	/**
	 * @param fromDate 
	 * @param toDate 
	 * @return
	 */
	public BalanceSheet generateBalanceSheet(Time fromDate, Time toDate) {
      return new  BalanceSheet( fromDate,  toDate, new HashMap<Account, Money>(), new HashMap<Account, Money>(),
            new HashMap<Account, Money>(), new Money("USD", new BigDecimal(0), "Dollars"), new Money("USD", new BigDecimal(0), "Dollars") );
	}
	

}