package objects;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import libraries.booster.graphics.Graphics;
import libraries.booster.mather.Mather;
import main.Init;
import main.Main;
import objects.model.WorldObject;


public class Cannon extends WorldObject {
	public boolean changeAngleActive;
	public double startX = -9999d, startY = -9999d;
	public Image originalImage;
	public int angle = 0;
	private int tempAngle = 0;


	public Cannon(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		image = new Image("resources/images/cannon.png");
		originalImage = image;
		image = Graphics.rotate(originalImage, 0);
		handler = new Rectangle(x, y, width, height);
	}


	public void onMouseIntersectAndPressed() {
		changeAngleActive = true;
	}


	public void toUpdate() {
		mouseChangeAngle();
	}


	private void mouseChangeAngle() {
		if (changeAngleActive) {
			if (startY < -9998d)
				startY = Init.mouse.getY();
			double changeY = Init.mouse.getY() - startY;
			if (Init.mouse.primaryButtonReleased) {
				changeAngleActive = false;
				startY = -9999d;
				angle = tempAngle;
				return;
			}
			tempAngle = (int) Mather.clamp(-90, 90, (float) (angle + changeY / 2));
			image = Graphics.rotate(originalImage, tempAngle);
			Init.points.clear();
			Init.ball = null;
		}
	}


	public void fire() {
		restart();
	}


	private void restart() {
		Init.points.clear();
		Init.ball = new Ball(Init.startPosition.x, Init.startPosition.y, 30, 30);
	}


	public void render() {
		Main.gc.drawImage(image, x, y, width, height);
		int offsetX = -130;
		int offsetY = -100;
		Main.gc.setFill(new Color(0, 0, 0, 0.6));
		Main.gc.fillRoundRect(x + width + offsetX, y + 51 + offsetY, 60, 36, 10, 10);
		Main.gc.setFill(Color.WHITE);
		Main.gc.setFont(new Font("Calibri", 24));
		Main.gc.setTextAlign(TextAlignment.CENTER);
		Main.gc.fillText(String.valueOf(-tempAngle), x + width + 30 + offsetX, y + 77 + offsetY);
		Main.gc.setFont(new Font("Consolas", 14));
		Main.gc.fillText("o", x + width + 52 + offsetX, y + 64 + offsetY);
	}
}
