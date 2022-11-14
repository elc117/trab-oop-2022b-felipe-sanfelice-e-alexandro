
package ch.makery.address.view;

import javafx.fxml.FXML;
import java.io.File;
import javafx.stage.FileChooser;
import ch.makery.address.MainApp;
import java.io.IOException;


public class RootLayoutController3 {
    
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleNew() {
        mainApp.getPersonData3().clear();
        mainApp.setPersonFilePath(null);
    }

    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadPersonDataFromFile(file, "person3");
        }
    }

    @FXML
    private void handleSave() {
        File personFile = mainApp.getPersonFilePath();
        if (personFile != null) {
            mainApp.savePersonDataToFile(personFile, "person3");
        } else {
            handleSaveAs();
        }
    }

    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.savePersonDataToFile(file, "person3");
        }
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleMedicamento() throws IOException {
        mainApp.loadRootLayout();
        mainApp.showPersonOverview("view/PersonOverview.fxml");
    }

    @FXML
    private void handleAgua() throws IOException {
        mainApp.loadRootLayout2();
        mainApp.showPersonOverview("view/PersonOverview2.fxml");
    }

    @FXML
    private void handleComida() throws IOException {
        mainApp.loadRootLayout3();
        mainApp.showPersonOverview("view/PersonOverview3.fxml");
    }
    
}
