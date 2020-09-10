package bswanepo.textBase;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        
        LobbyController lobbyController = new LobbyController();
        lobbyController.startScreen();
        lobbyController.startOrEndGame();
    }
}