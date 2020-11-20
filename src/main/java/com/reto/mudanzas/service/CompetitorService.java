package com.reto.mudanzas.service;

import com.reto.mudanzas.domain.Competitor;
import java.util.List;

public interface CompetitorService {

    public void save(Competitor competitor);

    public List<Competitor> findAll();

    public void deleteById(String id) throws Exception;

}
