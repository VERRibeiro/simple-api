package com.verribeiro.tournamentapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Tournament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private BigDecimal subscription;

	@Column(nullable = true)
	@JsonFormat(pattern = "(dd/MM/yyyy)")
	private LocalDate dateTournament;
	
	@Column(nullable = false)
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

	public BigDecimal getSubscription() {
		return subscription;
	}

	public void setSubscription(BigDecimal subscription) {
		this.subscription = subscription;
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

	@Override
	public String toString() {
		return "Tournament [id=" + id + ", title=" + title + ", subscription=" + subscription + ", dateTournament="
				+ dateTournament + ", maxSubscribers=" + maxSubscribers + "]";
	}	
		
}
