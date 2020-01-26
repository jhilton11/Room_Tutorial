package com.appify.roomtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.UUID;

public class AddItemActivity extends AppCompatActivity {
    private EditText nameEt, descEt, dateEt;
    private CheckBox isFinishedCb;
    private Button addBtn;
    private ItemViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        viewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        nameEt = findViewById(R.id.item_name);
        descEt = findViewById(R.id.item_description);
        dateEt = findViewById(R.id.item_date);

        isFinishedCb = findViewById(R.id.finished_check_box);
        addBtn = findViewById(R.id.add_btn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            }
        });
    }

    private void addItem() {
        String item = nameEt.getText().toString();
        String desc = descEt.getText().toString();
        String date = dateEt.getText().toString();
        boolean finished = isFinishedCb.isSelected();
        if (!TextUtils.isEmpty(item) && !TextUtils.isEmpty(desc) && !TextUtils.isEmpty(date)) {
            Intent intent = getIntent();
            intent.putExtra("item", item);
            intent.putExtra("desc", desc);
            intent.putExtra("date", date);
            intent.putExtra("finished", finished);

            String id = UUID.randomUUID().toString();

            ToDoItem toDoItem = new ToDoItem(id, item, desc, date, finished);
            viewModel.insertItem(toDoItem);

            setResult(RESULT_OK, intent);
        }
    }
}
