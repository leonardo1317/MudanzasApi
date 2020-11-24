package com.reto.mudanzas.controller;

import com.reto.mudanzas.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.reto.mudanzas.mapper.ParticipantMapper;
import com.reto.mudanzas.persistence.entity.Participant;
import com.reto.mudanzas.service.ParticipantService;
import com.reto.mudanzas.service.utils.Util;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/participant")
@CrossOrigin("*")
public class ParticipantController {

    @Autowired
    ParticipantMapper participantMapper;

    @Autowired
    ParticipantService participantService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> save(
            @NonNull @RequestParam(value = "participantId", required = true) String participantId,
            @NonNull @RequestParam(value = "file", required = true) MultipartFile multipartFile) {
        try {
            participantService.save(participantId, Util.toByteArray(multipartFile));
        } catch (BusinessException ex) {
            return ResponseEntity.badRequest()
                    .body(ex.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        List<Participant> participants = participantService.findAll();
        return ResponseEntity.ok().body(participantMapper.toParticipantsDto(participants));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            participantService.deleteById(id);
        } catch (BusinessException ex) {
            return ResponseEntity.badRequest()
                    .body(ex.getMessage());
        }
        return ResponseEntity.ok().build();
    }

}
