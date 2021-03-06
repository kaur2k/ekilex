/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.LexemeLifecycleLogRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
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
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LexemeLifecycleLog extends TableImpl<LexemeLifecycleLogRecord> {

    private static final long serialVersionUID = -1320170671;

    /**
     * The reference instance of <code>public.lexeme_lifecycle_log</code>
     */
    public static final LexemeLifecycleLog LEXEME_LIFECYCLE_LOG = new LexemeLifecycleLog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LexemeLifecycleLogRecord> getRecordType() {
        return LexemeLifecycleLogRecord.class;
    }

    /**
     * The column <code>public.lexeme_lifecycle_log.id</code>.
     */
    public final TableField<LexemeLifecycleLogRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_lifecycle_log_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.lexeme_lifecycle_log.lexeme_id</code>.
     */
    public final TableField<LexemeLifecycleLogRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexeme_lifecycle_log.lifecycle_log_id</code>.
     */
    public final TableField<LexemeLifecycleLogRecord, Long> LIFECYCLE_LOG_ID = createField("lifecycle_log_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>public.lexeme_lifecycle_log</code> table reference
     */
    public LexemeLifecycleLog() {
        this(DSL.name("lexeme_lifecycle_log"), null);
    }

    /**
     * Create an aliased <code>public.lexeme_lifecycle_log</code> table reference
     */
    public LexemeLifecycleLog(String alias) {
        this(DSL.name(alias), LEXEME_LIFECYCLE_LOG);
    }

    /**
     * Create an aliased <code>public.lexeme_lifecycle_log</code> table reference
     */
    public LexemeLifecycleLog(Name alias) {
        this(alias, LEXEME_LIFECYCLE_LOG);
    }

    private LexemeLifecycleLog(Name alias, Table<LexemeLifecycleLogRecord> aliased) {
        this(alias, aliased, null);
    }

    private LexemeLifecycleLog(Name alias, Table<LexemeLifecycleLogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> LexemeLifecycleLog(Table<O> child, ForeignKey<O, LexemeLifecycleLogRecord> key) {
        super(child, key, LEXEME_LIFECYCLE_LOG);
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
        return Arrays.<Index>asList(Indexes.LEXEME_LIFECYCLE_LOG_LEXEME_ID_IDX, Indexes.LEXEME_LIFECYCLE_LOG_LOG_ID_IDX, Indexes.LEXEME_LIFECYCLE_LOG_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LexemeLifecycleLogRecord, Long> getIdentity() {
        return Keys.IDENTITY_LEXEME_LIFECYCLE_LOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LexemeLifecycleLogRecord> getPrimaryKey() {
        return Keys.LEXEME_LIFECYCLE_LOG_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LexemeLifecycleLogRecord>> getKeys() {
        return Arrays.<UniqueKey<LexemeLifecycleLogRecord>>asList(Keys.LEXEME_LIFECYCLE_LOG_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LexemeLifecycleLogRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LexemeLifecycleLogRecord, ?>>asList(Keys.LEXEME_LIFECYCLE_LOG__LEXEME_LIFECYCLE_LOG_LEXEME_ID_FKEY, Keys.LEXEME_LIFECYCLE_LOG__LEXEME_LIFECYCLE_LOG_LIFECYCLE_LOG_ID_FKEY);
    }

    public Lexeme lexeme() {
        return new Lexeme(this, Keys.LEXEME_LIFECYCLE_LOG__LEXEME_LIFECYCLE_LOG_LEXEME_ID_FKEY);
    }

    public LifecycleLog lifecycleLog() {
        return new LifecycleLog(this, Keys.LEXEME_LIFECYCLE_LOG__LEXEME_LIFECYCLE_LOG_LIFECYCLE_LOG_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeLifecycleLog as(String alias) {
        return new LexemeLifecycleLog(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeLifecycleLog as(Name alias) {
        return new LexemeLifecycleLog(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LexemeLifecycleLog rename(String name) {
        return new LexemeLifecycleLog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LexemeLifecycleLog rename(Name name) {
        return new LexemeLifecycleLog(name, null);
    }
}
