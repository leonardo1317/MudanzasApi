package com.reto.mudanzas.service.impl;

import com.reto.mudanzas.domain.Competitor;
import com.reto.mudanzas.repository.CompetitorRepository;
import com.reto.mudanzas.service.CompetitorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitorServiceImpl implements CompetitorService {

    @Autowired
    CompetitorRepository competitorRepository;

    @Override
    public void save(Competitor competitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Competitor> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
