package model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {	

	    private final StringProperty primeiroNome;
	    private final StringProperty segundoNome;
	    private final StringProperty rua;
	    private final IntegerProperty cep;
	    private final StringProperty cidade;
	    private final ObjectProperty<LocalDate> aniversario;

	    
	    public Pessoa(String primeiroNome, String segundoNome) {
			this.primeiroNome = new SimpleStringProperty(primeiroNome);
			this.segundoNome = new SimpleStringProperty(segundoNome);
			this.rua = new SimpleStringProperty("Rua teste");
			this.cep = new SimpleIntegerProperty(1234);			
			this.cidade = new SimpleStringProperty("Goiania");
			this.aniversario = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
		}
	    	    
	 
		/**
	     *  Construtor padrão.
	     */
	    public Pessoa() {
	        this(null, null);
	    }
	
	    
	    //GETERS E SETERS
	    
	    
	    public StringProperty getPrimeiroNome() {
			return primeiroNome;
		}

		public StringProperty getSegundoNome() {
			return segundoNome;
		}

		public StringProperty getRua() {
			return rua;
		}

		public IntegerProperty getCep() {
			return cep;
		}

		public StringProperty getCidade() {
			return cidade;
		}

		public ObjectProperty<LocalDate> getAniversario() {
			return aniversario;
		}
	    
}
