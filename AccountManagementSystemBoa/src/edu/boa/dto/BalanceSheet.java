package edu.boa.dto;

import java.io.Serializable;
import java.util.Map;

import edu.boa.bo.Account;
import edu.boa.utils.Money;
import edu.boa.utils.time.Time;

/**
 * @author sidmishraw
 */
public class BalanceSheet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public BalanceSheet() {
	}

	/**
	 * 
	 */
	private Time fromDate, toDate;

	/**
	 * 
	 */
	private Map<Account,Money> assets, liabilities, equities;

	/**
	 * 
	 */
	private Money assetsLessLiabilities, totalEquity;

	/**
	 * @param fromDate
	 * @param toDate
	 * @param assets
	 * @param liabilities
	 * @param equities
	 * @param assetsLessLiabilities
	 * @param totalEquity
	 */
	public BalanceSheet(Time fromDate, Time toDate, Map<Account, Money> assets, Map<Account, Money> liabilities,
			Map<Account, Money> equities, Money assetsLessLiabilities, Money totalEquity) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.assets = assets;
		this.liabilities = liabilities;
		this.equities = equities;
		this.assetsLessLiabilities = assetsLessLiabilities;
		this.totalEquity = totalEquity;
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
	 * @return the assets
	 */
	public Map<Account, Money> getAssets() {
		return assets;
	}

	/**
	 * @param assets the assets to set
	 */
	public void setAssets(Map<Account, Money> assets) {
		this.assets = assets;
	}

	/**
	 * @return the liabilities
	 */
	public Map<Account, Money> getLiabilities() {
		return liabilities;
	}

	/**
	 * @param liabilities the liabilities to set
	 */
	public void setLiabilities(Map<Account, Money> liabilities) {
		this.liabilities = liabilities;
	}

	/**
	 * @return the equities
	 */
	public Map<Account, Money> getEquities() {
		return equities;
	}

	/**
	 * @param equities the equities to set
	 */
	public void setEquities(Map<Account, Money> equities) {
		this.equities = equities;
	}

	/**
	 * @return the assetsLessLiabilities
	 */
	public Money getAssetsLessLiabilities() {
		return assetsLessLiabilities;
	}

	/**
	 * @param assetsLessLiabilities the assetsLessLiabilities to set
	 */
	public void setAssetsLessLiabilities(Money assetsLessLiabilities) {
		this.assetsLessLiabilities = assetsLessLiabilities;
	}

	/**
	 * @return the totalEquity
	 */
	public Money getTotalEquity() {
		return totalEquity;
	}

	/**
	 * @param totalEquity the totalEquity to set
	 */
	public void setTotalEquity(Money totalEquity) {
		this.totalEquity = totalEquity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assets == null) ? 0 : assets.hashCode());
		result = prime * result + ((assetsLessLiabilities == null) ? 0 : assetsLessLiabilities.hashCode());
		result = prime * result + ((equities == null) ? 0 : equities.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((liabilities == null) ? 0 : liabilities.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		result = prime * result + ((totalEquity == null) ? 0 : totalEquity.hashCode());
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
		if (!(obj instanceof BalanceSheet)) {
			return false;
		}
		BalanceSheet other = (BalanceSheet) obj;
		if (assets == null) {
			if (other.assets != null) {
				return false;
			}
		} else if (!assets.equals(other.assets)) {
			return false;
		}
		if (assetsLessLiabilities == null) {
			if (other.assetsLessLiabilities != null) {
				return false;
			}
		} else if (!assetsLessLiabilities.equals(other.assetsLessLiabilities)) {
			return false;
		}
		if (equities == null) {
			if (other.equities != null) {
				return false;
			}
		} else if (!equities.equals(other.equities)) {
			return false;
		}
		if (fromDate == null) {
			if (other.fromDate != null) {
				return false;
			}
		} else if (!fromDate.equals(other.fromDate)) {
			return false;
		}
		if (liabilities == null) {
			if (other.liabilities != null) {
				return false;
			}
		} else if (!liabilities.equals(other.liabilities)) {
			return false;
		}
		if (toDate == null) {
			if (other.toDate != null) {
				return false;
			}
		} else if (!toDate.equals(other.toDate)) {
			return false;
		}
		if (totalEquity == null) {
			if (other.totalEquity != null) {
				return false;
			}
		} else if (!totalEquity.equals(other.totalEquity)) {
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
		builder.append("BalanceSheet [fromDate=");
		builder.append(fromDate);
		builder.append(", toDate=");
		builder.append(toDate);
		builder.append(", assets=");
		builder.append(assets);
		builder.append(", liabilities=");
		builder.append(liabilities);
		builder.append(", equities=");
		builder.append(equities);
		builder.append(", assetsLessLiabilities=");
		builder.append(assetsLessLiabilities);
		builder.append(", totalEquity=");
		builder.append(totalEquity);
		builder.append("]");
		return builder.toString();
	}
}