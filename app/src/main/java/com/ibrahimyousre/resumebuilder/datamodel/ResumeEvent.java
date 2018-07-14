package com.ibrahimyousre.resumebuilder.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by ibrahim on 1/18/18.
 */

public class ResumeEvent implements Parcelable {
    private String title;
    private String detail;
    private String subtitle;
    private String description;
    private Date fromDate;
    private Date toDate;

    public ResumeEvent() {
    }

    public ResumeEvent(String title, String detail, String subtitle, String description, Date fromDate, Date toDate) {
        this.title = title;
        this.detail = detail;
        this.subtitle = subtitle;
        this.description = description;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    protected ResumeEvent(Parcel in) {
        title = in.readString();
        detail = in.readString();
        subtitle = in.readString();
        description = in.readString();
        fromDate = (Date) in.readSerializable();
        toDate = (Date) in.readSerializable();
    }

    public static final Creator<ResumeEvent> CREATOR = new Creator<ResumeEvent>() {
        @Override
        public ResumeEvent createFromParcel(Parcel in) {
            return new ResumeEvent(in);
        }

        @Override
        public ResumeEvent[] newArray(int size) {
            return new ResumeEvent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(detail);
        dest.writeString(subtitle);
        dest.writeString(description);
        dest.writeSerializable(fromDate);
        dest.writeSerializable(toDate);
    }

    public ResumeEvent(ResumeEvent resumeEvent) {
        cloneThis(resumeEvent);
    }

    public void cloneThis(ResumeEvent resumeEvent) {
        this.title = resumeEvent.title;
        this.detail = resumeEvent.detail;
        this.subtitle = resumeEvent.subtitle;
        this.description = resumeEvent.description;
        this.fromDate = resumeEvent.fromDate;
        this.toDate = resumeEvent.toDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
