package bswanepo.Controller.textBaseGame;

import bswanepo.Launcher;
import bswanepo.View.terminalView.*;

public class Board {

   public static int mapSize;
   public static int ROWS;
   public static int COLS;
   public static final String ANSI_GREEN = "\u001B[32m";
   public static final String ANSI_RESET = "\u001B[0m";
   public static final String ANSI_WHITE = "\u001B[37m";
   public static final String ANSI_BLUE = "\u001B[34m";
   public static final String ANSI_RED = "\u001B[31m";

   public Cell[][] cells;
   public int currentRow;
public int currentCol;

   public static void getBoardRowAndCell() {
      String[] level = Launcher.handler.getPlayerInfo().getLevel().split(" ");

      mapSize = (Integer.parseInt(level[1]) - 1) * 5 + 10 - (Integer.parseInt(level[1]) % 2);
      ROWS = mapSize;
      COLS = mapSize;
   }

   public Board() {
      getBoardRowAndCell();
      cells = new Cell[ROWS][COLS];
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cells[row][col] = new Cell(row, col);
         }
      }
   }

   public void init() {
      TheView view = new TheView();
      getBoardRowAndCell();
      // Model.heroLvl = Functions.getLevel(Model.hero);
      view.gameStart(Launcher.handler.getPlayerInfo().getLevel());
      try {
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cells[row][col].clear();
         }
      }
   }

   public void paint() {
      TheView view = new TheView();
      getBoardRowAndCell();

      String line = "-";
      int i = mapSize;
      while (i-- != 0) {
         line += "---";
      }

      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cells[row][col].paint();
            if (col < COLS - 1)
               if (col == 0 || col == COLS - 2) {
                  System.out.print(ANSI_GREEN + "|" + ANSI_RESET);
               }
         }
         System.out.println();
         if (row < ROWS - 1) {
            if (row == 0 || row == ROWS - 2) {

               System.out.println(ANSI_GREEN + line + ANSI_RESET);

            }
         }
      }
      view.compass();
   }
}