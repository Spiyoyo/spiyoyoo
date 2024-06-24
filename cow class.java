public static class Cow extends FarmAnimal {
    private double milkProduction;

    public Cow(String name, int age, double milkProduction) {
        super(name, age, "Cow");
        this.milkProduction = milkProduction;
    }

    public double getMilkProduction() {
        return milkProduction;
    }

    public void setMilkProduction(double milkProduction) {
        this.milkProduction = milkProduction;
    }

    @Override
    public void makeSound() {
        System.out.println("Moo");
    }

    public void produceMilk() {
        System.out.println(getName() + " produced " + milkProduction + " liters of milk.");
    }
}
