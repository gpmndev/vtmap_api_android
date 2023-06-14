package com.viettel.map.maplib;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gpmn.vtmap.api.ViettelMapApi;
import com.gpmn.vtmap.api.models.api.CancelRequest;
import com.gpmn.vtmap.api.models.api.MapApiParam;

import kotlin.Unit;


public class TestActivity extends AppCompatActivity {
    private Button btGeocoding;

    private Button btCancelGeocoding;
    private CancelRequest cancelRequest;
    private final ViettelMapApi getMapApi = new ViettelMapApi("", "");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btGeocoding = findViewById(R.id.btGeocoding);
        btCancelGeocoding = findViewById(R.id.btCancelGeocoding);

        btGeocoding.setOnClickListener(v -> {
            cancelRequest = getMapApi.geocode(new MapApiParam(), (response) ->
                    {
                        Log.d("MainActivity", response.toString());
                        return Unit.INSTANCE;
                    },
                    (failure) -> {
                        Log.d("MainActivity", failure);
                        return Unit.INSTANCE;
                    }, () -> {
                        Log.d("MainActivity", "cancelled");
                        return Unit.INSTANCE;
                    });
        });

        btCancelGeocoding.setOnClickListener(v -> cancelRequest.cancel());
    }
}
