package net.designanddata.etools.projecttracker

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import net.designanddata.etools.projecttracker.model.AllClientsViewModel
import net.designanddata.etools.projecttracker.view.ClientListAdapter

// I don't know the purpose behind this yet
//const val EXTRA_MESSAGE = "net.designanddata.etools.projecttracker.MESSAGE"
const val CREATE_CLIENT_INTENT = 1  // request code

/**
 * Initial activity to display a list of clients and provide a button for adding more.
 */
class MainActivity : AppCompatActivity() {
	// initialize ViewModel for data
	private lateinit var allClients:AllClientsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

		//bind adapter to recyclerview
		val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
		val recyclerAdapter = ClientListAdapter(this)
		recyclerView.adapter = recyclerAdapter
		recyclerView.layoutManager = LinearLayoutManager(this)

		allClients = ViewModelProviders.of(this).get(AllClientsViewModel::class.java)

		// I have no idea what this syntax is on
		allClients.getAllClients().observe(this, Observer { clients ->
			clients?.let { recyclerAdapter.setClients(clients)}
		})
    }

    /**
     * This is called from activity_main.xml from the action button => onClick
     * - Must have public access
     * - implicit unit return value
     * and
     * @param view:View as the only parameter
	 *
	 * https://developer.android.com/training/basics/firstapp/starting-activity
	 *
	 * This click is from the action button
     */
    fun sendMessage(view:View) {
        val intent = Intent(this, NewClientActivity::class.java)
        startActivityForResult(intent, CREATE_CLIENT_INTENT)
    }

	override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?) {
		super.onActivityResult(requestCode,resultCode,data)
		if (resultCode != Activity.RESULT_OK || data == null) return

		var fn = data.getStringExtra("firstName")
		if (fn == null) fn = ""
		var ln = data.getStringExtra("lastName")
		if (ln == null) ln = ""
		var em = data.getStringExtra("email")
		if (em == null) em = ""
		var ph = data.getStringExtra("phone")
		if (ph == null) ph = ""

		allClients.insert(fn,ln,em,ph,data.getStringExtra("business"))
	}

	fun inspectClient(view:View) {
		val review = findViewById<TextView>(R.id.recyclerItem)
		val message = review.text.toString()

		// create the intent to navigate
		// https://developer.android.com/training/basics/firstapp/starting-activity
		val intent = Intent(this, ClientActivity::class.java)
		startActivity(intent)
	}
}
