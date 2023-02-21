package cat.dam.andy.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //member variables
    ListView lv_fruits;
    Spinner sp_fruits,sp_fruits_custom;
    String[] fruitsNames = {"Apple", "Banana", "Litchi", "Mango", "PineApple","Orange","Grapes"};//fruit names array
    int[] fruitsImages = {R.drawable.apple, R.drawable.banana, R.drawable.litchi, R.drawable.mango, R.drawable.pineapple, R.drawable.orange,R.drawable.grapes};//fruits images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initArrayAdapter();
        initCustomBaseAdapter();
        initSimpleAdapter();
        initListeners();
    }


    private void initViews() {
        lv_fruits =findViewById(R.id.lv_fruits);
        sp_fruits = findViewById(R.id.sp_fruits);
        sp_fruits_custom = findViewById(R.id.sp_fruits_custom);
    }

    private void initArrayAdapter() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fruitsNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_fruits.setAdapter(arrayAdapter);
        sp_fruits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(getApplicationContext(), fruitsNames[pos], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void initCustomBaseAdapter() {
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),fruitsImages,fruitsNames);
        sp_fruits_custom.setAdapter(customAdapter);
        sp_fruits_custom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(getApplicationContext(), fruitsNames[pos], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void initSimpleAdapter() {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < fruitsNames.length; i++) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", fruitsNames[i]);
            hashMap.put("image", fruitsImages[i]);
            arrayList.add(hashMap);
        }
        String[] from = {"name", "image"};
        int[] to = {R.id.tv_fruit_name, R.id.iv_fruit_image};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.custom_listview_item, from, to);
        lv_fruits.setAdapter(simpleAdapter);
    }

    private void initListeners() {
        lv_fruits.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(MainActivity.this, fruitsNames[position], Toast.LENGTH_SHORT).show());
    }




}