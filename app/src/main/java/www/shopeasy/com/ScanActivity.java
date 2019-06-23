package www.shopeasy.com;

import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public void handleResult(Result rawResult) {
        Home.result.setText(rawResult.getText());
        onBackPressed();
        Toast.makeText(getApplicationContext(),"Item added to cart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}
