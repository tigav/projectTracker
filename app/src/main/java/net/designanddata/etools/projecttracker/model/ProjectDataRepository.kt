package net.designanddata.etools.projecttracker.model

import android.app.Application
import android.arch.lifecycle.LiveData
import org.jetbrains.anko.doAsync

class ProjectDataRepository internal constructor(application: Application) {
	private val mProjectTrackerDao: ProjectTrackerDao
	private val allClients: LiveData<List<Client>>

	// only client requires to be fully active, rest are dependant on current ViewModel
	init {
		val db = ProjectTrackerDatabase.getInstance(application)!!
		// add !! not-null assertion operator to throw an exception if null
		// effectively the same as:
		// if (db == null) System.exit(1)
		mProjectTrackerDao = db.projectTrackerDao()
		allClients = mProjectTrackerDao.getAllClients()

	}

	fun insert(client:Client) {
		doAsync {
			mProjectTrackerDao.insert(client)
		}
	}

	fun getAllClients():LiveData<List<Client>> { return allClients }
	fun getAllBusinesses():LiveData<List<Business>> {
		return mProjectTrackerDao.getAllBusinesses()
	}
	fun getClient(id:Int):Client {
		// loop through clients and return matching ID
		return mProjectTrackerDao.getClient(id)
	}

}


