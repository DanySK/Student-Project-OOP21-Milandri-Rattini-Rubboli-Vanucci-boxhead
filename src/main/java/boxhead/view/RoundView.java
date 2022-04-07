package boxhead.view;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class RoundView {

	private int round;
	private Label roundLabel;
	
	public RoundView(){
		this.round=1;
		this.roundLabel=new Label();
		this.roundLabel.setText(Integer.toString(this.round));
		this.roundLabel.setFont(Font.font("Corbel",20));
		this.roundLabel.setVisible(true);
	}
	
	/**
	 * Set the actual round for the view
	 * @param round
	 */
	public void setRound(final int round) {
		this.round=round;
		this.roundLabel.setText(Integer.toString(round));
	}
}
