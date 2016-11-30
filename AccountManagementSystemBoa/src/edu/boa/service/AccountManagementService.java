package edu.boa.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import edu.boa.bo.Account;
import edu.boa.bo.Transaction;
import edu.boa.constants.AccountType;
import edu.boa.dto.AccountSummary;
import edu.boa.dto.BalanceSheet;
import edu.boa.dto.Journal;
import edu.boa.dto.Ledger;
import edu.boa.dto.ProfitLossStatement;
import edu.boa.exceptions.SaveFailedException;
import edu.boa.exceptions.UnbalancedTransactionException;
import edu.boa.utils.Money;
import edu.boa.utils.time.Time;
import edu.boa.dao.AccountManagementDAO;
/**
 * @author sidmishraw
 */
public class AccountManagementService implements HRRelatedAMSService, FulfillmentRelatedAMSService {

	private static AccountManagementService accountManagementService = null;

	/**
	 * Default constructor
	 */
	private AccountManagementService() {}

	/**
	 * 
	 * @return AccountManagementService
	 */
	public static AccountManagementService getInstance() {

		if ( null == accountManagementService ) {

			return new AccountManagementService();
		}

		return accountManagementService;
	}

	/**
	 * @param accountName 
	 * @param accountType 
	 * @return
	 */
   public Account createAccount(String accountName, AccountType accountType) throws SaveFailedException
   {
      Account a = new Account(accountName,
            new Money("USD", new BigDecimal(0), "Dollars"), accountType, false);
      //check for unique name and save account
      
      AccountManagementDAO.getInstance().saveAccount(a);
      return a;
   }

	/**
	 * @param accountName 
	 * @return
	 */
	public boolean reverseAccount(String accountID) {
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
	 * @throws Exception 
	 */
	public AccountSummary viewTransactionsAndBalanceOfAccount(Account account, Time toDate, Time fromDate) throws Exception {
      AccountManagementDAO d = AccountManagementDAO.getInstance();
      Set<Transaction> allTransactions = d.getTransactions(fromDate, toDate);
      Set<Transaction> accountTransactions = new HashSet<Transaction>();
      for (Transaction t : allTransactions) {
         if (t.getCreditedAccount() == account || t.getDebitedAccount() == account) {
            accountTransactions.add(t);
         }
      }
		return new AccountSummary(account, accountTransactions, fromDate, toDate);
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
	public BalanceSheet generateBalanceSheet(Time asofDate) {
      return new  BalanceSheet(asofDate, new HashMap<Account, Money>(), new HashMap<Account, Money>(),
            new HashMap<Account, Money>(), new Money("USD", new BigDecimal(0), "Dollars"), new Money("USD", new BigDecimal(0), "Dollars") );
	}

	@Override
	public Account createEmployeeAccount(String employeeName) throws SaveFailedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean payEmployee(String employeeAccountId, Money amount) throws UnbalancedTransactionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean payEmployees(File file) throws UnbalancedTransactionException {
		// TODO Auto-generated method stub
		return false;
	}
	

}