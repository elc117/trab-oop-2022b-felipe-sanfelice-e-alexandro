package ch.makery.address.view;

import ch.makery.address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController3 {

    @FXML
    private TextField RefeicaoField;
    @FXML
    private TextField CardapioField;
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

        RefeicaoField.setText(person.getRefeicao());
        CardapioField.setText(person.getCardapio());
        HorarioField.setText(person.getHorario());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setRefeicao(RefeicaoField.getText());
            person.setCardapio(CardapioField.getText());
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

        if (RefeicaoField.getText() == null || RefeicaoField.getText().length() == 0) {
            errorMessage += "No valid Refeicao!\n"; 
        }
        if (CardapioField.getText() == null || CardapioField.getText().length() == 0) {
            errorMessage += "No valid Cardapio!\n"; 
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