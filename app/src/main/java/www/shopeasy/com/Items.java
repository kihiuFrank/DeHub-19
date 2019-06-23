package www.shopeasy.com;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Items extends AppCompatActivity {

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
        Home.result.setText(listView.toString());
    }

}
