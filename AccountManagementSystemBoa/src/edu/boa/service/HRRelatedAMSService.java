/**
 * 
 */
package edu.boa.service;

import java.io.File;

import edu.boa.bo.Account;
import edu.boa.exceptions.SaveFailedException;
import edu.boa.exceptions.UnbalancedTransactionException;
import edu.boa.utils.Money;

/**
 * @author sidmishraw
 *
 */
public interface HRRelatedAMSService {

	public Account createEmployeeAccount(String employeeName) throws SaveFailedException;

	public boolean payEmployee(String employeeAccountId, Money amount) throws UnbalancedTransactionException;

	public boolean payEmployees(File file) throws UnbalancedTransactionException;
}
