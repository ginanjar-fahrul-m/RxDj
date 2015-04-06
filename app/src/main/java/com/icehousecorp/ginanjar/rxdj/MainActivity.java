package com.icehousecorp.ginanjar.rxdj;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.icehousecorp.ginanjar.rxdj.adapters.DjAdapter;
import com.icehousecorp.ginanjar.rxdj.models.Collections;
import com.icehousecorp.ginanjar.rxdj.presenters.ListPresenter;
import com.icehousecorp.ginanjar.rxdj.services.DjService;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.listView) ListView listView;
    DjAdapter adapter;
    DjService djService;
    ListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        ArrayList<Collections> empty = new ArrayList<Collections>();
        adapter = new DjAdapter(this, empty);
        listView.setAdapter(adapter);

        djService = new DjService();
        presenter = new ListPresenter(this, djService);
        presenter.loadSongs();
    }

    public void displaySongs(List<Collections> collections){
        adapter.clear();
        adapter.addAll(collections);
        adapter.notifyDataSetInvalidated();
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
}
