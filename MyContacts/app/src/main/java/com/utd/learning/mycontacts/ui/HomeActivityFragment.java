package com.utd.learning.mycontacts.ui;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utd.learning.mycontacts.R;
import com.utd.learning.mycontacts.model.CallLogItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment{

    private static final String TAG = HomeActivityFragment.class.getSimpleName();

    private RecyclerView callLogRecycler;
    private CallLogViewAdapter callLogViewAdapter;
    private RecyclerView.ItemAnimator animator;
    private static final int URL_LOADER = 1;
    private List<CallLogItem> callLogItems;

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        callLogRecycler = (RecyclerView) v.findViewById(R.id.contactsRecyclerView);

        callLogItems = getCallDetails(getActivity().getApplicationContext());
        callLogViewAdapter = new CallLogViewAdapter(getActivity(), callLogItems);
        callLogRecycler.setAdapter(callLogViewAdapter);
        callLogRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        callLogRecycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));


        return v;
    }

    /**
     * Method to get the call log details from the phone
     * @param context
     * @return
     */
    private static List<CallLogItem> getCallDetails(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        List<CallLogItem> callLogItems = new ArrayList<>();
        Cursor cursor = context.getContentResolver().query(CallLog.Calls.CONTENT_URI,
                null, null, null, CallLog.Calls.DATE + " DESC");
        int name = cursor.getColumnIndex(CallLog.Calls.CACHED_NAME);
        int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = cursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = cursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
        int[] dummyPics = {R.drawable.contact_one, R.drawable.contact_two, R.drawable.contact_three, R.drawable.contact_four};

        while (cursor.moveToNext()) {
            CallLogItem logItem = new CallLogItem();
            logItem.setName(cursor.getString(name));
            logItem.setNumber(cursor.getString(number));
            logItem.setCallDuration(cursor.getInt(duration));
            int callType = cursor.getInt(type);
            String callDate = cursor.getString(date);
            logItem.setId(dummyPics[callType]);
            logItem.setCallType(callType);
            logItem.setCallTime(new Date(Long.valueOf(callDate)).toString());
            callLogItems.add(logItem);
        }
        Log.d(TAG, "getCallDetails :" + stringBuffer.toString());
        cursor.close();
        return callLogItems;
    }
    @Override
    public void onPause() {
        Log.d(TAG, "Fragment paused");
        super.onPause();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "Fragment resumed");
        super.onResume();
    }

    @Override
    public void onStart() {
        Log.d(TAG, "Fragment started");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "Fragment stopped");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "Fragment destroyed");
        super.onDestroy();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
