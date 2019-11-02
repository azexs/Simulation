package main;

import javafx.scene.shape.Rectangle;


public class Mouse {
	public boolean primaryButtonClicked, primaryButtonPressed, primaryButtonReleased;
	private double x, y;
	private Rectangle point = new Rectangle();


	public Mouse() {

		Main.scene.setOnMouseMoved(event -> {
			x = event.getX();
			y = event.getY();
			point = new Rectangle(x, y, 1, 1);
		});
		Main.scene.setOnMouseClicked(event -> primaryButtonClicked = true);
		Main.scene.setOnMousePressed(event -> {
			primaryButtonPressed = true;
		});
		Main.scene.setOnMouseDragged(event -> {
			x = event.getX();
			y = event.getY();
		});
		Main.scene.setOnMouseReleased(event -> primaryButtonReleased = true);
	}


	public void clearFlags() {
		primaryButtonClicked = false;
		primaryButtonPressed = false;
		primaryButtonReleased = false;
	}


	public double getX() {
		return x;
	}


	public double getY() {
		return y;
	}


	public Rectangle getPoint() {
		return point;
	}
}
