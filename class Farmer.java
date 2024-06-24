public static class Farmer {
    private String name;
    private int experienceLevel;

    public Farmer(String name, int experienceLevel) {
        this.name = name;
        this.experienceLevel = experienceLevel;
    }

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

    public void tendToAnimals() {
        System.out.println(name + " is tending to the animals.");
    }

    public void plantCrops() {
        System.out.println(name + " is planting crops.");
    }
}
