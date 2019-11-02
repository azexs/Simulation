package objects.model;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import main.Init;
import main.Main;


public abstract class WorldObject {
	public float x, y, width, height;
	public Rectangle handler;
	public Image image;


	public void update() {
		if (handler.intersects(Init.mouse.getPoint().getBoundsInLocal())) {
			onMouseIntersectAndMove();
			if (Init.mouse.primaryButtonPressed)
				onMouseIntersectAndPressed();
		}
		this.handler = new Rectangle(x, y, width, height);
		toUpdate();
	}


	public void toUpdate() {

	}


	public void onMouseIntersectAndPressed() {

	}


	public void onMouseIntersectAndMove() {

	}


	public void render() {
		Main.gc.drawImage(image, x, y, width, height);
	}
}
