package objects;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;
import libraries.booster.mather.Mather;
import main.Init;
import main.Main;


public class Settings {
	private Slider gravitationSlider, powerSlider;
	private Label gravitationLabel, powerLabel;
	private Button fireButton;


	public Settings() {
		gravitationSlider = new Slider();
		powerSlider = new Slider();
		gravitationLabel = new Label();
		powerLabel = new Label();
		fireButton = new Button("Start");

		gravitationSlider.setMin(0.1);
		gravitationSlider.setMax(30);
		gravitationSlider.setLayoutX(1600);
		gravitationSlider.setLayoutY(100);
		gravitationSlider.setPrefWidth(250);
		gravitationSlider.setValue(9.81);
		gravitationSlider.setShowTickLabels(true);
		gravitationSlider.setShowTickMarks(true);
		gravitationSlider.setMajorTickUnit(5);
		gravitationSlider.setMinorTickCount(1);
		gravitationSlider.setBlockIncrement(10);
		gravitationSlider.valueProperty().addListener((ov, old_val, new_val) -> {
			Init.gravitation = (double) new_val;
		});

		powerSlider.setMin(0);
		powerSlider.setMax(50);
		powerSlider.setLayoutX(1600);
		powerSlider.setLayoutY(200);
		powerSlider.setPrefWidth(250);
		powerSlider.setValue(17.5);
		powerSlider.setShowTickLabels(true);
		powerSlider.setShowTickMarks(true);
		powerSlider.setMajorTickUnit(50);
		powerSlider.setMinorTickCount(5);
		powerSlider.setBlockIncrement(10);
		powerSlider.valueProperty().addListener((ov, old_val, new_val) -> {
			Init.power = (double) new_val;
		});

		gravitationLabel.setLayoutX(1602);
		gravitationLabel.setLayoutY(50);
		gravitationLabel.setFont(new Font("Calibri", 26));
		gravitationLabel.setStyle("-fx-text-fill: #222222;  -fx-font-weight: bold; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");

		powerLabel.setLayoutX(1602);
		powerLabel.setLayoutY(150);
		powerLabel.setFont(new Font("Calibri", 26));
		powerLabel.setStyle("-fx-text-fill: #222222;  -fx-font-weight: bold; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");

		fireButton.setOnAction(e -> Init.cannon.fire());
		fireButton.setPadding(new Insets(15, 15, 15, 15));
		fireButton.setLayoutY(840);
		fireButton.setPrefWidth(160);
		fireButton.setLayoutX(920);
		DropShadow shadow = new DropShadow();
		fireButton.setEffect(shadow);
		fireButton.setStyle("-fx-font: 22 arial; -fx-base: #ff8800;");
		gravitationLabel.setText("Grawitacja: " + String.valueOf(Init.gravitation));
		powerLabel.setText("Prędkość: " + String.valueOf(Init.power));

		Main.root.getChildren().addAll(gravitationSlider, powerSlider, gravitationLabel, powerLabel, fireButton);
	}


	public void update() {
		gravitationLabel.setText("Grawitacja: " + String.valueOf(Mather.round(Init.gravitation, 2)));
		powerLabel.setText("Prędkość: " + String.valueOf(Mather.round(Init.power, 2)));
	}
}
