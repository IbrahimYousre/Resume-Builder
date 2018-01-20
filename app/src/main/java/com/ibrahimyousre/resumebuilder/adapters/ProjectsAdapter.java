package com.ibrahimyousre.resumebuilder.adapters;

import android.support.annotation.NonNull;
import android.view.View;

import com.ibrahimyousre.resumebuilder.datamodel.Project;

import java.util.List;

/**
 * Created by ibrahim on 1/19/18.
 */

public class ProjectsAdapter extends ResumeEventAdapter<Project> {

    public ProjectsAdapter(@NonNull List<Project> list,
                           ResumeEventOnClickListener resumeEventOnClickListener) {
        super(list, resumeEventOnClickListener);
    }

    @Override
    protected void updateViewHolder(ResumeEventAdapterViewHolder viewHolder) {
        viewHolder.subtitle.setVisibility(View.GONE);
    }
}