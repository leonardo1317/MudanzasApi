package com.reto.mudanzas.persistence.repository;

import com.reto.mudanzas.persistence.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, String> {

}
