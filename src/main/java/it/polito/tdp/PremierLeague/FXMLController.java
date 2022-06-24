/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.PremierLeague;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.PremierLeague.model.Avversari;
import it.polito.tdp.PremierLeague.model.Model;
import it.polito.tdp.PremierLeague.model.TopPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCreaGrafo"
    private Button btnCreaGrafo; // Value injected by FXMLLoader

    @FXML // fx:id="btnTopPlayer"
    private Button btnTopPlayer; // Value injected by FXMLLoader

    @FXML // fx:id="btnDreamTeam"
    private Button btnDreamTeam; // Value injected by FXMLLoader

    @FXML // fx:id="txtK"
    private TextField txtK; // Value injected by FXMLLoader

    @FXML // fx:id="txtGoals"
    private TextField txtGoals; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	txtResult.clear();
    	String goal=this.txtGoals.getText();
    	double goals=0.0;
    	if(goal.length()==0) {
    		txtResult.appendText("Inserisci un valore numerico per la ricerca");
    		return;
    	}
    	try {
    		goals=Double.parseDouble(goal);
    	}catch(NumberFormatException n) {
    		throw new NumberFormatException("Inserisci un valore numerico nella txtGoals");
    	}
    	this.model.creaGrafo(goals);
    	txtResult.appendText("GRAFO CREATO \n");
    	txtResult.appendText("Numero vertici : "+this.model.nVertici()+"\n");
    	txtResult.appendText("Numero archi : "+this.model.nArchi());
    	
    }

    @FXML
    void doDreamTeam(ActionEvent event) {

    }

    @FXML
    void doTopPlayer(ActionEvent event) {
    	txtResult.clear();
    	TopPlayer top= this.model.getTopPlayer();
    	txtResult.appendText("Giocatore Migliore : "+top.toString()+"\n");
    	txtResult.appendText("\n");
    	txtResult.appendText("Lista dei giocatori sconfitti: \n");
    	for(Avversari a : top.getAvversari()) {
    		txtResult.appendText(a.toString()+"\n");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTopPlayer != null : "fx:id=\"btnTopPlayer\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDreamTeam != null : "fx:id=\"btnDreamTeam\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtGoals != null : "fx:id=\"txtGoals\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
