package main;

import javafx.scene.image.Image;


public class Render {
	public static Image backgroundImage;
	public static Image roadImage;


	public static void tick() {
		Main.gc.drawImage(backgroundImage, 0, 0, Main.screenWidth, Main.screenHeight);
		Main.gc.drawImage(roadImage, 0, 550, Main.screenWidth, 130);
		Init.pillar.render();
		Init.cannon.render();
		if (Init.ball != null)
			Init.ball.render();
		Init.startPosition.render();
		for (int i = 0; i < Init.points.size(); i++)
			Init.points.get(i).render();
		for (int i = 0; i < Init.points.size(); i++)
			Init.points.get(i).lateRender();
	}
}
