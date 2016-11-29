package edu.boa.dto;

import java.io.Serializable;
import java.util.*;

import edu.boa.bo.Transaction;
import edu.boa.utils.time.Time;

/**
 * @author sidmishraw
 */
public class Journal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	/**
	 * @param fromDate
	 * @param toDate
	 * @param entries
	 */
	public Journal(Time fromDate, Time toDate, List<Transaction> entries) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.entries = entries;
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

	/**
	 * @return the entries
	 */
	public List<Transaction> getEntries() {
		return entries;
	}

	/**
	 * @param entries the entries to set
	 */
	public void setEntries(List<Transaction> entries) {
		this.entries = entries;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entries == null) ? 0 : entries.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
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
		if (!(obj instanceof Journal)) {
			return false;
		}
		Journal other = (Journal) obj;
		if (entries == null) {
			if (other.entries != null) {
				return false;
			}
		} else if (!entries.equals(other.entries)) {
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
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Journal [fromDate=");
		builder.append(fromDate);
		builder.append(", toDate=");
		builder.append(toDate);
		builder.append(", entries=");
		builder.append("\n");
		for (Transaction t : entries) {
			builder.append(t.toString());
			builder.append("\n");
		}
		
		builder.append("]");
		return builder.toString();
	}
}