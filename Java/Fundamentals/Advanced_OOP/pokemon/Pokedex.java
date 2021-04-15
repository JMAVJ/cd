public class Pokedex extends AbstractPokemon {
    private int myPokemons;

    public void listPokemon() {
        for (Pokemon pokemon : getPokemons()) {
            System.out.println(pokemonInfo(pokemon));
        }
    }

    public int getMyPokemons() {
        this.myPokemons = getPokemons().size();
        return this.myPokemons;
    }
}