package objects;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.Init;
import main.Main;
import objects.model.WorldObject;


public class Ball extends WorldObject {
	public boolean isFinish;
	public double startX, startY;
	public boolean showVectors = true;
	public double vectorX, vectorY;
	public double offsetX, offsetY;
	private long startTime;
	private double speed = 4d;


	public Ball(float x, float y, float width, float height) {
		startTime = System.currentTimeMillis();
		this.x = x;
		this.y = y;
		startX = x;
		startY = y;
		this.width = width;
		this.height = height;
		image = new Image("resources/images/ball.png");
		handler = new Rectangle(x, y, width, height);
	}


	public void toUpdate() {
		if (!isFinish) {
			if (System.currentTimeMillis() - startTime > Init.points.size() * 100) {
				System.out.println(Init.points.size() + " " + getOffsetYValue((float)Init.points.size() / 10f * 4f));
				double offsetY = getOffsetYValue(Init.points.size() / 10f * 4f);
				double offsetX = getOffsetXValue(Init.points.size() / 10f * 4f);
				Init.points.add(new Point((float) (startX + offsetX + 15), (float) (startY - offsetY + 15), Init.points.size() / 10f));
			}
			movement();
			finishListener();
		}
	}

	private void movement() {
		double time = (double) (System.currentTimeMillis() - startTime);
		time /= 1000d / speed;

		offsetY = getOffsetYValue(time);
		offsetX = getOffsetXValue(time);

		y = (float) (startY - offsetY);
		x = (float) (startX + offsetX);
	}


	private void finishListener() {
		if (y >= Init.groundY + 57 && Init.points.size() > 3)
			endSimulation();
	}


	private void endSimulation() {
		isFinish = true;
		Init.points.add(new Point(x + 15, y + 15, (float) (System.currentTimeMillis() - startTime) / 1000f));
	}





	private double getOffsetYValue(double time) {
		offsetY = (-(Init.gravitation * 1.25) * Math.pow(time, 2)) / 2d;
		offsetY += Init.power * Math.sin(-Math.toRadians(Init.cannon.angle)) * time * 5f;
		return offsetY;
	}


	private double getOffsetXValue(double time) {
		return Init.power * Math.cos(-Math.toRadians(Init.cannon.angle)) * time * 5d;
	}


	public void render() {
		Main.gc.drawImage(image, x, y, width, height);
		renderPointsLines();
		if (!isFinish)
			renderVectors();
	}


	private void renderPointsLines() {
		if (Init.points.size() >= 2) {
			Main.gc.beginPath();
			Main.gc.setLineWidth(3d);
			Main.gc.setStroke(Color.GREEN);
			Main.gc.moveTo(Init.points.get(0).x, Init.points.get(0).y);
			for (int i = 1; i < Init.points.size(); i++) {
				Point point = Init.points.get(i);
				Main.gc.lineTo(point.x, point.y);
			}
			Main.gc.stroke();
		}
	}


	private void renderVectors() {
		Main.gc.beginPath();
		Main.gc.setLineWidth(4d);
		Main.gc.setStroke(new Color(1, 1, 1, 0.8));
		Main.gc.moveTo(x + 15, y + 15);

		double time = (double) (System.currentTimeMillis() - startTime);
		time /= 1000d / speed;
		time += 0.1;
		double vectorY = offsetY - getOffsetYValue(time);

		Main.gc.lineTo(x + 15, y + 15 - vectorY * -15);
		Main.gc.moveTo(x + 15, y + 15);
		double vectorX = offsetX - getOffsetXValue(time);
		Main.gc.lineTo(x + 15 + vectorX * -15, y + 15);
		Main.gc.stroke();
	}
}
