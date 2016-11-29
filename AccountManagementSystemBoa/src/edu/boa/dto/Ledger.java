package edu.boa.dto;

import java.io.Serializable;
import java.util.*;

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
	private Set<AccountSummary> accountSummaries;

	/**
	 * 
	 */
	private Time dateGenerated;

	/**
	 * @param accounts
	 * @param dateGenerated
	 */
	public Ledger(Set<AccountSummary> accountSummaries, Time dateGenerated) {
		super();
		this.accountSummaries = accountSummaries;
		this.dateGenerated = dateGenerated;
	}

	/**
	 * @return the accounts
	 */
	public Set<AccountSummary> getAccountSummaries() {
		return accountSummaries;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccountSummaries(Set<AccountSummary> accountSummaries) {
		this.accountSummaries = accountSummaries;
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
		result = prime * result + ((accountSummaries == null) ? 0 : accountSummaries.hashCode());
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
		if (accountSummaries == null) {
			if (other.accountSummaries != null) {
				return false;
			}
		} else if (!accountSummaries.equals(other.accountSummaries)) {
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
		builder.append("Ledger [accountSummaries=");
		builder.append("\n");
		for (AccountSummary as: accountSummaries) {
			builder.append(as.toString);
			builder.append("\n");
		}
		builder.append(", dateGenerated=");
		builder.append(dateGenerated);
		builder.append("]");
		return builder.toString();
	}
}