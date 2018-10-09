package com.rohit.cloop;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

public class DialogPageAdaptor extends FragmentPagerAdapter {

    private String[] headers;
    private String[] msgs;

    public DialogPageAdaptor(FragmentManager fm, Context context) {
        super(fm);
        Resources resources = context.getResources();
        headers = resources.getStringArray(R.array.dialog_header);
        msgs = resources.getStringArray(R.array.dialog_msg);
    }

    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        bundle.putString(DialogFragment.HeaderKey, headers[i]);
        bundle.putString(DialogFragment.MsgKey, msgs[i]);
        bundle.putInt(DialogFragment.ImageIdKey, getImageId(i));

        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }

    @Override
    public boolean isViewFromObject(View view, Object ob) {
        return view == ob;
    }

    private int getImageId(int i) {
        int id = 0;
        switch (i) {
            case 0:
                id = R.drawable.cloop_work;
                break;
            case 1:
                id = R.drawable.fetured;
                break;
            case 2:
                id = R.drawable.invite_friends;
                break;
        }
        return id;
    }

    @Override
    public int getCount() {
        return headers.length;
    }
}
