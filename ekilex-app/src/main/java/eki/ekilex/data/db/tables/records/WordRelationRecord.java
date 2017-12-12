/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.WordRelation;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WordRelationRecord extends UpdatableRecordImpl<WordRelationRecord> implements Record4<Long, Long, Long, String> {

    private static final long serialVersionUID = -513847453;

    /**
     * Setter for <code>public.word_relation.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.word_relation.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.word_relation.word1_id</code>.
     */
    public void setWord1Id(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.word_relation.word1_id</code>.
     */
    public Long getWord1Id() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.word_relation.word2_id</code>.
     */
    public void setWord2Id(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.word_relation.word2_id</code>.
     */
    public Long getWord2Id() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.word_relation.word_rel_type_code</code>.
     */
    public void setWordRelTypeCode(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.word_relation.word_rel_type_code</code>.
     */
    public String getWordRelTypeCode() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, Long, Long, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, Long, Long, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return WordRelation.WORD_RELATION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return WordRelation.WORD_RELATION.WORD1_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return WordRelation.WORD_RELATION.WORD2_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return WordRelation.WORD_RELATION.WORD_REL_TYPE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getWord1Id();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getWord2Id();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getWordRelTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getWord1Id();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getWord2Id();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getWordRelTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordRelationRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordRelationRecord value2(Long value) {
        setWord1Id(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordRelationRecord value3(Long value) {
        setWord2Id(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordRelationRecord value4(String value) {
        setWordRelTypeCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordRelationRecord values(Long value1, Long value2, Long value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WordRelationRecord
     */
    public WordRelationRecord() {
        super(WordRelation.WORD_RELATION);
    }

    /**
     * Create a detached, initialised WordRelationRecord
     */
    public WordRelationRecord(Long id, Long word1Id, Long word2Id, String wordRelTypeCode) {
        super(WordRelation.WORD_RELATION);

        set(0, id);
        set(1, word1Id);
        set(2, word2Id);
        set(3, wordRelTypeCode);
    }
}