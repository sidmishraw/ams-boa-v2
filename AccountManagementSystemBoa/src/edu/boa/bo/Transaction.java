package edu.boa.bo;

import java.io.Serializable;

import edu.boa.utils.Money;
import edu.boa.utils.time.Time;

/**
 * @author Boa
 */
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Transaction() {
	}

	/**
	 * 
	 */
	private String ID;

	/**
	 * 
	 */
	private Account debitedAccount;

	/**
	 * 
	 */
	private Account creditedAccount;

	/**
	 * 
	 */
	private Money amount;

	/**
	 * 
	 */
	private Time date;

	/**
	 * @param debitedAccount
	 * @param creditedAccount
	 * @param amount
	 * @param date
	 */
	public Transaction(Account debitedAccount, Account creditedAccount, Money amount, Time date) {
		super();
		this.debitedAccount = debitedAccount;
		this.creditedAccount = creditedAccount;
		this.amount = amount;
		this.date = date;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the debitedAccount
	 */
	public Account getDebitedAccount() {
		return debitedAccount;
	}

	/**
	 * @param debitedAccount the debitedAccount to set
	 */
	public void setDebitedAccount(Account debitedAccount) {
		this.debitedAccount = debitedAccount;
	}

	/**
	 * @return the creditedAccount
	 */
	public Account getCreditedAccount() {
		return creditedAccount;
	}

	/**
	 * @param creditedAccount the creditedAccount to set
	 */
	public void setCreditedAccount(Account creditedAccount) {
		this.creditedAccount = creditedAccount;
	}

	/**
	 * @return the amount
	 */
	public Money getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Money amount) {
		this.amount = amount;
	}

	/**
	 * @return the date
	 */
	public Time getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Time date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((creditedAccount == null) ? 0 : creditedAccount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((debitedAccount == null) ? 0 : debitedAccount.hashCode());
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
		if (!(obj instanceof Transaction)) {
			return false;
		}
		Transaction other = (Transaction) obj;
		if (ID == null) {
			if (other.ID != null) {
				return false;
			}
		} else if (!ID.equals(other.ID)) {
			return false;
		}
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		if (creditedAccount == null) {
			if (other.creditedAccount != null) {
				return false;
			}
		} else if (!creditedAccount.equals(other.creditedAccount)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (debitedAccount == null) {
			if (other.debitedAccount != null) {
				return false;
			}
		} else if (!debitedAccount.equals(other.debitedAccount)) {
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
		builder.append("Transaction [ID=");
		builder.append(ID);
		builder.append(", debitedAccount=");
		builder.append(debitedAccount);
		builder.append(", creditedAccount=");
		builder.append(creditedAccount);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
}