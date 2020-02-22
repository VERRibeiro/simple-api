package com.verribeiro.tournamentapi.dto.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.verribeiro.tournamentapi.model.Tournament;
import com.verribeiro.tournamentapi.utils.FormatUtil;

public class TournamentResponse {

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
		this.subscription = fu.setBigDecimalPattern(subscription);
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

	public static TournamentResponse from(Tournament tournament) {
		TournamentResponse response = new TournamentResponse();

		response.setDateTournament(tournament.getDateTournament());
		response.setId(tournament.getId());
		response.setSubscription(tournament.getSubscription().toString());
		response.setTitle(tournament.getTitle());
		response.setMaxSubscribers(tournament.getMaxSubscribers());

		return response;
	}

	public static List<TournamentResponse> from(List<Tournament> tournaments) {
		List<TournamentResponse> responseArray = new ArrayList<TournamentResponse>();
		for (Tournament tournament : tournaments) {
			TournamentResponse response = new TournamentResponse();

			response.setDateTournament(tournament.getDateTournament());
			response.setId(tournament.getId());
			response.setSubscription(tournament.getSubscription().toString());
			response.setTitle(tournament.getTitle());
			response.setMaxSubscribers(tournament.getMaxSubscribers());

			responseArray.add(response);
		}

		return responseArray;
	}
}
