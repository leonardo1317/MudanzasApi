package com.reto.mudanzas.service;

import com.reto.mudanzas.persistence.entity.Participant;
import com.reto.mudanzas.exception.BusinessException;
import com.reto.mudanzas.service.utils.Util;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto.mudanzas.service.dataproviders.ParticipantDataProvider;
import java.util.Collections;

@Service
public class ParticipantService {

    @Autowired
    ParticipantDataProvider participantDataProvider;

    @Autowired
    FileService fileService;

    @Autowired
    LoadService loadService;

    public void save(String participantId, byte[] file) throws BusinessException {

//        
//             String content = Util.base64Decode(participant.getFileContent());
//        List<Integer> items = fileService.read(content);
//        System.out.println("test: " + items);
//
//        participant.setId(Util.toUUIDString());
//        participant.setCreateDate(Util.currentTimeMillis());
        List<Integer> elements = fileService.read(file);

        loadService.setElements(elements);
        List<List<Integer>> weights = loadService.getWeights();
        loadService.getNumberOfTrips(weights);

//
//        System.out.println("max: " + Collections.max(items));
//        System.out.println("min: " + Collections.min(items));
    }

    public List<Participant> findAll() {
        return participantDataProvider.findAll();
    }

    public void deleteById(String id) throws BusinessException {
        participantDataProvider.deleteById(id);
    }

}
