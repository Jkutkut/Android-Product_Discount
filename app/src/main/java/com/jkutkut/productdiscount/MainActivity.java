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
                        toastUser(getString(R.string.product_selected));
                        // Get data from intent
                        product = (Product) result.getData().getSerializableExtra(ProductSelection.PRODUCT);
                        updateUI();
                    }
                }
        );

        btnSelectProduct.setOnClickListener(v -> {
            Intent i = new Intent(this, ProductSelection.class);
            selectProduct.launch(i);
        });

        btnCalculate.setOnClickListener(v -> {
            float percent = Float.parseFloat(etxtDiscount.getText().toString());
            if (percent < 0 || percent > 100) {
                toastUser(getString(R.string.invalid_percent));
                return;
            }
            float discount = product.getPrice() * percent / 100;
            float price = product.getPrice() - discount;
            txtvDiscount.setText(String.format(
                getString(R.string.txtvDiscount),
                price
            ));
        });
    }

    private void updateUI() {
        if (product == null) {
            etxtDiscount.setEnabled(false);
            btnCalculate.setEnabled(false);
            txtvProduct.setText("");
        }
        else {
            etxtDiscount.setEnabled(true);
            btnCalculate.setEnabled(true);
            txtvProduct.setText(String.format(
                getString(R.string.txtvProductFilled),
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
            ));
        }
        txtvDiscount.setText("");
    }

    private void toastUser(String str) {
        if (str != null)
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}