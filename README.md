Report

This FarmingSystem program is designed to manage a simple farming environment with various entities such as animals, crops, and farmers. The program uses object-oriented programming concepts including inheritance, polymorphism, and encapsulation to model these entities and their interactions.

Class Design
FarmingSystem Class

Manages the main menu and user interactions.
Contains static lists to store instances of FarmAnimal, Crop, and Farmer.
Provides methods to add, display, and perform operations on animals, crops, and farmers.
FarmAnimal Class

Base class for all farm animals.
Attributes: name, age, type.
Methods: Getters and setters, and a makeSound method to be overridden by subclasses.
Cow Class (extends FarmAnimal)

Represents a cow with additional attribute milkProduction.
Overrides makeSound to provide a cow-specific sound.
Provides produceMilk method to output milk production.
Chicken Class (extends FarmAnimal)

Represents a chicken with additional attribute eggProduction.
Overrides makeSound to provide a chicken-specific sound.
Provides layEggs method to output egg production.
Crop Class

Represents a crop with attributes name, quantity, and pricePerUnit.
Methods: Getters and setters, and a harvest method to simulate harvesting.
Farmer Class

Represents a farmer with attributes name and experienceLevel.
Methods: Getters and setters, tendToAnimals, and plantCrops methods to simulate farmer activities.
Use of Inheritance and Polymorphism
Inheritance:
Cow and Chicken classes inherit from the FarmAnimal class. This allows for code reuse and a hierarchical relationship between general farm animals and specific animal types.
Polymorphism:
The animals list can store objects of type FarmAnimal, which can be either Cow or Chicken. This allows the performOperations method to iterate over the list and call overridden methods like makeSound, produceMilk, and layEggs without knowing the specific type of animal.
Encapsulation
Each class uses private attributes and provides public getter and setter methods to access and modify these attributes. This hides the internal state of the objects and only allows controlled access through methods.
Commented code....
import java.util.ArrayList;
import java.util.Scanner;

public class FarmingSystem {
    private static ArrayList<FarmAnimal> animals = new ArrayList<>();
    private static ArrayList<Crop> crops = new ArrayList<>();
    private static ArrayList<Farmer> farmers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Main loop for the farming system menu
        while (!exit) {
            System.out.println("Farming System Menu:");
            System.out.println("1. Add Animal");
            System.out.println("2. Add Crop");
            System.out.println("3. Add Farmer");
            System.out.println("4. Display Animals");
            System.out.println("5. Display Crops");
            System.out.println("6. Display Farmers");
            System.out.println("7. Perform Operations");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAnimal(scanner);
                    break;
                case 2:
                    addCrop(scanner);
                    break;
                case 3:
                    addFarmer(scanner);
                    break;
                case 4:
                    displayAnimals();
                    break;
                case 5:
                    displayCrops();
                    break;
                case 6:
                    displayFarmers();
                    break;
                case 7:
                    performOperations(scanner);
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to add an animal to the farm
    private static void addAnimal(Scanner scanner) {
        System.out.print("Enter animal type (Cow/Chicken): ");
        String type = scanner.next();
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        // Add specific type of animal based on user input
        if (type.equalsIgnoreCase("Cow")) {
            System.out.print("Enter milk production: ");
            double milkProduction = scanner.nextDouble();
            animals.add(new Cow(name, age, milkProduction));
        } else if (type.equalsIgnoreCase("Chicken")) {
            System.out.print("Enter egg production: ");
            int eggProduction = scanner.nextInt();
            animals.add(new Chicken(name, age, eggProduction));
        } else {
            System.out.println("Invalid animal type.");
        }
    }

    // Method to add a crop to the farm
    private static void addCrop(Scanner scanner) {
        System.out.print("Enter crop name: ");
        String name = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price per unit: ");
        double pricePerUnit = scanner.nextDouble();
        crops.add(new Crop(name, quantity, pricePerUnit));
    }

    // Method to add a farmer to the farm
    private static void addFarmer(Scanner scanner) {
        System.out.print("Enter farmer name: ");
        String name = scanner.next();
        System.out.print("Enter experience level: ");
        int experienceLevel = scanner.nextInt();
        farmers.add(new Farmer(name, experienceLevel));
    }

    // Method to display all animals
    private static void displayAnimals() {
        for (FarmAnimal animal : animals) {
            System.out.println(animal.getType() + ": " + animal.getName() + ", Age: " + animal.getAge());
        }
    }

    // Method to display all crops
    private static void displayCrops() {
        for (Crop crop : crops) {
            System.out.println("Crop: " + crop.getName() + ", Quantity: " + crop.getQuantity() + ", Price per unit: " + crop.getPricePerUnit());
        }
    }

    // Method to display all farmers
    private static void displayFarmers() {
        for (Farmer farmer : farmers) {
            System.out.println("Farmer: " + farmer.getName() + ", Experience Level: " + farmer.getExperienceLevel());
        }
    }

    // Method to perform various operations on the farm
    private static void performOperations(Scanner scanner) {
        System.out.println("1. Make Animal Sound");
        System.out.println("2. Produce Milk (Cow)");
        System.out.println("3. Lay Eggs (Chicken)");
        System.out.println("4. Harvest Crops");
        System.out.println("5. Tend to Animals (Farmer)");
        System.out.println("6. Plant Crops (Farmer)");
        System.out.print("Choose an operation: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                for (FarmAnimal animal : animals) {
                    animal.makeSound();
                }
                break;
            case 2:
                for (FarmAnimal animal : animals) {
                    if (animal instanceof Cow) {
                        ((Cow) animal).produceMilk();
                    }
                }
                break;
            case 3:
                for (FarmAnimal animal : animals) {
                    if (animal instanceof Chicken) {
                        ((Chicken) animal).layEggs();
                    }
                }
                break;
            case 4:
                for (Crop crop : crops) {
                    crop.harvest();
                }
                break;
            case 5:
                for (Farmer farmer : farmers) {
                    farmer.tendToAnimals();
                }
                break;
            case 6:
                for (Farmer farmer : farmers) {
                    farmer.plantCrops();
                }
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }

    // FarmAnimal Class
    public static class FarmAnimal {
        private String name;
        private int age;
        private String type;

        // Constructor
        public FarmAnimal(String name, int age, String type) {
            this.name = name;
            this.age = age;
            this.type = type;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        // Method to be overridden by subclasses
        public void makeSound() {
            System.out.println("Animal sound");
        }
    }

    // Cow Class
    public static class Cow extends FarmAnimal {
        private double milkProduction;

        // Constructor
        public Cow(String name, int age, double milkProduction) {
            super(name, age, "Cow");
            this.milkProduction = milkProduction;
        }

        // Getters and setters
        public double getMilkProduction() {
            return milkProduction;
        }

        public void setMilkProduction(double milkProduction) {
            this.milkProduction = milkProduction;
        }

        // Overridden method to produce cow-specific sound
        @Override
        public void makeSound() {
            System.out.println("Moo");
        }

        // Method to simulate milk production
        public void produceMilk() {
            System.out.println(getName() + " produced " + milkProduction + " liters of milk.");
        }
    }

    // Chicken Class
    public static class Chicken extends FarmAnimal {
        private int eggProduction;

        // Constructor
        public Chicken(String name, int age, int eggProduction) {
            super(name, age, "Chicken");
            this.eggProduction = eggProduction;
        }

        // Getters and setters
        public int getEggProduction() {
            return eggProduction;
        }

        public void setEggProduction(int eggProduction) {
            this.eggProduction = eggProduction;
        }

        // Overridden method to produce chicken-specific sound
        @Override
        public void makeSound() {
            System.out.println("Cluck");
        }

        // Method to simulate egg laying
        public void layEggs() {
            System.out.println(getName() + " laid " + eggProduction + " eggs.");
        }
    }

    // Crop Class
    public static class Crop {
        private String name;
        private int quantity;
        private double pricePerUnit;

        // Constructor
        public Crop(String name, int quantity, double pricePerUnit) {
            this.name = name;
            this.quantity = quantity;
            this.pricePerUnit = pricePerUnit;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPricePerUnit() {
            return pricePerUnit;
        }

        public void setPricePerUnit(double pricePerUnit) {
            this.pricePerUnit = pricePerUnit;
        }

        // Method to simulate crop harvesting
        public void harvest() {
            System.out.println(quantity + " units of " + name + " harvested.");
        }
    }

    // Farmer Class
    public static class Farmer {
        private String name;
        private int experienceLevel;

        // Constructor
        public Farmer(String name, int experienceLevel) {
            this.name = name;
            this.experienceLevel = experienceLevel;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getExperienceLevel() {
            return experienceLevel;
        }

        public void setExperienceLevel(int experienceLevel) {
            this.experienceLevel = experienceLevel;
        }

        // Method to simulate tending to animals
        public void tendToAnimals() {
            System.out.println(name + " is tending to the animals.");
        }

        // Method to simulate planting crops
        public void plantCrops() {
            System.out.println(name + " is planting crops.");
        }
    }
}

