/**
 * 
 */
package edu.boa.utils;

import java.io.Serializable;
import java.math.BigDecimal;

import edu.boa.exceptions.NotSameCurrencyException;

/**
 * @author sidmishraw
 *
 */
public class Money implements Serializable, Comparable<Money> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String currencySymbol;
	private BigDecimal amount;
	private String currencyFullName;

	/**
	 * 
	 */
	public Money() {}

	/**
	 * @param currencySymbol
	 * @param amount
	 * @param currencyFullName
	 */
	public Money(String currencySymbol, BigDecimal amount, String currencyFullName) {

		super();
		this.currencySymbol = currencySymbol;
		this.amount = amount;
		this.currencyFullName = currencyFullName;
	}

	/**
	 * @return the currencySymbol
	 */
	public String getCurrencySymbol() {
		return currencySymbol;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @return the currencyFullName
	 */
	public String getCurrencyFullName() {
		return currencyFullName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currencyFullName == null) ? 0 : currencyFullName.hashCode());
		result = prime * result + ((currencySymbol == null) ? 0 : currencySymbol.hashCode());
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
		if (!(obj instanceof Money)) {
			return false;
		}
		Money other = (Money) obj;
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		if (currencyFullName == null) {
			if (other.currencyFullName != null) {
				return false;
			}
		} else if (!currencyFullName.equals(other.currencyFullName)) {
			return false;
		}
		if (currencySymbol == null) {
			if (other.currencySymbol != null) {
				return false;
			}
		} else if (!currencySymbol.equals(other.currencySymbol)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Money o) {

		if ( !(this.currencySymbol.equalsIgnoreCase(o.getCurrencySymbol())
				&& this.currencyFullName.equalsIgnoreCase(o.getCurrencyFullName())) ) {

			return -1;
		}

		return this.amount.compareTo(o.getAmount());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Money [currencySymbol=");
		builder.append(currencySymbol);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", currencyFullName=");
		builder.append(currencyFullName);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Adds the money with somemoremoney provided to it, and returns the new Money
	 * @param someMoreMoney
	 * @return Money
	 * @throws NotSameCurrencyException
	 */
	public Money add(Money someMoreMoney) throws NotSameCurrencyException {

		if ( !( this.currencySymbol.equalsIgnoreCase(someMoreMoney.getCurrencySymbol()) 
				&& this.currencyFullName.equalsIgnoreCase(someMoreMoney.getCurrencyFullName())) ) {

			throw new NotSameCurrencyException("The currency of amounts being added are not same.");
		}

		return new Money(this.currencySymbol, this.amount.add(someMoreMoney.getAmount()), this.currencyFullName);
	}

	/**
	 * Subtracts the money with somemoremoney provided to it, and returns the new Money
	 * @param someMoreMoney
	 * @return Money
	 * @throws NotSameCurrencyException
	 */
	public Money subtract(Money someMoreMoney) throws NotSameCurrencyException {

		if ( !( this.currencySymbol.equalsIgnoreCase(someMoreMoney.getCurrencySymbol()) 
				&& this.currencyFullName.equalsIgnoreCase(someMoreMoney.getCurrencyFullName())) ) {

			throw new NotSameCurrencyException("The currency of amounts being subtracted are not same.");
		}

		return new Money(this.currencySymbol, this.amount.subtract(someMoreMoney.getAmount()), this.currencyFullName);
	}

	/**
	 * Multiplies the money with factor (BigDecimal) provided to it, and returns the new Money
	 * @param someMoreMoney
	 * @return Money
	 * @throws NotSameCurrencyException
	 */
	public Money multiply(BigDecimal factor) {

		return new Money(this.currencySymbol, this.amount.multiply(factor), this.currencyFullName);
	}

	/**
	 * Divides the current money with the divisor and returns a new Money object having quotient
	 * as the new amount.
	 * @param divisor
	 * @return Money
	 * @throws ArithmeticException
	 */
	public Money divide(BigDecimal divisor) throws ArithmeticException {

		try {

			BigDecimal newAmount = this.amount.divide(divisor);

			return new Money(this.currencySymbol, newAmount, this.currencyFullName);
		} catch(ArithmeticException e) {

			throw new ArithmeticException("Division failed due to arithmetic exception. Might be a divide by zero error");
		}
	}
}
