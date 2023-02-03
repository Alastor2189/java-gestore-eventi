package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class Concerto extends Evento {
	
	private LocalTime orarioAttuale;
	private BigDecimal prezzoTicket;
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH.mm").withLocale(Locale.ITALIAN);
	
	
	public LocalTime getOrarioAttuale() {
		return orarioAttuale;
	}


	public void setOrarioAttuale(LocalTime orarioAttuale) {
		this.orarioAttuale = orarioAttuale;
	}


	public BigDecimal getPrezzoTicket() {
		return prezzoTicket;
	}


	public void setPrezzoTicket(BigDecimal prezzoTicket) {
		this.prezzoTicket = prezzoTicket;
	}


	public DateTimeFormatter getDtf() {
		return dtf;
	}


	public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime orarioAttuale, BigDecimal prezzoTicket)
			throws Exception {
		super(titolo, data, postiTotali);
		this.orarioAttuale = orarioAttuale;
		this.prezzoTicket = prezzoTicket;
	}
	
}
