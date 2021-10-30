package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 课程具体日期
 * @TableName course_time
 */
@TableName(value ="course_time")
@Data
public class CourseTime implements Serializable {
    /**
     * 课程详情号
     */
    @TableField(value = "course_detail_id")
    private String courseDetailId;

    /**
     * 开始周
     */
    @TableField(value = "start_week")
    private Byte startWeek;

    /**
     * 结束周
     */
    @TableField(value = "end_week")
    private Byte endWeek;

    /**
     * 一星期内的日次，如1,3,4
     */
    @TableField(value = "day_time")
    private String dayTime;

    /**
     * 节次，每天用;分割，如1-2,6-7;3-4
     */
    @TableField(value = "section_start")
    private String sectionStart;

    @TableField(value = "section_end")
    private String sectionEnd;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CourseTime other = (CourseTime) that;
        return (this.getCourseDetailId() == null ? other.getCourseDetailId() == null : this.getCourseDetailId().equals(other.getCourseDetailId()))
            && (this.getStartWeek() == null ? other.getStartWeek() == null : this.getStartWeek().equals(other.getStartWeek()))
            && (this.getEndWeek() == null ? other.getEndWeek() == null : this.getEndWeek().equals(other.getEndWeek()))
            && (this.getDayTime() == null ? other.getDayTime() == null : this.getDayTime().equals(other.getDayTime()))
            && (this.getSectionStart() == null ? other.getSectionStart() == null : this.getSectionStart().equals(other.getSectionStart()))
            && (this.getSectionEnd() == null ? other.getSectionEnd() == null : this.getSectionEnd().equals(other.getSectionEnd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCourseDetailId() == null) ? 0 : getCourseDetailId().hashCode());
        result = prime * result + ((getStartWeek() == null) ? 0 : getStartWeek().hashCode());
        result = prime * result + ((getEndWeek() == null) ? 0 : getEndWeek().hashCode());
        result = prime * result + ((getDayTime() == null) ? 0 : getDayTime().hashCode());
        result = prime * result + ((getSectionStart() == null) ? 0 : getSectionStart().hashCode());
        result = prime * result + ((getSectionEnd() == null) ? 0 : getSectionEnd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseId=").append(courseDetailId);
        sb.append(", startWeek=").append(startWeek);
        sb.append(", endWeek=").append(endWeek);
        sb.append(", dayTime=").append(dayTime);
        sb.append(", sectionStart=").append(sectionStart);
        sb.append(", sectionEnd=").append(sectionEnd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}