package shoval.ask.studentapp;

import static shoval.ask.studentapp.StudentAdapter.mList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class StudentDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    // announcement to widgets
    TextView tvName, tvId, tvPhone, tvAddress;
    Button btnEdit;
    Switch stChecked;

    int POSITION = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        // get control on widgets in xml
        tvName = findViewById(R.id.tvName);
        tvId = findViewById(R.id.tvId);
        tvPhone = findViewById(R.id.tvPhone);
        tvAddress = findViewById(R.id.tvAddress);
        stChecked = findViewById(R.id.stChecked);
        btnEdit = findViewById(R.id.btnEdit);

        // get data from the other screen and set the text of EditText
        Intent in = getIntent();
        if (in != null && in.getExtras() != null) // לקבל את המפתח
        {
            Bundle xtras = in.getExtras();
            POSITION = xtras.getInt("POSITION");
            tvName.setText("name: " + mList.get(POSITION).getName());
            tvId.setText("id: " + mList.get(POSITION).getId());
            tvPhone.setText("phone: " + mList.get(POSITION).getPhone());
            tvAddress.setText("address: " + mList.get(POSITION).getAddress());
            stChecked.setChecked(mList.get(POSITION).isChecked());
    }

        // connect buttons to on click, in other words, do smt when click
        btnEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==btnEdit.getId()) {
            finish();
            Intent intent = new Intent(StudentDetailsActivity.this, EditStudentActivity.class);
            intent.putExtra("POSITION",POSITION);
            startActivity(intent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.itBack)
            finish();
        return super.onOptionsItemSelected(item);
    }
}