import java.util.ArrayList;
import java.util.Scanner;

public class FarmingSystem {
    private static ArrayList<FarmAnimal> animals = new ArrayList<>();
    private static ArrayList<Crop> crops = new ArrayList<>();
    private static ArrayList<Farmer> farmers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Farming System Menu:");
            System.out.println("1. Add Animal");
            System.out.println("2. View Animals");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    viewAnimals();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addAnimal() {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter animal age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter animal type: ");
        String type = scanner.nextLine();

        FarmAnimal animal = new FarmAnimal(name, age, type);
        animals.add(animal);
        System.out.println("Animal added successfully.");
    }

    private static void viewAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the system.");
        } else {
            System.out.println("List of animals:");
            for (FarmAnimal animal : animals) {
                System.out.println("Name: " + animal.getName() + ", Age: " + animal.getAge() + ", Type: " + animal.getType());
            }
        }
    }

    public static class FarmAnimal {
        private String name;
        private int age;
        private String type;

        public FarmAnimal(String name, int age, String type) {
            this.name = name;
            this.age = age;
            this.type = type;
        }

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

        public void makeSound() {
            System.out.println("Animal sound");
        }
    }

    public static class Crop {
        private String name;
        private int growthTime;

        public Crop(String name, int growthTime) {
            this.name = name;
            this.growthTime = growthTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGrowthTime() {
            return growthTime;
        }

        public void setGrowthTime(int growthTime) {
            this.growthTime = growthTime;
        }
    }

    public static class Farmer {
        private String name;
        private int experience;

        public Farmer(String name, int experience) {
            this.name = name;
            this.experience = experience;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }
    }
}
