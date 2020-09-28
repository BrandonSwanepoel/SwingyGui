package bswanepo.Model;

import java.io.IOException;
import java.util.ArrayList;

public interface Actionable{
    public String[] fight(ArrayList<String> villain,ArrayList<String> hero);
    public boolean run();
    public String levelUp(String heroName) throws IOException;
    public String gainedXp(String xp, String heroName);
    public String nextLevel(ArrayList<String> hero);
    public String[] pickedUpArtefact(ArrayList<String> artefact,String heroName);
    
}