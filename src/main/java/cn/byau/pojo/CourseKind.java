package cn.byau.pojo;

import java.util.List;

public class CourseKind {
    private String kindId;

    private String kindName;

    private String kindRemark;
    @Override
	public String toString() {
		return "CourseKind [kindId=" + kindId + ", kindName=" + kindName + ", kindRemark=" + kindRemark
				+ ", courseList=" + courseList + "]";
	}

	private List<Course> courseList;

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

	public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    
}