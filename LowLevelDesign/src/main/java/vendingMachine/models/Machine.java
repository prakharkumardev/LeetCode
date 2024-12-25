package vendingMachine.models;

public interface Machine {
    void addMoney(Payment payment);
    void dispenseItem(long productId, Integer quantity);
    void closeTransaction();
}
