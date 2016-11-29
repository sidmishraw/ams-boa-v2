package edu.boa.bo;

import java.io.Serializable;
import edu.boa.constants.AccountType;
import edu.boa.utils.Money;

/**
 * @author Boa
 */
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Account() {}

	/**
	 * 
	 */
	private String ID;
	
	/**
    * 
    */
	private Boolean isReversed;
	
	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private Money balance;

	/**
	 * 
	 */
	private AccountType type;

	/**
	 * @param name
	 * @param balance
	 * @param type
	 */
	public Account(String name, Money balance, AccountType type, boolean isReversed) {

		super();
		this.name = name;
		this.balance = balance;
		this.type = type;
		this.isReversed = isReversed;
	}

	public Boolean getIsReversed()
   {
      return isReversed;
   }

   public void setIsReversed(Boolean isReversed)
   {
      this.isReversed = isReversed;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the balance
	 */
	public Money getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Money balance) {
		this.balance = balance;
	}

	/**
	 * @return the type
	 */
	public AccountType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(AccountType type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (!(obj instanceof Account)) {
			return false;
		}
		Account other = (Account) obj;
		if (ID == null) {
			if (other.ID != null) {
				return false;
			}
		} else if (!ID.equals(other.ID)) {
			return false;
		}
		if (balance == null) {
			if (other.balance != null) {
				return false;
			}
		} else if (!balance.equals(other.balance)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (type != other.type) {
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
		builder.append("Account [ID=");
		builder.append(ID);
		builder.append(", name=");
		builder.append(name);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
}