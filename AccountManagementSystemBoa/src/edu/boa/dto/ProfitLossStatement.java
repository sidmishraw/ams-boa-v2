package edu.boa.dto;


import java.io.Serializable;
import java.util.Map;

import edu.boa.bo.Account;
import edu.boa.utils.Money;
import edu.boa.utils.time.Time;

/**
 * @author sidmishraw
 */
public class ProfitLossStatement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


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

	
	/**
	 * @param fromDate
	 * @param toDate
	 * @param revenues
	 * @param expenses
	 * @param totalRevenue
	 * @param totalExpense
	 */
	public ProfitLossStatement(Time fromDate, Time toDate, Map<Account, Money> revenues, Map<Account, Money> expenses,
			Money totalRevenue, Money totalExpense) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.revenues = revenues;
		this.expenses = expenses;
		this.totalRevenue = totalRevenue;
		this.totalExpense = totalExpense;
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
	 * @return the revenues
	 */
	public Map<Account, Money> getRevenues() {
		return revenues;
	}

	/**
	 * @param revenues the revenues to set
	 */
	public void setRevenues(Map<Account, Money> revenues) {
		this.revenues = revenues;
	}

	/**
	 * @return the expenses
	 */
	public Map<Account, Money> getExpenses() {
		return expenses;
	}

	/**
	 * @param expenses the expenses to set
	 */
	public void setExpenses(Map<Account, Money> expenses) {
		this.expenses = expenses;
	}

	/**
	 * @return the totalRevenue
	 */
	public Money getTotalRevenue() {
		return totalRevenue;
	}

	/**
	 * @param totalRevenue the totalRevenue to set
	 */
	public void setTotalRevenue(Money totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	/**
	 * @return the totalExpense
	 */
	public Money getTotalExpense() {
		return totalExpense;
	}

	/**
	 * @param totalExpense the totalExpense to set
	 */
	public void setTotalExpense(Money totalExpense) {
		this.totalExpense = totalExpense;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expenses == null) ? 0 : expenses.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((revenues == null) ? 0 : revenues.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		result = prime * result + ((totalExpense == null) ? 0 : totalExpense.hashCode());
		result = prime * result + ((totalRevenue == null) ? 0 : totalRevenue.hashCode());
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
		if (!(obj instanceof ProfitLossStatement)) {
			return false;
		}
		ProfitLossStatement other = (ProfitLossStatement) obj;
		if (expenses == null) {
			if (other.expenses != null) {
				return false;
			}
		} else if (!expenses.equals(other.expenses)) {
			return false;
		}
		if (fromDate == null) {
			if (other.fromDate != null) {
				return false;
			}
		} else if (!fromDate.equals(other.fromDate)) {
			return false;
		}
		if (revenues == null) {
			if (other.revenues != null) {
				return false;
			}
		} else if (!revenues.equals(other.revenues)) {
			return false;
		}
		if (toDate == null) {
			if (other.toDate != null) {
				return false;
			}
		} else if (!toDate.equals(other.toDate)) {
			return false;
		}
		if (totalExpense == null) {
			if (other.totalExpense != null) {
				return false;
			}
		} else if (!totalExpense.equals(other.totalExpense)) {
			return false;
		}
		if (totalRevenue == null) {
			if (other.totalRevenue != null) {
				return false;
			}
		} else if (!totalRevenue.equals(other.totalRevenue)) {
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
		builder.append("ProfitLossStatement [fromDate=");
		builder.append(fromDate);
		builder.append(", toDate=");
		builder.append(toDate);
		builder.append(", revenues=");
		builder.append(revenues);
		builder.append(", expenses=");
		builder.append(expenses);
		builder.append(", totalRevenue=");
		builder.append(totalRevenue);
		builder.append(", totalExpense=");
		builder.append(totalExpense);
		builder.append("]");
		return builder.toString();
	}
}