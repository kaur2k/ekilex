/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.LexemeRegister;

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
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LexemeRegisterRecord extends UpdatableRecordImpl<LexemeRegisterRecord> implements Record5<Long, Long, String, String, Long> {

    private static final long serialVersionUID = -1218587397;

    /**
     * Setter for <code>public.lexeme_register.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lexeme_register.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.lexeme_register.lexeme_id</code>.
     */
    public void setLexemeId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lexeme_register.lexeme_id</code>.
     */
    public Long getLexemeId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.lexeme_register.register_code</code>.
     */
    public void setRegisterCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lexeme_register.register_code</code>.
     */
    public String getRegisterCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.lexeme_register.process_state_code</code>.
     */
    public void setProcessStateCode(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lexeme_register.process_state_code</code>.
     */
    public String getProcessStateCode() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.lexeme_register.order_by</code>.
     */
    public void setOrderBy(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lexeme_register.order_by</code>.
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
        return LexemeRegister.LEXEME_REGISTER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return LexemeRegister.LEXEME_REGISTER.LEXEME_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return LexemeRegister.LEXEME_REGISTER.REGISTER_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return LexemeRegister.LEXEME_REGISTER.PROCESS_STATE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return LexemeRegister.LEXEME_REGISTER.ORDER_BY;
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
        return getRegisterCode();
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
        return getRegisterCode();
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
    public LexemeRegisterRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeRegisterRecord value2(Long value) {
        setLexemeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeRegisterRecord value3(String value) {
        setRegisterCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeRegisterRecord value4(String value) {
        setProcessStateCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeRegisterRecord value5(Long value) {
        setOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeRegisterRecord values(Long value1, Long value2, String value3, String value4, Long value5) {
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
     * Create a detached LexemeRegisterRecord
     */
    public LexemeRegisterRecord() {
        super(LexemeRegister.LEXEME_REGISTER);
    }

    /**
     * Create a detached, initialised LexemeRegisterRecord
     */
    public LexemeRegisterRecord(Long id, Long lexemeId, String registerCode, String processStateCode, Long orderBy) {
        super(LexemeRegister.LEXEME_REGISTER);

        set(0, id);
        set(1, lexemeId);
        set(2, registerCode);
        set(3, processStateCode);
        set(4, orderBy);
    }
}
