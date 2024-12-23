package main;

public class Players {
	private boolean player;
	String name;
	
	Players(boolean player){
		nextTurn(player);
	}
	
	public boolean turn() {
		return this.player;
	}
	
	public void nextTurn(boolean player) {
		this.player = player;
	}

}
