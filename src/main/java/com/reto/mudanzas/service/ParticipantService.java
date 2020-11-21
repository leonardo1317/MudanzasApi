package com.reto.mudanzas.service;

import com.reto.mudanzas.domain.Participant;
import com.reto.mudanzas.exception.BusinessException;
import java.util.List;

public interface ParticipantService {

    public void save(Participant participant) throws BusinessException;

    public List<Participant> findAll();

    public void deleteById(String id) throws BusinessException;

}
