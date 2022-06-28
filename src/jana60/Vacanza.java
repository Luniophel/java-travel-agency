package jana60;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Vacanza {
		
	DateTimeFormatter dataIT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	//ATTRIBUTI
	//Variabili del costruttore Vacanza
	private String destinazione;
	private LocalDate dataInizio, dataFine;
	//Variabili dei metodi
	public static final LocalDate dataOggi = LocalDate.now();
	
	//COSTRUTTORI
	public Vacanza(String destinazione, LocalDate dataInizio, LocalDate dataFine) throws Exception
	{
		boolean datiValidi = true;
		String mexErrore = "";
		
		//Validazione data d'inizio
		try
		{
			validaDataInizio(dataInizio);
			validaDataFine(dataFine);
			validaDataInizioFine(dataInizio, dataFine);
		} 
		catch (IllegalArgumentException iae)
		{
			datiValidi = false;
			mexErrore += " " + iae.getMessage();
		}
		catch (NullPointerException npe)
		{
			datiValidi = false;
			mexErrore += " " + npe.getMessage();
		}	
		
		if (datiValidi) {
			this.destinazione = destinazione;
			this.dataInizio = dataInizio;
			this.dataFine = dataFine;
		}
		else
			throw new Exception(mexErrore);
	}

	//GETTER / SETTERS
	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) throws Exception {
		boolean datiValidi = true;
		String mexErrore = "";
		
		try
		{
			validaDataInizio(dataInizio);
			validaDataInizioFine(dataInizio, getDataFine());
		}
		catch (IllegalArgumentException iae)
		{
			datiValidi = false;
			mexErrore += " " + iae.getMessage();
		}
		catch (NullPointerException npe)
		{
			datiValidi = false;
			mexErrore += " " + npe.getMessage();
		}
		if (datiValidi) {
			this.dataInizio = dataInizio;
		}
		else
			throw new Exception(mexErrore);
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) throws Exception {
		boolean datiValidi = true;
		String mexErrore = "";
		
		try
		{
			validaDataFine(dataFine);
			validaDataInizioFine(getDataInizio(), dataFine);
		}
		catch (IllegalArgumentException iae)
		{
			datiValidi = false;
			mexErrore += " " + iae.getMessage();
		}
		catch (NullPointerException npe)
		{
			datiValidi = false;
			mexErrore += " " + npe.getMessage();
		}
		if (datiValidi) {
			this.dataFine = dataFine;
		}
		else
			throw new Exception(mexErrore);
	}
	
	//METODI
	private Period durataVacanza(LocalDate dataInizio, LocalDate dataFine)
	{
		Period durataVacanza = Period.between(dataInizio, dataFine);
		return durataVacanza;
	}
	
	//GESTIONE ECCEZIONI
	
	private void validaDataInizio(LocalDate dataIInput) throws IllegalArgumentException, NullPointerException
	{
		if(dataIInput == null)
			throw new NullPointerException("Devi dichiarare la data in cui inizierà la tua vacanza.");
		if(dataIInput.isBefore(dataOggi))
			throw new IllegalArgumentException("Non hanno ancora inventato le macchine del tempo. Inserisci una data nel futuro.");
	}
	
	private void validaDataFine(LocalDate dataFInput) throws IllegalArgumentException, NullPointerException
	{
		if(dataFInput == null)
			throw new NullPointerException("Devi dichiarare la data in cui finirà la tua vacanza.");
		if(dataFInput.isBefore(dataOggi))
			throw new IllegalArgumentException("Ti piacciono i paradossi temporali? Anche a me!\nLa data di fine vacanza non può essere prima della partenza.");
	}
	
	private void validaDataInizioFine(LocalDate dataIInput, LocalDate dataFInput) throws IllegalArgumentException
	{
		if(dataIInput.isAfter(dataFInput))
			throw new IllegalArgumentException("Non puoi partire dopo la fine della vacanza.");
	}
	
	@Override
	public String toString()
	{
		return 
				
		"\n"+	"Hai prenotato una vacanza di "		+	
		"\n"+	durataVacanza(getDataInizio(), getDataFine()).getDays()		+	" giorni,"	+
		"\n"+	durataVacanza(getDataInizio(), getDataFine()).getMonths()	+	" mesi,"	+
		"\n"+	durataVacanza(getDataInizio(), getDataFine()).getYears()	+	" anni."	+

		"\n"+	"La tua vacanza inizia il giorno "	+	dataIT.format(getDataInizio())	+
		"\n"+	"e termina il giorno "				+	dataIT.format(getDataFine()) 	+
		"\n"+	"Destinazione: "					+	getDestinazione()				;


	}
	

}
