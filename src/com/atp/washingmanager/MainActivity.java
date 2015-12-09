/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.atp.washingmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.TextView;

import com.example.android.navigationdrawerexample.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActionBar();
    }

	private void initActionBar() {
		View actionBarView = (View) LayoutInflater.from(this).inflate(
				R.layout.item_action_bar, null);
		getActionBar().setDisplayShowCustomEnabled(true);
		getActionBar().setCustomView(actionBarView);
		
		TextView mTvTitle = (TextView) actionBarView.findViewById(R.id.txt_title);
		mTvTitle.setText(GeneralUtil.getString(this, Contanst.USER_NAME, "ATP"));
		mTvTitle.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View arg0) {
				showDialogAccount();
				return false;
			}
		});
	}
	
	private void showDialogAccount(){
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog_account);
		dialog.show();
	}
}