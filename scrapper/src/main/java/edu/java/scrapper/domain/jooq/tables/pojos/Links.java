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
public class Links implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String uri;
    private String host;
    private String protocol;
    private OffsetDateTime lastUpdatedAt;

    public Links() {}

    public Links(Links value) {
        this.id = value.id;
        this.uri = value.uri;
        this.host = value.host;
        this.protocol = value.protocol;
        this.lastUpdatedAt = value.lastUpdatedAt;
    }

    @ConstructorProperties({ "id", "uri", "host", "protocol", "lastUpdatedAt" })
    public Links(
        @Nullable Long id,
        @NotNull String uri,
        @NotNull String host,
        @NotNull String protocol,
        @Nullable OffsetDateTime lastUpdatedAt
    ) {
        this.id = id;
        this.uri = uri;
        this.host = host;
        this.protocol = protocol;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    /**
     * Getter for <code>LINKS.ID</code>.
     */
    @Nullable
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>LINKS.ID</code>.
     */
    public void setId(@Nullable Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>LINKS.URI</code>.
     */
    @jakarta.validation.constraints.NotNull
    @Size(max = 256)
    @NotNull
    public String getUri() {
        return this.uri;
    }

    /**
     * Setter for <code>LINKS.URI</code>.
     */
    public void setUri(@NotNull String uri) {
        this.uri = uri;
    }

    /**
     * Getter for <code>LINKS.HOST</code>.
     */
    @jakarta.validation.constraints.NotNull
    @Size(max = 16)
    @NotNull
    public String getHost() {
        return this.host;
    }

    /**
     * Setter for <code>LINKS.HOST</code>.
     */
    public void setHost(@NotNull String host) {
        this.host = host;
    }

    /**
     * Getter for <code>LINKS.PROTOCOL</code>.
     */
    @jakarta.validation.constraints.NotNull
    @Size(max = 16)
    @NotNull
    public String getProtocol() {
        return this.protocol;
    }

    /**
     * Setter for <code>LINKS.PROTOCOL</code>.
     */
    public void setProtocol(@NotNull String protocol) {
        this.protocol = protocol;
    }

    /**
     * Getter for <code>LINKS.LAST_UPDATED_AT</code>.
     */
    @Nullable
    public OffsetDateTime getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    /**
     * Setter for <code>LINKS.LAST_UPDATED_AT</code>.
     */
    public void setLastUpdatedAt(@Nullable OffsetDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Links other = (Links) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.uri == null) {
            if (other.uri != null)
                return false;
        }
        else if (!this.uri.equals(other.uri))
            return false;
        if (this.host == null) {
            if (other.host != null)
                return false;
        }
        else if (!this.host.equals(other.host))
            return false;
        if (this.protocol == null) {
            if (other.protocol != null)
                return false;
        }
        else if (!this.protocol.equals(other.protocol))
            return false;
        if (this.lastUpdatedAt == null) {
            if (other.lastUpdatedAt != null)
                return false;
        }
        else if (!this.lastUpdatedAt.equals(other.lastUpdatedAt))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.uri == null) ? 0 : this.uri.hashCode());
        result = prime * result + ((this.host == null) ? 0 : this.host.hashCode());
        result = prime * result + ((this.protocol == null) ? 0 : this.protocol.hashCode());
        result = prime * result + ((this.lastUpdatedAt == null) ? 0 : this.lastUpdatedAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Links (");

        sb.append(id);
        sb.append(", ").append(uri);
        sb.append(", ").append(host);
        sb.append(", ").append(protocol);
        sb.append(", ").append(lastUpdatedAt);

        sb.append(")");
        return sb.toString();
    }
}
