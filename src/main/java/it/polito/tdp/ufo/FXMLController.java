package it.polito.tdp.ufo;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.ufo.model.Model;
import it.polito.tdp.ufo.model.YearAndCount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<YearAndCount> boxAnno;

    @FXML
    private ComboBox<String> boxStato;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleAnalizza(ActionEvent event) {

    }

    @FXML
    void handleAvvistamenti(ActionEvent event) {
    	Integer s = this.boxAnno.getValue().getAnno();
    	if(s==null)
    	{
    		this.txtResult.appendText("Selezionare un anno!\n");
    		return;
    	}
    	
    	this.model.creaGrafo(s);
    	
    	this.txtResult.appendText("Vertici: "+this.model.vertexSet().size()+"\n");
    	this.txtResult.appendText("Archi: "+this.model.vertexSet().size()+"\n");
    	this.boxStato.getItems().addAll(this.model.vertexSet());
		
    	
    	

    }

    @FXML
    void handleSequenza(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert boxAnno != null : "fx:id=\"boxAnno\" was not injected: check your FXML file 'Ufo.fxml'.";
        assert boxStato != null : "fx:id=\"boxStato\" was not injected: check your FXML file 'Ufo.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Ufo.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		if(this.model.getYearsAndCount()==null)
		{
			this.txtResult.appendText("Errore lettura anni\n");
			return;
		}
		this.boxAnno.getItems().addAll(this.model.getYearsAndCount());
	}
}
