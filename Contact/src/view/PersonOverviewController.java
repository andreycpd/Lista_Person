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
	// O construtor � chamado antes do m�todo inicialize().

	public PersonOverviewController() {
	}

	/**
	 * Inicializa a classe controller. Este m�todo � chamado automaticamente ap�s o
	 * arquivo fxml ter sido carregado.
	 */
	@FXML
	private void initialize() {
		// Inicializa a tablea de pessoa com duas colunas. primerioNomeColumn
		primeiroNomeColumn.setCellValueFactory(cellData -> cellData.getValue().getPrimeiroNome());
		segundoNomeColumn.setCellValueFactory(cellData -> cellData.getValue().getSegundoNome());
		

	    // Limpa os detalhes da pessoa.
	    showPersonDetails(null);

	    // Detecta mudan�as de sele��o e mostra os detalhes da pessoa quando houver mudan�a.
	    PessoaTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showPersonDetails(newValue));
		
	}

	/**
	 * � chamado pela aplica��o principal para dar uma refer�ncia de volta a si
	 * mesmo.
	 * 
	 * @param mainApp
	 */

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Adiciona os dados da observable list na tabela
		PessoaTable.setItems(mainApp.getPessoaData());
	}

	@SuppressWarnings("unused")
	private void showPersonDetails(Pessoa pessoa) {
		if (pessoa != null) {
			primerioNomeLabel.setText(pessoa.getPrimeiroNome().toString());
			segundoNomeLabel.setText(pessoa.getSegundoNome().toString());
			ruaLabel.setText(pessoa.getRua().toString());
			cepLabel.setText(pessoa.getCep().toString());
			cidadeLabel.setText(pessoa.getCidade().toString());
			//
		} else {
			primerioNomeLabel.setText("");
			segundoNomeLabel.setText("");
			ruaLabel.setText("");
			cepLabel.setText("");
			cidadeLabel.setText("");
		  //aniversarioLabel.setText(DateUtil.format(String.valueOf(pessoa.getAniversario())));
		}

	}
	
	/**
	 * Chamado quando o usu�rio clica no bot�o delete.
	 */
	@FXML
	private void handleDeletePerson() {
	    int selectedIndex = PessoaTable.getSelectionModel().getSelectedIndex();
	    PessoaTable.getItems().remove(selectedIndex);
	}

}
