package com.reto.mudanzas.service.dataproviders.jpa;

import com.reto.mudanzas.exception.BusinessException;
import com.reto.mudanzas.persistence.entity.Participant;
import com.reto.mudanzas.persistence.repository.ParticipantRepository;
import com.reto.mudanzas.service.dataproviders.ParticipantDataProvider;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaParticipantDataProvider implements ParticipantDataProvider {

    @Autowired
    ParticipantRepository participantRepository;

    @Override
    public void save(Participant participant) throws BusinessException {
        participantRepository.save(participant);
    }

    @Override
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    @Override
    public void deleteById(Long id) throws BusinessException {
        if (id == null) {
            throw new BusinessException("El id no puede ser nulo");
        }
        if (!participantRepository.existsById(id)) {
            throw new BusinessException("El id: " + id + " no existe");
        }
        participantRepository.deleteById(id);
    }

}
