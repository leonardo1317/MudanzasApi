package com.reto.mudanzas.service.impl;

import com.reto.mudanzas.domain.Participant;
import com.reto.mudanzas.exception.BusinessException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import com.reto.mudanzas.service.ParticipantService;

@SpringBootTest
@Rollback(false)
public class ParticipantServiceImplTest {

    private final static Logger LOG = LoggerFactory.getLogger(ParticipantServiceImplTest.class);

    public ParticipantServiceImplTest() {
    }
    
    private final static String PARTICIPANTID = "123";
    private final static byte [] FILE = "Esto es una prueba".getBytes();

    @Autowired
    ParticipantService participantService;

    @Test
    void testSave() throws BusinessException {
      /*  assertNotNull(participantService, "El participantService es nulo");
        Participant participant = new Participant();
        participant.setParticipantId("123");
        participant.setFileContent("Esto es una prueba");
       // participantService.save(PARTICIPANTID, FILE);*/
    }

    @Test
    void testfindAll() {
       /* List<Participant> participants = participantService.findAll();
        participants.forEach(competitor -> LOG.info(competitor.getParticipantId()));*/
    }

    @Test
    void testDeleteById() throws BusinessException {
       /* Participant participant = new Participant();
        participant.setParticipantId("122345434");
        participant.setFileContent("Esto es una prueba");
        participantService.save(PARTICIPANTID, FILE);
        //participantService.deleteById(participant.getId());
       // assertTrue(true);*/
    }

}
