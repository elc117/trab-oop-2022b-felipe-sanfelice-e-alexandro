package ch.makery.address;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ch.makery.address.model.Person;
import ch.makery.address.model.PersonListWrapper;
import ch.makery.address.view.PersonEditDialogController;
import ch.makery.address.view.PersonEditDialogController2;
import ch.makery.address.view.PersonEditDialogController3;
import ch.makery.address.view.PersonOverviewController;
import ch.makery.address.view.PersonOverviewController2;
import ch.makery.address.view.PersonOverviewController3;
import ch.makery.address.view.RootLayoutController;
import ch.makery.address.view.RootLayoutController2;
import ch.makery.address.view.RootLayoutController3;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout, rootLayout2, rootLayout3;
    private FXMLLoader loaderrl1,loaderrl2, loaderrl3;
    private Scene scene1, scene2, scene3;
    
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    private ObservableList<Person> personData2 = FXCollections.observableArrayList();
    private ObservableList<Person> personData3 = FXCollections.observableArrayList();
    
    public MainApp() {
        personData.add(new Person("..."));
        personData2.add(new Person("..."));
        personData3.add(new Person("..."));
       
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }
    
    public ObservableList<Person> getPersonData2() {
        return personData2;
    }
    
    public ObservableList<Person> getPersonData3() {
        return personData3;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("TRABALHO DE PARADGMAS");
        
        this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));

        initRootLayout("view/RootLayout.fxml");

        showPersonOverview("view/PersonOverview.fxml");
    }
    
    public void loadRootLayout() throws IOException {
        
        loaderrl1 = new FXMLLoader();
        loaderrl1.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
        rootLayout = (BorderPane) loaderrl1.load();
        
        scene1 = new Scene(rootLayout);
        primaryStage.setScene(scene1);
        RootLayoutController controller = loaderrl1.getController();
        controller.setMainApp(this);
        primaryStage.show();

        File file = getPersonFilePath();
        if (file != null) {
            
            loadPersonDataFromFile(file, "person");
        }        
        
    }
    
    public void loadRootLayout2() throws IOException {
        
        loaderrl2 = new FXMLLoader();
        loaderrl2.setLocation(MainApp.class.getResource("view/RootLayout2.fxml"));
        rootLayout2 = (BorderPane) loaderrl2.load();
        
        scene2 = new Scene(rootLayout2);
        primaryStage.setScene(scene2);
        RootLayoutController2 controller = loaderrl2.getController();
        controller.setMainApp(this);
        primaryStage.show();
        
        File file = getPersonFilePath();
        if (file != null) {
            loadPersonDataFromFile(file, "person2");
        }
       
    }
    
    public void loadRootLayout3() throws IOException {
        
        loaderrl3 = new FXMLLoader();
        loaderrl3.setLocation(MainApp.class.getResource("view/RootLayout3.fxml"));
        rootLayout3 = (BorderPane) loaderrl3.load();
        
        scene3 = new Scene(rootLayout3);
        primaryStage.setScene(scene3);
        RootLayoutController3 controller = loaderrl3.getController();
        controller.setMainApp(this);
        primaryStage.show();

        
        File file = getPersonFilePath();
        if (file != null) {
            loadPersonDataFromFile(file, "person3");
        }
        
    }

    public void initRootLayout(String caminho) {
        String name = caminho;
        try {
            loaderrl1 = new FXMLLoader();
            loaderrl1.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loaderrl1.load();
            
            loaderrl2 = new FXMLLoader();
            loaderrl2.setLocation(MainApp.class.getResource("view/RootLayout2.fxml"));
            rootLayout2 = (BorderPane) loaderrl2.load();
            
            loaderrl3 = new FXMLLoader();
            loaderrl3.setLocation(MainApp.class.getResource("view/RootLayout3.fxml"));
            rootLayout3 = (BorderPane) loaderrl3.load();

            scene1 = new Scene(rootLayout);
            primaryStage.setScene(scene1);

            RootLayoutController controller = loaderrl1.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = getPersonFilePath();
        if (file != null) {
            if(name == "view/RootLayout.fxml"){
                loadPersonDataFromFile(file, "person");
            } else if(name == "view/RootLayout2.fxml"){
                loadPersonDataFromFile(file, "person2");
            } else{
                loadPersonDataFromFile(file, "person3");
            }
        }
    }
    
    public void showPersonOverview(String Caminho) {
        if(Caminho == "view/PersonOverview.fxml"){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(Caminho));
                AnchorPane personOverview = (AnchorPane) loader.load();

                rootLayout.setCenter(personOverview);

                PersonOverviewController controller = loader.getController();
                controller.setMainApp(this);
        
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (Caminho == "view/PersonOverview2.fxml"){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(Caminho));
                AnchorPane personOverview = (AnchorPane) loader.load();
    
                rootLayout2.setCenter(personOverview);
    
                PersonOverviewController2 controller = loader.getController();
                controller.setMainApp(this);
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(Caminho));
                AnchorPane personOverview = (AnchorPane) loader.load();
    
                rootLayout3.setCenter(personOverview);
    
                PersonOverviewController3 controller = loader.getController();
                controller.setMainApp(this);
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public boolean showPersonEditDialog(Person person, String Caminho) {
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(Caminho));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Adicionar");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            if(Caminho == "view/PersonEditDialog.fxml"){
                PersonEditDialogController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setPerson(person);
                dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
            
                dialogStage.showAndWait();

                return controller.isOkClicked();

            } else if(Caminho == "view/PersonEditDialog2.fxml"){
                PersonEditDialogController2 controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setPerson(person);

                dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
                dialogStage.showAndWait();
                return controller.isOkClicked();

            } else {
                PersonEditDialogController3 controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setPerson(person);

                dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
                dialogStage.showAndWait();
                return controller.isOkClicked();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    
    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");
            primaryStage.setTitle("TRABALHO DE PARADGMAS");
        }
    }
    
    
    public void loadPersonDataFromFile(File file, String caminho) {
        try {
            JAXBContext context = JAXBContext.newInstance(PersonListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            PersonListWrapper wrapper = (PersonListWrapper) um.unmarshal(file);

            if(caminho == "person"){
                personData.clear();
                personData.addAll(wrapper.getPersons());
            } else if(caminho == "person2"){
                personData2.clear();
                personData2.addAll(wrapper.getPersons());
            } else{
                personData3.clear();
                personData3.addAll(wrapper.getPersons());
            }
            
            setPersonFilePath(file);

        } catch (Exception e) {
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error");
        	alert.setHeaderText("Could not load data");
        	alert.setContentText("Could not load data from file:\n" + file.getPath());
        	alert.showAndWait();
        }
    }
    
    public void savePersonDataToFile(File file, String caminho) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(PersonListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            PersonListWrapper wrapper = new PersonListWrapper();
            
            if(caminho ==  "person"){
                wrapper.setPersons(personData);
            } else if(caminho == "person2"){
                wrapper.setPersons(personData2);
            } else {
                wrapper.setPersons(personData3);
            }
        
            m.marshal(wrapper, file);

            setPersonFilePath(file);
        } catch (Exception e) { 
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Error");
        	alert.setHeaderText("Could not save data");
        	alert.setContentText("Could not save data to file:\n" + file.getPath());
        	
        	alert.showAndWait();
        }
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}