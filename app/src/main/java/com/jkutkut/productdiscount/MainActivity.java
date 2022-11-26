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

import com.jkutkut.productdiscount.javabean.Product;

public class MainActivity extends AppCompatActivity {

    // ******** UI Components ********
    private Button btnSelectProduct;
    private TextView txtvProduct;
    private EditText etxtDiscount;
    private TextView txtvDiscount;
    private Button btnCalculate;

    private ActivityResultLauncher<Intent> selectProduct;

    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product = null;

        // ******** UI Components ********
        btnSelectProduct = findViewById(R.id.btnSelectProduct);
        txtvProduct = findViewById(R.id.txtvProduct);
        etxtDiscount = findViewById(R.id.etxtDiscount);
        txtvDiscount = findViewById(R.id.txtvDiscount);
        btnCalculate = findViewById(R.id.btnCalculate);

        // ******** UI ********
        updateUI();

        // ******** Controller ********

        selectProduct = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        toastUser("Product selected");
                        // Get data from intent
                        product = (Product) result.getData().getSerializableExtra("product");
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

    private void updateUI() {
        if (product == null) {
            txtvProduct.setText("No product selected");
            txtvDiscount.setText("");
        }
        else {
            txtvProduct.setText(String.format(
                getString(R.string.txtvProductFilled),
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
            ));
        }
    }

    private void toastUser(String str) {
        if (str != null)
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}