package com.reto.mudanzas.repository;

import com.reto.mudanzas.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, String> {

}
