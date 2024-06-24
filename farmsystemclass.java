import java.util.ArrayList;
import java.util.Scanner;

public class FarmingSystem {
    private static ArrayList<FarmAnimal> animals = new ArrayList<>();
    private static ArrayList<Crop> crops = new ArrayList<>();
    private static ArrayList<Farmer> farmers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

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

    private static void addAnimal(Scanner scanner) {
        System.out.print("Enter animal type (Cow/Chicken): ");
        String type = scanner.next();
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();

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

    private static void addCrop(Scanner scanner) {
        System.out.print("Enter crop name: ");
        String name = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price per unit: ");
        double pricePerUnit = scanner.nextDouble();
        crops.add(new Crop(name, quantity, pricePerUnit));
    }

    private static void addFarmer(Scanner scanner) {
        System.out.print("Enter farmer name: ");
        String name = scanner.next();
        System.out.print("Enter experience level: ");
        int experienceLevel = scanner.nextInt();
        farmers.add(new Farmer(name, experienceLevel));
    }

    private static void displayAnimals() {
        for (FarmAnimal animal : animals) {
            System.out.println(animal.getType() + ": " + animal.getName() + ", Age: " + animal.getAge());
        }
    }

    private static void displayCrops() {
        for (Crop crop : crops) {
            System.out.println("Crop: " + crop.getName() + ", Quantity: " + crop.getQuantity() + ", Price per unit: " + crop.getPricePerUnit());
        }
    }

    private static void displayFarmers() {
        for (Farmer farmer : farmers) {
            System.out.println("Farmer: " + farmer.getName() + ", Experience Level: " + farmer.getExperienceLevel());
        }
    }

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
}
