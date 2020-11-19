package com.reto.mudanzas.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "competitors", schema = "public")
public class Competitor {

    @Id
    private Long id;
    private String code;
    private Long createdate;

    public Competitor() {
    }

    public Competitor(String code, Long createdate) {
        this.code = code;
        this.createdate = createdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

}
