/*
 * This file is generated by jOOQ.
 */
package edu.java.scrapper.domain.jooq.tables.records;


import edu.java.scrapper.domain.jooq.tables.GithubLinks;

import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class GithubLinksRecord extends UpdatableRecordImpl<GithubLinksRecord> implements Record3<Long, String, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>GITHUB_LINKS.ID</code>.
     */
    public void setId(@NotNull Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>GITHUB_LINKS.ID</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>GITHUB_LINKS.DEFAULT_BRANCH</code>.
     */
    public void setDefaultBranch(@Nullable String value) {
        set(1, value);
    }

    /**
     * Getter for <code>GITHUB_LINKS.DEFAULT_BRANCH</code>.
     */
    @Size(max = 64)
    @Nullable
    public String getDefaultBranch() {
        return (String) get(1);
    }

    /**
     * Setter for <code>GITHUB_LINKS.FORKS_COUNT</code>.
     */
    public void setForksCount(@Nullable Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>GITHUB_LINKS.FORKS_COUNT</code>.
     */
    @Nullable
    public Long getForksCount() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row3<Long, String, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    @NotNull
    public Row3<Long, String, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    @NotNull
    public Field<Long> field1() {
        return GithubLinks.GITHUB_LINKS.ID;
    }

    @Override
    @NotNull
    public Field<String> field2() {
        return GithubLinks.GITHUB_LINKS.DEFAULT_BRANCH;
    }

    @Override
    @NotNull
    public Field<Long> field3() {
        return GithubLinks.GITHUB_LINKS.FORKS_COUNT;
    }

    @Override
    @NotNull
    public Long component1() {
        return getId();
    }

    @Override
    @Nullable
    public String component2() {
        return getDefaultBranch();
    }

    @Override
    @Nullable
    public Long component3() {
        return getForksCount();
    }

    @Override
    @NotNull
    public Long value1() {
        return getId();
    }

    @Override
    @Nullable
    public String value2() {
        return getDefaultBranch();
    }

    @Override
    @Nullable
    public Long value3() {
        return getForksCount();
    }

    @Override
    @NotNull
    public GithubLinksRecord value1(@NotNull Long value) {
        setId(value);
        return this;
    }

    @Override
    @NotNull
    public GithubLinksRecord value2(@Nullable String value) {
        setDefaultBranch(value);
        return this;
    }

    @Override
    @NotNull
    public GithubLinksRecord value3(@Nullable Long value) {
        setForksCount(value);
        return this;
    }

    @Override
    @NotNull
    public GithubLinksRecord values(@NotNull Long value1, @Nullable String value2, @Nullable Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GithubLinksRecord
     */
    public GithubLinksRecord() {
        super(GithubLinks.GITHUB_LINKS);
    }

    /**
     * Create a detached, initialised GithubLinksRecord
     */
    @ConstructorProperties({ "id", "defaultBranch", "forksCount" })
    public GithubLinksRecord(@NotNull Long id, @Nullable String defaultBranch, @Nullable Long forksCount) {
        super(GithubLinks.GITHUB_LINKS);

        setId(id);
        setDefaultBranch(defaultBranch);
        setForksCount(forksCount);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised GithubLinksRecord
     */
    public GithubLinksRecord(edu.java.scrapper.domain.jooq.tables.pojos.GithubLinks value) {
        super(GithubLinks.GITHUB_LINKS);

        if (value != null) {
            setId(value.getId());
            setDefaultBranch(value.getDefaultBranch());
            setForksCount(value.getForksCount());
            resetChangedOnNotNull();
        }
    }
}
