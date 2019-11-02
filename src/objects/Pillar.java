package objects;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import libraries.booster.mather.Mather;
import main.Init;
import main.Main;
import objects.model.WorldObject;


public class Pillar extends WorldObject {
	public boolean changeHeightActive;
	public double startX = -9999d, startY = -9999d;
	public int heightInMeters = 10;
	private int tempHeightInMeters = 10;


	public Pillar(float x, float y, float width) {
		this.x = x;
		this.y = y;
		this.width = width;
		image = new Image("resources/images/cylinder.png");
		this.height = (float) image.getHeight();
		handler = new Rectangle(x, y, width, height);
		setHeightInMeters(heightInMeters);
	}


	public void setHeightInMeters(int meters) {
		y = Init.groundY - meters * 20;
		Init.cannon.y = y;
	}


	public void onMouseIntersectAndPressed() {
		changeHeightActive = true;
	}


	public void toUpdate() {
		mouseChangeHeight();
	}


	private void mouseChangeHeight() {
		if (Init.cannon.changeAngleActive)
			changeHeightActive = false;
		if (changeHeightActive) {
			if (startY < -9998d)
				startY = Init.mouse.getY();
			double changeY = Init.mouse.getY() - startY;
			if (Init.mouse.primaryButtonReleased) {
				changeHeightActive = false;
				startY = -9999d;
				heightInMeters = tempHeightInMeters;
				return;
			}
			tempHeightInMeters = (int) Mather.clamp(0, 20, (float) (heightInMeters - changeY / 20));
			setHeightInMeters(tempHeightInMeters);
		}
	}


	public void render() {
		Main.gc.drawImage(image, x, y, width, height);
		int offsetX = -330;
		int offsetY = 20;
		Main.gc.setFill(new Color(0, 0, 0, 0.6));
		Main.gc.fillRoundRect(x + width + 3 + offsetX, y + 51 + offsetY, 54, 36, 10, 10);
		Main.gc.setFill(Color.WHITE);
		Main.gc.setFont(new Font("Consolas", 24));
		Main.gc.setTextAlign(TextAlignment.CENTER);
		Main.gc.fillText(String.valueOf(tempHeightInMeters), x + width + 30 + offsetX, y + 77 + offsetY);
	}
}
