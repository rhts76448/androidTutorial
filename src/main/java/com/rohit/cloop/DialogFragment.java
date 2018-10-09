package com.rohit.cloop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogFragment extends Fragment {

    public static final String ImageIdKey = "imageKey";
    public static final String HeaderKey = "headerKey";
    public static final String MsgKey = "msgKey";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View dialog = inflater.inflate(R.layout.dialog, container, false);
        Bundle bundle = getArguments();
        if(bundle != null) {
            int imageId = bundle.getInt(ImageIdKey);
            String header = bundle.getString(HeaderKey);
            String msg = bundle.getString(MsgKey);
            setValues(dialog, imageId, header, msg);
        }
        return dialog;
    }

    private void setValues(View dialog, int imageId, String header, String msg) {
        ImageView image = (ImageView)dialog.findViewById(R.id.dialog_image);
        image.setImageResource(imageId);
        TextView head = (TextView)dialog.findViewById(R.id.dialog_header);
        head.setText(header);
        TextView message = (TextView)dialog.findViewById(R.id.dialog_msg);
        message.setText(msg);

    }
}
