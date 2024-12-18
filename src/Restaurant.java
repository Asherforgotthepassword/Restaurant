import java.util.*;

/**
 * The Restaurant class manages the reservations of a restaurant
 * Including user authentication, table management, and customer management
 */
public class Restaurant {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();

    /**
     * The main method is the entry point for the Restaurant program
     * It handles user authentication and provides options for managing tables and customers
     * @param args main method entry point
     */
    public static void main(String[] args) {
        // User and Password Check
        getCredentials();
        // Initialize food
        ArrayList<Food> menu = new ArrayList<>();
        Food burger = new Food("Hamburger",8.50);
        Food hotDog = new Food("Hog Dog",7.50);
        Food pizza = new Food("Pizza",7.50);
        Food spaghetti = new Food("Spaghetti",11.50);
        Food salad = new Food("Salad",7.00);
        menu.add(burger); menu.add(hotDog); menu.add(pizza); menu.add(spaghetti); menu.add(salad);
        // Initialize tables
        ArrayList<Table> tables = new ArrayList<>();
        Table t1 = new Table(1,2);
        Table t2 = new Table(2,2);
        Table t3 = new Table(3,4);
        Table t4 = new Table(4,4);
        Table t5 = new Table(5,8);
        Table t6 = new Table(6,8);
        tables.add(t1); tables.add(t2); tables.add(t3); tables.add(t4); tables.add(t5); tables.add(t6);
        // Initialize tester customers
        ArrayList<Customer> customers = new ArrayList<>();
        Customer bob = new Customer("Bob",3);
        Customer john = new Customer("John",2);
        Customer jane = new Customer("Jane",5);
        customers.add(bob); customers.add(john); customers.add(jane);
        for (Customer customer : customers) {
            customer.setOrder(menu.get(rand.nextInt(4)));
        }

        /*
          Uses a switch class for a variety of possible management options
          Includes table status, checkout, adding and removing customers
         */
        boolean isRunning = true;
        while (isRunning) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Options:\n1. Check Table Status\n2. Check Customer Status\n3. Manage Tables\n4. Manage Customers\n5. Calculate Checkout\n6. Exit");
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            int option = sc.nextInt();
            outerloop:
            switch (option) {
                case 1:
                    System.out.println("Table Status:");
                    for (Table table : tables) {
                        System.out.println(table);
                    }
                    break;
                case 2:
                    System.out.println("Customer Status:");
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;
                case 3:
                    System.out.print("Customer Name (case sensitive): ");
                    sc.nextLine();
                    String customerName = sc.nextLine();
                    Customer specifiedCustomer = null;
                    for (Customer customer : customers) {
                        if (customer.getName().equals(customerName)) {
                            specifiedCustomer = customer;
                        }
                    }
                    if (specifiedCustomer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    System.out.print("Table Number: ");
                    int tableNumber = sc.nextInt();
                    if (1 > tableNumber || tableNumber > tables.size()) {
                        System.out.println("Invalid table number.");
                        break;
                    }
                    tables.get(tableNumber - 1).assignCustomer(specifiedCustomer);
                    break;
                case 4:
                    // Prompt asking ADD or REMOVE
                    System.out.print("Add or remove customer: ");
                    sc.nextLine();
                    String response = sc.nextLine().toLowerCase();
                    if (response.equals("add")) {
                        System.out.print("Customer name (case sensitive): ");
                        String name = sc.nextLine();
                        System.out.print("Customer party size: ");
                        int party = sc.nextInt();
                        Customer newCustomer = new Customer(name, party);
                        newCustomer.setOrder(menu.get(rand.nextInt(menu.size())));
                        customers.add(newCustomer);
                        break;
                    } else if (response.equals("remove")) {
                        System.out.print("Customer name (case sensitive): ");
                        String name = sc.nextLine();
                        for (int i = 0; i < customers.size(); i++) {
                            if (customers.get(i).getName().equals(name)) {
                                if (customers.get(i).getNumber() != 0) {
                                    tables.get(customers.get(i).getNumber() - 1).removeCustomer();

                                }
                                customers.remove(i);
                                break outerloop;
                            }
                        }
                        System.out.println("Customer not found.");
                        break;
                    } else {
                        System.out.println("Invalid response.");
                        break;
                    }
                case 5:
                    System.out.print("Customer name (case sensitive): ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    for (Customer customer : customers) {
                        if (customer.getName().equals(name)) {
                            if (customer.getNumber() != 0) {
                                double total = customer.getOrder().getPrice();
                                System.out.println("Total for " + name + ": $" + total);
                                tables.get(customer.getNumber() - 1).removeCustomer();
                                customers.remove(customer);

                            } else {
                                System.out.println("Customer is not seated.");
                            }
                            break outerloop;
                        }
                    }
                    System.out.println("Customer not found.");
                    break;
                case 6:
                    System.out.println("Shutting down . . .");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    /**
     * Authorizes user by taking a username and password and verifying information
     * If username/password is correct, allow access to program, else inform user that credentials are incorrect
     */
    private static void getCredentials() {
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
    }
}
