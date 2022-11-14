package ch.makery.address.view;

import ch.makery.address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {

    @FXML
    private TextField NomeField;
    @FXML
    private TextField DoseField;
    @FXML
    private TextField HorarioField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Person person) {
        this.person = person;

        NomeField.setText(person.getNome());
        DoseField.setText(person.getDose());
        HorarioField.setText(person.getHorario());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setNome(NomeField.getText());
            person.setDose(DoseField.getText());
            person.setHorario(HorarioField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (NomeField.getText() == null || NomeField.getText().length() == 0) {
            errorMessage += "No valid Nome!\n"; 
        }
        if (DoseField.getText() == null || DoseField.getText().length() == 0) {
            errorMessage += "No valid Dose!\n"; 
        }

        if (HorarioField.getText() == null || HorarioField.getText().length() == 0) {
            errorMessage += "No valid Horario!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}