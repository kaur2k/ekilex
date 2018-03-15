/*
 * This file is generated by jOOQ.
*/
package eki.wordweb.data.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.UDT;
import org.jooq.impl.SchemaImpl;

import eki.wordweb.data.db.tables.MviewWwForm;
import eki.wordweb.data.db.tables.MviewWwMeaning;
import eki.wordweb.data.db.tables.MviewWwWord;
import eki.wordweb.data.db.udt.DblinkPkeyResults;

/**
 * This class is generated by jOOQ.
 */
@Generated(value = {
		"http://www.jooq.org",
		"jOOQ version:3.10.5"
}, comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Public extends SchemaImpl {

	private static final long serialVersionUID = -399414874;

	/**
	 * The reference instance of <code>public</code>
	 */
	public static final Public PUBLIC = new Public();

	/**
	 * The table <code>public.mview_ww_form</code>.
	 */
	public final MviewWwForm MVIEW_WW_FORM = eki.wordweb.data.db.tables.MviewWwForm.MVIEW_WW_FORM;

	/**
	 * The table <code>public.mview_ww_meaning</code>.
	 */
	public final MviewWwMeaning MVIEW_WW_MEANING = eki.wordweb.data.db.tables.MviewWwMeaning.MVIEW_WW_MEANING;

	/**
	 * The table <code>public.mview_ww_word</code>.
	 */
	public final MviewWwWord MVIEW_WW_WORD = eki.wordweb.data.db.tables.MviewWwWord.MVIEW_WW_WORD;

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
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>> asList(
				MviewWwForm.MVIEW_WW_FORM,
				MviewWwMeaning.MVIEW_WW_MEANING,
				MviewWwWord.MVIEW_WW_WORD);
	}

	@Override
	public final List<UDT<?>> getUDTs() {
		List result = new ArrayList();
		result.addAll(getUDTs0());
		return result;
	}

	private final List<UDT<?>> getUDTs0() {
		return Arrays.<UDT<?>> asList(
				DblinkPkeyResults.DBLINK_PKEY_RESULTS);
	}
}