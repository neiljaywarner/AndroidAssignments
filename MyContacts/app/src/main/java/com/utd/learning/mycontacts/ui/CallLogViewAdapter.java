package com.utd.learning.mycontacts.ui;

import android.content.Context;
import android.content.res.Resources;
import android.provider.CallLog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.utd.learning.mycontacts.R;
import com.utd.learning.mycontacts.model.CallLogItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by Subbu on 6/17/15.
 */
public class CallLogViewAdapter extends RecyclerView.Adapter<CallLogViewAdapter.CallLogViewHolder> {
    private static final String TAG = CallLogViewAdapter.class.getSimpleName();
    private LayoutInflater inflater;
    private List<CallLogItem> callLogList = Collections.emptyList();
    private Context context;

    public CallLogViewAdapter(Context context, List<CallLogItem> callLogList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.callLogList = callLogList;
    }

    @Override
    public CallLogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.call_log_list_item, parent, false);
        CallLogViewHolder cViewHolder = new CallLogViewHolder(view);
        return cViewHolder;
    }

    @Override
    public void onBindViewHolder(CallLogViewHolder holder, int position) {
        CallLogItem callLog = callLogList.get(position);
        holder.contactName.setText(callLog.getName());
        holder.contactImage.setImageResource(callLog.getId());
        holder.contactNumber.setText(callLog.getNumber());
        holder.callTime.setText(callLog.getCallTime());

        holder.callType.setTextColor(context.getResources().getColor(R.color.colorGreen));
        String callType = null;
        switch (callLog.getCallType()) {
            case CallLog.Calls.OUTGOING_TYPE:
                callType = "OUTGOING";
                break;
            case CallLog.Calls.INCOMING_TYPE:
                callType = "INCOMING";
                break;

            case CallLog.Calls.MISSED_TYPE:
                callType = "MISSED";
                holder.callType.setTextColor(context.getResources().getColor(R.color.colorRed));
                break;
        }
        holder.callType.setText(callType);
//        holder.callDuration.setText(callLog.getCallDuration());
    }

    @Override
    public int getItemCount() {
        return callLogList.size();
    }

    public class CallLogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CardView cv;
        TextView contactName;
        ImageView contactImage;
        TextView contactNumber;
        TextView callTime;
        TextView callDuration;
        TextView callType;

        public CallLogViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.contact_card);
            contactName = (TextView) itemView.findViewById(R.id.callerName);
            contactImage = (ImageView) itemView.findViewById(R.id.callerPic);
            contactNumber = (TextView) itemView.findViewById(R.id.callerNumber);
            callTime = (TextView) itemView.findViewById(R.id.calledTime);
            callDuration = (TextView) itemView.findViewById(R.id.callDuration);
            callType= (TextView) itemView.findViewById(R.id.callType);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick ");;
        }
    }
}
