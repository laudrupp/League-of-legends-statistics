package com.ryhma10.tilastoohjelma.view;

import com.ryhma10.tilastoohjelma.MainApp;
import com.ryhma10.tilastoohjelma.model.FeedBack;
import com.ryhma10.tilastoohjelma.model.Gamedata;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * A class for the communication between individual game stage and the model
 * @author Janari
 *
 */
public class IndividualGameController {
	Gamedata gd;
	FeedBack fb;
	MainApp main;
	MainController mc;
	private MainApp mainApp;
    private Stage igstage;
	private long riotId;
	private ResourceBundle textBundle;
	
    @FXML
	private Label mr;
	@FXML 
	private Label champplayed;
	@FXML
	private Label kda;
	@FXML
	private Label gpm;
	@FXML
	private Label cs;
	@FXML
	private Label wp;
	@FXML
	private Label dd;
	@FXML
	private Label r;
	@FXML
	private Label champ1;
	@FXML
	private Label champ2;
	@FXML
	private Label champ3;
	@FXML
	private Label champ4;
	@FXML
	private Label enemy1;
	@FXML
	private Label enemy2;
	@FXML
	private Label enemy3;
	@FXML
	private Label enemy4;
	@FXML
	private Label enemy5;
	
	public IndividualGameController() {

	}
	
	/**
	 * Setter for main application
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
	/**
	 * Setter for Individual game stage
	 * @param igstage
	 */
    public void setIGStage(Stage igstage) {
        this.igstage = igstage;
    }
	
    /**
     * Method for initializing the individual game stage when it's called
     */
	public void initialize() {
		Platform.runLater(() -> {
			fb = new FeedBack(riotId);
			champplayed.setText(fb.getChamp());
			if (fb.getResult().equalsIgnoreCase("Win")) {
				mr.setText(textBundle.getString("label.win"));
			}
			else if (fb.getResult().equalsIgnoreCase("Loss")) {
				mr.setText(textBundle.getString("label.loss"));
			}
			kda.setText(fb.getKDAToString());
			gpm.setText(fb.getGPMToString());
			cs.setText(fb.getCStoString());
			wp.setText(fb.getWardsToString());
			dd.setText(fb.getDdToString());
			if (fb.getRank().equalsIgnoreCase("No Rank")) {
				r.setText(textBundle.getString("label.noRank"));
			}
			else {
				r.setText(fb.getRank());
			}
			champ1.setText(fb.getChamp1());
			champ2.setText(fb.getChamp2());
			champ3.setText(fb.getChamp3());
			champ4.setText(fb.getChamp4());
			enemy1.setText(fb.getEnemy1());
			enemy2.setText(fb.getEnemy2());
			enemy3.setText(fb.getEnemy3());
			enemy4.setText(fb.getEnemy4());
			enemy5.setText(fb.getEnemy5());
			this.mc = mainApp.getMainController();
		});
	}
	
	/**
	 * Action handler for when the "Back" button is pressed
	 */
	public void handleBack() {
		igstage.close();
	}
	
	/**
	 * Action handler for when the "Feedback" button is pressed
	 * @param event
	 * @throws IOException
	 */
	public void handleFeedback(ActionEvent event) throws IOException{
		mainApp.showFeedBackWindow(fb);
	}
	
	/**
	 * get method for the riotif used to specify the match
	 * @return the riotid
	 */
	public long getRiotId() {
		return riotId;
	}
	
	/**
	 * setter method for the riotid 
	 * @param riotId to be set
	 */
	public void setRiotId(long riotId) {
		this.riotId = riotId;
	}
	
	/**
	 * getter for the FeedBack object used to give feedback to the user
	 * @return feedback object
	 */
	public FeedBack getFb() {
		return fb;
	}
	
	/**
	 * setter for the textbundle used to print messages in finnish and english depending on the language selected
	 * @param textBundle to be used
	 */
	public void setTextBundle(ResourceBundle textBundle) {
		this.textBundle = textBundle;
	}

}
