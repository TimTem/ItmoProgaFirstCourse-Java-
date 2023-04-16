package Moves;
import ru.ifmo.se.pokemon.*;
public class FocusBlast extends SpecialMove{
    public FocusBlast(){
        super(Type.FIGHTING, 120,70);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        if(Math.random()<0.1){
            p.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }
    @Override
    protected String describe(){return "Использует Focus Blast";}
}
