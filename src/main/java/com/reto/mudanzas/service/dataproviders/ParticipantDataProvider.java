package com.reto.mudanzas.service.dataproviders;

import com.reto.mudanzas.exception.BusinessException;
import com.reto.mudanzas.persistence.entity.Participant;
import java.util.List;

public interface ParticipantDataProvider {

    public void save(Participant participant) throws BusinessException;

    public List<Participant> findAll();

    public void deleteById(Long id) throws BusinessException;

}
