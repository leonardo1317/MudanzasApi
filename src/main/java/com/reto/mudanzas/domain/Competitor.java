package com.reto.mudanzas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "competitors", schema = "public")
public class Competitor {
   
    @Id
    private String id;
    private String code;
    @Column(name = "filecontent")
    private String fileContent;
    @Column(name = "createdate")
    private Long createDate;

    public Competitor() {
    }

    public Competitor(String id, String code, String fileContent, Long createDate) {
        this.id = id;
        this.code = code;
        this.fileContent = fileContent;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
