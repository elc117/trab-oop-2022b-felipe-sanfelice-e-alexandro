package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController3 {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> RefeicaoColumn;
    @FXML
    private Label RefeicaoLabel;
    @FXML
    private Label CardapioLabel;
    @FXML
    private Label HorarioLabel;

    private MainApp mainApp;

    public PersonOverviewController3() {
    }

    @FXML
    private void initialize() {
        RefeicaoColumn.setCellValueFactory(cellData -> cellData.getValue().RefeicaoProperty());        
        showPersonDetails(null);

        personTable.getSelectionModel().selectedItemProperty().addListener(
(observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

   
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        personTable.setItems(mainApp.getPersonData3());
    }
    
    private void showPersonDetails(Person person) {
        if (person != null) {
            RefeicaoLabel.setText(person.getRefeicao());
            CardapioLabel.setText(person.getCardapio());
            HorarioLabel.setText(person.getHorario());
        } else {
            RefeicaoLabel.setText("");
            CardapioLabel.setText("");
            HorarioLabel.setText("");
        }
    }
   
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            
            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson, "view/PersonEditDialog3.fxml");
        if (okClicked) {
            mainApp.getPersonData3().add(tempPerson);
        }
    }

    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson, "view/PersonEditDialog3.fxml");
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            
            alert.showAndWait();
        }
    }
}
