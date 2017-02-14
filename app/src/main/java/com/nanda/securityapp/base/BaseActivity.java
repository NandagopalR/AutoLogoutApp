package com.nanda.securityapp.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.nanda.securityapp.ui.login.LoginActivity;

/**
 * Created by nandagopal on 2/14/17.
 */
public class BaseActivity extends AppCompatActivity {

  private long startTime = 10 * 1000; // 10 MillSec Idle Time
  private final long interval = 1 * 1000;
  private LogoutTimerTask logoutTimerTask;
  private boolean isOnScreen;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    logoutTimerTask = new LogoutTimerTask(startTime, interval);
  }

  @Override public void onUserInteraction() {
    super.onUserInteraction();
    if (this instanceof LoginActivity) {
      stopTimerTask();
    } else {
      startTimerTask();
    }
  }

  protected void startTimerTask() {
    logoutTimerTask.cancel();
    logoutTimerTask.start();
  }

  protected void stopTimerTask() {
    logoutTimerTask.cancel();
  }

  @Override protected void onPause() {
    super.onPause();
    isOnScreen = false;
  }

  @Override protected void onResume() {
    super.onResume();
    isOnScreen = true;
  }

  private void navigateToLogin() {
    if (isOnScreen) {
      startActivity(new Intent(BaseActivity.this, LoginActivity.class).addFlags(
          Intent.FLAG_ACTIVITY_CLEAR_TOP));
      this.finish();
    } else {
      this.finish();
    }
  }

  public class LogoutTimerTask extends CountDownTimer {

    public LogoutTimerTask(long startTime, long interval) {
      super(startTime, interval);
    }

    @Override public void onFinish() {
      Log.e("Finish", "onFinish: ");
      navigateToLogin();
    }

    @Override public void onTick(long millisUntilFinished) {
      Log.e("MilliSec", " - " + millisUntilFinished);
    }
  }
}
