package com.reto.mudanzas.repository;

import com.reto.mudanzas.domain.Competitor;
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
public class CompetitorRepositoryTest {

    private final static Logger LOG = LoggerFactory.getLogger(CompetitorRepositoryTest.class);
    private final static String ID = "2c988576-2a53-49c4-b9eb-8a5577407407";

    public CompetitorRepositoryTest() {
    }

    @Autowired
    CompetitorRepository competitorRepository;

    @Test
    @Transactional
    void save() {
        assertNotNull(competitorRepository, "El competitorRepository es nulo");
        Competitor competitor = new Competitor();
        competitor.setId(ID);
        competitor.setCode("122345434");
        competitor.setFileContent("Esto es una prueba");
        competitor.setCreateDate(1605830175737l);
        competitorRepository.save(competitor);
    }

    @Test
    @Transactional
    void findAll() {
        List<Competitor> competitors = competitorRepository.findAll();
        competitors.forEach(competitor -> LOG.info(competitor.getCode()));
    }

    @Test
    @Transactional
    void delete() {
        Optional<Competitor> competitorOptional = competitorRepository.findById(ID);
        assertTrue(competitorOptional.isPresent(), "El competitor con id: " + ID + " no existe.");
        Competitor competitor = competitorOptional.get();
        competitorRepository.delete(competitor);
    }

}
