package com.utd.learning.mycontacts.ui;

import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
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
import com.utd.learning.mycontacts.model.Contact;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Subbu on 6/17/15.
 */
public class ContactsViewAdapter extends RecyclerView.Adapter<ContactsViewAdapter.ContactViewHolder> {
    private static final String TAG = ContactsViewAdapter.class.getSimpleName();
    private static final int URL_LOADER = 1;
    private LayoutInflater inflater;
    private List<Contact> contactsList = Collections.emptyList();
    private Context context;

    public ContactsViewAdapter(Context context, List<Contact> contactsList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.contactsList = contactsList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        ContactViewHolder cViewHolder = new ContactViewHolder(view);
        return cViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact con = contactsList.get(position);
        holder.contactName.setText(con.getName());
        holder.contactImage.setImageResource(con.getId());
        holder.contactEmail.setText(con.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CardView cv;
        TextView contactName;
        ImageView contactImage;
        TextView contactEmail;

        public ContactViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.contact_card);
            contactName = (TextView) itemView.findViewById(R.id.contactName);
            contactImage = (ImageView) itemView.findViewById(R.id.contactPic);
            contactEmail = (TextView) itemView.findViewById(R.id.contact_mail);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick ");;
        }
    }
}
