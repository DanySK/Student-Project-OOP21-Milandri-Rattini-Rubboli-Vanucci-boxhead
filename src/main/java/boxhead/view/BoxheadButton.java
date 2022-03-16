package boxhead.view;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;

/**
 *
 * Define generic buttons
 *
 */

public class BoxheadButton extends Button {

	private final String BUTTON_PRESSED_STYLE = "-fx-background-color: red";
	private final String BUTTON_FREE_STYLE = "-fx-background-color: red";

	public BoxheadButton(final String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(190);
		setPrefHeight(49);
		setStyle(BUTTON_FREE_STYLE);
		initializeButtonListeners();
	}

	private void setButtonFont() {
		setFont(Font.font("Arial Black", 23));

	}

	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);
	}

	private void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 4);
	}

	private void initializeButtonListeners() {

		setOnMousePressed(event -> {
			if (event.getButton().equals(MouseButton.PRIMARY)) {
				setButtonPressedStyle();
			}

		});

		setOnMouseReleased(event -> {
			if (event.getButton().equals(MouseButton.PRIMARY)) {
				setButtonReleasedStyle();
			}

		});

		setOnMouseEntered(event -> setEffect(new DropShadow()));

		setOnMouseExited(event -> setEffect(null));
	}

}