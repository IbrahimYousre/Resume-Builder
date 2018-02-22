package com.ibrahimyousre.resumebuilder.helper;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibrahimyousre.resumebuilder.datamodel.Resume;

/**
 * Created by ibrahim on 1/19/18.
 */

abstract public class ResumeFragment extends Fragment {

    public static final String ARGUMENT_RESUME = "resume";

    public void setResume(Resume resume) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARGUMENT_RESUME, resume);
        setArguments(bundle);
    }

    public Resume getResume() {
        return getArguments().getParcelable(ARGUMENT_RESUME);
    }
}
