package com.verribeiro.tournamentapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.verribeiro.tournamentapi.dto.request.TournamentRequest;
import com.verribeiro.tournamentapi.dto.response.TournamentResponse;
import com.verribeiro.tournamentapi.model.Tournament;
import com.verribeiro.tournamentapi.service.TournamentService;

@RestController
@RequestMapping("/api/tournaments")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TournamentController {

	private TournamentService tournamentService;

	public TournamentController(TournamentService tourService) {
		this.tournamentService = tourService;
	}

	@PostMapping
	public ResponseEntity<TournamentResponse> registerTournament(@Valid @RequestBody TournamentRequest request) {
		Tournament tour = this.tournamentService.registerTournament(request);
		return ResponseEntity.ok(TournamentResponse.from(tour));
	}

	@GetMapping("/{id}")
	public ResponseEntity<TournamentResponse> findTournament(@Valid @PathVariable(value = "id") Long id) {
		Tournament tour = this.tournamentService.findTournament(id);
		return ResponseEntity.ok(TournamentResponse.from(tour));
	}

	@GetMapping("/list")
	public ResponseEntity<List<TournamentResponse>> listTournament(@RequestParam(required = false) String title,
			@RequestParam(required = false) String dateTournament, @RequestParam(required = false) String subscription,
			@RequestParam(required = false) String maxSubscribers) {
		List<Tournament> tournaments = this.tournamentService.listTournaments(title, subscription, dateTournament,
				maxSubscribers);
		return ResponseEntity.ok(TournamentResponse.from(tournaments));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TournamentResponse> updateTournament(@Valid @PathVariable(value = "id") Long id,
			@Valid @RequestBody TournamentRequest request) {
		Tournament tour = this.tournamentService.updateTournament(id, request);
		return ResponseEntity.ok(TournamentResponse.from(tour));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<TournamentResponse> deleteTournament(@Valid @PathVariable(value = "id") Long id) {
		Tournament tour = tournamentService.deleteTournament(id);
		return ResponseEntity.ok(TournamentResponse.from(tour));
	}
}
