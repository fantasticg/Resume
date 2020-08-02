package com.example.heekyungyeom_resume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.heekyungyeom_resume.ui.main.MainFragment;
import com.example.heekyungyeom_resume.ui.main.SkillsFragment;
import com.example.heekyungyeom_resume.ui.main.dummy.EducationContent;

public class MainActivity extends AppCompatActivity implements SkillsFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, SkillsFragment.newInstance(1))
                    .commitNow();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.description_fragment, MainFragment.newInstance())
                    .commitNow();
        }
    }

    @Override
    public void onListFragmentInteraction(EducationContent.EducationItem item) {

    }
}
