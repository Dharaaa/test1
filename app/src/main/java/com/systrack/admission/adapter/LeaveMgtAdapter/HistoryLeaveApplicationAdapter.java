package com.systrack.admission.adapter.LeaveMgtAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.LeaveManagement.ViewLeaveApplicationFragment;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.LeaveApplicationInformation;
import com.systrack.admission.pojo.LeaveAssignInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class HistoryLeaveApplicationAdapter extends BaseAdapter {
    ArrayList<LeaveApplicationInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView leave_date,leave_duration,leave_type,start_date,end_date,days,status,reason;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    FontAwesomeTextview view_leave_application;
    public HistoryLeaveApplicationAdapter(Context context, ArrayList<LeaveApplicationInformation> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(final int i, View convertview, ViewGroup viewGroup) {
        inflater=(LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.item_history_leave_application,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        leave_date= (TextView)view.findViewById(R.id.leave_date);
        leave_duration = (TextView)view.findViewById(R.id.leave_duration);
        leave_type = (TextView)view.findViewById(R.id.leave_type);
        start_date=view.findViewById(R.id.start_date);
        end_date=view.findViewById(R.id.end_date);
        days=view.findViewById(R.id.days);
        status=view.findViewById(R.id.status);
        reason=view.findViewById(R.id.reason);
        view_leave_application=view.findViewById(R.id.view_leave_application);


        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);        t5.setTypeface(typeface_semibold);
        t6=view.findViewById(R.id.t6);        t6.setTypeface(typeface_semibold);
        t7=view.findViewById(R.id.t7);        t7.setTypeface(typeface_semibold);
        t8=view.findViewById(R.id.t8);        t8.setTypeface(typeface_semibold);



        leave_date.setTypeface(typeface_regular);
        leave_duration.setTypeface(typeface_regular);
        leave_type.setTypeface(typeface_regular);
        start_date.setTypeface(typeface_regular);
        end_date.setTypeface(typeface_regular);
        days.setTypeface(typeface_regular);
        status.setTypeface(typeface_regular);
        reason.setTypeface(typeface_regular);



        leave_date.setText(arrayList.get(i).getLEAVEDATE());
        leave_duration.setText(arrayList.get(i).getDURATIONNAME());
        leave_type.setText(arrayList.get(i).getLEAVETYPENAME());
        start_date.setText(arrayList.get(i).getSTARTDATE());
        end_date.setText(arrayList.get(i).getENDDATE());
        days.setText(arrayList.get(i).getLEAVEDAYS()+"");
        status.setText(arrayList.get(i).getSTATUS());
        reason.setText(arrayList.get(i).getREASON());

        if(status.getText().equals("Pending")){

            status.setBackgroundColor(Color.parseColor("#337ab7"));
        }else if(status.getText().toString().equals("Approved")){
            status.setBackgroundColor(Color.parseColor("#5cb85c"));


        }else if(status.getText().toString().equals("Reject")){
            status.setBackgroundColor(Color.parseColor("#d9534f"));

        }
        view_leave_application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setSelected_current_Leave_DurationID(arrayList.get(i).getLEAVEDURATIONID()+"");
                appController.setSelected_current_Leave_AppID(String.valueOf(arrayList.get(i).getLEAVEAPPID()));




                ViewLeaveApplicationFragment leaveapplication = new ViewLeaveApplicationFragment();
                FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,leaveapplication);
                transaction.commit();

            }
        });

//        if(arrayList.get(i).getLEAVETYPEDETAIL().equals("")){
//            0detail.setText("Not Set");
//            detail.setTextColor(Color.RED);
//            detail.setTypeface(null, Typeface.ITALIC);
//        }


//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}
