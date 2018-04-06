/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.ViewWwLexeme;
import eki.ekilex.data.db.udt.records.TypeUsageRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ViewWwLexemeRecord extends TableRecordImpl<ViewWwLexemeRecord> implements Record13<Long, Long, Long, String[], String[], String[], Long, String, Long, String, TypeUsageRecord[], String[], String[]> {

    private static final long serialVersionUID = 996158850;

    /**
     * Setter for <code>public.view_ww_lexeme.lexeme_id</code>.
     */
    public void setLexemeId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.lexeme_id</code>.
     */
    public Long getLexemeId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.word_id</code>.
     */
    public void setWordId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.word_id</code>.
     */
    public Long getWordId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.meaning_id</code>.
     */
    public void setMeaningId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.meaning_id</code>.
     */
    public Long getMeaningId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.advice_notes</code>.
     */
    public void setAdviceNotes(String... value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.advice_notes</code>.
     */
    public String[] getAdviceNotes() {
        return (String[]) get(3);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.public_notes</code>.
     */
    public void setPublicNotes(String... value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.public_notes</code>.
     */
    public String[] getPublicNotes() {
        return (String[]) get(4);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.grammars</code>.
     */
    public void setGrammars(String... value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.grammars</code>.
     */
    public String[] getGrammars() {
        return (String[]) get(5);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.government_id</code>.
     */
    public void setGovernmentId(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.government_id</code>.
     */
    public Long getGovernmentId() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.government</code>.
     */
    public void setGovernment(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.government</code>.
     */
    public String getGovernment() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.usage_meaning_id</code>.
     */
    public void setUsageMeaningId(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.usage_meaning_id</code>.
     */
    public Long getUsageMeaningId() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.usage_meaning_type_code</code>.
     */
    public void setUsageMeaningTypeCode(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.usage_meaning_type_code</code>.
     */
    public String getUsageMeaningTypeCode() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.usages</code>.
     */
    public void setUsages(TypeUsageRecord... value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.usages</code>.
     */
    public TypeUsageRecord[] getUsages() {
        return (TypeUsageRecord[]) get(10);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.usage_translations</code>.
     */
    public void setUsageTranslations(String... value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.usage_translations</code>.
     */
    public String[] getUsageTranslations() {
        return (String[]) get(11);
    }

    /**
     * Setter for <code>public.view_ww_lexeme.usage_definitions</code>.
     */
    public void setUsageDefinitions(String... value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.view_ww_lexeme.usage_definitions</code>.
     */
    public String[] getUsageDefinitions() {
        return (String[]) get(12);
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<Long, Long, Long, String[], String[], String[], Long, String, Long, String, TypeUsageRecord[], String[], String[]> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<Long, Long, Long, String[], String[], String[], Long, String, Long, String, TypeUsageRecord[], String[], String[]> valuesRow() {
        return (Row13) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ViewWwLexeme.VIEW_WW_LEXEME.LEXEME_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return ViewWwLexeme.VIEW_WW_LEXEME.WORD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return ViewWwLexeme.VIEW_WW_LEXEME.MEANING_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field4() {
        return ViewWwLexeme.VIEW_WW_LEXEME.ADVICE_NOTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field5() {
        return ViewWwLexeme.VIEW_WW_LEXEME.PUBLIC_NOTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field6() {
        return ViewWwLexeme.VIEW_WW_LEXEME.GRAMMARS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return ViewWwLexeme.VIEW_WW_LEXEME.GOVERNMENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return ViewWwLexeme.VIEW_WW_LEXEME.GOVERNMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return ViewWwLexeme.VIEW_WW_LEXEME.USAGE_MEANING_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return ViewWwLexeme.VIEW_WW_LEXEME.USAGE_MEANING_TYPE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<TypeUsageRecord[]> field11() {
        return ViewWwLexeme.VIEW_WW_LEXEME.USAGES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field12() {
        return ViewWwLexeme.VIEW_WW_LEXEME.USAGE_TRANSLATIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field13() {
        return ViewWwLexeme.VIEW_WW_LEXEME.USAGE_DEFINITIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getMeaningId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component4() {
        return getAdviceNotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component5() {
        return getPublicNotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component6() {
        return getGrammars();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component7() {
        return getGovernmentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getGovernment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component9() {
        return getUsageMeaningId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getUsageMeaningTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeUsageRecord[] component11() {
        return getUsages();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component12() {
        return getUsageTranslations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component13() {
        return getUsageDefinitions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getMeaningId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value4() {
        return getAdviceNotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value5() {
        return getPublicNotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value6() {
        return getGrammars();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getGovernmentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getGovernment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getUsageMeaningId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getUsageMeaningTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeUsageRecord[] value11() {
        return getUsages();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value12() {
        return getUsageTranslations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value13() {
        return getUsageDefinitions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value1(Long value) {
        setLexemeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value2(Long value) {
        setWordId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value3(Long value) {
        setMeaningId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value4(String... value) {
        setAdviceNotes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value5(String... value) {
        setPublicNotes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value6(String... value) {
        setGrammars(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value7(Long value) {
        setGovernmentId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value8(String value) {
        setGovernment(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value9(Long value) {
        setUsageMeaningId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value10(String value) {
        setUsageMeaningTypeCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value11(TypeUsageRecord... value) {
        setUsages(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value12(String... value) {
        setUsageTranslations(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord value13(String... value) {
        setUsageDefinitions(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwLexemeRecord values(Long value1, Long value2, Long value3, String[] value4, String[] value5, String[] value6, Long value7, String value8, Long value9, String value10, TypeUsageRecord[] value11, String[] value12, String[] value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ViewWwLexemeRecord
     */
    public ViewWwLexemeRecord() {
        super(ViewWwLexeme.VIEW_WW_LEXEME);
    }

    /**
     * Create a detached, initialised ViewWwLexemeRecord
     */
    public ViewWwLexemeRecord(Long lexemeId, Long wordId, Long meaningId, String[] adviceNotes, String[] publicNotes, String[] grammars, Long governmentId, String government, Long usageMeaningId, String usageMeaningTypeCode, TypeUsageRecord[] usages, String[] usageTranslations, String[] usageDefinitions) {
        super(ViewWwLexeme.VIEW_WW_LEXEME);

        set(0, lexemeId);
        set(1, wordId);
        set(2, meaningId);
        set(3, adviceNotes);
        set(4, publicNotes);
        set(5, grammars);
        set(6, governmentId);
        set(7, government);
        set(8, usageMeaningId);
        set(9, usageMeaningTypeCode);
        set(10, usages);
        set(11, usageTranslations);
        set(12, usageDefinitions);
    }
}