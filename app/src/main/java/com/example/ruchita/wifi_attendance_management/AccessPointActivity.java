package com.example.ruchita.wifi_attendance_management;

        import java.util.ArrayList;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.TextView;
import android.util.Log;
        import android.widget.Toast;


public class AccessPointActivity extends AppCompatActivity {
    TextView textView1;
    WifiApManager wifiApManager;
    Database_Helper db;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database_Helper(this);

        textView1 = (TextView) findViewById(R.id.textView1);
        wifiApManager = new WifiApManager(this);

        scan();

    }

    private void scan() {
        wifiApManager.getClientList(false, new FinishScanListener() {

            @Override
            public void onFinishScan(final ArrayList<ClientScanResult> clients) {

                textView1.setText("Attendance State: " );
                if(wifiApManager.getWifiApState()==WIFI_AP_STATE.WIFI_AP_STATE_ENABLED)
                    textView1.append("STARTED\n\n");

                if(wifiApManager.getWifiApState()==WIFI_AP_STATE.WIFI_AP_STATE_DISABLED)
                    textView1.append("NOT STARTED\n\n");

                textView1.append("Students: \n");
                for (ClientScanResult clientScanResult : clients) {
                    Student s = db.getStudent(clientScanResult.getHWAddr());
                    if(s!=null)
                    {
                        Log.wtf("Called","Calles");
                        textView1.append("####################\n");
                        //   textView1.append("IpAddr: " + clientScanResult.getIpAddr() + "\n");
                        //  textView1.append("Device: " + clientScanResult.getDevice() + "\n");
                        //  textView1.append("HWAddr: " + clientScanResult.getHWAddr() + "\n");
                        // textView1.append("isReachable: " + clientScanResult.isReachable() + "\n");
                        textView1.append("Name " + s.getName() + "\n");
                        textView1.append("Present" + "\n");
                        textView1.append("Attendance: " + (s.getAttendance() +1) + "\n");
                      //temp comment the code  db.updateContact(s.getID(), (s.getAttendance()+1));

                    }
                    else
                    {
                        //textView1.append("HWAddr: " + clientScanResult.getHWAddr() + "\n");
                    }

                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "Get Students");
        menu.add(0, 1, 0, "Open Access Point");
        menu.add(0, 2, 0, "Close Access Point");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                scan();
                break;
            case 1:
                wifiApManager.setWifiApEnabled(null, true);
                break;
            case 2:
                wifiApManager.setWifiApEnabled(null, false);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
