/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.ViewWwCollocation;
import eki.ekilex.data.db.udt.records.TypeCollocMemberRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record19;
import org.jooq.Row19;
import org.jooq.impl.TableRecordImpl;


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
public class ViewWwCollocationRecord extends TableRecordImpl<ViewWwCollocationRecord> implements Record19<Long, Long, String, Integer, Integer, Integer, Long, String, Long, Long, String, Long, Integer, Long, String, String, String[], TypeCollocMemberRecord[], String> {

    private static final long serialVersionUID = -1633575698;

    /**
     * Setter for <code>public.view_ww_collocation.lexeme_id</code>.
     */
    public void setLexemeId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.lexeme_id</code>.
     */
    public Long getLexemeId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.view_ww_collocation.word_id</code>.
     */
    public void setWordId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.word_id</code>.
     */
    public Long getWordId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.view_ww_collocation.dataset_code</code>.
     */
    public void setDatasetCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.dataset_code</code>.
     */
    public String getDatasetCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.view_ww_collocation.level1</code>.
     */
    public void setLevel1(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.level1</code>.
     */
    public Integer getLevel1() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.view_ww_collocation.level2</code>.
     */
    public void setLevel2(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.level2</code>.
     */
    public Integer getLevel2() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.view_ww_collocation.level3</code>.
     */
    public void setLevel3(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.level3</code>.
     */
    public Integer getLevel3() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.view_ww_collocation.pos_group_id</code>.
     */
    public void setPosGroupId(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.pos_group_id</code>.
     */
    public Long getPosGroupId() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.view_ww_collocation.pos_group_code</code>.
     */
    public void setPosGroupCode(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.pos_group_code</code>.
     */
    public String getPosGroupCode() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.view_ww_collocation.pos_group_order_by</code>.
     */
    public void setPosGroupOrderBy(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.pos_group_order_by</code>.
     */
    public Long getPosGroupOrderBy() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>public.view_ww_collocation.rel_group_id</code>.
     */
    public void setRelGroupId(Long value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.rel_group_id</code>.
     */
    public Long getRelGroupId() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>public.view_ww_collocation.rel_group_name</code>.
     */
    public void setRelGroupName(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.rel_group_name</code>.
     */
    public String getRelGroupName() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.view_ww_collocation.rel_group_order_by</code>.
     */
    public void setRelGroupOrderBy(Long value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.rel_group_order_by</code>.
     */
    public Long getRelGroupOrderBy() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>public.view_ww_collocation.colloc_group_order</code>.
     */
    public void setCollocGroupOrder(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.colloc_group_order</code>.
     */
    public Integer getCollocGroupOrder() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>public.view_ww_collocation.colloc_id</code>.
     */
    public void setCollocId(Long value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.colloc_id</code>.
     */
    public Long getCollocId() {
        return (Long) get(13);
    }

    /**
     * Setter for <code>public.view_ww_collocation.colloc_value</code>.
     */
    public void setCollocValue(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.colloc_value</code>.
     */
    public String getCollocValue() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.view_ww_collocation.colloc_definition</code>.
     */
    public void setCollocDefinition(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.colloc_definition</code>.
     */
    public String getCollocDefinition() {
        return (String) get(15);
    }

    /**
     * Setter for <code>public.view_ww_collocation.colloc_usages</code>.
     */
    public void setCollocUsages(String... value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.colloc_usages</code>.
     */
    public String[] getCollocUsages() {
        return (String[]) get(16);
    }

    /**
     * Setter for <code>public.view_ww_collocation.colloc_members</code>.
     */
    public void setCollocMembers(TypeCollocMemberRecord... value) {
        set(17, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.colloc_members</code>.
     */
    public TypeCollocMemberRecord[] getCollocMembers() {
        return (TypeCollocMemberRecord[]) get(17);
    }

    /**
     * Setter for <code>public.view_ww_collocation.target_context</code>.
     */
    public void setTargetContext(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>public.view_ww_collocation.target_context</code>.
     */
    public String getTargetContext() {
        return (String) get(18);
    }

    // -------------------------------------------------------------------------
    // Record19 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row19<Long, Long, String, Integer, Integer, Integer, Long, String, Long, Long, String, Long, Integer, Long, String, String, String[], TypeCollocMemberRecord[], String> fieldsRow() {
        return (Row19) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row19<Long, Long, String, Integer, Integer, Integer, Long, String, Long, Long, String, Long, Integer, Long, String, String, String[], TypeCollocMemberRecord[], String> valuesRow() {
        return (Row19) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.LEXEME_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.WORD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.DATASET_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.LEVEL1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.LEVEL2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.LEVEL3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.POS_GROUP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.POS_GROUP_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.POS_GROUP_ORDER_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field10() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.REL_GROUP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.REL_GROUP_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field12() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.REL_GROUP_ORDER_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field13() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.COLLOC_GROUP_ORDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field14() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.COLLOC_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.COLLOC_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field16() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.COLLOC_DEFINITION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field17() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.COLLOC_USAGES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<TypeCollocMemberRecord[]> field18() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.COLLOC_MEMBERS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field19() {
        return ViewWwCollocation.VIEW_WW_COLLOCATION.TARGET_CONTEXT;
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
    public String component3() {
        return getDatasetCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getLevel1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getLevel2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getLevel3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component7() {
        return getPosGroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getPosGroupCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component9() {
        return getPosGroupOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component10() {
        return getRelGroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getRelGroupName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component12() {
        return getRelGroupOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component13() {
        return getCollocGroupOrder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component14() {
        return getCollocId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getCollocValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component16() {
        return getCollocDefinition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component17() {
        return getCollocUsages();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeCollocMemberRecord[] component18() {
        return getCollocMembers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component19() {
        return getTargetContext();
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
    public String value3() {
        return getDatasetCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getLevel1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getLevel2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getLevel3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getPosGroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getPosGroupCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getPosGroupOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value10() {
        return getRelGroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getRelGroupName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value12() {
        return getRelGroupOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value13() {
        return getCollocGroupOrder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value14() {
        return getCollocId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getCollocValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value16() {
        return getCollocDefinition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value17() {
        return getCollocUsages();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeCollocMemberRecord[] value18() {
        return getCollocMembers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value19() {
        return getTargetContext();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value1(Long value) {
        setLexemeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value2(Long value) {
        setWordId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value3(String value) {
        setDatasetCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value4(Integer value) {
        setLevel1(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value5(Integer value) {
        setLevel2(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value6(Integer value) {
        setLevel3(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value7(Long value) {
        setPosGroupId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value8(String value) {
        setPosGroupCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value9(Long value) {
        setPosGroupOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value10(Long value) {
        setRelGroupId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value11(String value) {
        setRelGroupName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value12(Long value) {
        setRelGroupOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value13(Integer value) {
        setCollocGroupOrder(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value14(Long value) {
        setCollocId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value15(String value) {
        setCollocValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value16(String value) {
        setCollocDefinition(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value17(String... value) {
        setCollocUsages(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value18(TypeCollocMemberRecord... value) {
        setCollocMembers(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord value19(String value) {
        setTargetContext(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwCollocationRecord values(Long value1, Long value2, String value3, Integer value4, Integer value5, Integer value6, Long value7, String value8, Long value9, Long value10, String value11, Long value12, Integer value13, Long value14, String value15, String value16, String[] value17, TypeCollocMemberRecord[] value18, String value19) {
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
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ViewWwCollocationRecord
     */
    public ViewWwCollocationRecord() {
        super(ViewWwCollocation.VIEW_WW_COLLOCATION);
    }

    /**
     * Create a detached, initialised ViewWwCollocationRecord
     */
    public ViewWwCollocationRecord(Long lexemeId, Long wordId, String datasetCode, Integer level1, Integer level2, Integer level3, Long posGroupId, String posGroupCode, Long posGroupOrderBy, Long relGroupId, String relGroupName, Long relGroupOrderBy, Integer collocGroupOrder, Long collocId, String collocValue, String collocDefinition, String[] collocUsages, TypeCollocMemberRecord[] collocMembers, String targetContext) {
        super(ViewWwCollocation.VIEW_WW_COLLOCATION);

        set(0, lexemeId);
        set(1, wordId);
        set(2, datasetCode);
        set(3, level1);
        set(4, level2);
        set(5, level3);
        set(6, posGroupId);
        set(7, posGroupCode);
        set(8, posGroupOrderBy);
        set(9, relGroupId);
        set(10, relGroupName);
        set(11, relGroupOrderBy);
        set(12, collocGroupOrder);
        set(13, collocId);
        set(14, collocValue);
        set(15, collocDefinition);
        set(16, collocUsages);
        set(17, collocMembers);
        set(18, targetContext);
    }
}
