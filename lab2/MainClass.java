import Pockemons.*;
import ru.ifmo.se.pokemon.*;
    public class MainClass {
    public static void main(String[] args) {
    Battle b = new Battle();
    Sigilyph p1 = new Sigilyph("Sigi", 1);
    MimeJr p2 = new MimeJr("MimeJr", 1);
    MrMime p3 = new MrMime("MrMime",1);
    Tynamo p4 = new Tynamo("Tynamo",1);
    Eelektrik p5 = new Eelektrik("Eelektrik",1);
    Eelektross p6 = new Eelektross("Eelektross",1);
    b.addAlly(p1);
    b.addAlly(p2);
    b.addAlly(p3);
    b.addFoe(p4);
    b.addFoe(p5);
    b.addFoe(p6);
    b.go();
    }
}
