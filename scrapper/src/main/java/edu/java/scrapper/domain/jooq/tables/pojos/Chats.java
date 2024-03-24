/*
 * This file is generated by jOOQ.
 */
package edu.java.scrapper.domain.jooq.tables.pojos;


import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Chats implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private OffsetDateTime createdAt;
    private String createdBy;

    public Chats() {}

    public Chats(Chats value) {
        this.id = value.id;
        this.createdAt = value.createdAt;
        this.createdBy = value.createdBy;
    }

    @ConstructorProperties({ "id", "createdAt", "createdBy" })
    public Chats(
        @NotNull Long id,
        @NotNull OffsetDateTime createdAt,
        @Nullable String createdBy
    ) {
        this.id = id;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    /**
     * Getter for <code>CHATS.ID</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>CHATS.ID</code>.
     */
    public void setId(@NotNull Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>CHATS.CREATED_AT</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>CHATS.CREATED_AT</code>.
     */
    public void setCreatedAt(@NotNull OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Getter for <code>CHATS.CREATED_BY</code>.
     */
    @Size(max = 64)
    @Nullable
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Setter for <code>CHATS.CREATED_BY</code>.
     */
    public void setCreatedBy(@Nullable String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Chats other = (Chats) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!this.createdAt.equals(other.createdAt))
            return false;
        if (this.createdBy == null) {
            if (other.createdBy != null)
                return false;
        }
        else if (!this.createdBy.equals(other.createdBy))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.createdBy == null) ? 0 : this.createdBy.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Chats (");

        sb.append(id);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(createdBy);

        sb.append(")");
        return sb.toString();
    }
}