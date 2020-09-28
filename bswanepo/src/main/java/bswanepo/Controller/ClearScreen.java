package bswanepo.Controller;

public class ClearScreen {
    public ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
