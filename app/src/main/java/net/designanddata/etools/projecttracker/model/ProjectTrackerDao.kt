package net.designanddata.etools.projecttracker.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao // data access object
interface ProjectTrackerDao {
	// Clients
	@Query("SELECT * FROM client ORDER BY last_name, first_name")
	fun getAllClients(): LiveData<List<Client>>

	@Query( "SELECT * FROM client WHERE `rowid` = :id ORDER BY `rowid` LIMIT 1")
	fun getClient(id: Int): Client

	@Insert(onConflict = OnConflictStrategy.FAIL)
	fun insert(client: Client): Long

	@Update(onConflict = OnConflictStrategy.FAIL)
	fun update(client: Client): Int

	@Delete
	fun deleteClient(client: Client)

	// Businesses
	@Query( "SELECT * FROM business ORDER BY `rowid`")
	fun getAllBusinesses(): LiveData<List<Business>>

	@Query("SELECT * FROM business WHERE `rowid` = :id ORDER BY `rowid`")
	fun getBusinessById(id: Int): Business

	@Insert(onConflict = OnConflictStrategy.FAIL)
	fun insert(business: Business): Long

	@Update(onConflict = OnConflictStrategy.FAIL)
	fun update(business: Business): Int

	@Delete
	fun deleteBusiness(business: Business)

	// Work Hours
	@Query("SELECT * FROM workhour WHERE `project` = :projectID ORDER BY `rowid`")
	fun getWorkHours(projectID: Int): LiveData<List<WorkHour>>

	@Insert
	fun insert(workHours: WorkHour): Long

	@Update
	fun update(workHours: WorkHour): Int

	@Delete
	fun deleteHours(workHours: WorkHour)

	// Payment
	@Query("SELECT * FROM payment WHERE client = :clientId ORDER BY date")
	fun getPaymentsByClient(clientId: Int): LiveData<List<Payment>>

	@Insert
	fun insert(payment: Payment): Long

	@Delete
	fun delete(payment: Payment)

	@Update
	fun update(payment: Payment): Int

	// Delivery
	@Query("SELECT * FROM delivery WHERE project_id = :project")
	fun getDeliverables(project: Int): LiveData<List<Delivery>>

	@Insert
	fun insert(delivery: Delivery): Long

	@Delete
	fun delete(delivery: Delivery)

	@Update
	fun update(delivery: Delivery): Int

	// Invoices
	@Query("SELECT * FROM invoice ORDER BY `rowid`")
	fun getInvoices(): List<Invoice>

	@Query("SELECT * FROM invoice WHERE project_id = :projectId ORDER BY `rowid`")
	fun getInvoices(projectId: Int): LiveData<List<Invoice>>

	@Query("SELECT * FROM invoice WHERE `rowid` = :rowid")
	fun getInvoice(rowid: Int): Invoice

	@Insert
	fun insert(invoice: Invoice): Long

	@Update
	fun update(invoice: Invoice): Int

	@Delete
	fun delete(invoice: Invoice)

	// Project
	@Insert(onConflict = OnConflictStrategy.FAIL)
	fun insert(project: Project): Long

	@Update
	fun update(project: Project): Int

	@Delete
	fun delete(project: Project)

	@Query("SELECT * FROM project WHERE name == :name ORDER BY last_updated")
	fun getProjectByName(name: String): LiveData<List<Project>>

	@Query("SELECT * FROM project ORDER BY last_updated")
	fun getAllProjects(): LiveData<List<Project>>

	@Query("SELECT * FROM project ORDER BY `rowid`")
	fun getAllProjectsById(): LiveData<List<Project>>

	@Query("SELECT * FROM project WHERE `rowid` == :rowid ORDER BY `rowid` LIMIT 1")
	fun geProjectById(rowid: String): LiveData<Project>
}
