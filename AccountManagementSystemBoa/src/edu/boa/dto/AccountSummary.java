package edu.boa.dto;

import java.io.Serializable;
import java.util.*;

import edu.boa.bo.Account;
import edu.boa.bo.Transaction;
import edu.boa.utils.time.Time;

/**
 * @author Boa
 */
public class AccountSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public AccountSummary() {
	}

	/**
	 * 
	 */
	private Account account;

	/**
	 * 
	 */
	private Set<Transaction> transactions;

	/**
	 * 
	 */
	private Time fromDate, toDate;

}