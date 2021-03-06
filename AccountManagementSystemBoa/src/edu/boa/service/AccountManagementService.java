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
import edu.boa.exceptions.NotSameCurrencyException;
import edu.boa.exceptions.AccountNotFoundException;
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
	 * @return Account
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
	 * @return boolean
	 * @throws AccountNotFoundException 
	 */
	public boolean reverseAccount(String accountID) throws AccountNotFoundException {
		// TODO implement here
		AccountManagementDAO.getInstance().getAccount(accountID).setIsReversed(true);
		return AccountManagementDAO.getInstance().getAccount(accountID).getIsReversed();
	}

	/**
	 * @param debitAccount 
	 * @param creditAccount 
	 * @param amount 
	 * @return boolean
	 * @throws NotSameCurrencyException 
	 */
   public boolean transferFund(Account debitAccount, Account creditAccount,
         Money amount) throws UnbalancedTransactionException, NotSameCurrencyException
   {
      Transaction t = new Transaction(debitAccount, creditAccount, amount,
            new Time(Calendar.getInstance().getTimeInMillis()));
      AccountManagementDAO d = AccountManagementDAO.getInstance();

      //TODO check 'equity = assets - liabilities' --- pending

      if ( debitAccount.getType().equals(AccountType.ASSET)
            || debitAccount.getType().equals(AccountType.EXPENSE) ) {

         Money currencyBalance = debitAccount.getBalance();

         debitAccount.setBalance(currencyBalance.add(amount));
      } else {

         Money currencyBalance = debitAccount.getBalance();

         debitAccount.setBalance(currencyBalance.subtract(amount));
      }

      if ( creditAccount.getType().equals(AccountType.LIABILITY)
            || creditAccount.getType().equals(AccountType.STOCKHOLDERS_EQUITY)
            || creditAccount.getType().equals(AccountType.REVENUE) ) {

         Money currencyBalance = creditAccount.getBalance();

         creditAccount.setBalance(currencyBalance.add(amount));
      } else {

         Money currencyBalance = creditAccount.getBalance();

         creditAccount.setBalance(currencyBalance.subtract(amount));
      }

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
	 * @return boolean
	 */
	public boolean transferFund(File file) throws UnbalancedTransactionException {
		// TODO implement here
		return false;
	}

	/**
	 * @param fromDate 
	 * @param toDate 
	 * @return Journal
	 */
	public Journal viewJournal(Time fromDate, Time toDate) {
		// TODO implement here
		return null;
	}

	/**
	 * @param account 
	 * @param toDate 
	 * @param fromDate 
	 * @return AccountSummary
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
	 * @return Ledger
	 */
	public Ledger viewLedger() {
		// TODO implement here
		return null;
	}

	/**
	 * @param fromDate 
	 * @param toDate 
	 * @return ProfitLossStatement
	 */
	public ProfitLossStatement generateProfitLossStatement(Time fromDate, Time toDate) {
	   return new  ProfitLossStatement( fromDate,  toDate, new HashMap<Account, Money>(), new HashMap<Account, Money>(),
            new Money("USD", new BigDecimal(0), "Dollars"), new Money("USD", new BigDecimal(0), "Dollars") );
	}

	/**
	 * @param fromDate 
	 * @param toDate 
	 * @return BalanceSheet
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
