package com.ibrahimyousre.resumebuilder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.ibrahimyousre.resumebuilder.datamodel.Resume;
import com.ibrahimyousre.resumebuilder.fragments.EducationFragment;
import com.ibrahimyousre.resumebuilder.fragments.EssentialsFragment;
import com.ibrahimyousre.resumebuilder.fragments.ExperienceFragment;
import com.ibrahimyousre.resumebuilder.fragments.PersonalInfoFragment;
import com.ibrahimyousre.resumebuilder.fragments.PreviewFragment;
import com.ibrahimyousre.resumebuilder.fragments.ProjectsFragment;
import com.ibrahimyousre.resumebuilder.helper.ResumeFragment;

public class MainActivity extends AppCompatActivity {
    private Resume resume;
    private String currentTitle;
    private String STATE_CURRENT_TITLE = "current title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupLayout();

        Gson gson = new Gson();
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String json = mPrefs.getString("SerializableObject", "");
        if (json.isEmpty())
            resume = Resume.createNewResume();
        else
            resume = gson.fromJson(json, Resume.class);

        if (savedInstanceState == null) {
            openFragment(PersonalInfoFragment.newInstance(resume));
            currentTitle = getString(R.string.navigation_personal_info);
        } else
            currentTitle = savedInstanceState.getString(STATE_CURRENT_TITLE);

        getSupportActionBar().setTitle(currentTitle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(resume);
        prefsEditor.putString("SerializableObject", json);
        prefsEditor.apply();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_CURRENT_TITLE, currentTitle);
    }

    private void setupLayout() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        drawerLayout.closeDrawers();
                        currentTitle = item.getTitle().toString();
                        getSupportActionBar().setTitle(currentTitle);
                        return handleMenuItem(item);
                    }
                });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.content_description_open_drawer,
                R.string.content_description_close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(getString(R.string.steps));
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(currentTitle);
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private boolean handleMenuItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_personal_info:
                openFragment(PersonalInfoFragment.newInstance(resume));
                break;
            case R.id.action_essentials:
                openFragment(EssentialsFragment.newInstance(resume));
                break;
            case R.id.action_projects:
                openFragment(ProjectsFragment.newInstance(resume));
                break;
            case R.id.action_education:
                openFragment(EducationFragment.newInstance(resume));
                break;
            case R.id.action_experience:
                openFragment(ExperienceFragment.newInstance(resume));
                break;
            case R.id.action_preview:
                openFragment(PreviewFragment.newInstance(resume));
                break;
            default:
                return false;
        }
        return true;
    }

    private void openFragment(ResumeFragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }
}
