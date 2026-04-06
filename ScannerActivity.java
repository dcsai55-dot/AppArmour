package com.apparmour;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ScannerActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> appNames = new ArrayList<>();
    ArrayList<String> packageNames = new ArrayList<>();
    ArrayList<String> riskLevels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        listView = findViewById(R.id.listView);

        loadApps();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                appNames
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view;

                String risk = riskLevels.get(position);

                if (risk.equals("DANGEROUS")) {
                    tv.setTextColor(Color.RED);
                } else if (risk.equals("SUSPICIOUS")) {
                    tv.setTextColor(Color.YELLOW);
                } else {
                    tv.setTextColor(Color.GREEN);
                }

                tv.setText(appNames.get(position) + " (" + risk + ")");
                return view;
            }
        };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String pkg = packageNames.get(position);
            String risk = riskLevels.get(position);

            Toast.makeText(this, "Risk: " + risk, Toast.LENGTH_SHORT).show();

            if (risk.equals("DANGEROUS")) {
                Intent intent = new Intent(Intent.ACTION_DELETE);
                intent.setData(Uri.parse("package:" + pkg));
                startActivity(intent);
            }
        });
    }

    private void loadApps() {
        PackageManager pm = getPackageManager();
        List<ApplicationInfo> apps = pm.getInstalledApplications(0);

        for (ApplicationInfo app : apps) {
            String name = app.loadLabel(pm).toString();
            String pkg = app.packageName;

            String risk = RiskAnalyzer.analyze(pkg, pm);

            appNames.add(name);
            packageNames.add(pkg);
            riskLevels.add(risk);
        }
    }
}
