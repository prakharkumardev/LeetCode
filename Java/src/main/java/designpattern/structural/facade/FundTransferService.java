package designpattern.structural.facade;

public  class FundTransferService {
    void transferFunds(String fromAccount, String toAccount, double amount) {
        System.out.println("Transferred " + amount + " from " + fromAccount + " to " + toAccount);
    }
}
