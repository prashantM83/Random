package com.example.practical8;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

// 8a: SQLite CRUD Demo
public class MainActivitySQLite extends AppCompatActivity {
    EditText etName, etPhone;
    Button btnAdd, btnUpdate, btnDelete, btnView;
    ListView lvContacts;
    DatabaseHelper dbHelper;
    ArrayList<Integer> contactIds;
    int selectedId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);

        etName   = findViewById(R.id.etName);
        etPhone  = findViewById(R.id.etPhone);
        btnAdd   = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnView  = findViewById(R.id.btnView);
        lvContacts = findViewById(R.id.lvContacts);

        dbHelper   = new DatabaseHelper(this);
        contactIds = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name  = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                if (name.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(MainActivitySQLite.this, "Enter name and phone", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (dbHelper.insertContact(name, phone)) {
                    Toast.makeText(MainActivitySQLite.this, "Contact added", Toast.LENGTH_SHORT).show();
                    etName.setText(""); etPhone.setText(""); loadContacts();
                } else {
                    Toast.makeText(MainActivitySQLite.this, "Insertion failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedId == -1) { Toast.makeText(MainActivitySQLite.this, "Select a contact first", Toast.LENGTH_SHORT).show(); return; }
                String name  = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                if (name.isEmpty() || phone.isEmpty()) { Toast.makeText(MainActivitySQLite.this, "Enter name and phone", Toast.LENGTH_SHORT).show(); return; }
                if (dbHelper.updateContact(selectedId, name, phone)) {
                    Toast.makeText(MainActivitySQLite.this, "Contact updated", Toast.LENGTH_SHORT).show();
                    etName.setText(""); etPhone.setText(""); selectedId = -1; loadContacts();
                } else {
                    Toast.makeText(MainActivitySQLite.this, "Update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedId == -1) { Toast.makeText(MainActivitySQLite.this, "Select a contact first", Toast.LENGTH_SHORT).show(); return; }
                if (dbHelper.deleteContact(selectedId)) {
                    Toast.makeText(MainActivitySQLite.this, "Contact deleted", Toast.LENGTH_SHORT).show();
                    etName.setText(""); etPhone.setText(""); selectedId = -1; loadContacts();
                } else {
                    Toast.makeText(MainActivitySQLite.this, "Deletion failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnView.setOnClickListener(v -> loadContacts());

        lvContacts.setOnItemClickListener((adapterView, view, position, l) -> {
            selectedId = contactIds.get(position);
            Cursor cursor = dbHelper.getAllContacts();
            if (cursor.moveToPosition(position)) {
                etName.setText(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                etPhone.setText(cursor.getString(cursor.getColumnIndexOrThrow("phone")));
            }
        });

        loadContacts();
    }

    private void loadContacts() {
        Cursor cursor = dbHelper.getAllContacts();
        ArrayList<String> list = new ArrayList<>();
        contactIds.clear();
        if (cursor.getCount() == 0) {
            list.add("No records found");
        } else {
            while (cursor.moveToNext()) {
                int id     = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name  = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow("phone"));
                list.add(name + " - " + phone);
                contactIds.add(id);
            }
        }
        lvContacts.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));
    }
}
