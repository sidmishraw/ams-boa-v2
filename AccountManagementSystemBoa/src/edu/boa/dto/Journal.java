package edu.boa.dto;

import java.util.*;

import edu.boa.bo.Transaction;
import edu.boa.utils.time.Time;

/**
 * @author Boa
 */
public class Journal {

	/**
	 * Default constructor
	 */
	public Journal() {
	}

	/**
	 * 
	 */
	private Time fromDate, toDate;

	/**
	 * 
	 */
	private List<Transaction> entries;

}