package com.verribeiro.tournamentapi.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.verribeiro.tournamentapi.dto.request.TournamentRequest;
import com.verribeiro.tournamentapi.model.Tournament;
import com.verribeiro.tournamentapi.repository.TournamentRepository;

@Service
public class TournamentService {
	private TournamentRepository tournamentRepository;

	public TournamentService(TournamentRepository tourRepo) {
		this.tournamentRepository = tourRepo;
	}

	@Transactional
	public Tournament registerTournament(TournamentRequest request) {
		Tournament tour = new Tournament();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(request, tour);
		this.tournamentRepository.save(tour);
		return tour;
	}

	@Transactional
	public Tournament deleteTournament(Long id) {
		Tournament tour = this.tournamentRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Torneio inexistente"));

		this.tournamentRepository.delete(tour);
		return tour;
	}

	public Tournament findTournament(Long id) {
		Tournament tour = tournamentRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Torneio inexistente"));

		return tour;
	}

	public List<Tournament> listTournaments(String title, String subscription, String dateTournament,
			String maxSubscribers) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("(dd/MM/yyyy)");
		LocalDate localDate;
		BigDecimal sub;		
		if(subscription == null) {
			sub = null; 
		}else {
			sub = new BigDecimal(subscription);
		}		
		if(dateTournament == null) {			
			localDate = null;
		}else {
			localDate = LocalDate.parse(dateTournament, formatter);
		}
		if(maxSubscribers == null) {
			return this.tournamentRepository.findAllTournamentCustom(title, sub, localDate, -1);
		}
		return this.tournamentRepository.findAllTournamentCustom(title, sub, localDate, Integer.parseInt(maxSubscribers));
		
	}
	
	@Transactional
	public Tournament updateTournament(Long id, TournamentRequest request) {
		Tournament tour = tournamentRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Torneio inexistente"));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(request, tour);
		
		tour.setId(id);
		this.tournamentRepository.save(tour);
		return tour;
	}
}
