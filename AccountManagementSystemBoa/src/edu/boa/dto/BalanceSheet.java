package edu.boa.dto;

import java.util.Map;

import edu.boa.bo.Account;
import edu.boa.utils.Money;
import edu.boa.utils.time.Time;

/**
 * @author Boa
 */
public class BalanceSheet {

	/**
	 * Default constructor
	 */
	public BalanceSheet() {
	}

	/**
	 * 
	 */
	private Time fromDate, toDate;

	/**
	 * 
	 */
	private Map<Account,Money> assets, liabilities, equities;

	/**
	 * 
	 */
	private Money assetsLessLiabilities, totalEquity;

}