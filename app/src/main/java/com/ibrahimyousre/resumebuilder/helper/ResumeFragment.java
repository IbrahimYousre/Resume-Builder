package com.ibrahimyousre.resumebuilder.helper;

import android.support.v4.app.Fragment;

import com.ibrahimyousre.resumebuilder.datamodel.Resume;

/**
 * Created by ibrahim on 1/19/18.
 */

abstract public class ResumeFragment extends Fragment {

    protected Resume resume;

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}
