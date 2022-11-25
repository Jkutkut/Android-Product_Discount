package com.jkutkut.productdiscount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ProductSelection extends AppCompatActivity {

    // ******** UI Components ********
    private EditText etxtCode;
    private EditText etxtName;
    private EditText etxtDesc;
    private EditText etxtPrice;
    private Button btnSearch;
    private Button btnOk;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_selection);

        // ******** UI Components ********
        etxtCode = findViewById(R.id.etxtCode);
        etxtName = findViewById(R.id.etxtName);
        etxtDesc = findViewById(R.id.etxtDesc);
        etxtPrice = findViewById(R.id.etxtPrice);
        btnSearch = findViewById(R.id.btnSearch);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);


        btnOk.setOnClickListener(v -> handleOk());

        btnCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }

    private void handleOk() {
        // TODO

        Intent data = new Intent();
        data.putExtra("test", "testValue");
        setResult(RESULT_OK, data);
        finish();
    }
}