package com.reto.mudanzas.domain.dto;

public class CompetitorDTO {

    private String id;
    private String code;
    private String fileContent;
    private Long createDate;

    public CompetitorDTO() {
    }

    public CompetitorDTO(String id, String code, String fileContent, Long createDate) {
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
