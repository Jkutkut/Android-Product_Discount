package com.jkutkut.productdiscount;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // ******** UI Components ********
    private Button btnSelectProduct;
    private TextView txtvProduct;
    private EditText etxtDiscount;
    private TextView txtvDiscount;
    private Button btnCalculate;

    private ActivityResultLauncher<Intent> selectProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ******** UI Components ********
        btnSelectProduct = findViewById(R.id.btnSelectProduct);
        txtvProduct = findViewById(R.id.txtvProduct);
        etxtDiscount = findViewById(R.id.etxtDiscount);
        txtvDiscount = findViewById(R.id.txtvDiscount);
        btnCalculate = findViewById(R.id.btnCalculate);

        selectProduct = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        toastUser("Product selected");
                        // Get data from intent
                        String test = result.getData().getStringExtra("test");
                        toastUser(test);
                    }
                    else {
                        // TODO
                    }
                }
        );

        btnSelectProduct.setOnClickListener(v -> {
            Intent i = new Intent(this, ProductSelection.class);
            selectProduct.launch(i);
        });

        btnCalculate.setOnClickListener(v -> {
            // TODO
        });
    }

    private void toastUser(String str) {
        if (str != null)
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}