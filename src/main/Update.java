package main;

public class Update {
	public static void tick() {
		Init.cannon.update();
		Init.pillar.update();
		if (Init.ball != null)
			Init.ball.update();
		Init.startPosition.update();
		Init.mouse.clearFlags();
		for (int i = 0; i < Init.points.size(); i++)
			Init.points.get(i).update();
		Init.settings.update();
	}
}
