package eki.ekilex.data;

import java.sql.Timestamp;

import javax.persistence.Column;

import eki.common.constant.FreeformType;
import eki.common.constant.SourceType;
import eki.common.data.AbstractDataObject;

public class SourcePropertyTuple extends AbstractDataObject {

	private static final long serialVersionUID = 1L;

	@Column(name = "source_id")
	private Long sourceId;

	@Column(name = "type")
	private SourceType type;

	@Column(name = "source_property_id")
	private Long sourcePropertyId;

	@Column(name = "source_property_type")
	private FreeformType sourcePropertyType;

	@Column(name = "source_property_value_text")
	private String sourcePropertyValueText;

	@Column(name = "source_property_value_date")
	private Timestamp sourcePropertyValueDate;

	@Column(name = "is_source_property_match")
	private boolean sourcePropertyMatch;

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public SourceType getType() {
		return type;
	}

	public void setType(SourceType type) {
		this.type = type;
	}

	public Long getSourcePropertyId() {
		return sourcePropertyId;
	}

	public void setSourcePropertyId(Long sourcePropertyId) {
		this.sourcePropertyId = sourcePropertyId;
	}

	public FreeformType getSourcePropertyType() {
		return sourcePropertyType;
	}

	public void setSourcePropertyType(FreeformType sourcePropertyType) {
		this.sourcePropertyType = sourcePropertyType;
	}

	public String getSourcePropertyValueText() {
		return sourcePropertyValueText;
	}

	public void setSourcePropertyValueText(String sourcePropertyValueText) {
		this.sourcePropertyValueText = sourcePropertyValueText;
	}

	public Timestamp getSourcePropertyValueDate() {
		return sourcePropertyValueDate;
	}

	public void setSourcePropertyValueDate(Timestamp sourcePropertyValueDate) {
		this.sourcePropertyValueDate = sourcePropertyValueDate;
	}

	public boolean isSourcePropertyMatch() {
		return sourcePropertyMatch;
	}

	public void setSourcePropertyMatch(boolean sourcePropertyMatch) {
		this.sourcePropertyMatch = sourcePropertyMatch;
	}

}
