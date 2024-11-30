import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomerApp {

    // Customer JavaBean class
    public static class Customer {
        private String firstName;
        private String lastName;
        private int id;
        private double balance;

        // Constructor
        public Customer(String firstName, String lastName, int id, double balance) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
            this.balance = balance;
        }

        // Getters and setters
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Customer [ID=" + id + ", Name=" + firstName + " " + lastName + ", Balance=" + balance + "]";
        }
    }

    // CustomerComparator class to compare Customers based on the criteria
    public static class CustomerComparator implements Comparator<Customer> {

        @Override
        public int compare(Customer c1, Customer c2) {
            // Compare by First Name
            int firstNameCompare = c1.getFirstName().compareTo(c2.getFirstName());
            if (firstNameCompare != 0) return firstNameCompare;

            // If First Name is the same, compare by Last Name
            int lastNameCompare = c1.getLastName().compareTo(c2.getLastName());
            if (lastNameCompare != 0) return lastNameCompare;

            // If both First Name and Last Name are the same, compare by ID
            int idCompare = Integer.compare(c1.getId(), c2.getId());
            if (idCompare != 0) return idCompare;

            // If First Name, Last Name, and ID are the same, compare by Balance
            return Double.compare(c1.getBalance(), c2.getBalance());
        }
    }

    // Main application class
    public static void main(String[] args) {
        // Create a list of customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "Doe", 102, 500.50));
        customers.add(new Customer("Jane", "Smith", 101, 1500.75));
        customers.add(new Customer("John", "Doe", 100, 1000.00));
        customers.add(new Customer("Alice", "Johnson", 104, 300.00));
        customers.add(new Customer("Bob", "Smith", 103, 750.25));

        // Print customers before sorting
        System.out.println("Customers before sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Sort customers using the custom comparator
        Collections.sort(customers, new CustomerComparator());

        // Print customers after sorting
        System.out.println("\nCustomers after sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}