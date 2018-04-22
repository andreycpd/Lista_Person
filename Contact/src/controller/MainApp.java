package controller;


import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Pessoa;
import view.PersonOverviewController;

public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Endereço App");
		
		initRootLayout();
        showPessoaOverview();
	}
	
	/* Inicializa o root layout (layout base). */
          
    
	 public void initRootLayout() {
	        try {
	            // Carrega o rootLayout.fxml 
	          FXMLLoader loader = new FXMLLoader();	            
	            loader.setLocation(MainApp.class.getResource("/view/rootLayout.fxml"));	            
	            rootLayout = (BorderPane) loader.load();

	            // Mostra a scene (cena) contendo o root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	 /* Mostra o Pessoa overview dentro do root layout. */
	     
	    public void showPessoaOverview() {
	        try {
	            // Carrega o PessoaOverview.fxml
	            FXMLLoader loader = new FXMLLoader();	           
	            loader.setLocation(MainApp.class.getResource("/view/PersonOverview.fxml"));
	            AnchorPane PersonOverview = (AnchorPane) loader.load();

	            // Define o Pessoaoverview dentro do root layout.
	            rootLayout.setCenter(PersonOverview);
	            
	         // Dá ao controlador acesso à the main app.
	            PersonOverviewController controller = loader.getController();
	            controller.setMainApp(this);

	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    /* Retorna o palco principal.*/
	    
	    
	    public Stage getPrimaryStage() {
	        return primaryStage;
	    }
	    
	    public static void main(String[] args) {
	        launch(args);
	    }	    
	    
	    //Lista de Pessoa
	    
	    private ObservableList<Pessoa> pessoaData = FXCollections.observableArrayList();
	    
	    public MainApp() {
	        // Add some sample data
	        pessoaData.add(new Pessoa("Hans", "Muster"));
	        pessoaData.add(new Pessoa("Ruth", "Mueller"));
	        pessoaData.add(new Pessoa("Heinz", "Kurz"));
	        pessoaData.add(new Pessoa("Cornelia", "Meier"));
	        pessoaData.add(new Pessoa("Werner", "Meyer"));
	        pessoaData.add(new Pessoa("Lydia", "Kunz"));
	        pessoaData.add(new Pessoa("Anna", "Best"));
	        pessoaData.add(new Pessoa("Stefan", "Meier"));
	        pessoaData.add(new Pessoa("Martin", "Mueller"));
	    }


	    public ObservableList<Pessoa> getPessoaData() {
	        return pessoaData;
	    }


































}
