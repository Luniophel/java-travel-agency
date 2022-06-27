package jana60;

import java.time.LocalDate;

public class Vacanza {
		
	//ATTRIBUTI
	//Variabili del costruttore Vacanza
	private String destinazione;
	private LocalDate dataInizio, dataFine;
	//Variabili dei metodi
	private static final LocalDate dataOggi = LocalDate.now();
	
	//COSTRUTTORI
	public Vacanza(String destinazione, LocalDate dataInizio, LocalDate dataFine) throws Exception
	{
		boolean datiValidi = true;
		String mexErrore = "";
		
		//Validazione data d'inizio
		try
		{
			validaDataInizio(dataInizio);
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
		
		//Validazione dada di fine
		
		this.destinazione = destinazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
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

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	
	//METODI
	
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
	
	
	

}
