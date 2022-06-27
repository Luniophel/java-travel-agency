package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Agenzia {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		DateTimeFormatter dataIT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		boolean continua = true;
		boolean creaVacanza = true;
		
		System.out.println("Benvenuto, grazie per averci scelto.");
		
		do //Ciclo di selezione dove l'utente decide se creare un biglietto o chiudere la procedura.
		{
			System.out.println("Vuoi prenotare una nuova Vacanza?");
			System.out.println("1- SI, 2-NO");
			
			String input = scan.nextLine();
			
			switch (input)
			{
				case "1":
					continua = true;
					creaVacanza = true;
					break;
					
				case "2":
					continua = true;
					creaVacanza = false;
					break;
					
				default:
					continua = false;
					System.out.println("Attenzione, hai inserito un valore non valido.");
					break;
			}
		}
		while (!continua);
		
		while (creaVacanza) 
		{
			System.out.println("Oggi è il " + dataIT.format(Vacanza.dataOggi));
			try
			{
				//Compilazione dei dati del viaggio
				System.out.print("\nDigita la meta del tuo viaggio: ");
				String tempDestinazione = scan.nextLine();
				
				System.out.print("\nDigita la data di andata: ");
				String tempDataInizioSt = scan.nextLine();
				LocalDate tempDataInizioLD = LocalDate.parse(tempDataInizioSt, dataIT);
				
				System.out.print("\nDigita la data di ritorno: ");
				String tempDataFineSt = scan.nextLine();
				LocalDate tempDataFineLD = LocalDate.parse(tempDataFineSt, dataIT);
				
				//Tentativo creazione di Vacanza()
				Vacanza vacanza = new Vacanza(tempDestinazione, tempDataInizioLD, tempDataFineLD);
				
				System.out.println(vacanza.toString());
			}
			
			catch (Exception genericExc)
			{
				System.out.println("Qualcosa è andato storto...\n" + genericExc.getMessage());
			}
			
			//Se volessimo decidere di salvare gli oggetti Vacanza, sarebbe necessario un costruttore di copia Vacanza(Vacanza vacanza)
		}
		
		System.out.println("Va bene, alla prossima!");
		
		
		scan.close();
	}

}
