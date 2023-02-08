package com.example.myapplication3;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ManageProduct extends AppCompatActivity {
    ListView listView;
    List<Product> data = new ArrayList<>();
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product);
        listView = (ListView) findViewById(R.id.listProduct);
//        data.add(new Product(1, 10, "https://img.thuthuatphanmem.vn/uploads/2018/09/25/hinh-anh-hoa-cuc-cau-vong-dep_110817989.jpg", "Hoa", 15.000));
//        data.add(new Product(2, 10, "https://phunugioi.com/wp-content/uploads/2020/08/hinh-anh-hoa-dep.jpg", "Hoa hoang", 15.000));
        ProcessDatabase.getInstance(ManageProduct.this);
        data = ModifyProduct.getProductList();
        adapter = new ProductAdapter(ManageProduct.this, data);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                return false;
            }
        });
    }

    public void showAddProduct() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialogproduct, null);
        EditText img = view.findViewById(R.id.imageProduct);
        EditText edName = view.findViewById(R.id.nameProduct);
        EditText edCost = view.findViewById(R.id.costProduct);
        EditText edQuantity = view.findViewById(R.id.quantityProduct);
        builder.setView(view);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = edName.getText().toString();
                String thumbnai = img.getText().toString();
                int quantity = Integer.parseInt(edQuantity.getText().toString());
                double cost = Integer.parseInt(edCost.getText().toString());
                Product product = new Product(data.size(), quantity, thumbnai, name, cost);
                ModifyProduct.insert(product);
                data.add(product);
                adapter.notifyDataSetChanged();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menucontext, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void editProduct(int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialogproduct, null);
        EditText img = view.findViewById(R.id.imageProduct);
        EditText edName = view.findViewById(R.id.nameProduct);
        EditText edCost = view.findViewById(R.id.costProduct);
        EditText edQuantity = view.findViewById(R.id.quantityProduct);
        builder.setView(view);
        builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = edName.getText().toString();
                String thumbnai = img.getText().toString();
                int quantity = Integer.parseInt(edQuantity.getText().toString());
                double cost = Integer.parseInt(edCost.getText().toString());
                Product product = new Product(data.get(index).getId(), quantity, thumbnai, name, cost);
                ModifyProduct.update(product);
                data.set(index, product);
                adapter.notifyDataSetChanged();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        switch (item.getItemId()) {
            case R.id.delete:
                ModifyProduct.delete(data.get(index).getId());
                data.remove(index);
                adapter.notifyDataSetChanged();
                break;
            case R.id.edit:
                editProduct(index);
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                showAddProduct();
                break;
            case R.id.exit:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}