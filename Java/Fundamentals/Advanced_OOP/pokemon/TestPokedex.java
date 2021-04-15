/**
 * TestPokedex
 */
public class TestPokedex {
    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();
        Pokemon pk1 = pokedex.createPokemon("Pokemon1", 100, "type1");
        Pokemon pk2 = pokedex.createPokemon("Pokemon2", 100, "type2");
        Pokemon pk3 = pokedex.createPokemon("Pokemon3", 100, "type3");
        System.out.println(pokedex.pokemonInfo(pk1));
        pk1.attackPokemon(pk2);
        System.out.println(pk2.getHealth());
        System.out.println(pk3.getHealth());
        pokedex.listPokemon();
    }
}