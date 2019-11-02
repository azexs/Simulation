package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import objects.*;

import java.util.LinkedList;


public class Init {
	public static final float groundY = 542;
	public static Cannon cannon;
	public static Pillar pillar;
	public static Ball ball;
	public static StartPosition startPosition;
	public static LinkedList<Point> points = new LinkedList<>();
	public static Mouse mouse;
	public static Settings settings;
	public static double gravitation = 9.81d;
	public static double power = 10d;


	public static void init() {
		Main.canvas = new Canvas(Main.screenWidth, Main.screenHeight);
		Main.gc = Main.canvas.getGraphicsContext2D();
		Main.root.getChildren().add(Main.canvas);
		Render.backgroundImage = new Image("resources/images/background.png");
		Render.roadImage = new Image("resources/images/road.jpg");

		cannon = new Cannon(195, 385, 160, 130);
		pillar = new Pillar(120, 400, 300);
		startPosition = new StartPosition(30, 30);
		settings = new Settings();
		mouse = new Mouse();
	}
}
