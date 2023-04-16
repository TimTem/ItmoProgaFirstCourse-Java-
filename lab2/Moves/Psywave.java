package Moves;
import ru.ifmo.se.pokemon.*;
public class Psywave extends SpecialMove{
    public Psywave(){
        super(Type.PSYCHIC,0,100);
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        double a = 0.5 + (Math.random());
        a*=p.getStat(Stat.ATTACK);
        int b = (int) a;
        p.setMod(Stat.ATTACK,b);
    }
    @Override
    protected String describe(){return "Использует Psywave";}
}
