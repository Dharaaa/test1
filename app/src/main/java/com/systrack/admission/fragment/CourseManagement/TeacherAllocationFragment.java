package com.systrack.admission.fragment.CourseManagement;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.Activity.ClassTimingBatchActivity;
import com.systrack.admission.Activity.ClassTimingSectionActivity;
import com.systrack.admission.Activity.ExamTimetableAcademicYearActivity;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherAllocationFragment extends Fragment {


    View view;
LinearLayout search_employee;
EditText course_edittext,medium_edittext,year_edittext,batch_edittext,section_edittext;
    AppController appController;
    TextView error;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_teacher_allocation, container, false);
        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();

        appController.setTeacher_allocation_batchId(null);
        appController.setTeacher_allocation_batchName(null);
        appController.setTeacher_allocation_medium(null);
        appController.setTeacher_allocation_sectionId(null);
        appController.setTeacher_allocation_sectionName(null);
        appController.setTeacher_allocation_streamId(null);
        appController.setTeacher_allocation_streamName(null);
        appController.setTeacher_allocation_yearId(null);
        appController.setTeacher_allocation_yearName(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setTeacher_allocation_medium(null);

                appController.setManageEmpCourseFlag("TeacherAllocation");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("TeacherAllocation");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });

        batch_edittext=view.findViewById(R.id.batch_edittext);
        batch_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingBatchFlag("TeacherAllocation");

                Intent i=new Intent(getActivity(), ClassTimingBatchActivity.class);
                startActivity(i);
            }
        });
        section_edittext=view.findViewById(R.id.section_edittext);
        section_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingSectionFlag("TeacherAllocation");
                Intent i=new Intent(getActivity(), ClassTimingSectionActivity.class);
                startActivity(i);
            }
        });

        year_edittext=view.findViewById(R.id.academic_year_edittext);
        year_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setExamTimetableYearFlag("TeacherAllocation");
                Intent i=new Intent(getActivity(), ExamTimetableAcademicYearActivity.class);
                startActivity(i);
            }
        });

        search_employee=view.findViewById(R.id.search_employee);
        search_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchData();

            }
        });
       ImageView back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CourseMgtMenuFragment coursefragment = new CourseMgtMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("OnREsume ","Calles ");
        if(appController.getTeacher_allocation_yearName()!=null){
            year_edittext.setText(appController.getTeacher_allocation_yearName());
        }else{
            year_edittext.setText("");
        }

        if(appController.getTeacher_allocation_streamName()!=null){
            course_edittext.setText(appController.getTeacher_allocation_streamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getTeacher_allocation_medium()!=null){
            medium_edittext.setText(appController.getTeacher_allocation_medium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getTeacher_allocation_batchName()!=null){
            batch_edittext.setText(appController.getTeacher_allocation_batchName());
        }else{
            batch_edittext.setText("");
        }

        if(appController.getTeacher_allocation_sectionName()!=null){
            section_edittext.setText(appController.getTeacher_allocation_sectionName());
        }else{
            section_edittext.setText("");
        }


    }

    private void SearchData() {

        if (course_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Course data required");
        } else if (medium_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Medium data required");
        } else if (batch_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Batch data required");
        } else if (section_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Section data required");
        } else if (year_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Academic Year data required");
        } else {


            SearchTeacherAllocationFragment coursefragment = new SearchTeacherAllocationFragment();
            FragmentTransaction country = getFragmentManager().beginTransaction();
            country.replace(R.id.frame, coursefragment);
            country.commit();


        }
    }

}
