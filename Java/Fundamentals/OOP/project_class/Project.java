public class Project {
    String name;
    String description;
    double initialCost;

    public Project() {
        this.name = "Name not set yet";
        this.description = "Description not set yet";
    }
    
    public Project(String name) {
        this.name = name;
        this.description = "Description not set yet";
        this.initialCost = 0.0;
    }
    
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.initialCost = 0.0;
    }
    
    public Project(String name, String description, double initialCost) {
        this.name = name;
        this.description = description;
        this.initialCost = initialCost;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setInitialCost(double initialCost) {
        this.initialCost = initialCost;
    }

    public double getInitialCost() {
        return this.initialCost;
    }

    public String toString() {
        return this.name + "(" + this.initialCost + ")" + " : " + this.description;
    }
}