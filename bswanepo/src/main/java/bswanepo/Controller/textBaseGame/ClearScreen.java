package bswanepo.Controller.textBaseGame;

public class ClearScreen {
    public ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
