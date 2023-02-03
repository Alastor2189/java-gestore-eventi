package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	private String titolo;
	private int postiTotali;
	private int postiPrenotati;
	private LocalDate data;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("gg/MM/yyyy, Ore: HH:mm");

	public Evento(String titolo, int postiTotali, in postiDisponibili) {
		super();
		this.titolo = titolo;
		this.postiTotali = 0;
		this.postiPrenotati = postiDisponibili;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiDisponibili() {
		return postiPrenotati;
	}

	public static DateTimeFormatter getDtf() {
		return dtf;
	}

	public void setPostiTotali(int postiTotali) {
		this.postiTotali = postiTotali;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiPrenotati = postiDisponibili;
	}
	
	//METODI
	
	public void prenota() throws Exception {
		if(LocalDate.now()isAfter(data)) {
			throw new Exception("Evento già concluso, prenotazioni chiuse");
		} else if (postiTotali == postiPrenotati) {
			throw new Exception("Evento già al completo, nessun posto disponibile");
		} else
			postiPrenotati++;
	}
	
	public void disdettaPrenotazione() throws Exception {
		if(LocalDate.now().isAfter(data)) {
			throw new Exception("Evento concluso, impossibile disdire");
		} else if (postiPrenotati<1) {
			throw new Exception("Non ci sono prenotazioni per questo evento");
		} else
			postiPrenotati--;
	}

	@Override
	public String toString() {
		return "Evento [titolo=" + titolo + ", data=" + data + "]";
	}
	
	
}
