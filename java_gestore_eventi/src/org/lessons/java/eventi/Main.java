package org.lessons.java.eventi;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Evento insertEvento = null;
		
		try {
			System.out.print("Inserisci il titolo dell'evento:");
			String titolo = s.nextLine();
			
			System.out.print("Inserisci l'anno dell'evento:");
			int annoEvento = Integer.parseInt(s.nextLine());
			
			System.out.print("Inserisci il mese: ");
			int meseEvento = Integer.parseInt(s.nextLine());

			System.out.print("Inserisci il giorno: ");
			int giornoEvento = Integer.parseInt(s.nextLine());

			LocalDate dataCompletaEvento = LocalDate.of(annoEvento, meseEvento, giornoEvento);

			System.out.print("Posti totali: ");
			int postiTotali = Integer.parseInt(s.nextLine());
			
			insertEvento = new Evento(titolo, dataCompletaEvento, postiTotali);
		} catch (Exception e) {
			System.out.println("Uno o più campi sono inseriti in maniera erronea");
			e.printStackTrace();
		}
		
		//System.out.println(insertEvento.toString());
		
		
		
		
		int postiPrenotati = 0;
		boolean checkPrenotazione = true;

		while (checkPrenotazione) {
			try {
				System.out.print("Vuoi prenotare? (s/n)");
				checkPrenotazione = s.nextLine().equals("s");
				if (checkPrenotazione) {
					System.out.print("Quanti posti vuoi prenotare? ");
					postiPrenotati = Integer.parseInt(s.nextLine());
					if (postiPrenotati < 1 || postiPrenotati > insertEvento.getPostiTotali())
						System.out.println("Numero non valido, intervallo accettato da 1 a " + insertEvento.getPostiTotali());
					else
						checkPrenotazione = false;
				}

			} catch (Exception error) {
				System.out.println("Errore: Input non valido");
			}
		}
		
		LocalDate now = LocalDate.now();
		
		for (int i = 0; i < postiPrenotati; i++)   {
			try {
				insertEvento.prenotaEvento(now);
			} catch (Exception e) {
					e.printStackTrace();
			}
		}
		
		System.out.println("Il numero dei posti prenotati è" + insertEvento.getPostiPrenotati());
		System.out.println("Il numero dei posti disponibili è" + insertEvento.postiDisponibili());
		
		int resoPrenotazioni= 0;
		boolean disdettaTicket = true;

		while (disdettaTicket) {
			try {
				System.out.print("Vuoi disdire dei posti? (s/n)");
				disdettaTicket = s.nextLine().equals("s");
				if (disdettaTicket) {
					if (postiPrenotati < 1) {
						System.out.println("Nessun ticket prenotato");
						disdettaTicket = false;
					} else {
						System.out.print("Quanti posti vuoi disdire? ");
						resoPrenotazioni = Integer.parseInt(s.nextLine());
						if (resoPrenotazioni < 1 || resoPrenotazioni > insertEvento.getPostiPrenotati())
							System.out.println("Numero non valido, intervallo accettato da 1 a " + insertEvento.getPostiPrenotati());
						else
							disdettaTicket = false;
					}
				}

			} catch (Exception error) {
				System.out.println("Input non valido");
			}
		}

		for (int i=0; i < resoPrenotazioni; i++) {
			try {
				insertEvento.disdiciEvento(now);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("Posti prenotati: " + insertEvento.getPostiPrenotati());
		System.out.println("Posti disponibili: " + insertEvento.getPostiDisponibili());

		

		System.out.println("fine prenotazione");
		
		
		
		
		
		s.close();
		
		
		
		
	}
}
