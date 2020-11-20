package com.reto.mudanzas.service.impl;

import com.reto.mudanzas.domain.Competitor;
import com.reto.mudanzas.exception.BusinessException;
import com.reto.mudanzas.repository.CompetitorRepository;
import com.reto.mudanzas.service.CompetitorService;
import com.reto.mudanzas.service.utils.Util;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitorServiceImpl implements CompetitorService {

    @Autowired
    CompetitorRepository competitorRepository;

    @Override
    public void save(Competitor competitor) throws BusinessException {

        competitor.setId(Util.toUUIDString());
        competitor.setCreateDate(Util.currentTimeMillis());
        competitorRepository.save(competitor);
    }

    @Override
    public List<Competitor> findAll() {
        return competitorRepository.findAll();
    }

    @Override
    public void deleteById(String id) throws BusinessException {
        if (id == null) {
            throw new BusinessException("El id no puede ser nulo");
        }
        if (!competitorRepository.existsById(id)) {
            throw new BusinessException("El id: " + id + " no existe");
        }
        competitorRepository.deleteById(id);
    }

}
