package com.reto.mudanzas.persistence.entity;

import com.reto.mudanzas.persistence.entity.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participants", schema = "public")
public class Participant {

    @Id
    private String id;
    @Column(name = "participant_id")
    private String participantId;
    @Column(name = "filecontent")
    private String fileContent;
    @Column(name = "createdate")
    private Long createDate;

    public Participant() {
    }

    public Participant(String id, String participantId, String fileContent, Long createDate) {
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
