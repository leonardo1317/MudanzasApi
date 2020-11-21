package com.reto.mudanzas.repository;

import com.reto.mudanzas.domain.Participant;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Rollback(false)
public class ParticipantRepositoryTest {

    private final static Logger LOG = LoggerFactory.getLogger(ParticipantRepositoryTest.class);
    private final static String ID = "2c988576-2a53-49c4-b9eb-8a5577407407";

    public ParticipantRepositoryTest() {
    }

    @Autowired
    ParticipantRepository participantRepository;

    @Test
    @Transactional
    void save() {
        assertNotNull(participantRepository, "El participantRepository es nulo");
        Participant participant = new Participant();
        participant.setId(ID);
        participant.setParticipantId("122345434");
        participant.setFileContent("Esto es una prueba");
        participant.setCreateDate(1605830175737l);
        participantRepository.save(participant);
    }

    @Test
    @Transactional
    void findAll() {
        List<Participant> participants = participantRepository.findAll();
        participants.forEach(participant -> LOG.info(participant.getParticipantId()));
    }

    @Test
    @Transactional
    void delete() {
        Optional<Participant> participantOptional = participantRepository.findById(ID);
        assertTrue(participantOptional.isPresent(), "El participant con id: " + ID + " no existe.");
        Participant participant = participantOptional.get();
        participantRepository.delete(participant);
    }

}
