/*
 * This file is generated by jOOQ.
*/
package eki.wordweb.data.db.tables;


import eki.wordweb.data.db.Indexes;
import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.tables.records.MviewWwMeaningRelationRecord;
import eki.wordweb.data.db.udt.records.TypeMeaningRelationRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MviewWwMeaningRelation extends TableImpl<MviewWwMeaningRelationRecord> {

    private static final long serialVersionUID = -856744716;

    /**
     * The reference instance of <code>public.mview_ww_meaning_relation</code>
     */
    public static final MviewWwMeaningRelation MVIEW_WW_MEANING_RELATION = new MviewWwMeaningRelation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MviewWwMeaningRelationRecord> getRecordType() {
        return MviewWwMeaningRelationRecord.class;
    }

    /**
     * The column <code>public.mview_ww_meaning_relation.lexeme_id</code>.
     */
    public final TableField<MviewWwMeaningRelationRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mview_ww_meaning_relation.meaning_id</code>.
     */
    public final TableField<MviewWwMeaningRelationRecord, Long> MEANING_ID = createField("meaning_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mview_ww_meaning_relation.related_meanings</code>.
     */
    public final TableField<MviewWwMeaningRelationRecord, TypeMeaningRelationRecord[]> RELATED_MEANINGS = createField("related_meanings", eki.wordweb.data.db.udt.TypeMeaningRelation.TYPE_MEANING_RELATION.getDataType().getArrayDataType(), this, "");

    /**
     * Create a <code>public.mview_ww_meaning_relation</code> table reference
     */
    public MviewWwMeaningRelation() {
        this(DSL.name("mview_ww_meaning_relation"), null);
    }

    /**
     * Create an aliased <code>public.mview_ww_meaning_relation</code> table reference
     */
    public MviewWwMeaningRelation(String alias) {
        this(DSL.name(alias), MVIEW_WW_MEANING_RELATION);
    }

    /**
     * Create an aliased <code>public.mview_ww_meaning_relation</code> table reference
     */
    public MviewWwMeaningRelation(Name alias) {
        this(alias, MVIEW_WW_MEANING_RELATION);
    }

    private MviewWwMeaningRelation(Name alias, Table<MviewWwMeaningRelationRecord> aliased) {
        this(alias, aliased, null);
    }

    private MviewWwMeaningRelation(Name alias, Table<MviewWwMeaningRelationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.MVIEW_WW_MEANING_RELATION_LEXEME_ID_IDX, Indexes.MVIEW_WW_MEANING_RELATION_MEANING_ID_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRelation as(String alias) {
        return new MviewWwMeaningRelation(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRelation as(Name alias) {
        return new MviewWwMeaningRelation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MviewWwMeaningRelation rename(String name) {
        return new MviewWwMeaningRelation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MviewWwMeaningRelation rename(Name name) {
        return new MviewWwMeaningRelation(name, null);
    }
}
