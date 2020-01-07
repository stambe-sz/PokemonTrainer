import java.util.*;

public class Trainer {
    private String name;
    private int badges;
    private Map<String,List<Pokemon>> pokemons;


    public Trainer (String name){
        this.name = name;
        this.badges = 0;
        this.setPokemons();

    }

    private void setPokemons() {
        this.pokemons = new HashMap<>();
        this.pokemons.put("Fire",new ArrayList<>());
        this.pokemons.put("Water",new ArrayList<>());
        this.pokemons.put("Electricity",new ArrayList<>());
    }
    public int getBadges(){
        return this.badges;
    }

    public String getName() {
        return this.name;
    }
    public String setName(String name){
        return this.name = name;
    }


    public void addPokemon(Pokemon pokemon) {
        this.pokemons.putIfAbsent(pokemon.getElement(),new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);
    }

    public boolean hasElementType(String element) {
        return !pokemons.get(element).isEmpty();
    }

    public int increseBadges(int i) {

        return this.badges += i;
    }

    public void damegePokemons(int damege) {
        for (List<Pokemon> value : pokemons.values()) {
            for (Pokemon pokemon : value) {
                pokemon.takeDamage(damege);
            }
        }
        this.clearDeadPokemons();
    }
    private void clearDeadPokemons(){
        for (List<Pokemon> value : pokemons.values()) {
            value.removeIf(p -> p.getHealth() <=0);
        }
    }
    public int getPokemonCount(){

        int size = 0;
        for (List<Pokemon> value : pokemons.values()) {
            size += value.size();
        }
        return size;
    }

    @Override
    public String toString(){
        return String.format("%s %d %d",this.name,this.badges,this.getPokemonCount());
    }
}
