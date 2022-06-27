package jana60;

import java.util.Scanner;

public class Agenzia {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

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
			
		}
		
		System.out.println("Va bene, alla prossima!");
		
		
		scan.close();
	}

}
