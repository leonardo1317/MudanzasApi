package com.reto.mudanzas.mapper;


import com.reto.mudanzas.domain.dto.ParticipantDto;
import com.reto.mudanzas.persistence.entity.Participant;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface ParticipantMapper {

    public ParticipantDto toParticipantDto(Participant participant);

    public Participant toParticipant(ParticipantDto participantDto);

    public List<ParticipantDto> toParticipantsDto(List<Participant> participants);

    public List<Participant> toParticipants(List<ParticipantDto> ParticipantDto);
}
