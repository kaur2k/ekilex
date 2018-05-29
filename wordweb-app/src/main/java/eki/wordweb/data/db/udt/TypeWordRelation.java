/*
 * This file is generated by jOOQ.
*/
package eki.wordweb.data.db.udt;


import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.udt.records.TypeWordRelationRecord;

import javax.annotation.Generated;

import org.jooq.Schema;
import org.jooq.UDTField;
import org.jooq.impl.UDTImpl;


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
public class TypeWordRelation extends UDTImpl<TypeWordRelationRecord> {

    private static final long serialVersionUID = -84413707;

    /**
     * The reference instance of <code>public.type_word_relation</code>
     */
    public static final TypeWordRelation TYPE_WORD_RELATION = new TypeWordRelation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TypeWordRelationRecord> getRecordType() {
        return TypeWordRelationRecord.class;
    }

    /**
     * The attribute <code>public.type_word_relation.word_id</code>.
     */
    public static final UDTField<TypeWordRelationRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.word</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String> WORD = createField("word", org.jooq.impl.SQLDataType.CLOB, TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.word_lang</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String> WORD_LANG = createField("word_lang", org.jooq.impl.SQLDataType.CHAR(3), TYPE_WORD_RELATION, "");

    /**
     * The attribute <code>public.type_word_relation.word_rel_type_code</code>.
     */
    public static final UDTField<TypeWordRelationRecord, String> WORD_REL_TYPE_CODE = createField("word_rel_type_code", org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_WORD_RELATION, "");

    /**
     * No further instances allowed
     */
    private TypeWordRelation() {
        super("type_word_relation", null, null, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }
}
