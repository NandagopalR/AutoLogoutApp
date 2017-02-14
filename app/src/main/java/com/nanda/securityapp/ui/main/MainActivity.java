package com.nanda.securityapp.ui.main;

import android.os.Bundle;
import com.nanda.securityapp.R;
import com.nanda.securityapp.base.BaseActivity;

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    startTimerTask();
  }
}
