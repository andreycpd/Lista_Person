package view;

import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Pessoa;

public class PersonOverviewController {

	@FXML
    private TableView<Pessoa> PessoaTable;
    @FXML
    private TableColumn<Pessoa, String> primeiroNomeColumn;
    @FXML
    private TableColumn<Pessoa, String> segundoNomeColumn;
    
    @FXML
    private Label primerioNomeLabel;
    @FXML
    private Label segundoNomeLabel;
    @FXML
    private Label ruaLabel;
    @FXML
    private Label cepLabel;
    @FXML
    private Label cidadeLabel;
    @FXML
    private Label aniversarioLabel;

    @SuppressWarnings("unused")
	private MainApp mainApp;
    
    // Reference to the main application. 
     //O construtor é chamado antes do método inicialize().
     
    public PersonOverviewController() {
    }

    /**
     * Inicializa a classe controller. Este método é chamado automaticamente
     *  após o arquivo fxml ter sido carregado.
     */
    @FXML
    private void initialize() {
        // Inicializa a tablea de pessoa com duas colunas. primerioNomeColumn
        primeiroNomeColumn.setCellValueFactory(cellData -> cellData.getValue().getPrimeiroNome());
        segundoNomeColumn.setCellValueFactory(cellData -> cellData.getValue().getSegundoNome());
    }

    /**
     * É chamado pela aplicação principal para dar uma referência de volta a si mesmo.
     * 
     * @param mainApp
     */
    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Adiciona os dados da observable list na tabela
        PessoaTable.setItems(mainApp.getPessoaData());
    }
	
}
