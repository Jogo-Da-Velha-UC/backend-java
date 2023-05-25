package com.br.uni.edu.jogoDaVelha.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.JsonJdbcType;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "tb_game_structs")
public class GameStruct implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameStructId;
    @JdbcType(value = JsonJdbcType.class)
    private Map<String, String> fields = new HashMap<>();
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public GameStruct() {
        this.fields.put("00","");
        this.fields.put("01","");
        this.fields.put("02","");
        this.fields.put("10","");
        this.fields.put("11","");
        this.fields.put("12","");
        this.fields.put("20","");
        this.fields.put("21","");
        this.fields.put("22","");
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Long getGameStructId() {
        return gameStructId;
    }

    public void setGameStructId(Long gameStructId) {
        this.gameStructId = gameStructId;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
