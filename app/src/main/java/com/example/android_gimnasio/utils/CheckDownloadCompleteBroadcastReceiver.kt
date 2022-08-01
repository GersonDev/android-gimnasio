package com.example.android_gimnasio.utils

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.database.Cursor
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData

class CheckDownloadCompleteBroadcastReceiver: BroadcastReceiver() {

//    val mData: MutableLiveData<String> = MutableLiveData<String>()
//
//    fun getData(): LiveData<String> {
//        return mData
//    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent!!.action
        if (action == DownloadManager.ACTION_DOWNLOAD_COMPLETE) {

            val query: DownloadManager.Query = DownloadManager.Query()

            query.setFilterById(intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0))

            val manager: DownloadManager = context!!.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

            val cursor: Cursor = manager.query(query)

            if (cursor.moveToFirst()) {
                if (cursor.count > 0) {
                    val status: Int =
                        cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
                    if (status == DownloadManager.STATUS_SUCCESSFUL) {
                        val file: String =
                            cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
                        print(file)
                        Repoo.mData.value = file
                        // So something here on success
                    } else {
                        val message: Int =
                            cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_REASON))
                        // So something here on failed.
                    }
                }
            }
        }
    }
}