/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.aspect_type_order_by_seq</code>
     */
    public static final Sequence<Long> ASPECT_TYPE_ORDER_BY_SEQ = new SequenceImpl<Long>("aspect_type_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.collocation_freeform_id_seq</code>
     */
    public static final Sequence<Long> COLLOCATION_FREEFORM_ID_SEQ = new SequenceImpl<Long>("collocation_freeform_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.collocation_id_seq</code>
     */
    public static final Sequence<Long> COLLOCATION_ID_SEQ = new SequenceImpl<Long>("collocation_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.dataset_order_by_seq</code>
     */
    public static final Sequence<Long> DATASET_ORDER_BY_SEQ = new SequenceImpl<Long>("dataset_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.definition_freeform_id_seq</code>
     */
    public static final Sequence<Long> DEFINITION_FREEFORM_ID_SEQ = new SequenceImpl<Long>("definition_freeform_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.definition_id_seq</code>
     */
    public static final Sequence<Long> DEFINITION_ID_SEQ = new SequenceImpl<Long>("definition_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.definition_order_by_seq</code>
     */
    public static final Sequence<Long> DEFINITION_ORDER_BY_SEQ = new SequenceImpl<Long>("definition_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.definition_source_link_id_seq</code>
     */
    public static final Sequence<Long> DEFINITION_SOURCE_LINK_ID_SEQ = new SequenceImpl<Long>("definition_source_link_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.definition_source_link_order_by_seq</code>
     */
    public static final Sequence<Long> DEFINITION_SOURCE_LINK_ORDER_BY_SEQ = new SequenceImpl<Long>("definition_source_link_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.deriv_order_by_seq</code>
     */
    public static final Sequence<Long> DERIV_ORDER_BY_SEQ = new SequenceImpl<Long>("deriv_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.display_morph_order_by_seq</code>
     */
    public static final Sequence<Long> DISPLAY_MORPH_ORDER_BY_SEQ = new SequenceImpl<Long>("display_morph_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.domain_order_by_seq</code>
     */
    public static final Sequence<Long> DOMAIN_ORDER_BY_SEQ = new SequenceImpl<Long>("domain_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.eki_user_id_seq</code>
     */
    public static final Sequence<Long> EKI_USER_ID_SEQ = new SequenceImpl<Long>("eki_user_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.etymology_type_order_by_seq</code>
     */
    public static final Sequence<Long> ETYMOLOGY_TYPE_ORDER_BY_SEQ = new SequenceImpl<Long>("etymology_type_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.feedback_log_id_seq</code>
     */
    public static final Sequence<Long> FEEDBACK_LOG_ID_SEQ = new SequenceImpl<Long>("feedback_log_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.form_id_seq</code>
     */
    public static final Sequence<Long> FORM_ID_SEQ = new SequenceImpl<Long>("form_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.freeform_id_seq</code>
     */
    public static final Sequence<Long> FREEFORM_ID_SEQ = new SequenceImpl<Long>("freeform_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.freeform_order_by_seq</code>
     */
    public static final Sequence<Long> FREEFORM_ORDER_BY_SEQ = new SequenceImpl<Long>("freeform_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.freeform_source_link_id_seq</code>
     */
    public static final Sequence<Long> FREEFORM_SOURCE_LINK_ID_SEQ = new SequenceImpl<Long>("freeform_source_link_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.freeform_source_link_order_by_seq</code>
     */
    public static final Sequence<Long> FREEFORM_SOURCE_LINK_ORDER_BY_SEQ = new SequenceImpl<Long>("freeform_source_link_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.game_nonword_id_seq</code>
     */
    public static final Sequence<Long> GAME_NONWORD_ID_SEQ = new SequenceImpl<Long>("game_nonword_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.gender_order_by_seq</code>
     */
    public static final Sequence<Long> GENDER_ORDER_BY_SEQ = new SequenceImpl<Long>("gender_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.government_type_order_by_seq</code>
     */
    public static final Sequence<Long> GOVERNMENT_TYPE_ORDER_BY_SEQ = new SequenceImpl<Long>("government_type_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.language_order_by_seq</code>
     */
    public static final Sequence<Long> LANGUAGE_ORDER_BY_SEQ = new SequenceImpl<Long>("language_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lex_colloc_id_seq</code>
     */
    public static final Sequence<Long> LEX_COLLOC_ID_SEQ = new SequenceImpl<Long>("lex_colloc_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lex_colloc_pos_group_id_seq</code>
     */
    public static final Sequence<Long> LEX_COLLOC_POS_GROUP_ID_SEQ = new SequenceImpl<Long>("lex_colloc_pos_group_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lex_colloc_pos_group_order_by_seq</code>
     */
    public static final Sequence<Long> LEX_COLLOC_POS_GROUP_ORDER_BY_SEQ = new SequenceImpl<Long>("lex_colloc_pos_group_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lex_colloc_rel_group_id_seq</code>
     */
    public static final Sequence<Long> LEX_COLLOC_REL_GROUP_ID_SEQ = new SequenceImpl<Long>("lex_colloc_rel_group_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lex_colloc_rel_group_order_by_seq</code>
     */
    public static final Sequence<Long> LEX_COLLOC_REL_GROUP_ORDER_BY_SEQ = new SequenceImpl<Long>("lex_colloc_rel_group_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lex_rel_type_order_by_seq</code>
     */
    public static final Sequence<Long> LEX_REL_TYPE_ORDER_BY_SEQ = new SequenceImpl<Long>("lex_rel_type_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lex_relation_id_seq</code>
     */
    public static final Sequence<Long> LEX_RELATION_ID_SEQ = new SequenceImpl<Long>("lex_relation_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lex_relation_order_by_seq</code>
     */
    public static final Sequence<Long> LEX_RELATION_ORDER_BY_SEQ = new SequenceImpl<Long>("lex_relation_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_deriv_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_DERIV_ID_SEQ = new SequenceImpl<Long>("lexeme_deriv_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_freeform_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_FREEFORM_ID_SEQ = new SequenceImpl<Long>("lexeme_freeform_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_frequency_order_by_seq</code>
     */
    public static final Sequence<Long> LEXEME_FREQUENCY_ORDER_BY_SEQ = new SequenceImpl<Long>("lexeme_frequency_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_ID_SEQ = new SequenceImpl<Long>("lexeme_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_lifecycle_log_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_LIFECYCLE_LOG_ID_SEQ = new SequenceImpl<Long>("lexeme_lifecycle_log_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_order_by_seq</code>
     */
    public static final Sequence<Long> LEXEME_ORDER_BY_SEQ = new SequenceImpl<Long>("lexeme_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_pos_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_POS_ID_SEQ = new SequenceImpl<Long>("lexeme_pos_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_pos_order_by_seq</code>
     */
    public static final Sequence<Long> LEXEME_POS_ORDER_BY_SEQ = new SequenceImpl<Long>("lexeme_pos_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_register_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_REGISTER_ID_SEQ = new SequenceImpl<Long>("lexeme_register_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_register_order_by_seq</code>
     */
    public static final Sequence<Long> LEXEME_REGISTER_ORDER_BY_SEQ = new SequenceImpl<Long>("lexeme_register_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_source_link_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_SOURCE_LINK_ID_SEQ = new SequenceImpl<Long>("lexeme_source_link_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_source_link_order_by_seq</code>
     */
    public static final Sequence<Long> LEXEME_SOURCE_LINK_ORDER_BY_SEQ = new SequenceImpl<Long>("lexeme_source_link_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lifecycle_log_id_seq</code>
     */
    public static final Sequence<Long> LIFECYCLE_LOG_ID_SEQ = new SequenceImpl<Long>("lifecycle_log_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_domain_id_seq</code>
     */
    public static final Sequence<Long> MEANING_DOMAIN_ID_SEQ = new SequenceImpl<Long>("meaning_domain_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_domain_order_by_seq</code>
     */
    public static final Sequence<Long> MEANING_DOMAIN_ORDER_BY_SEQ = new SequenceImpl<Long>("meaning_domain_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_freeform_id_seq</code>
     */
    public static final Sequence<Long> MEANING_FREEFORM_ID_SEQ = new SequenceImpl<Long>("meaning_freeform_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_id_seq</code>
     */
    public static final Sequence<Long> MEANING_ID_SEQ = new SequenceImpl<Long>("meaning_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_lifecycle_log_id_seq</code>
     */
    public static final Sequence<Long> MEANING_LIFECYCLE_LOG_ID_SEQ = new SequenceImpl<Long>("meaning_lifecycle_log_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_rel_type_order_by_seq</code>
     */
    public static final Sequence<Long> MEANING_REL_TYPE_ORDER_BY_SEQ = new SequenceImpl<Long>("meaning_rel_type_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_relation_id_seq</code>
     */
    public static final Sequence<Long> MEANING_RELATION_ID_SEQ = new SequenceImpl<Long>("meaning_relation_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_relation_order_by_seq</code>
     */
    public static final Sequence<Long> MEANING_RELATION_ORDER_BY_SEQ = new SequenceImpl<Long>("meaning_relation_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.morph_order_by_seq</code>
     */
    public static final Sequence<Long> MORPH_ORDER_BY_SEQ = new SequenceImpl<Long>("morph_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.paradigm_id_seq</code>
     */
    public static final Sequence<Long> PARADIGM_ID_SEQ = new SequenceImpl<Long>("paradigm_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.pos_group_order_by_seq</code>
     */
    public static final Sequence<Long> POS_GROUP_ORDER_BY_SEQ = new SequenceImpl<Long>("pos_group_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.pos_order_by_seq</code>
     */
    public static final Sequence<Long> POS_ORDER_BY_SEQ = new SequenceImpl<Long>("pos_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.process_state_order_by_seq</code>
     */
    public static final Sequence<Long> PROCESS_STATE_ORDER_BY_SEQ = new SequenceImpl<Long>("process_state_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.register_order_by_seq</code>
     */
    public static final Sequence<Long> REGISTER_ORDER_BY_SEQ = new SequenceImpl<Long>("register_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.source_freeform_id_seq</code>
     */
    public static final Sequence<Long> SOURCE_FREEFORM_ID_SEQ = new SequenceImpl<Long>("source_freeform_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.source_id_seq</code>
     */
    public static final Sequence<Long> SOURCE_ID_SEQ = new SequenceImpl<Long>("source_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.usage_type_order_by_seq</code>
     */
    public static final Sequence<Long> USAGE_TYPE_ORDER_BY_SEQ = new SequenceImpl<Long>("usage_type_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.value_state_order_by_seq</code>
     */
    public static final Sequence<Long> VALUE_STATE_ORDER_BY_SEQ = new SequenceImpl<Long>("value_state_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_etymology_id_seq</code>
     */
    public static final Sequence<Long> WORD_ETYMOLOGY_ID_SEQ = new SequenceImpl<Long>("word_etymology_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_etymology_order_by_seq</code>
     */
    public static final Sequence<Long> WORD_ETYMOLOGY_ORDER_BY_SEQ = new SequenceImpl<Long>("word_etymology_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_group_id_seq</code>
     */
    public static final Sequence<Long> WORD_GROUP_ID_SEQ = new SequenceImpl<Long>("word_group_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_group_member_id_seq</code>
     */
    public static final Sequence<Long> WORD_GROUP_MEMBER_ID_SEQ = new SequenceImpl<Long>("word_group_member_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_group_member_order_by_seq</code>
     */
    public static final Sequence<Long> WORD_GROUP_MEMBER_ORDER_BY_SEQ = new SequenceImpl<Long>("word_group_member_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_guid_id_seq</code>
     */
    public static final Sequence<Long> WORD_GUID_ID_SEQ = new SequenceImpl<Long>("word_guid_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_id_seq</code>
     */
    public static final Sequence<Long> WORD_ID_SEQ = new SequenceImpl<Long>("word_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_lifecycle_log_id_seq</code>
     */
    public static final Sequence<Long> WORD_LIFECYCLE_LOG_ID_SEQ = new SequenceImpl<Long>("word_lifecycle_log_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_rel_type_order_by_seq</code>
     */
    public static final Sequence<Long> WORD_REL_TYPE_ORDER_BY_SEQ = new SequenceImpl<Long>("word_rel_type_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_relation_id_seq</code>
     */
    public static final Sequence<Long> WORD_RELATION_ID_SEQ = new SequenceImpl<Long>("word_relation_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_relation_order_by_seq</code>
     */
    public static final Sequence<Long> WORD_RELATION_ORDER_BY_SEQ = new SequenceImpl<Long>("word_relation_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_source_link_id_seq</code>
     */
    public static final Sequence<Long> WORD_SOURCE_LINK_ID_SEQ = new SequenceImpl<Long>("word_source_link_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_source_link_order_by_seq</code>
     */
    public static final Sequence<Long> WORD_SOURCE_LINK_ORDER_BY_SEQ = new SequenceImpl<Long>("word_source_link_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_type_order_by_seq</code>
     */
    public static final Sequence<Long> WORD_TYPE_ORDER_BY_SEQ = new SequenceImpl<Long>("word_type_order_by_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
