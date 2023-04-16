package Pockemons;
import Moves.*;
import ru.ifmo.se.pokemon.*;
public class Eelektross extends Eelektrik {
    public Eelektross(String name,int lvl){
        super(name,lvl);
        setStats(85,115,80,105,80,50);
        setType(Type.ELECTRIC);
        addMove(new DoubleTeam());
    }
}
