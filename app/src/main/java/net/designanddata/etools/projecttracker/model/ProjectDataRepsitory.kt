package net.designanddata.etools.projecttracker.model

import android.app.Application
import android.os.AsyncTask

class ProjectDataRepsitory internal constructor(application: Application) {
	private val mProjectTrackerDao: ProjectTrackerDao

	// only client requires to be fully active, rest are dependant on current ViewModel
	init {
		val db = ProjectTrackerDatabase.getInstance(application)!!
		// add !! not-null assertion operator to throw an exception if null
		// effectively the same as:
		// if (db == null) System.exit(1)
		mProjectTrackerDao = db.projectTrackerDao()
	}

	fun insert(client:Client) {
		InsertAsyncTask(mProjectTrackerDao).execute(client)
	}

	private class InsertAsyncTask internal constructor (
		private val mInsertAsyncTask: ProjectTrackerDao): AsyncTask<Client, Void, Void>() {
			override fun doInBackground(vararg params: Client): Void? {
				mInsertAsyncTask.insert(params[0])
				return null
			}
	}
}


