import java.util.*;

// PROBLEM: Different classes with no common interface
// Client has to handle each type separately

class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public double getProductPrice() {
        return price;
    }
    
    public String getProductName() {
        return name;
    }
    
    public void displayProduct() {
        System.out.println("Product: " + name + " - $" + price);
    }
}

class Box {
    private String name;
    private List<Object> contents; // MIXED TYPES - PROBLEMATIC!
    
    public Box(String name) {
        this.name = name;
        this.contents = new ArrayList<>();
    }
    
    public void addItem(Object item) {
        contents.add(item);
    }
    
    public double calculateTotalPrice() {
        double total = 0;
        
        // PROBLEM: Client has to check types and handle each differently
        for (Object item : contents) {
            if (item instanceof Product) {
                total += ((Product) item).getProductPrice();
            } else if (item instanceof Box) {
                total += ((Box) item).calculateTotalPrice(); // Recursive but messy
            }
            // PROBLEM: What if we add new types? Have to modify this method!
        }
        return total;
    }
    
    public void displayContents() {
        System.out.println("Box: " + name);
        System.out.println("Contents:");
        
        // PROBLEM: More type checking and different method calls
        for (Object item : contents) {
            if (item instanceof Product) {
                ((Product) item).displayProduct();
            } else if (item instanceof Box) {
                ((Box) item).displayContents(); // Different method name!
            }
        }
    }
}

// CLIENT CODE - MESSY AND HARD TO MAINTAIN
public class BeforeComposite {
    public static void main(String[] args) {
        // Create products
        Product phone = new Product("iPhone", 999.99);
        Product charger = new Product("Charger", 29.99);
        Product headphones = new Product("AirPods", 159.99);
        
        // Create boxes
        Box smallBox = new Box("Small Box");
        smallBox.addItem(charger);
        smallBox.addItem(headphones);
        
        Box bigBox = new Box("Big Box");
        bigBox.addItem(phone);
        bigBox.addItem(smallBox); // Adding box to box
        
        // PROBLEM: Client has to know which method to call for each type
        System.out.println("=== DISPLAYING CONTENTS ===");
        bigBox.displayContents();
        
        // PROBLEM: Different calculation methods
        System.out.println("\n=== CALCULATING PRICES ===");
        System.out.println("Phone price: $" + phone.getProductPrice());
        System.out.println("Small box price: $" + smallBox.calculateTotalPrice());
        System.out.println("Big box price: $" + bigBox.calculateTotalPrice());
        
        // PROBLEM: Adding new item types breaks everything!
        // If we add a "Bundle" class, we have to modify ALL the type checks
    }
}


/////////////////////////COMPOSITE PATTERN/////////////////////////////
// 1. COMMON INTERFACE - Both single items and groups implement this
interface Item {
    double getPrice();
    String getName();
    void display();
}

// 2. LEAF - Represents individual products (no children)
class Product implements Item {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void display() {
        System.out.println("Product: " + name + " - $" + price);
    }
}

// 3. COMPOSITE - Represents boxes that can contain other items (products or other boxes)
class Box implements Item {
    private String name;
    private List<Item> items; // Can hold both Products AND other Boxes!
    
    public Box(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }
    
    // Add either a Product or another Box
    public void add(Item item) {
        items.add(item);
    }
    
    // Remove an item
    public void remove(Item item) {
        items.remove(item);
    }
    
    @Override
    public double getPrice() {
        // Automatically calculates total of all contained items
        double total = 0;
        for (Item item : items) {
            total += item.getPrice(); // Works for both Products AND Boxes!
        }
        return total;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void display() {
        System.out.println("Box: " + name + " (Total: $" + getPrice() + ")");
        System.out.println("Contents:");
        for (Item item : items) {
            item.display(); // Same method works for both Products AND Boxes!
        }
        System.out.println("--- End of " + name + " ---");
    }
}

// 4. CLIENT CODE - Uses everything through the common interface
public class CompositeDemo {
    public static void main(String[] args) {
        // Create individual products
        Product phone = new Product("iPhone", 999.99);
        Product charger = new Product("Charger", 29.99);
        Product headphones = new Product("AirPods", 159.99);
        Product caseProduct = new Product("Phone Case", 19.99);
        
        // Create boxes and add products
        Box accessoriesBox = new Box("Accessories Box");
        accessoriesBox.add(charger);
        accessoriesBox.add(headphones);
        accessoriesBox.add(caseProduct);
        
        Box mainBox = new Box("Main Package");
        mainBox.add(phone);
        mainBox.add(accessoriesBox); // Adding a box inside another box!
        
        // Display everything - client doesn't care what's inside!
        System.out.println("=== SHIPPING ORDER ===");
        mainBox.display();
        
        // Calculate total - works the same way for single items or complex boxes
        System.out.println("FINAL TOTAL: $" + mainBox.getPrice());
    }
}



import java.util.*;

interface OrganizationalComponent 
{
    double getSalary();
    void display();
}

class Employee implements OrganizationalComponent 
{
    private String name;
    private double salary;

    public Employee(String name, double salary) 
    {
        this.name = name;
        this.salary = salary;
    }
    
    @Override
    public double getSalary() 
    {
        return salary;
    }
    
    @Override
    public void display() 
    {
        System.out.println("Employee: " + name + " - $" + String.format("%,.1f", salary));
    }
}

class Department implements OrganizationalComponent
{
    private String name;
    private List<OrganizationalComponent> components;

    public Department(String name) 
    {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(OrganizationalComponent component) 
    {
        components.add(component);
    }

    public void removeComponent(OrganizationalComponent component) 
    {
        components.remove(component);
    }
    
    @Override
    public double getSalary() 
    {
        double totalSalary = 0;
        for (OrganizationalComponent component : components) 
        {
            totalSalary += component.getSalary();
        }
        return totalSalary;
    }
    
    @Override
    public void display() 
    {
        System.out.println("Department: " + name);
        for (OrganizationalComponent component : components) 
        {
            component.display();
        }
    }
}

// CLIENT CODE - Uses everything through the common interface
public class CompanyHierarchyDemo {
    public static void main(String[] args) 
    {
        Employee johnDoe = new Employee("John Doe", 50000.0);
        Employee janeSmith = new Employee("Jane Smith", 60000.0);
        Employee bobJohnson = new Employee("Bob Johnson", 40000.0);

        Department qaDepartment = new Department("QA");
        qaDepartment.addComponent(bobJohnson);

        Department engineeringDepartment = new Department("Engineering");
        engineeringDepartment.addComponent(johnDoe);
        engineeringDepartment.addComponent(janeSmith);
        engineeringDepartment.addComponent(qaDepartment); 
        System.out.println("Full Company Structure");
        engineeringDepartment.display();
        System.out.println("Total Engineering Department Salary: $" + String.format("%,.1f", engineeringDepartment.getSalary()));
    }
}

