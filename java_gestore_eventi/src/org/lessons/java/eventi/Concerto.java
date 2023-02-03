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
	private final DecimalFormat prezzoFormat = new DecimalFormat("#,##$");
	
	public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime orarioAttuale, BigDecimal prezzoTicket) throws Exception {
		super(titolo, data, postiTotali);
		setOrarioAttuale(orarioAttuale);
		this.prezzoTicket = prezzoTicket;
		setPrezzoTicket(prezzoTicket);
	}
	
	public LocalTime getOrarioAttuale() {
		return orarioAttuale;
	}


	public void setOrarioAttuale(LocalTime orarioAttuale2) {
		this.orarioAttuale = formatTime(orarioAttuale2);
	}
	
	private LocalTime formatTime(LocalTime orarioAttuale2) {
		 LocalTime timeLocal = LocalTime.parse(orarioAttuale2,dtf);
	        return timeLocal;
	}


	public BigDecimal getPrezzoTicket() {
		return prezzoTicket;
	}


	public void setPrezzoTicket(BigDecimal prezzoTicket2) {
		this.prezzoTicket = prezzoTicket2;
	}


	public DateTimeFormatter getDtf() {
		return dtf;
	}

	@Override
	public String toString() {
		return "Concerto [orarioAttuale=" + orarioAttuale + ", prezzoTicket=" + prezzoFormat.format(prezzoTicket) + ", dtf=" + dtf + "]";
	}

