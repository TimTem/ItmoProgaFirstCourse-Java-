package Moves;
import ru.ifmo.se.pokemon.*;
public class EnergyBall extends SpecialMove{
    public EnergyBall(){
        super(Type.GRASS, 90,100);
    }
    @Override
    protected  void applyOppEffects(Pokemon p){
        if(Math.random()<0.1){
            p.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }
    @Override
    protected String describe(){return "Использует Energy Ball";}
}
