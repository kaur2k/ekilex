package eki.ekilex.data.util;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import eki.ekilex.data.transform.WordMeaningPair;

public class WordMeaningPairRowMapper implements RowMapper<WordMeaningPair> {

	@Override
	public WordMeaningPair mapRow(ResultSet rs, int rowNum) throws SQLException {

		String word = rs.getString("word");
		Long wordId = rs.getObject("word_id", Long.class);
		Long meaningId = rs.getObject("meaning_id", Long.class);
		Array lexemeIdsPgArr = rs.getArray("lexeme_ids");
		Long[] lexemeIdsArr = (Long[]) lexemeIdsPgArr.getArray();
		List<Long> lexemeIds = Arrays.asList(lexemeIdsArr);
		boolean mainDatasetLexemeExists = rs.getBoolean("main_ds_lex_exists");
		Integer mainDatasetLexemeMaxLevel1 = rs.getInt("main_ds_lex_max_level1");
		WordMeaningPair wordMeaningPair = new WordMeaningPair();
		wordMeaningPair.setWord(word);
		wordMeaningPair.setWordId(wordId);
		wordMeaningPair.setMeaningId(meaningId);
		wordMeaningPair.setLexemeIds(lexemeIds);
		wordMeaningPair.setMainDatasetLexemeExists(mainDatasetLexemeExists);
		wordMeaningPair.setMainDatasetLexemeMaxLevel1(mainDatasetLexemeMaxLevel1);
		return wordMeaningPair;
	}
}