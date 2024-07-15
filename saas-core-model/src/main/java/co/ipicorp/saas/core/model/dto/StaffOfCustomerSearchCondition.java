package co.ipicorp.saas.core.model.dto;

import grass.micro.apps.model.dto.SearchCondition;

public class StaffOfCustomerSearchCondition extends SearchCondition {

	private static final long serialVersionUID = 9126751499946659580L;
	
	Integer staffId;

	Integer status;

	Integer offset;

	Integer segment;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getSegment() {
		return segment;
	}

	public void setSegment(Integer segment) {
		this.segment = segment;
	}

	@Override
	public String toString() {
		return "StaffOfCustomerSearchCondition [staffId=" + staffId + ", status=" + status + ", offset=" + offset
				+ ", segment=" + segment + "]";
	}

}
