package shoval.ask.studentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    // announcement to widgets
    RecyclerView lv;
    StudentAdapter adapter;
    ArrayList<Student> list;
    FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get control on widgets in xml
        btnAdd = findViewById(R.id.btnAdd);

        // connect buttons to on click, in other words, do smt when click
        btnAdd.setOnClickListener(this);

        // set the RecyclerView that item can be show
        lv = findViewById(R.id.lv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        lv.setLayoutManager(layoutManager);
        lv.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(lv.getContext(), ((LinearLayoutManager) layoutManager).getOrientation());
        lv.addItemDecoration(dividerItemDecoration);

        list = new ArrayList<>();
        adapter = new StudentAdapter(this, list);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        // when we get into screen after we create him and when come back from finish of another screen
        super.onResume();
        adapter = new StudentAdapter(this,list);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        // intent => go to another screen
        if(view.getId()==btnAdd.getId())
            startActivity(new Intent(MainActivity.this,NewStudentActivity.class));
    }

}