package com.nanda.securityapp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.nanda.securityapp.ui.main.MainActivity;
import com.nanda.securityapp.R;
import com.nanda.securityapp.base.BaseActivity;

/**
 * Created by nandagopal on 2/14/17.
 */
public class LoginActivity extends BaseActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btn_login) public void onLoginButtonClick() {
    startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
        | Intent.FLAG_ACTIVITY_CLEAR_TASK
        | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS));
    finish();
  }
}
