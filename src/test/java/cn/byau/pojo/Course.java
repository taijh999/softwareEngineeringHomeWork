package cn.byau.pojo;

public class Course {
    private String courseId;

    

    

	private String courseName;

    private String courseKindId;

    

	private String courseScore;

    private String courseHour;

    private String courseRemark;

    private CourseKind courseKind;
    
    public Course() {
		super();
	}
    
    public Course(String courseId, String courseName, String courseKindId, String courseScore, String courseHour,
			String courseRemark) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseKindId = courseKindId;
		this.courseScore = courseScore;
		this.courseHour = courseHour;
		this.courseRemark = courseRemark;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	

	public String getCourseKindId() {
		return courseKindId;
	}

	public void setCourseKindId(String courseKindId) {
		this.courseKindId = courseKindId;
	}

	public CourseKind getCourseKind() {
		return courseKind;
	}

	public void setCourseKind(CourseKind courseKind) {
		this.courseKind = courseKind;
	}

	public String getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(String courseScore) {
		this.courseScore = courseScore;
	}

	public String getCourseHour() {
		return courseHour;
	}

	public void setCourseHour(String courseHour) {
		this.courseHour = courseHour;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseKindId=" + courseKindId
				+ ", courseScore=" + courseScore + ", courseHour=" + courseHour + ", courseRemark=" + courseRemark
				+ "]";
	}

	public String getCourseRemark() {
		return courseRemark;
	}

	public void setCourseRemark(String courseRemark) {
		this.courseRemark = courseRemark;
	}
	
	

	

    

    
}