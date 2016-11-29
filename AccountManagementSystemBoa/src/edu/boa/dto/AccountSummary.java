package edu.boa.dto;

import java.io.Serializable;
import java.util.*;

import edu.boa.bo.Account;
import edu.boa.bo.Transaction;
import edu.boa.utils.time.Time;

/**
 * @author sidmishraw
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

	/**
	 * @param account
	 * @param transactions
	 * @param fromDate
	 * @param toDate
	 */
	public AccountSummary(Account account, Set<Transaction> transactions, Time fromDate, Time toDate) {
		super();
		this.account = account;
		this.transactions = transactions;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the transactions
	 */
	public Set<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	/**
	 * @return the fromDate
	 */
	public Time getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Time fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Time getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Time toDate) {
		this.toDate = toDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AccountSummary)) {
			return false;
		}
		AccountSummary other = (AccountSummary) obj;
		if (account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!account.equals(other.account)) {
			return false;
		}
		if (fromDate == null) {
			if (other.fromDate != null) {
				return false;
			}
		} else if (!fromDate.equals(other.fromDate)) {
			return false;
		}
		if (toDate == null) {
			if (other.toDate != null) {
				return false;
			}
		} else if (!toDate.equals(other.toDate)) {
			return false;
		}
		if (transactions == null) {
			if (other.transactions != null) {
				return false;
			}
		} else if (!transactions.equals(other.transactions)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountSummary [account=");
		builder.append(account);
		builder.append(", transactions=");
		builder.append(transactions);
		builder.append(", fromDate=");
		builder.append(fromDate);
		builder.append(", toDate=");
		builder.append(toDate);
		builder.append("]");
		return builder.toString();
	}
}