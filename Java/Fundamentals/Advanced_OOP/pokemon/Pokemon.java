/**
 * Pokemon
 */
public class Pokemon {
    private String name;
    private int health;
    private String type;

    public Pokemon(String name, int health, String type) {
        this.name = name;
        this.health = health;
        this.type = type;
    }

    void attackPokemon(Pokemon target) {
        target.health -= 10;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}