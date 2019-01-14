package net.designanddata.etools.projecttracker.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.designanddata.etools.projecttracker.R
import net.designanddata.etools.projecttracker.model.Client

/**
 * Adapter for list of clients, a type of RecyclerView adapter
 */
class ClientListAdapter internal constructor(
		private val context: Context
	) : RecyclerView.Adapter<ClientListAdapter.ClientViewHolder>() {

	private val inflater: LayoutInflater = LayoutInflater.from(context)
	private var clients = emptyList<Client>() // Cached copy of words

	/**
	 * View holder - the individual items
	 */
	inner class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		// Child id of Recyclerview_item.xml : ConstraintLayout = a recyclerItem - check ID in .xml file
		val clientItemView: TextView = itemView.findViewById(R.id.recyclerItem)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
		val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
		return ClientViewHolder(itemView)
	}

	override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
		val current: Client = clients[position]

		if (current.firstName.isEmpty() && current.lastName.isEmpty()) {
			holder.clientItemView.text = context.getString(R.string.nameless_client)
		} else {
			holder.clientItemView.text = context.getString(
				R.string.client_name, current.firstName, current.lastName
			).trim()
		}
	}

	internal fun setClients(clients: List<Client>) {
		this.clients = clients
		notifyDataSetChanged()
	}

	override fun getItemCount() = clients.size
}
