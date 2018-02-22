package com.ibrahimyousre.resumebuilder.fragments;


import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.ibrahimyousre.resumebuilder.EditActivity;
import com.ibrahimyousre.resumebuilder.adapters.ResumeEventAdapter;
import com.ibrahimyousre.resumebuilder.adapters.SchoolsAdapter;
import com.ibrahimyousre.resumebuilder.datamodel.Resume;
import com.ibrahimyousre.resumebuilder.datamodel.School;
import com.ibrahimyousre.resumebuilder.helper.ResumeEventFragment;
import com.ibrahimyousre.resumebuilder.helper.ResumeFragment;

public class EducationFragment extends ResumeEventFragment<School> {
    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new EducationFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    protected void delete(int pos) {
        getResume().schools.remove(pos);
    }

    @Override
    public void onClick(int position) {
        Intent intent = EditActivity.getSchoolIntent(getContext());
        EditActivity.setData(intent, position, getResume().schools.get(position));
        startActivityForResult(intent, REQUEST_EDIT);
    }

    @Override
    protected void addClicked() {
        Intent intent = EditActivity.getSchoolIntent(getContext());
        startActivityForResult(intent, REQUEST_ADD);
    }

    @Override
    protected ResumeEventAdapter<School> getAdapter(View emptyView) {
        return new SchoolsAdapter(getResume().schools, this)
                .setEmptyView(emptyView);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ADD && resultCode == Activity.RESULT_OK) {
            getResume().schools.add(new School(EditActivity.getEvent(data)));
            notifyDataChanged();
        }
        if (requestCode == REQUEST_EDIT && resultCode == Activity.RESULT_OK) {
            int id = data.getIntExtra(EditActivity.FIELD_ID, -1);
            getResume().schools.get(id).cloneThis(EditActivity.getEvent(data));
            notifyDataChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
