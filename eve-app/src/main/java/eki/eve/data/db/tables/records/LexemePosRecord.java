/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables.records;


import eki.eve.data.db.tables.LexemePos;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LexemePosRecord extends UpdatableRecordImpl<LexemePosRecord> implements Record5<Long, Long, String, String, Long> {

    private static final long serialVersionUID = 1215079260;

    /**
     * Setter for <code>public.lexeme_pos.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lexeme_pos.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.lexeme_pos.lexeme_id</code>.
     */
    public void setLexemeId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lexeme_pos.lexeme_id</code>.
     */
    public Long getLexemeId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.lexeme_pos.pos_code</code>.
     */
    public void setPosCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lexeme_pos.pos_code</code>.
     */
    public String getPosCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lexeme_pos.process_state_code</code>.
     */
    public void setProcessStateCode(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lexeme_pos.process_state_code</code>.
     */
    public String getProcessStateCode() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.lexeme_pos.order_by</code>.
     */
    public void setOrderBy(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lexeme_pos.order_by</code>.
     */
    public Long getOrderBy() {
        return (Long) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Long, Long, String, String, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Long, Long, String, String, Long> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return LexemePos.LEXEME_POS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return LexemePos.LEXEME_POS.LEXEME_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return LexemePos.LEXEME_POS.POS_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return LexemePos.LEXEME_POS.PROCESS_STATE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return LexemePos.LEXEME_POS.ORDER_BY;
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
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getPosCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getProcessStateCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getOrderBy();
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
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPosCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getProcessStateCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemePosRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemePosRecord value2(Long value) {
        setLexemeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemePosRecord value3(String value) {
        setPosCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemePosRecord value4(String value) {
        setProcessStateCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemePosRecord value5(Long value) {
        setOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemePosRecord values(Long value1, Long value2, String value3, String value4, Long value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LexemePosRecord
     */
    public LexemePosRecord() {
        super(LexemePos.LEXEME_POS);
    }

    /**
     * Create a detached, initialised LexemePosRecord
     */
    public LexemePosRecord(Long id, Long lexemeId, String posCode, String processStateCode, Long orderBy) {
        super(LexemePos.LEXEME_POS);

        set(0, id);
        set(1, lexemeId);
        set(2, posCode);
        set(3, processStateCode);
        set(4, orderBy);
    }
}
