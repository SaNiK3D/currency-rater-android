package com.sanik.currencyrater.db.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class PrepopulateDatabaseWorker(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {
        return Result.SUCCESS
    }
}