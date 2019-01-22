/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db;


import eki.wordweb.data.db.tables.LexicalDecisionData;
import eki.wordweb.data.db.tables.LexicalDecisionResult;
import eki.wordweb.data.db.tables.MviewWwAsWord;
import eki.wordweb.data.db.tables.MviewWwClassifier;
import eki.wordweb.data.db.tables.MviewWwCollocation;
import eki.wordweb.data.db.tables.MviewWwDataset;
import eki.wordweb.data.db.tables.MviewWwForm;
import eki.wordweb.data.db.tables.MviewWwLexeme;
import eki.wordweb.data.db.tables.MviewWwLexemeRelation;
import eki.wordweb.data.db.tables.MviewWwMeaning;
import eki.wordweb.data.db.tables.MviewWwMeaningRelation;
import eki.wordweb.data.db.tables.MviewWwWord;
import eki.wordweb.data.db.tables.MviewWwWordEtymology;
import eki.wordweb.data.db.tables.MviewWwWordRelation;
import eki.wordweb.data.db.tables.SimilarityJudgementData;
import eki.wordweb.data.db.tables.SimilarityJudgementResult;
import eki.wordweb.data.db.udt.TypeCollocMember;
import eki.wordweb.data.db.udt.TypeDefinition;
import eki.wordweb.data.db.udt.TypeDomain;
import eki.wordweb.data.db.udt.TypeLexemeRelation;
import eki.wordweb.data.db.udt.TypeMeaningRelation;
import eki.wordweb.data.db.udt.TypeUsage;
import eki.wordweb.data.db.udt.TypeWord;
import eki.wordweb.data.db.udt.TypeWordEtym;
import eki.wordweb.data.db.udt.TypeWordRelation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.UDT;
import org.jooq.impl.SchemaImpl;


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
public class Public extends SchemaImpl {

    private static final long serialVersionUID = -501732777;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.lexical_decision_data</code>.
     */
    public final LexicalDecisionData LEXICAL_DECISION_DATA = eki.wordweb.data.db.tables.LexicalDecisionData.LEXICAL_DECISION_DATA;

    /**
     * The table <code>public.lexical_decision_result</code>.
     */
    public final LexicalDecisionResult LEXICAL_DECISION_RESULT = eki.wordweb.data.db.tables.LexicalDecisionResult.LEXICAL_DECISION_RESULT;

    /**
     * The table <code>public.mview_ww_as_word</code>.
     */
    public final MviewWwAsWord MVIEW_WW_AS_WORD = eki.wordweb.data.db.tables.MviewWwAsWord.MVIEW_WW_AS_WORD;

    /**
     * The table <code>public.mview_ww_classifier</code>.
     */
    public final MviewWwClassifier MVIEW_WW_CLASSIFIER = eki.wordweb.data.db.tables.MviewWwClassifier.MVIEW_WW_CLASSIFIER;

    /**
     * The table <code>public.mview_ww_collocation</code>.
     */
    public final MviewWwCollocation MVIEW_WW_COLLOCATION = eki.wordweb.data.db.tables.MviewWwCollocation.MVIEW_WW_COLLOCATION;

    /**
     * The table <code>public.mview_ww_dataset</code>.
     */
    public final MviewWwDataset MVIEW_WW_DATASET = eki.wordweb.data.db.tables.MviewWwDataset.MVIEW_WW_DATASET;

    /**
     * The table <code>public.mview_ww_form</code>.
     */
    public final MviewWwForm MVIEW_WW_FORM = eki.wordweb.data.db.tables.MviewWwForm.MVIEW_WW_FORM;

    /**
     * The table <code>public.mview_ww_lexeme</code>.
     */
    public final MviewWwLexeme MVIEW_WW_LEXEME = eki.wordweb.data.db.tables.MviewWwLexeme.MVIEW_WW_LEXEME;

    /**
     * The table <code>public.mview_ww_lexeme_relation</code>.
     */
    public final MviewWwLexemeRelation MVIEW_WW_LEXEME_RELATION = eki.wordweb.data.db.tables.MviewWwLexemeRelation.MVIEW_WW_LEXEME_RELATION;

    /**
     * The table <code>public.mview_ww_meaning</code>.
     */
    public final MviewWwMeaning MVIEW_WW_MEANING = eki.wordweb.data.db.tables.MviewWwMeaning.MVIEW_WW_MEANING;

    /**
     * The table <code>public.mview_ww_meaning_relation</code>.
     */
    public final MviewWwMeaningRelation MVIEW_WW_MEANING_RELATION = eki.wordweb.data.db.tables.MviewWwMeaningRelation.MVIEW_WW_MEANING_RELATION;

    /**
     * The table <code>public.mview_ww_word</code>.
     */
    public final MviewWwWord MVIEW_WW_WORD = eki.wordweb.data.db.tables.MviewWwWord.MVIEW_WW_WORD;

    /**
     * The table <code>public.mview_ww_word_etymology</code>.
     */
    public final MviewWwWordEtymology MVIEW_WW_WORD_ETYMOLOGY = eki.wordweb.data.db.tables.MviewWwWordEtymology.MVIEW_WW_WORD_ETYMOLOGY;

    /**
     * The table <code>public.mview_ww_word_relation</code>.
     */
    public final MviewWwWordRelation MVIEW_WW_WORD_RELATION = eki.wordweb.data.db.tables.MviewWwWordRelation.MVIEW_WW_WORD_RELATION;

    /**
     * The table <code>public.similarity_judgement_data</code>.
     */
    public final SimilarityJudgementData SIMILARITY_JUDGEMENT_DATA = eki.wordweb.data.db.tables.SimilarityJudgementData.SIMILARITY_JUDGEMENT_DATA;

    /**
     * The table <code>public.similarity_judgement_result</code>.
     */
    public final SimilarityJudgementResult SIMILARITY_JUDGEMENT_RESULT = eki.wordweb.data.db.tables.SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.LEXICAL_DECISION_DATA_ID_SEQ,
            Sequences.LEXICAL_DECISION_RESULT_ID_SEQ,
            Sequences.SIMILARITY_JUDGEMENT_DATA_ID_SEQ,
            Sequences.SIMILARITY_JUDGEMENT_RESULT_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            LexicalDecisionData.LEXICAL_DECISION_DATA,
            LexicalDecisionResult.LEXICAL_DECISION_RESULT,
            MviewWwAsWord.MVIEW_WW_AS_WORD,
            MviewWwClassifier.MVIEW_WW_CLASSIFIER,
            MviewWwCollocation.MVIEW_WW_COLLOCATION,
            MviewWwDataset.MVIEW_WW_DATASET,
            MviewWwForm.MVIEW_WW_FORM,
            MviewWwLexeme.MVIEW_WW_LEXEME,
            MviewWwLexemeRelation.MVIEW_WW_LEXEME_RELATION,
            MviewWwMeaning.MVIEW_WW_MEANING,
            MviewWwMeaningRelation.MVIEW_WW_MEANING_RELATION,
            MviewWwWord.MVIEW_WW_WORD,
            MviewWwWordEtymology.MVIEW_WW_WORD_ETYMOLOGY,
            MviewWwWordRelation.MVIEW_WW_WORD_RELATION,
            SimilarityJudgementData.SIMILARITY_JUDGEMENT_DATA,
            SimilarityJudgementResult.SIMILARITY_JUDGEMENT_RESULT);
    }

    @Override
    public final List<UDT<?>> getUDTs() {
        List result = new ArrayList();
        result.addAll(getUDTs0());
        return result;
    }

    private final List<UDT<?>> getUDTs0() {
        return Arrays.<UDT<?>>asList(
            TypeCollocMember.TYPE_COLLOC_MEMBER,
            TypeDefinition.TYPE_DEFINITION,
            TypeDomain.TYPE_DOMAIN,
            TypeLexemeRelation.TYPE_LEXEME_RELATION,
            TypeMeaningRelation.TYPE_MEANING_RELATION,
            TypeUsage.TYPE_USAGE,
            TypeWord.TYPE_WORD,
            TypeWordEtym.TYPE_WORD_ETYM,
            TypeWordRelation.TYPE_WORD_RELATION);
    }
}
