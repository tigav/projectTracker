package net.designanddata.etools.projecttracker.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

class AllClientsViewModel: ViewModel() {
	private lateinit var repository: ProjectDataRepository
	private lateinit var mAllClients: LiveData<List<Client>>

	@Inject fun init(repository: ProjectDataRepository) {
		this.repository = repository
		mAllClients = repository.getAllClients()
	}
}
