package com.yasarerkan.sms_send;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Messageadapter extends BaseAdapter {

    List<Messagemodel>list;
    Context context;
    String namev,pnumberv;
    Activity activity;

    public Messageadapter(List<Messagemodel> list, Context context,Activity activity) {
        this.list=list;
        this.context=context;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mylayout= LayoutInflater.from(context).inflate(R.layout.mylayout,viewGroup,false);
        final EditText message=mylayout.findViewById(R.id.msg1);
        TextView name=mylayout.findViewById(R.id.nm1);
        TextView pnumber=mylayout.findViewById(R.id.pnm1);
        Button button=mylayout.findViewById(R.id.btn1);


        namev=list.get(i).getName();
        pnumberv=list.get(i).getNumber();
        name.setText(namev);
        pnumber.setText(pnumberv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messagecontent=message.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+pnumberv));
                intent.putExtra("sms_body",messagecontent);
                activity.startActivity(intent);
            }
        });

        return mylayout;
    }
}
