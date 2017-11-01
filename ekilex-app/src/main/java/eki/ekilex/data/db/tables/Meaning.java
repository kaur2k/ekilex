/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.MeaningRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Meaning extends TableImpl<MeaningRecord> {

    private static final long serialVersionUID = -1011991998;

    /**
     * The reference instance of <code>public.meaning</code>
     */
    public static final Meaning MEANING = new Meaning();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MeaningRecord> getRecordType() {
        return MeaningRecord.class;
    }

    /**
     * The column <code>public.meaning.id</code>.
     */
    public final TableField<MeaningRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('meaning_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.meaning.created_on</code>.
     */
    public final TableField<MeaningRecord, Timestamp> CREATED_ON = createField("created_on", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.meaning.created_by</code>.
     */
    public final TableField<MeaningRecord, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.meaning.modified_on</code>.
     */
    public final TableField<MeaningRecord, Timestamp> MODIFIED_ON = createField("modified_on", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.meaning.modified_by</code>.
     */
    public final TableField<MeaningRecord, String> MODIFIED_BY = createField("modified_by", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.meaning.entry_class_code</code>.
     */
    public final TableField<MeaningRecord, String> ENTRY_CLASS_CODE = createField("entry_class_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.meaning.state_code</code>.
     */
    public final TableField<MeaningRecord, String> STATE_CODE = createField("state_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.meaning.type_code</code>.
     */
    public final TableField<MeaningRecord, String> TYPE_CODE = createField("type_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * Create a <code>public.meaning</code> table reference
     */
    public Meaning() {
        this(DSL.name("meaning"), null);
    }

    /**
     * Create an aliased <code>public.meaning</code> table reference
     */
    public Meaning(String alias) {
        this(DSL.name(alias), MEANING);
    }

    /**
     * Create an aliased <code>public.meaning</code> table reference
     */
    public Meaning(Name alias) {
        this(alias, MEANING);
    }

    private Meaning(Name alias, Table<MeaningRecord> aliased) {
        this(alias, aliased, null);
    }

    private Meaning(Name alias, Table<MeaningRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.MEANING_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<MeaningRecord, Long> getIdentity() {
        return Keys.IDENTITY_MEANING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MeaningRecord> getPrimaryKey() {
        return Keys.MEANING_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MeaningRecord>> getKeys() {
        return Arrays.<UniqueKey<MeaningRecord>>asList(Keys.MEANING_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MeaningRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MeaningRecord, ?>>asList(Keys.MEANING__MEANING_ENTRY_CLASS_CODE_FKEY, Keys.MEANING__MEANING_STATE_CODE_FKEY, Keys.MEANING__MEANING_TYPE_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Meaning as(String alias) {
        return new Meaning(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Meaning as(Name alias) {
        return new Meaning(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Meaning rename(String name) {
        return new Meaning(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Meaning rename(Name name) {
        return new Meaning(name, null);
    }
}
