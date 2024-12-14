import java.util.*;

public class Restaurant {
    public static void main(String[] args) {
        // User and Password Check
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String username = "SuperCoolManager";
        String password = "SuperCoolPassword";
        boolean accessGranted = false;
        while (!accessGranted) {
            System.out.print("USERNAME: ");
            String user = sc.nextLine();
            if (username.equals(user)) {
                System.out.print("PASSWORD: ");
                String pass = sc.nextLine();
                if (password.equals(pass)) {
                    System.out.println("WELCOME " + username);
                    for (int i = 0; i < rand.nextInt(5)+3; i++) {
                        System.out.println("RETRIEVING INFORMATION...");
                    }
                    accessGranted = true;
                } else {
                    System.out.println("THE INFORMATION YOU ENTERED DOES NOT MATCH OUR RECORDS");
                }
            } else {
                System.out.println("THE INFORMATION YOU ENTERED DOES NOT MATCH OUR RECORDS");
            }
        }
        // Initialize tables
        Table t1 = new Table(1,2);
        Table t2 = new Table(2,2);
        Table t3 = new Table(3,4);
        Table t4 = new Table(4,4);
        Table t5 = new Table(5,8);
        Table t6 = new Table(6,8);
        // Test Table/Customer class
        // TODO: Prevent Customer from being assigned to multiple tables
        System.out.println(t4.getNumber()); // should return 4
        System.out.println(t6.getNumber()); // should return 6
        System.out.println(t3); // test toString empty
        Customer frank = new Customer("Frank", 2);
        t1.assignCustomer(frank); // assigns frank to t1
        System.out.println(t1); // test toString with someone assigned
        System.out.println(t1.getCustomer()); // returns Customer frank, TODO: Create Customer toString
        Customer bob = new Customer("Bob", 2);
        t1.assignCustomer(bob); // table is already reserved
        t1.removeCustomer(); // remove frank from t1
        t1.assignCustomer(bob); // assigns bob to t1
        Customer steve = new Customer("Steve", 5);
        t2.assignCustomer(steve); // t2 is too small
        t5.assignCustomer(steve); // assigns steve to t5
    }
}
