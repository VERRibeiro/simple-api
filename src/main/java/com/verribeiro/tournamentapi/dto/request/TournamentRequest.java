package com.verribeiro.tournamentapi.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.verribeiro.tournamentapi.utils.FormatUtil;

public class TournamentRequest {

	private Long id;
	private String title;
	private String subscription;

	@JsonFormat(pattern = "(dd/MM/yyyy)")
	private LocalDate dateTournament;

	private int maxSubscribers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		FormatUtil fu = new FormatUtil();
		this.subscription = fu.formatBigDecimal(subscription);
	}

	public LocalDate getDateTournament() {
		return dateTournament;
	}

	public void setDateTournament(LocalDate dateTournament) {
		this.dateTournament = dateTournament;
	}

	public int getMaxSubscribers() {
		return maxSubscribers;
	}

	public void setMaxSubscribers(int maxSubscribers) {
		this.maxSubscribers = maxSubscribers;
	}

}
