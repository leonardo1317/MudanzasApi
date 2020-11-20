package com.reto.mudanzas.service;

import com.reto.mudanzas.domain.Competitor;
import com.reto.mudanzas.exception.BusinessException;
import java.util.List;

public interface CompetitorService {

    public void save(Competitor competitor) throws BusinessException;

    public List<Competitor> findAll();

    public void deleteById(String id) throws BusinessException;

}
