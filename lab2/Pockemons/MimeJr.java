package Pockemons;
import Moves.*;
import ru.ifmo.se.pokemon.*;
public class MimeJr extends Pokemon{
    public MimeJr(String name, int lvl){
        setStats(20, 25,45,70,90,60);
        setType(Type.PSYCHIC, Type.FAIRY);
        setMove(new ThunderWave(), new Thunderbolt(),new Meditate());
    }
}
