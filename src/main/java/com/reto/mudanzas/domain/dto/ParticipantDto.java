package com.reto.mudanzas.domain.dto;

public class ParticipantDto {

    private Long id;
    private String participantId;
    private String trace;
    private Long createDate;

    public ParticipantDto() {
    }

    public ParticipantDto(Long id, String participantId, String trace, Long createDate) {
        this.id = id;
        this.participantId = participantId;
        this.trace = trace;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

}
