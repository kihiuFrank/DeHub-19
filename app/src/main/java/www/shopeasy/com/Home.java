package www.shopeasy.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Home extends AppCompatActivity {

        public static TextView result;
        Button btn_scan;
        Button btn_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_scan = findViewById(R.id.btn_scan);
        result = findViewById(R.id.text_scan);
        btn_items = findViewById(R.id.btn_items);

        btn_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Items.class);
                 startActivity(intent);

            }
        });

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ScanActivity.class);
                startActivity(i);
            }
        });
    }

}
