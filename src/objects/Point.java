package objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import libraries.booster.mather.Mather;
import main.Init;
import main.Main;
import objects.model.WorldObject;


public class Point extends WorldObject {
	private float time;
	private boolean isHover;


	public Point(float x, float y, float time) {
		this.x = x;
		this.y = y;
		this.time = time;
		handler = new Rectangle(x - 5, y - 5, 11, 11);
	}


	public void toUpdate() {
		handler = new Rectangle(x - 5, y - 5, 11, 11);
		isHover = handler.intersects(Init.mouse.getPoint().getBoundsInLocal());
	}


	public void render() {
		Main.gc.setFill(Color.LIME);
		Main.gc.fillOval(x - 3, y - 3, 7, 7);
		Main.gc.setFill(Color.RED);
	}


	public void lateRender() {
		if (isHover) {
			float offsetY = -40;
			Main.gc.setFill(new Color(0.2, 0.2, 0.2, 0.95));
			Main.gc.fillRect(x + 25, y - 4 + offsetY, 200, 175);

			Main.gc.setFill(new Color(1, 1, 1, 0.85));
			Main.gc.setFont(new Font("Calibri", 18));
			Main.gc.fillText("Czas", x + 125, y + 11 + offsetY);
			Main.gc.fillRect(x + 40, y + 18 + offsetY, 170, 25);
			Main.gc.fillText("Wysokość", x + 125, y + 61 + offsetY);
			Main.gc.fillRect(x + 40, y + 68 + offsetY, 170, 25);
			Main.gc.fillText("Odległość", x + 125, y + 111 + offsetY);
			Main.gc.fillRect(x + 40, y + 118 + offsetY, 170, 25);

			Main.gc.setFill(new Color(0.2, 0.2, 0.2, 0.95));
			Main.gc.fillText(String.valueOf(Mather.round(time, 2)), x + 125, y + 36 + offsetY);
			Main.gc.fillText(String.valueOf(Mather.round((Init.groundY - y) / 20f + 3.75d, 2)), x + 125, y + 86 + offsetY);
			Main.gc.fillText(String.valueOf(Mather.round((x - 15 - Init.startPosition.x) / 20f, 2)), x + 125, y + 136 + offsetY);
		}
	}
}
