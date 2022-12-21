package shoval.ask.studentapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> implements RecyclerView.OnItemTouchListener {

    public static ArrayList<Student> mList;
    private final Context context;

    public StudentAdapter(Context context, ArrayList<Student> mList) {
        this.context = context;
        StudentAdapter.mList = mList;
    }

    // get view xml
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.student_tile, parent, false);
        return new MyViewHolder(v);
    }

    // get control of view
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getStChecked().setChecked(mList.get(position).isChecked());
        holder.getStChecked().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mList.get(position).setChecked(isChecked);
            }
        });
        holder.getTvId().setText("" + mList.get(position).getId());
        holder.getTvName().setText("" + mList.get(position).getName());
        holder.getBase().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(context, StudentDetailsActivity.class);
               intent.putExtra("POSITION", position);
               context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // announcement to widgets
        ImageView ivImage;
        TextView tvName, tvId;
        Switch stChecked;
        LinearLayout base;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            ivImage = itemView.findViewById(R.id.ivImage);
            stChecked = itemView.findViewById(R.id.stChecked);
            base = itemView.findViewById(R.id.base);
        }

        public TextView getTvId() {
            return tvId;
        }

        public ImageView getIvImage() {
            return ivImage;
        }

        public Switch getStChecked() {
            return stChecked;
        }

        public TextView getTvName() {
            return tvName;
        }

        public LinearLayout getBase() {
            return base;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}