public static class Chicken extends FarmAnimal {
    private int eggProduction;

    public Chicken(String name, int age, int eggProduction) {
        super(name, age, "Chicken");
        this.eggProduction = eggProduction;
    }

    public int getEggProduction() {
        return eggProduction;
    }

    public void setEggProduction(int eggProduction) {
        this.eggProduction = eggProduction;
    }

    @Override
    public void makeSound() {
        System.out.println("Cluck");
    }

    public void layEggs() {
        System.out.println(getName() + " laid " + eggProduction + " eggs.");
    }
}
