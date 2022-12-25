import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Restaurant machine = new Restaurant();
            int customerID, orderQty;
            try {

                System.out.println("Masukan nomer customer: ");
                customerID = input.nextInt();

                System.out.println("Masukan berapa banyak makanan yang dibuat: ");
                orderQty = input.nextInt();

                Thread t1 = new Thread(machine);
                Waiter waiter = new Waiter(customerID, orderQty);
                Thread t2 = new Thread(waiter);

                t1.start();
                t2.start();
                t1.join();
                t2.join();

            } catch (Exception e) {
                System.out.println("Hanya menerima angka!");
            }
        }

    }

}