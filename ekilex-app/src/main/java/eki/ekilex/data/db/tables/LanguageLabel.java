/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.LanguageLabelRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LanguageLabel extends TableImpl<LanguageLabelRecord> {

    private static final long serialVersionUID = 499128987;

    /**
     * The reference instance of <code>public.language_label</code>
     */
    public static final LanguageLabel LANGUAGE_LABEL = new LanguageLabel();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LanguageLabelRecord> getRecordType() {
        return LanguageLabelRecord.class;
    }

    /**
     * The column <code>public.language_label.code</code>.
     */
    public final TableField<LanguageLabelRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.CHAR(3).nullable(false), this, "");

    /**
     * The column <code>public.language_label.value</code>.
     */
    public final TableField<LanguageLabelRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.language_label.lang</code>.
     */
    public final TableField<LanguageLabelRecord, String> LANG = createField("lang", org.jooq.impl.SQLDataType.CHAR(3).nullable(false), this, "");

    /**
     * The column <code>public.language_label.type</code>.
     */
    public final TableField<LanguageLabelRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * Create a <code>public.language_label</code> table reference
     */
    public LanguageLabel() {
        this(DSL.name("language_label"), null);
    }

    /**
     * Create an aliased <code>public.language_label</code> table reference
     */
    public LanguageLabel(String alias) {
        this(DSL.name(alias), LANGUAGE_LABEL);
    }

    /**
     * Create an aliased <code>public.language_label</code> table reference
     */
    public LanguageLabel(Name alias) {
        this(alias, LANGUAGE_LABEL);
    }

    private LanguageLabel(Name alias, Table<LanguageLabelRecord> aliased) {
        this(alias, aliased, null);
    }

    private LanguageLabel(Name alias, Table<LanguageLabelRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> LanguageLabel(Table<O> child, ForeignKey<O, LanguageLabelRecord> key) {
        super(child, key, LANGUAGE_LABEL);
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
        return Arrays.<Index>asList(Indexes.LANGUAGE_LABEL_CODE_LANG_TYPE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LanguageLabelRecord>> getKeys() {
        return Arrays.<UniqueKey<LanguageLabelRecord>>asList(Keys.LANGUAGE_LABEL_CODE_LANG_TYPE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LanguageLabelRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LanguageLabelRecord, ?>>asList(Keys.LANGUAGE_LABEL__LANGUAGE_LABEL_CODE_FKEY, Keys.LANGUAGE_LABEL__LANGUAGE_LABEL_LANG_FKEY, Keys.LANGUAGE_LABEL__LANGUAGE_LABEL_TYPE_FKEY);
    }

    public Language languageLabel_LanguageLabelCodeFkey() {
        return new Language(this, Keys.LANGUAGE_LABEL__LANGUAGE_LABEL_CODE_FKEY);
    }

    public Language languageLabel_LanguageLabelLangFkey() {
        return new Language(this, Keys.LANGUAGE_LABEL__LANGUAGE_LABEL_LANG_FKEY);
    }

    public LabelType labelType() {
        return new LabelType(this, Keys.LANGUAGE_LABEL__LANGUAGE_LABEL_TYPE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguageLabel as(String alias) {
        return new LanguageLabel(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguageLabel as(Name alias) {
        return new LanguageLabel(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LanguageLabel rename(String name) {
        return new LanguageLabel(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LanguageLabel rename(Name name) {
        return new LanguageLabel(name, null);
    }
}