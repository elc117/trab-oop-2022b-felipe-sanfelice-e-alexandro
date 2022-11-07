import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class AppController implements Initializable {
    @FXML
    private TableView<Cliente> tabela;
    @FXML
    private TableColumn<Cliente, Boolean> selectCol;
    @FXML
    private TableColumn<Cliente, String> nomeCol;
    @FXML
    private TableColumn<Cliente, String> doseCol;
    @FXML
    private TableColumn<Cliente, String> horarioCol;

    @FXML private TableColumn<Cliente, Cliente> columnEdit;
    @FXML private TableColumn<Cliente, Cliente> columnDelete;

    public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
    public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectCol.setCellValueFactory(
                new PropertyValueFactory<>("selected"));
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        doseCol.setCellValueFactory(
                new PropertyValueFactory<>("dose"));
        horarioCol.setCellValueFactory(
                new PropertyValueFactory<>("horario"));

        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectCol));

        nomeCol.setCellFactory(TextFieldTableCell.forTableColumn());

        tabela.setItems(listaDeClientes());

        Utils.initButtons(columnEdit, 15, PEN_SOLID, "svg-gray", (Cliente Cliente, ActionEvent event) -> {
            System.out.println("Você clicou para editar as informações de: " + Cliente.getNome());
        });

        Utils.initButtons(columnDelete, 15, TRASH_SOLID, "svg-red", (Cliente Cliente, ActionEvent event) -> {
            System.out.println("Você clicou para deletar as informações de: " + Cliente.getNome());
            
        });

    }

    private ObservableList<Cliente> listaDeClientes() {
        return FXCollections.observableArrayList(
                new Cliente("Paracetamol", "1 comprimido", "08:00"),
                new Cliente("Dipirona", "1 comprimido", "08:00")
             
        );

    }

    

    public static class Cliente {
        private final SimpleBooleanProperty selected;
        private final SimpleStringProperty nome;
        private final SimpleStringProperty dose;
        private final SimpleStringProperty horario;
    
        public Cliente(String nome, String dose, String horario) {
            this.selected = new SimpleBooleanProperty(false);
            this.nome = new SimpleStringProperty(nome);
            this.dose = new SimpleStringProperty(dose);
            this.horario = new SimpleStringProperty(horario);
           
        }
    
        public boolean isSelected() {
            return selected.get();
        }
    
        public SimpleBooleanProperty selectedProperty() {
            return selected;
        }
    
        public void setSelected(boolean selected) {
            this.selected.set(selected);
        }
    
        public String getNome() {
            return nome.get();
        }
    
        public SimpleStringProperty nomeProperty() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome.set(nome);
        }
    
        public String getDose() {
            return dose.get();
        }
    
        public SimpleStringProperty doseProperty() {
            return dose;
        }
    
        public void setDose(String dose) {
            this.dose.set(dose);
        }
        
        public String getHorario() {
            return horario.get();
        }
    
        public SimpleStringProperty horarioProperty() {
            return horario;
        }
    
        public void setHorario(String horario) {
            this.horario.set(horario);
        }
    
    }

}
