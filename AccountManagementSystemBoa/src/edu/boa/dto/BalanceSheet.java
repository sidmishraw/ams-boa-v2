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
	private Time asofDate;

	/**
	 * 
	 */
	private Map<Account,Money> assets, liabilities, equities;


   /**
	 * 
	 */
	private Money assetsLessLiabilities, totalEquity;

	/**
	 * @param asofDate
	 * @param assets
	 * @param liabilities
	 * @param equities
	 * @param assetsLessLiabilities
	 * @param totalEquity
	 */
	public BalanceSheet(Time asofDate, Map<Account, Money> assets, Map<Account, Money> liabilities,
			Map<Account, Money> equities, Money assetsLessLiabilities, Money totalEquity) {
		super();
		this.assets = assets;
		this.liabilities = liabilities;
		this.equities = equities;
		this.assetsLessLiabilities = assetsLessLiabilities;
		this.totalEquity = totalEquity;
	}

   public Time getAsofDate()
   {
      return asofDate;
   }

   public void setAsofDate(Time asofDate)
   {
      this.asofDate = asofDate;
   }

   public Map<Account, Money> getAssets()
   {
      return assets;
   }

   public void setAssets(Map<Account, Money> assets)
   {
      this.assets = assets;
   }

   public Map<Account, Money> getLiabilities()
   {
      return liabilities;
   }

   public void setLiabilities(Map<Account, Money> liabilities)
   {
      this.liabilities = liabilities;
   }

   public Map<Account, Money> getEquities()
   {
      return equities;
   }

   public void setEquities(Map<Account, Money> equities)
   {
      this.equities = equities;
   }

   public Money getAssetsLessLiabilities()
   {
      return assetsLessLiabilities;
   }

   public void setAssetsLessLiabilities(Money assetsLessLiabilities)
   {
      this.assetsLessLiabilities = assetsLessLiabilities;
   }

   public Money getTotalEquity()
   {
      return totalEquity;
   }

   public void setTotalEquity(Money totalEquity)
   {
      this.totalEquity = totalEquity;
   }

   @Override
   public String toString()
   {
      return "BalanceSheet [asofDate=" + asofDate + ", assets=" + assets
            + ", liabilities=" + liabilities + ", equities=" + equities
            + ", assetsLessLiabilities=" + assetsLessLiabilities
            + ", totalEquity=" + totalEquity + "]";
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((asofDate == null) ? 0 : asofDate.hashCode());
      result = prime * result + ((assets == null) ? 0 : assets.hashCode());
      result = prime * result + ((assetsLessLiabilities == null) ? 0
            : assetsLessLiabilities.hashCode());
      result = prime * result + ((equities == null) ? 0 : equities.hashCode());
      result = prime * result
            + ((liabilities == null) ? 0 : liabilities.hashCode());
      result = prime * result
            + ((totalEquity == null) ? 0 : totalEquity.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      BalanceSheet other = (BalanceSheet) obj;
      if (asofDate == null)
      {
         if (other.asofDate != null)
            return false;
      } else if (!asofDate.equals(other.asofDate))
         return false;
      if (assets == null)
      {
         if (other.assets != null)
            return false;
      } else if (!assets.equals(other.assets))
         return false;
      if (assetsLessLiabilities == null)
      {
         if (other.assetsLessLiabilities != null)
            return false;
      } else if (!assetsLessLiabilities.equals(other.assetsLessLiabilities))
         return false;
      if (equities == null)
      {
         if (other.equities != null)
            return false;
      } else if (!equities.equals(other.equities))
         return false;
      if (liabilities == null)
      {
         if (other.liabilities != null)
            return false;
      } else if (!liabilities.equals(other.liabilities))
         return false;
      if (totalEquity == null)
      {
         if (other.totalEquity != null)
            return false;
      } else if (!totalEquity.equals(other.totalEquity))
         return false;
      return true;
   }
}