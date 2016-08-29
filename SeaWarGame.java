import java.io.IOException;


public class SeaWarGame {
	public static void main(String args[]) throws IOException{
		SeaWarGame game = new SeaWarGame();
		game.start();
	}
    
	private void start() throws IOException{
		MainWindow mw = new MainWindow();
		mw.go();
	}
}
