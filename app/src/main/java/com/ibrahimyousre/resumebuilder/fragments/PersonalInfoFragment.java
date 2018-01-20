package com.ibrahimyousre.resumebuilder.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ibrahimyousre.resumebuilder.R;
import com.ibrahimyousre.resumebuilder.datamodel.PersonalInfo;
import com.ibrahimyousre.resumebuilder.datamodel.Resume;
import com.ibrahimyousre.resumebuilder.helper.ResumeFragment;
import com.ibrahimyousre.resumebuilder.helper.TextChangeListener;

public class PersonalInfoFragment extends ResumeFragment {
    PersonalInfo personalInfo;

    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new PersonalInfoFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    public void setResume(Resume resume) {
        super.setResume(resume);
        personalInfo = resume.personalInfo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =
                inflater.inflate(R.layout.fragment_personal_info, container, false);
        ;
        EditText nameEditText = root.findViewById(R.id.input_name);
        nameEditText.setText(personalInfo.getName());
        nameEditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setName(s.toString());
            }
        });

        EditText jobTitleEditText = root.findViewById(R.id.input_job_title);
        jobTitleEditText.setText(personalInfo.getJobTitle());
        jobTitleEditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setJobTitle(s.toString());
            }
        });

        EditText address1EditText = root.findViewById(R.id.input_address1);
        address1EditText.setText(personalInfo.getAddressLine1());
        address1EditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setAddressLine1(s.toString());
            }
        });

        EditText address2EditText = root.findViewById(R.id.input_address2);
        address2EditText.setText(personalInfo.getAddressLine2());
        address2EditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setAddressLine2(s.toString());
            }
        });

        EditText phoneEditText = root.findViewById(R.id.input_phone);
        phoneEditText.setText(personalInfo.getPhone());
        phoneEditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setPhone(s.toString());
            }
        });

        EditText emailEditText = root.findViewById(R.id.input_email);
        emailEditText.setText(personalInfo.getEmail());
        emailEditText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                personalInfo.setEmail(s.toString());
            }
        });
        return root;
    }
}
