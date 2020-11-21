package com.reto.mudanzas.service.impl;

import com.reto.mudanzas.domain.Participant;
import com.reto.mudanzas.exception.BusinessException;
import com.reto.mudanzas.service.FileService;
import com.reto.mudanzas.service.utils.Util;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto.mudanzas.repository.ParticipantRepository;
import com.reto.mudanzas.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    ParticipantRepository competitorRepository;

    @Autowired
    FileService fileService;

    @Override
    public void save(Participant participant) throws BusinessException {

        String content = Util.base64Decode(participant.getFileContent());
        List<Integer> items = fileService.read(content);
        System.out.println("test: "+ items);

        participant.setId(Util.toUUIDString());
        participant.setCreateDate(Util.currentTimeMillis());
        competitorRepository.save(participant);
    }

    @Override
    public List<Participant> findAll() {
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
