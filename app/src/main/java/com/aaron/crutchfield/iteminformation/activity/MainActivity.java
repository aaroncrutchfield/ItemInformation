package com.aaron.crutchfield.iteminformation.activity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.aaron.crutchfield.iteminformation.ItemListAdapter;
import com.aaron.crutchfield.iteminformation.R;
import com.aaron.crutchfield.iteminformation.data.ItemEntry;
import com.aaron.crutchfield.iteminformation.viewModel.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.mancj.materialsearchbar.MaterialSearchBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MaterialSearchBar.OnSearchActionListener {

    private MainViewModel viewModel;
    private final ItemListAdapter adapter = new ItemListAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        MaterialSearchBar searchBar = findViewById(R.id.search_bar);
        searchBar.setOnSearchActionListener(this);
        searchBar.inflateMenu(R.menu.menu_main);
        searchBar.setHint("Search an item number");
        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        List<ItemEntry> itemEntryList = initializeDatabase();

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.insertItemEntries(itemEntryList);

        RecyclerView recyclerView = findViewById(R.id.rv_items_list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getAllItems().observe(this, new Observer<List<ItemEntry>>() {
            @Override
            public void onChanged(@Nullable List<ItemEntry> itemEntries) {
                viewModel.getAllItems().removeObserver(this);
                adapter.updateList(itemEntries);
            }
        });
    }

    private List<ItemEntry> initializeDatabase() {
        String jsonString = null;
        AssetManager assetManager = getAssets();

        // Load the JSON file
        InputStream input;
        try {
            input = assetManager.open("item_information.json");

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            // byte buffer into a string
            jsonString = new String(buffer);

            Log.d("MainActivity", "onCreate: " + jsonString.substring(0, 300));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<ItemEntry> itemEntryList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject itemEntryObject = jsonArray.getJSONObject(i);

                Gson itemGson = new Gson();
                ItemEntry itemEntry = itemGson.fromJson(itemEntryObject.toString(), ItemEntry.class);
                itemEntryList.add(itemEntry);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return itemEntryList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSearchStateChanged(boolean enabled) {

    }

    @Override
    public void onSearchConfirmed(CharSequence text) {
        final String itemNumber = "%" + text + "%";
        viewModel.getByLikeItemNumbers(itemNumber).observe(this, new Observer<List<ItemEntry>>() {
            @Override
            public void onChanged(@Nullable List<ItemEntry> itemEntryList) {
                viewModel.getByLikeItemNumbers(itemNumber).removeObserver(this);
                adapter.updateList(itemEntryList);
            }
        });
    }

    @Override
    public void onButtonClicked(int buttonCode) {

    }
}
