package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Evento {
	private String titolo;
	private int postiTotali;
	private int postiPrenotati = 0;
	private LocalDate data;
	LocalDate dateNow = LocalDate.now();
	
	

	public Evento(String titolo, LocalDate data, int postiTotali) throws Exception {
		
		this.data = data;
		validData(data);
		this.titolo = titolo;
		this.postiTotali = postiTotali;
		validPosti(postiTotali);
		this.postiPrenotati = postiPrenotati;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
		
	}
	
	public int postiDisponibili() {
		return postiTotali - postiPrenotati;
	}

	
		
	

	public void setPostiTotali(int postiTotali) {
		this.postiTotali = postiTotali;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiPrenotati = postiDisponibili;
	}
	
	public void setData(LocalDate data) {

		this.data = data;
	
	//VALIDATORI
	
	
	
	 public void validData(LocalDate data) throws Exception {
		 if (data.isBefore(dateNow))
			 throw new Exception();
	 }
	 
	 private void validPosti(int postiTotali) throws IllegalArgumentException {
	        if (postiTotali<1)
	            throw new IllegalArgumentException("Ci deve essere almeno un posto");
	    }
	
	//METODI
	
	public void prenotaEvento(LocalDate data) throws Exception {
		if (dateNow.isBefore(data))
			throw new Exception();
		if (postiTotali <= postiPrenotati)
			throw new Exception();
		postiPrenotati++;
	}
	
	public void disdiciEvento(LocalDate data) throws Exception {
		if (dateNow.isBefore(data))
			throw new Exception();
		if (postiPrenotati < 1)
			throw new Exception();
		postiPrenotati--;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
		String dateF = data.format(dtf);
		return "Evento [titolo=" + titolo + ", data=" + dateF + "]";
	}
	
	
}
