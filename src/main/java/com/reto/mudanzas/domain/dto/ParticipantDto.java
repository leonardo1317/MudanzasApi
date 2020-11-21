package com.reto.mudanzas.domain.dto;

public class ParticipantDto {

    private String id;
    private String participantId;
    private String fileContent;
    private Long createDate;

    public ParticipantDto() {
    }

    public ParticipantDto(String id, String participantId, String fileContent, Long createDate) {
        this.id = id;
        this.participantId = participantId;
        this.fileContent = fileContent;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

}
