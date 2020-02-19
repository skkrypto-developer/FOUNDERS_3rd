package com.example.spermbank;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.MyViewHolder>{

    Context context;
    ArrayList<SpermData> spermData;


    public LineAdapter(Context c, ArrayList<SpermData> p) {
        context = c;;
        spermData = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does,viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.titledoes.setText(spermData.get(i).getTitledoes());
        myViewHolder.titledoes1.setText(spermData.get(i).getTitledoes1());
        myViewHolder.titledoes2.setText(spermData.get(i).getTitledoes2());
        myViewHolder.titledoes3.setText(spermData.get(i).getTitledoes3());

        final String getTitleDoes = spermData.get(i).getTitledoes();
        final String getTitleDoes1 = spermData.get(i).getTitledoes1();
        final String getTitleDoes2 = spermData.get(i).getTitledoes2();
        final String getTitleDoes3 = spermData.get(i).getTitledoes3();
        final String getKeyDoes = spermData.get(i).getKeydoes();

        myViewHolder.btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aa = new Intent(context, EditTaskDesk.class);
                aa.putExtra("titledoes", getTitleDoes);
                aa.putExtra("titledoes1", getTitleDoes1);
                aa.putExtra("titledoes2", getTitleDoes2);
                aa.putExtra("titledoes2", getTitleDoes3);
//                aa.putExtra("descdoes", getDescDoes);
//                aa.putExtra("datedoes", getDateDoes);
                aa.putExtra("keydoes", getKeyDoes);
                context.startActivity(aa);
                Log.d("Test", "Success");
            }
        });
    }

    @Override
    public int getItemCount() {
        return spermData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titledoes, titledoes1, titledoes2, titledoes3,  keydoes;

        Button btnEnter;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
//            descdoes = (TextView) itemView.findViewById(R.id.descdoes);
//            datedoes = (TextView) itemView.findViewById(R.id.datedoes);
            titledoes1 = (TextView) itemView.findViewById(R.id.titledoes1);
            titledoes2 = (TextView) itemView.findViewById(R.id.titledoes2);
            titledoes3 = (TextView) itemView.findViewById(R.id.titledoes3);

            btnEnter = (Button) itemView.findViewById(R.id.btnEnter);
        }


    }

}