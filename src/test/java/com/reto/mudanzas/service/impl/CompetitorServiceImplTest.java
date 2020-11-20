package com.reto.mudanzas.service.impl;

import com.reto.mudanzas.domain.Competitor;
import com.reto.mudanzas.exception.BusinessException;
import com.reto.mudanzas.service.CompetitorService;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(false)
public class CompetitorServiceImplTest {

    private final static Logger LOG = LoggerFactory.getLogger(CompetitorServiceImplTest.class);
    private final static String ID = "2c988576-2a53-49c4-b9eb-8a5577407407";

    public CompetitorServiceImplTest() {
    }

    @Autowired
    CompetitorService competitorService;

    @Test
    void testSave() throws BusinessException {
        assertNotNull(competitorService, "El competitorRepository es nulo");
        Competitor competitor = new Competitor();
        competitor.setCode("122345434");
        competitor.setFileContent("Esto es una prueba");
        competitorService.save(competitor);
    }

    @Test
    void testfindAll() {
        List<Competitor> competitors = competitorService.findAll();
        competitors.forEach(competitor -> LOG.info(competitor.getCode()));
    }

    @Test
    void testDeleteById() throws BusinessException {
        Competitor competitor = new Competitor();
        competitor.setCode("122345434");
        competitor.setFileContent("Esto es una prueba");
        competitorService.save(competitor);
        competitorService.deleteById(competitor.getId());
        assertTrue(true);
    }

}
