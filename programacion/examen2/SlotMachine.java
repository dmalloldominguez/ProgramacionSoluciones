package examen2;

public class SlotMachine {
    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        wallet.add(new Bill(5));
        wallet.add(new Bill(20));
        wallet.add(new Bill(50));
        wallet.add(new Card("1234", 100, 50));
        wallet.add(new Card("5678", 1000, 500));

        System.out.println("Total: " + wallet.value() + " €");
    }
}
