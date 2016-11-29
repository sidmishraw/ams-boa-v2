package edu.boa.dto;


import java.util.Map;

import edu.boa.bo.Account;
import edu.boa.utils.Money;
import edu.boa.utils.time.Time;

/**
 * @author Boa
 */
public class ProfitLossStatement {

	/**
	 * Default constructor
	 */
	public ProfitLossStatement() {
	}

	/**
	 * 
	 */
	private Time fromDate, toDate;

	/**
	 * 
	 */
	private Map<Account,Money> revenues, expenses;

	/**
	 * 
	 */
	private Money totalRevenue, totalExpense;

}