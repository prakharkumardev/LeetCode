package designpattern.structural.facade;

public class BankingFacade {
    private final AccountService accountService;
    private final LoanService loanService;
    private final FundTransferService fundTransferService;
    public BankingFacade() {
        this.accountService = new AccountService();
        this.loanService = new LoanService();
        this.fundTransferService = new FundTransferService();
    }

    public void openAccount(String name) {
        accountService.createAccount(name);
        System.out.println("Welcome to the bank, " + name + "!");
    }

    public void applyForLoan(String name) {
        loanService.checkLoanEligibility(name);
        System.out.println("Loan application submitted for " + name);
    }

    public void transferFunds(String fromAccount, String toAccount, double amount) {
        fundTransferService.transferFunds(fromAccount, toAccount, amount);
        System.out.println("Transaction completed successfully.");
    }
}
