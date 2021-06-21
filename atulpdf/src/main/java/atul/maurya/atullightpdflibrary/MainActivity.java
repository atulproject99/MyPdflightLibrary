package atul.maurya.atullightpdflibrary;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import atul.maurya.atullightpdflibrary.adapter.PDFPagerAdapter;
import atul.maurya.atullightpdflibrary.remote.DownloadFile;


public class MainActivity extends AppCompatActivity implements DownloadFile.Listener {

    RemotePDFViewPager remotePDFViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://www.tutorialspoint.com/php/php_tutorial.pdf";
        remotePDFViewPager= new RemotePDFViewPager(this, url,this );
        //remotePDFViewPager.setRotationY(90);
        // The majority of the magic happens here

        // The easiest way to get rid of the overscroll drawing that happens on the left and right
    }



    PDFPagerAdapter adapter;
    @Override
    public void onSuccess(String url, String destinationPath) {
        Log.e("down","download finish");
        adapter = new PDFPagerAdapter(this, "php_tutorial.pdf");
        remotePDFViewPager.setAdapter(adapter);
        setContentView(remotePDFViewPager);
    }


    @Override
    public void onFailure(Exception e) {
        Log.e("down","download failed");
    }

    @Override
    public void onProgressUpdate(int progress, int total) {
        Log.e("down","download progresss");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.close();
    }




}
