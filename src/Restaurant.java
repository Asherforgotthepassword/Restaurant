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
                    System.out.println();
                    accessGranted = true;
                } else {
                    System.out.println("THE INFORMATION YOU ENTERED DOES NOT MATCH OUR RECORDS");
                }
            } else {
                System.out.println("THE INFORMATION YOU ENTERED DOES NOT MATCH OUR RECORDS");
            }
        }
        // Initialize food, tables, customers
        ArrayList<Food> menu = new ArrayList<>();
        Food burger = new Food("Hamburger",8.50);
        Food hotDog = new Food("Hog Dog",7.50);
        Food pizza = new Food("Pizza",7.50);
        Food spaghetti = new Food("Spaghetti",11.50);
        Food salad = new Food("Salad",7.00);
        menu.add(burger); menu.add(hotDog); menu.add(pizza); menu.add(spaghetti); menu.add(salad);

        ArrayList<Table> tables = new ArrayList<>();
        Table t1 = new Table(1,2);
        Table t2 = new Table(2,2);
        Table t3 = new Table(3,4);
        Table t4 = new Table(4,4);
        Table t5 = new Table(5,8);
        Table t6 = new Table(6,8);
        tables.add(t1); tables.add(t2); tables.add(t3); tables.add(t4); tables.add(t5);

        ArrayList<Customer> customers = new ArrayList<>();
        Customer bob = new Customer("Bob",3);
        Customer john = new Customer("John",2);
        Customer jane = new Customer("Jane",5);
        customers.add(bob); customers.add(john); customers.add(jane);
        for (Customer customer : customers) {
            customer.addOrder(menu.get(rand.nextInt(4)));
        }

        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Options:\n1. Check Table Status\n2. Check Customer Status\n3. Manage Tables\n4. Manage Customers\n6. Calculate Checkout");
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Table Status:");
                    for (Table table : tables) {
                        System.out.println(table);
                    }
                    break;

                case 2: // TODO 1: This should print out all customers, similar to table status
                    System.out.println("Table Status:");
                    for (Table table : tables) {
                        System.out.println(table);
                    }
                    break;

                case 3:
                    // TODO 2: Manage tables (prompt what customer, then what table, then assign customer to table)
                    System.out.print("CUSTOMER NAME: ");
                    String customerNameInput = sc.nextLine();
                    System.out.print("Table Number: ");
                    String tableNumberInput = sc.nextLine();

                    //iterate over tables
                    for (Table table : tables) {
                        //find table number matching the user entered table number
                        if (table.getNumber() == Integer.parseInt(tableNumberInput)) {
                            //once table is identified, now iterate over customers to match customer name
                            for (Customer customer : customers) {
                                if (customer.getName().equals(customerNameInput)) {
                                    //once customer is identified, assign the table to the customer
                                    table.assignCustomer(customer);
                                }
                            }
                        }
                    }
                    break;

                case 4:
                    // TODO 3: Manage customers (add/remove customers currently in the restaurant, if you add then randomly generate an order for their instance variable)
                    //prompt asking ADD or REMOVE
                    System.out.println("Add or remove customer: ");
                    String response = sc.nextLine();
                    if (response.equals("add")) {
                        System.out.println("Customer name:  ");
                        String name = sc.nextLine();
                        System.out.println("Customer party size:  ");
                        int party = sc.nextInt();
                        System.out.println("Customer number: ");
                        int number = sc.nextInt();
                        Customer newCustomer = new Customer(name, party);
                        newCustomer.setNumber(rand.nextInt());
                        newCustomer.addOrder(menu.get(rand.nextInt(5) + 3));
                        customers.add(newCustomer);
                    }
                    if (response.equals("remove")) {
                        System.out.println("Customer name:  ");
                        String name = sc.nextLine();
                        for (int i = 0; i < customers.size(); i++) {
                            if (customers.get(i).getName().equals(name)) {
                                customers.remove(i);
                                break;
                            }
                        }
                    }
                    break;

                case 5:
                    // TODO 4: Checkout, prompt what table, get customer's order, return food price, automatically removes customer
                    System.out.println("Customer: ");
                    String name = sc.nextLine();
                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i).getName().equals(name)) {
                            Customer customer = customers.get(i);
                            double total = customer.getOrder().getPrice();
                            System.out.println("Total for " + name + ":$" + total);
                            customers.remove(i);
                        }
                    }
            }
        }
    }
}
