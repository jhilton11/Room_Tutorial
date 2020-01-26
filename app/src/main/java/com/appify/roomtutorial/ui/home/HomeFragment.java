package com.appify.roomtutorial.ui.home;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appify.roomtutorial.ItemAdapter;
import com.appify.roomtutorial.ItemRepository;
import com.appify.roomtutorial.ItemViewModel;
import com.appify.roomtutorial.R;
import com.appify.roomtutorial.ToDoItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ItemViewModel viewModel;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private ItemAdapter adapter;
    private FabClickListener mListener;
    private LiveData<List<ToDoItem>> listLiveData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recyclerview);
        fab = root.findViewById(R.id.fab);
        viewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        adapter = new ItemAdapter(new ArrayList<ToDoItem>());
//        recyclerView.setAdapter(adapter);
        listLiveData = viewModel.getAllItems();
        listLiveData.observe(this, new Observer<List<ToDoItem>>() {
            @Override
            public void onChanged(List<ToDoItem> toDoItems) {
                adapter = new ItemAdapter(toDoItems);
                adapter.setData(toDoItems);
                Log.d(getClass().getSimpleName(), toDoItems.size()+" items added");
                recyclerView.setAdapter(adapter);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick();
            }
        });

        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (FabClickListener) context;
    }

    public interface FabClickListener {
        void onClick();
    }
}