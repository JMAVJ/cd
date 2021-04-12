public class Project {
    String name;
    String description;

    public Project() {
        this.name = "Name not set yet";
        this.description = "Description not set yet";
    }
    
    public Project(String name) {
        this.name = name;
        this.description = "Description not set yet";
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        
    }
}