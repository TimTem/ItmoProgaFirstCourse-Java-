package Pockemons;
import Moves.*;
import ru.ifmo.se.pokemon.*;
public class Tynamo extends Pokemon {
   public Tynamo(String name, int lvl){
       setStats(35,55,40,45,40,60);
       setType(Type.ELECTRIC);
       setMove(new ThunderWave(), new ChargeBeam());
   }
}
