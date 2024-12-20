package designpattern.structural.facade;

public class LoanService {
    void checkLoanEligibility(String name) {
        System.out.println("Loan eligibility checked for: " + name);
    }
}
