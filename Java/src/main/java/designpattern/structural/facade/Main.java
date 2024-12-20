package designpattern.structural.facade;
/*
Real-World Use Case: Banking System

Imagine a banking system where various subsystems manage account creation, loan processing,
and fund transfers. A customer doesn’t need to interact directly with these subsystems.
Instead, a BankingFacade simplifies the interaction by providing methods like openAccount(),
applyForLoan(), and transferFunds().
 */
public class Main {
    public static void main(String[] args) {
        BankingFacade bankingFacade = new BankingFacade();

        // Using the facade to interact with the banking system
        bankingFacade.openAccount("Prakahr");
        bankingFacade.applyForLoan("Prakhar");
        bankingFacade.transferFunds("Prakher4722", "Archit04", 500.00);
    }
}
