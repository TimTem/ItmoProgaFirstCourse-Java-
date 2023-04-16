package Pockemons;
import Moves.*;
import ru.ifmo.se.pokemon.*;
public class Sigilyph extends Pokemon{
public Sigilyph(String name, int lvl){
setStats(72, 58, 80, 103, 80 ,97 );
setType(Type.PSYCHIC, Type.FLYING);
setMove(new EnergyBall(), new CalmMind(),new AncientPower(),new Psywave());
}
}
