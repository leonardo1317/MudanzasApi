package com.reto.mudanzas.service;

import com.reto.mudanzas.persistence.entity.Participant;
import com.reto.mudanzas.exception.BusinessException;
import com.reto.mudanzas.service.utils.Util;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto.mudanzas.service.dataproviders.ParticipantDataProvider;

@Service
public class ParticipantService {

    @Autowired
    ParticipantDataProvider participantDataProvider;

    @Autowired
    FileService fileService;

    @Autowired
    LoadService loadService;

    public void save(String participantId, byte[] file) throws BusinessException {

        List<Integer> elements = fileService.read(file);
        List<List<Integer>> weights = loadService.getWeights(elements);
        List<Integer> tripsList = loadService.getNumberOfTrips(weights);
        String trace = fileService.write(tripsList);

        Participant participant = new Participant();
        participant.setParticipantId(participantId);
        participant.setCreateDate(Util.currentTimeMillis());
        participant.setTrace(trace);

        participantDataProvider.save(participant);

    }

    public List<Participant> findAll() {
        return participantDataProvider.findAll();
    }

    public void deleteById(Long id) throws BusinessException {
        participantDataProvider.deleteById(id);
    }

}
