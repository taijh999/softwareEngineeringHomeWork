package cn.byau.entity;

public class CourseKind {
    private String kindId;

    private String kindName;

    private String kindRemark;
    

	

    public String getKindId() {
		return kindId;
	}

	public void setKindId(String kindId) {
		this.kindId = kindId;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getKindRemark() {
		return kindRemark;
	}

	public void setKindRemark(String kindRemark) {
		this.kindRemark = kindRemark;
	}

	@Override
	public String toString() {
		return "CourseKind [kindId=" + kindId + ", kindName=" + kindName + ", kindRemark=" + kindRemark + "]";
	}

	

    
}