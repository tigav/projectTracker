package net.designanddata.etools.projecttracker.model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

class AllClientsViewModel(application: Application): AndroidViewModel(application) {
	private val repository: ProjectDataRepository = ProjectDataRepository(application)
	private val mAllClients: LiveData<List<Client>>

	init {
		mAllClients = repository.getAllClients()
	}

	fun getAllClients():LiveData<List<Client>> {
		return mAllClients
	}

	fun insert(client:Client) {
		repository.insert(client)
	}
	fun insert(firstName:String, lastName:String, email:String, phone:String, business: String?) {
		insert(Client( null,
			firstName,
			lastName,
			email,
			phone,
			business))
	}
}
