package shoval.ask.studentapp;

import static shoval.ask.studentapp.StudentAdapter.mList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class NewStudentActivity extends AppCompatActivity implements View.OnClickListener {

    // announcement to widgets
    EditText etName, etId, etPhone, etAddress;
    Switch stChecked;
    Button btnCancel, btnSave;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);


        // get control on widgets in xml
        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        stChecked = findViewById(R.id.stChecked);
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);

        // connect buttons to on click, in other words, do smt when click
        btnCancel.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancel:
                finish();
                break;

            case R.id.btnSave:
                saveStudent();
                break;
        }
    }

    public void saveStudent() {
        if(isEmptyData())
            Toast.makeText(this,"Enter all data!",Toast.LENGTH_SHORT).show();
        else {
            mList.add(new Student("pic",etName.getText().toString(),etId.getText().toString(),etPhone.getText().toString(),etPhone.getText().toString(),stChecked.isChecked()));
            Toast.makeText(this,"Data Saved!",Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public boolean isEmptyData() {
        if(etName.getText().toString().isEmpty() ||
                etId.getText().toString().isEmpty() ||
                etAddress.getText().toString().isEmpty() ||
                etPhone.getText().toString().isEmpty())
            return true;
        return false;
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