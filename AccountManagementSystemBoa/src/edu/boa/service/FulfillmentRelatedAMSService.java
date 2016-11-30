/**
 * 
 */
package edu.boa.service;

import java.io.File;

import edu.boa.bo.Account;
import edu.boa.exceptions.NotSameCurrencyException;
import edu.boa.exceptions.UnbalancedTransactionException;
import edu.boa.utils.Money;

/**
 * @author sidmishraw
 *
 */
public interface FulfillmentRelatedAMSService {

	public boolean transferFund(Account debitAccount, Account creditAccount, Money amount) throws UnbalancedTransactionException, NotSameCurrencyException;

	public boolean transferFund(File file) throws UnbalancedTransactionException;
}
