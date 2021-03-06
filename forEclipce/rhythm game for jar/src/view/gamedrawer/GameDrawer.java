package gamedrawer;

import java.util.ArrayList;

import calculater.NotePositionCalc;
import format.NoteFormat;
import format.ScoreFormat;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameDrawer {
	private Canvas gameScreen = new Canvas(800, 480);
	private GraphicsContext gc = gameScreen.getGraphicsContext2D();

	public NoteDrawer noteDrawer;
	public ScoreDrawer scoreDrawer = new ScoreDrawer(gc);
//	private Image background = new Image("file:./asset/image/background4.png");
//	private Image cover = new Image("file:./asset/image/cover2.png");
	private Image background = new Image( getClass().getClassLoader().getResourceAsStream("asset/image/background4.png") );
	private Image cover = new Image( getClass().getClassLoader().getResourceAsStream("asset/imagecover2.png") );

	public GameDrawer(NotePositionCalc npCalc) {
		noteDrawer = new NoteDrawer(gc, npCalc);
	}

	public Canvas getCanvas() {
		return this.gameScreen;
	}

	public void draw(double currentTime, ArrayList<NoteFormat> notesOnScreen, ScoreFormat score) {
		gc.drawImage(background, -0.5, -0.5, 801, 481);
		noteDrawer.draw(notesOnScreen, currentTime);
		gc.drawImage(cover, -0.5, -0.5, 801, 481);
		scoreDrawer.drawScore(score);
	}

	public GraphicsContext getGc() {
		return gc;
	}

	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}
}