package com.verribeiro.tournamentapi.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.verribeiro.tournamentapi.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

	@Query("SELECT t FROM Tournament t WHERE (:title is null or t.title LIKE :title) AND"
			+ " (:subscription is null or t.subscription = :subscription) AND"
			+ " (CAST(:dateTournament AS date) is null or t.dateTournament = :dateTournament) AND"
			+ " (:maxSubscribers = -1 or t.maxSubscribers = :maxSubscribers)")
	List<Tournament> findAllTournamentCustom(@Param("title") String title, @Param("subscription") BigDecimal subscription,
			@Param("dateTournament") LocalDate dateTournament, @Param("maxSubscribers") int maxSubscribers);

}
