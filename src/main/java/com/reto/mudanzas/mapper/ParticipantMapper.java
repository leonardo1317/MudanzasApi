package com.reto.mudanzas.mapper;

import com.reto.mudanzas.domain.Participant;
import com.reto.mudanzas.domain.dto.ParticipantDTO;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface ParticipantMapper {

    public ParticipantDTO toParticipantDTO(Participant participant);

    public Participant toParticipant(ParticipantDTO participantDTO);

    public List<ParticipantDTO> toParticipantsDTO(List<Participant> participants);

    public List<Participant> toParticipants(List<ParticipantDTO> ParticipantDTO);
}
