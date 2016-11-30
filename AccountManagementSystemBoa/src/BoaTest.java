
import edu.boa.bo.Account;
import edu.boa.constants.AccountType;
import edu.boa.exceptions.SaveFailedException;
import edu.boa.service.AccountManagementService;

public class BoaTest {
	public static void main(String[] args) throws SaveFailedException {
		
		//simulate launching account management service
		AccountManagementService ams = new AccountManagementService();
		
		//demo for use case: create account
		Account checking = ams.createAccount("checking", AccountType.ASSET);
		Account equipment = ams.createAccount("equipment", AccountType.ASSET);
		Account inventory = ams.createAccount("inventory", AccountType.ASSET);
		Account receivables = ams.createAccount("receivables", AccountType.ASSET);
		
		Account creditCard = ams.createAccount("creditcard", AccountType.LIABILITY);
		
		Account utilities = ams.createAccount("utilities", AccountType.EXPENSE);
		Account payroll = ams.createAccount("payroll", AccountType.EXPENSE);
		Account deprecation = ams.createAccount("deprecation", AccountType.EXPENSE);
		
		Account laptopSales = ams.createAccount("laptop sales", AccountType.REVENUE);
		Account tabletSales = ams.createAccount("tablet sales", AccountType.REVENUE);
		
		Account investments = ams.createAccount("investments", AccountType.STOCKHOLDERS_EQUITY);
		
		Account oldAccount = ams.createAccount("oldAccount", AccountType.ASSET);
		
		//demo for use case: reverse account
		
		
		
	}
}
