package com.ibrahimyousre.resumebuilder.fragments;


import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.ibrahimyousre.resumebuilder.EditActivity;
import com.ibrahimyousre.resumebuilder.adapters.ExperienceAdapter;
import com.ibrahimyousre.resumebuilder.adapters.ResumeEventAdapter;
import com.ibrahimyousre.resumebuilder.datamodel.Experience;
import com.ibrahimyousre.resumebuilder.datamodel.Resume;
import com.ibrahimyousre.resumebuilder.helper.ResumeEventFragment;
import com.ibrahimyousre.resumebuilder.helper.ResumeFragment;

public class ExperienceFragment extends ResumeEventFragment<Experience> {
    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new ExperienceFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    protected void delete(int pos) {
        getResume().experience.remove(pos);
    }

    @Override
    public void onClick(int position) {
        Intent intent = EditActivity.getExperienceIntent(getContext());
        EditActivity.setData(intent, position, getResume().experience.get(position));
        startActivityForResult(intent, REQUEST_EDIT);
    }

    @Override
    protected void addClicked() {
        Intent intent = EditActivity.getExperienceIntent(getContext());
        startActivityForResult(intent, REQUEST_ADD);
    }

    @Override
    protected ResumeEventAdapter<Experience> getAdapter(View emptyView) {
        return new ExperienceAdapter(getResume().experience, this)
                .setEmptyView(emptyView);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ADD && resultCode == Activity.RESULT_OK) {
            getResume().experience.add(new Experience(EditActivity.getEvent(data)));
            notifyDataChanged();
        }
        if (requestCode == REQUEST_EDIT && resultCode == Activity.RESULT_OK) {
            int id = data.getIntExtra(EditActivity.FIELD_ID, -1);
            getResume().experience.get(id).cloneThis(EditActivity.getEvent(data));
            notifyDataChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
