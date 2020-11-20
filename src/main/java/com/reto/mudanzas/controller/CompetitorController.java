package com.reto.mudanzas.controller;

import com.reto.mudanzas.domain.Competitor;
import com.reto.mudanzas.domain.dto.CompetitorDTO;
import com.reto.mudanzas.mapper.CompetitorMapper;
import com.reto.mudanzas.service.CompetitorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/competitor")
public class CompetitorController {

    @Autowired
    CompetitorMapper competitorMapper;

    @Autowired
    CompetitorService competitorService;

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody CompetitorDTO competitorDTO) throws Exception {

        Competitor competitor = competitorMapper.toCompetitor(competitorDTO);
        competitorService.save(competitor);
        /*customer = customerService.save(customer);
        customerDTO = customerMapper.toCustomerDTO(customer);*/
        return ResponseEntity.ok(competitor);

    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        List<Competitor> competitors = competitorService.findAll();
        return ResponseEntity.ok().body(competitorMapper.toCompetitorsDTO(competitors));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) throws Exception {
        competitorService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
