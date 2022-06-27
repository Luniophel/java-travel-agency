package jana60;

import java.util.Scanner;

public class Agenzia {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		boolean continua = true;
		
		do //Ciclo di selezione dove l'utente decide se creare un biglietto o chiudere la procedura.
		{
			
			System.out.println("Benvenuto, grazie per averci scelto.\nVuoi creare un biglietto?");
			System.out.println("1- SI, 2-NO");
			
			String input = scan.nextLine();
			if (input.equals("1"))		//L'utente vuole continuare
			{
				continua = true;
			}
			else if (input.equals("2"))	//L'utente vuole annullare la procedura
			{
				continua = false;
				System.out.println("Va bene, alla prossima!");
				scan.close();			//Chiusura dello scan prima del termine dell'applicazione
				break;
			}
			else
			{
				continua = false;
				System.out.println("Attenzione, hai inserito un valore non valido.");	
			}
				
		}
		while (!continua);
		
		
		
		
		scan.close();
	}

}
