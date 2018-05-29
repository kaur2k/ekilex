/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.DefinitionRefLinkRecord;

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
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefinitionRefLink extends TableImpl<DefinitionRefLinkRecord> {

    private static final long serialVersionUID = 1078991484;

    /**
     * The reference instance of <code>public.definition_ref_link</code>
     */
    public static final DefinitionRefLink DEFINITION_REF_LINK = new DefinitionRefLink();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DefinitionRefLinkRecord> getRecordType() {
        return DefinitionRefLinkRecord.class;
    }

    /**
     * The column <code>public.definition_ref_link.id</code>.
     */
    public final TableField<DefinitionRefLinkRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('definition_ref_link_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.definition_ref_link.definition_id</code>.
     */
    public final TableField<DefinitionRefLinkRecord, Long> DEFINITION_ID = createField("definition_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.definition_ref_link.ref_type</code>.
     */
    public final TableField<DefinitionRefLinkRecord, String> REF_TYPE = createField("ref_type", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.definition_ref_link.ref_id</code>.
     */
    public final TableField<DefinitionRefLinkRecord, Long> REF_ID = createField("ref_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.definition_ref_link.name</code>.
     */
    public final TableField<DefinitionRefLinkRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.definition_ref_link.value</code>.
     */
    public final TableField<DefinitionRefLinkRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.definition_ref_link.process_state_code</code>.
     */
    public final TableField<DefinitionRefLinkRecord, String> PROCESS_STATE_CODE = createField("process_state_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.definition_ref_link.order_by</code>.
     */
    public final TableField<DefinitionRefLinkRecord, Long> ORDER_BY = createField("order_by", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('definition_ref_link_order_by_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>public.definition_ref_link</code> table reference
     */
    public DefinitionRefLink() {
        this(DSL.name("definition_ref_link"), null);
    }

    /**
     * Create an aliased <code>public.definition_ref_link</code> table reference
     */
    public DefinitionRefLink(String alias) {
        this(DSL.name(alias), DEFINITION_REF_LINK);
    }

    /**
     * Create an aliased <code>public.definition_ref_link</code> table reference
     */
    public DefinitionRefLink(Name alias) {
        this(alias, DEFINITION_REF_LINK);
    }

    private DefinitionRefLink(Name alias, Table<DefinitionRefLinkRecord> aliased) {
        this(alias, aliased, null);
    }

    private DefinitionRefLink(Name alias, Table<DefinitionRefLinkRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.DEFINITION_REF_LINK_DEFINITION_ID_IDX, Indexes.DEFINITION_REF_LINK_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<DefinitionRefLinkRecord, Long> getIdentity() {
        return Keys.IDENTITY_DEFINITION_REF_LINK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DefinitionRefLinkRecord> getPrimaryKey() {
        return Keys.DEFINITION_REF_LINK_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DefinitionRefLinkRecord>> getKeys() {
        return Arrays.<UniqueKey<DefinitionRefLinkRecord>>asList(Keys.DEFINITION_REF_LINK_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<DefinitionRefLinkRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DefinitionRefLinkRecord, ?>>asList(Keys.DEFINITION_REF_LINK__DEFINITION_REF_LINK_DEFINITION_ID_FKEY, Keys.DEFINITION_REF_LINK__DEFINITION_REF_LINK_PROCESS_STATE_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefinitionRefLink as(String alias) {
        return new DefinitionRefLink(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefinitionRefLink as(Name alias) {
        return new DefinitionRefLink(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DefinitionRefLink rename(String name) {
        return new DefinitionRefLink(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DefinitionRefLink rename(Name name) {
        return new DefinitionRefLink(name, null);
    }
}
