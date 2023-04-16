package Pockemons;
import Moves.*;
import ru.ifmo.se.pokemon.*;
public class Eelektrik extends Tynamo {
    public Eelektrik(String name, int lvl){
        super(name,lvl);
        setStats(65,85,70,75,70,40);
        setType(Type.ELECTRIC);
        addMove(new Spark());
    }

}
