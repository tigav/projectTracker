package net.designanddata.etools.projecttracker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView

/**
 * TODO: Initial version - add raw unchecked data
 * TODO: version 0.1 - validate existent data, validate email & phone #
 * TODO: version 0.2? - bind to business
 */
class NewClientActivity : AppCompatActivity() {
//	private val allBusiness: LiveData<List<Business>>
//	private val mRepository: ProjectDataRepository// = ProjectDataRepository(application)

	init {
//		val allClients = ViewModelProviders.of(this).get(AllClientsViewModel::class.java)
//		allBusiness = mRepository.getAllBusinesses()
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		requestWindowFeature(Window.FEATURE_ACTION_BAR)
		setContentView(R.layout.activity_new_client)
		setTitle(R.string.title_new_client)
// 		TODO: Add business in next version
//		spinner.onItemSelectedListener = this
	}
//	class spinnerListener: AdapterView.OnItemSelectedListener {
//		fun onNothingSelected
//	}

	private fun getTextOfId(id:Int):String {
		return findViewById<TextView>(id).text.toString()
	}

	// Cancel and return, triggered via xml
	fun cancel(view: View) {
		setResult(RESULT_CANCELED)
		finish()
	}

	// TODO : get list of existing clients
	fun createClient(view : View) {
		val firstName = getTextOfId(R.id.firstNameField)
		val lastName = getTextOfId(R.id.lastNameField)
		val email = getTextOfId(R.id.emailField)
		var phone = getTextOfId(R.id.phoneField)
		if (phone.isNotEmpty()) { // strip all non-numeric digits
			phone = phone.replace( """[^\d]""", "" )
		}

		// insert validation here
		val replyIntent = Intent()
		replyIntent.putExtra("firstName", firstName )
			.putExtra("lastName", lastName )
			.putExtra("email", email )
			.putExtra("phone", phone )

		setResult(RESULT_OK, replyIntent)
		finish()
		// or on fail - TODO: gen fail code
	}

	override fun onResume() {
		super.onResume()
		// always null, no idea why
		supportActionBar?.setHomeButtonEnabled(true)
	}

}
