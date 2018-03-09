/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Indexes;
import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.LexemeRegisterRecord;

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
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LexemeRegister extends TableImpl<LexemeRegisterRecord> {

    private static final long serialVersionUID = 982508163;

    /**
     * The reference instance of <code>public.lexeme_register</code>
     */
    public static final LexemeRegister LEXEME_REGISTER = new LexemeRegister();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LexemeRegisterRecord> getRecordType() {
        return LexemeRegisterRecord.class;
    }

    /**
     * The column <code>public.lexeme_register.id</code>.
     */
    public final TableField<LexemeRegisterRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_register_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.lexeme_register.lexeme_id</code>.
     */
    public final TableField<LexemeRegisterRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexeme_register.register_code</code>.
     */
    public final TableField<LexemeRegisterRecord, String> REGISTER_CODE = createField("register_code", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.lexeme_register.order_by</code>.
     */
    public final TableField<LexemeRegisterRecord, Long> ORDER_BY = createField("order_by", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_register_order_by_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>public.lexeme_register</code> table reference
     */
    public LexemeRegister() {
        this(DSL.name("lexeme_register"), null);
    }

    /**
     * Create an aliased <code>public.lexeme_register</code> table reference
     */
    public LexemeRegister(String alias) {
        this(DSL.name(alias), LEXEME_REGISTER);
    }

    /**
     * Create an aliased <code>public.lexeme_register</code> table reference
     */
    public LexemeRegister(Name alias) {
        this(alias, LEXEME_REGISTER);
    }

    private LexemeRegister(Name alias, Table<LexemeRegisterRecord> aliased) {
        this(alias, aliased, null);
    }

    private LexemeRegister(Name alias, Table<LexemeRegisterRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.LEXEME_REGISTER_LEXEME_ID_REGISTER_CODE_KEY, Indexes.LEXEME_REGISTER_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LexemeRegisterRecord, Long> getIdentity() {
        return Keys.IDENTITY_LEXEME_REGISTER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LexemeRegisterRecord> getPrimaryKey() {
        return Keys.LEXEME_REGISTER_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LexemeRegisterRecord>> getKeys() {
        return Arrays.<UniqueKey<LexemeRegisterRecord>>asList(Keys.LEXEME_REGISTER_PKEY, Keys.LEXEME_REGISTER_LEXEME_ID_REGISTER_CODE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LexemeRegisterRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LexemeRegisterRecord, ?>>asList(Keys.LEXEME_REGISTER__LEXEME_REGISTER_LEXEME_ID_FKEY, Keys.LEXEME_REGISTER__LEXEME_REGISTER_REGISTER_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeRegister as(String alias) {
        return new LexemeRegister(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeRegister as(Name alias) {
        return new LexemeRegister(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LexemeRegister rename(String name) {
        return new LexemeRegister(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LexemeRegister rename(Name name) {
        return new LexemeRegister(name, null);
    }
}
