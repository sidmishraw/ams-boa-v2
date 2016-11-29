package edu.boa.dto;

import java.io.Serializable;
import java.util.*;

import edu.boa.bo.Account;
import edu.boa.utils.time.Time;

/**
 * @author sidmishraw
 */
public class Ledger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Ledger() {
	}

	/**
	 * 
	 */
	private Set<Account> accounts;

	/**
	 * 
	 */
	private Time dateGenerated;

	/**
	 * @param accounts
	 * @param dateGenerated
	 */
	public Ledger(Set<Account> accounts, Time dateGenerated) {
		super();
		this.accounts = accounts;
		this.dateGenerated = dateGenerated;
	}

	/**
	 * @return the accounts
	 */
	public Set<Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * @return the dateGenerated
	 */
	public Time getDateGenerated() {
		return dateGenerated;
	}

	/**
	 * @param dateGenerated the dateGenerated to set
	 */
	public void setDateGenerated(Time dateGenerated) {
		this.dateGenerated = dateGenerated;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((dateGenerated == null) ? 0 : dateGenerated.hashCode());
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
		if (!(obj instanceof Ledger)) {
			return false;
		}
		Ledger other = (Ledger) obj;
		if (accounts == null) {
			if (other.accounts != null) {
				return false;
			}
		} else if (!accounts.equals(other.accounts)) {
			return false;
		}
		if (dateGenerated == null) {
			if (other.dateGenerated != null) {
				return false;
			}
		} else if (!dateGenerated.equals(other.dateGenerated)) {
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
		builder.append("Ledger [accounts=");
		builder.append(accounts);
		builder.append(", dateGenerated=");
		builder.append(dateGenerated);
		builder.append("]");
		return builder.toString();
	}
}