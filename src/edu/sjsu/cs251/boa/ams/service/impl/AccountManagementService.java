package edu.sjsu.cs251.boa.ams.service.impl;

public class AccountManagementService
{
   /**
    * Jason
    */
   public Account createAccount(String accountName, AccountType type) {
      return new Account(accountName, type);
   }
   
   /**
    * Jason
    */
   public ProfitLossStatement generateProfitLossStatemet(Time fromTime, Time toTime) {
      
   }
}
