package com.jkutkut.productdiscount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jkutkut.productdiscount.data.Products;
import com.jkutkut.productdiscount.javabean.Product;

public class ProductSelection extends AppCompatActivity {

    public static final String PRODUCT = "product";

    // ******** UI Components ********
    private EditText etxtCode;
    private EditText etxtName;
    private EditText etxtDesc;
    private EditText etxtPrice;
    private Button btnSearch;
    private Button btnOk;
    private Button btnCancel;

    private Products products;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_selection);

        products = new Products();

        // ******** UI Components ********
        etxtCode = findViewById(R.id.etxtCode);
        etxtName = findViewById(R.id.etxtName);
        etxtDesc = findViewById(R.id.etxtDesc);
        etxtPrice = findViewById(R.id.etxtPrice);
        btnSearch = findViewById(R.id.btnSearch);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);


        btnSearch.setOnClickListener(v -> {
            String id = etxtCode.getText().toString();
            if (id.trim().isEmpty())
                toastUser(getString(R.string.empty_code));
            else {
                product = products.getProduct(id);
                if (product == null)
                    toastUser(getString(R.string.product_not_found));
                updateUI();
            }
        });

        btnSearch.setOnLongClickListener(v -> {
            product = products.getRandomProduct();
            updateUI();
            return true;
        });

        btnOk.setOnClickListener(v -> handleOk());

        btnCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }

    private void updateUI() {
        if (product == null) {
            btnOk.setEnabled(false);
            etxtName.setVisibility(EditText.INVISIBLE);
            etxtDesc.setVisibility(EditText.INVISIBLE);
            etxtPrice.setVisibility(EditText.INVISIBLE);
        }
        else {
            btnOk.setEnabled(true);
            etxtName.setVisibility(EditText.VISIBLE);
            etxtDesc.setVisibility(EditText.VISIBLE);
            etxtPrice.setVisibility(EditText.VISIBLE);
            etxtCode.setText(product.getId());
            etxtName.setText(product.getName());
            etxtDesc.setText(product.getDescription());
            etxtPrice.setText(String.valueOf(product.getPrice()));
        }
    }

    private void handleOk() {
        if (product == null)
            return;
        Intent data = new Intent();
        data.putExtra(PRODUCT, product);
        setResult(RESULT_OK, data);
        finish();
    }

    private void toastUser(String str) {
        if (str != null)
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}