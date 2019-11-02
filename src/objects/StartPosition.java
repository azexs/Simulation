package objects;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import main.Init;
import main.Main;
import objects.model.WorldObject;


public class StartPosition extends WorldObject {
	public StartPosition(float width, float height) {
		x = Init.cannon.x + 55;
		y = Init.cannon.y + 60;
		this.width = width;
		this.height = height;
		image = new Image("resources/images/plus.png");
		handler = new Rectangle(x, y, width, height);
	}


	public void toUpdate() {
		x = Init.cannon.x + 55;
		y = Init.cannon.y + 60;
	}


	public void render() {
		Main.gc.drawImage(image, x + 3, y, width, height);
	}
}
