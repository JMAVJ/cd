import java.util.ArrayList;

/**
 * AbstractPokemon
 */
public abstract class AbstractPokemon implements PokemonInterface {
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public Pokemon createPokemon(String name, int health, String type) {
        Pokemon pokemon = new Pokemon(name, health, type);
        this.pokemons.add(pokemon);
        return pokemon;
    }

    public String pokemonInfo(Pokemon pokemon) {
        String info = "<Pokemon [" + pokemon.getName() + "] Health: " + pokemon.getHealth() + " Type: " + pokemon.getType() + ">";
        return info;
    }

    public ArrayList<Pokemon> getPokemons() {
        return this.pokemons;
    }
}