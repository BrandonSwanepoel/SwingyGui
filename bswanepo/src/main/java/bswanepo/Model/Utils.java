package bswanepo.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bswanepo.Controller.states.State;


public class Utils {
	private State gameState;
	public static ArrayList<String> loadFileAsString(InputStream in){
		ArrayList<String> file = new ArrayList<>();
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while((line = br.readLine()) != null){
				file.add(line);

			}
				
			br.close();

		}catch(IOException e){
			e.printStackTrace();
		}
		
		return file;
	}
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
	public State getGame(){
		return gameState;
	}
	public void setGame(State gameState){
		this.gameState = gameState;
	}

}
