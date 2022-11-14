package ch.makery.address.model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Person {

    private final StringProperty Nome;
    private final StringProperty Dose;
    private final StringProperty Horario;
    private final StringProperty Refeicao;
    private final StringProperty Cardapio;

    public Person() {
        this(null);
    }

    public Person(String Nome) {
        this.Nome = new SimpleStringProperty(Nome);
        this.Dose = new SimpleStringProperty("...");
        this.Horario = new SimpleStringProperty("...");
        this.Refeicao = new SimpleStringProperty("...");
        this.Cardapio = new SimpleStringProperty("...");
    }

    public String getNome() {
        return Nome.get();
    }

    public void setNome(String Nome) {
        this.Nome.set(Nome);
    }

    public StringProperty NomeProperty() {
        return Nome;
    }

    public String getDose() {
        return Dose.get();
    }

    public void setDose(String Dose) {
        this.Dose.set(Dose);
    }

    public StringProperty DoseProperty() {
        return Dose;
    }

    public String getHorario() {
        return Horario.get();
    }

    public void setHorario(String Horario) {
        this.Horario.set(Horario);
    }

    public StringProperty HorarioProperty() {
        return Horario;
    }

    public String getRefeicao() {
        return Refeicao.get();
    }

    public void setRefeicao(String Refeicao) {
        this.Refeicao.set(Refeicao);
    }

    public StringProperty RefeicaoProperty() {
        return Refeicao;
    }

    public String getCardapio() {
        return Cardapio.get();
    }

    public void setCardapio(String Cardapio) {
        this.Cardapio.set(Cardapio);
    }

    public StringProperty CardapioProperty() {
        return Cardapio;
    }
}