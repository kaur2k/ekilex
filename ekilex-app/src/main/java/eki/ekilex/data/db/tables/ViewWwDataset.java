/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.ViewWwDatasetRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
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
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ViewWwDataset extends TableImpl<ViewWwDatasetRecord> {

    private static final long serialVersionUID = 973582079;

    /**
     * The reference instance of <code>public.view_ww_dataset</code>
     */
    public static final ViewWwDataset VIEW_WW_DATASET = new ViewWwDataset();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ViewWwDatasetRecord> getRecordType() {
        return ViewWwDatasetRecord.class;
    }

    /**
     * The column <code>public.view_ww_dataset.code</code>.
     */
    public final TableField<ViewWwDatasetRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.view_ww_dataset.name</code>.
     */
    public final TableField<ViewWwDatasetRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.view_ww_dataset.description</code>.
     */
    public final TableField<ViewWwDatasetRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<ViewWwDatasetRecord, Object> LANG = createField("lang", org.jooq.impl.DefaultDataType.getDefaultDataType("\"pg_catalog\".\"unknown\""), this, "");

    /**
     * The column <code>public.view_ww_dataset.order_by</code>.
     */
    public final TableField<ViewWwDatasetRecord, Long> ORDER_BY = createField("order_by", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>public.view_ww_dataset</code> table reference
     */
    public ViewWwDataset() {
        this(DSL.name("view_ww_dataset"), null);
    }

    /**
     * Create an aliased <code>public.view_ww_dataset</code> table reference
     */
    public ViewWwDataset(String alias) {
        this(DSL.name(alias), VIEW_WW_DATASET);
    }

    /**
     * Create an aliased <code>public.view_ww_dataset</code> table reference
     */
    public ViewWwDataset(Name alias) {
        this(alias, VIEW_WW_DATASET);
    }

    private ViewWwDataset(Name alias, Table<ViewWwDatasetRecord> aliased) {
        this(alias, aliased, null);
    }

    private ViewWwDataset(Name alias, Table<ViewWwDatasetRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ViewWwDataset(Table<O> child, ForeignKey<O, ViewWwDatasetRecord> key) {
        super(child, key, VIEW_WW_DATASET);
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
    public ViewWwDataset as(String alias) {
        return new ViewWwDataset(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwDataset as(Name alias) {
        return new ViewWwDataset(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ViewWwDataset rename(String name) {
        return new ViewWwDataset(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ViewWwDataset rename(Name name) {
        return new ViewWwDataset(name, null);
    }
}
