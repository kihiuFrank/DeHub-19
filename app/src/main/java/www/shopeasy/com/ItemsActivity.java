package www.shopeasy.com;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ItemsActivity extends AppCompatActivity {

    String [] products;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView listView = findViewById(R.id.list_items);

        products = getResources().getStringArray(R.array.products);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, products);
        listView.setAdapter(adapter);
        //initializeDisplayContent();

    }

    private void initializeDisplayContent() {
        final ListView listView = findViewById(R.id.list_items);
        HomeActivity.result.setText(listView.toString());
    }

}
