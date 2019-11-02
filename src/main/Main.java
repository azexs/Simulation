package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	public static double screenWidth = 1920;
	public static double screenHeight = 900;
	public static Pane root;
	public static Stage stage;
	public static Scene scene;
	public static Canvas canvas;
	public static GraphicsContext gc;


	public static void main(String[] args) {
		launch(args);
	}


	public static void exit() {
		Platform.exit();
		System.exit(0);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new Pane();
		root.setPrefWidth(screenWidth);
		root.setPrefHeight(screenHeight);
		stageSettings(primaryStage);
		stage = primaryStage;
		primaryStage.setTitle("Simulation");
		scene = new Scene(root, screenWidth, screenHeight);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);

		primaryStage.setOnCloseRequest(event -> {
			exit();
		});
		primaryStage.show();
		mainLoop();
	}


	private void mainLoop() {
		Init.init();
		new AnimationTimer() {
			public void handle(long now) {
				Update.tick();
				Render.tick();
			}
		}.start();
	}





	private void stageSettings(Stage primaryStage) {

	}
}
