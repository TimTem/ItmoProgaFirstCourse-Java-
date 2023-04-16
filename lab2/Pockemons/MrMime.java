package Pockemons;
import ru.ifmo.se.pokemon.*;
import Moves.*;
public class MrMime extends MimeJr{

    public MrMime(String name, int lvl){
        super(name,lvl);
        setStats(40,45,65,100,120,90);
        setType(Type.PSYCHIC, Type.FAIRY);
        addMove(new FocusBlast());
    }
}
