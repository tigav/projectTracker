package net.designanddata.etools.projecttracker.model

import android.arch.persistence.room.*

@Dao // data access object
interface ProjectTrackerDao {
	// Clients
	@Query("SELECT * FROM client ORDER BY last_name, first_name")
	fun getAllClients(): List<Client>

	@Query("SELECT * FROM client WHERE `rowid` = :id")
	fun getClientsById(id: Int): Client

	@Insert(onConflict = OnConflictStrategy.FAIL)
	fun insert(client: Client): Client

	@Update(onConflict = OnConflictStrategy.FAIL)
	fun udpate(client: Client): Client

	@Delete
	fun deleteClient()

	// Businesses
	fun getAllBusinesses(): List<Business>

	@Query("SELECT * FROM business WHERE `rowid` = :id ORDER BY")
	fun getBusinessById(id: Int): Business

	@Insert(onConflict = OnConflictStrategy.FAIL)
	fun insert(business: Business)

	@Update(onConflict = OnConflictStrategy.FAIL)
	fun udpate(business: Business)

	@Delete
	fun deleteBusiness(business: Business)

	// Work Hours
	@Query("SELECT * FROM workhour WHERE `project` = :projectID ORDER BY `rowid`")
	fun getWorkHours(projectID: Int): List<WorkHour>

	@Insert
	fun insert(workHours: WorkHour)

	@Update
	fun update(workHours: WorkHour)

	@Delete
	fun deleteHours(workHours: WorkHour)

	// Payment
	@Query("SELECT * FROM payment WHERE client = :clientID ORDER BY date")
	fun getPaymentsByClient(clientId: Int): List<Payment>

	@Insert
	fun insert(payment: Payment)

	@Delete
	fun delete(payment: Payment)

	@Update
	fun update(payment: Payment)

	// Delivery
	@Query("SELECT * FROM delivery WHERE project_id = :project")
	fun getDeliverables(project: Int)

	@Insert
	fun insert(delivery: Delivery)

	@Delete
	fun delete(delivery: Delivery)

	@Update
	fun update(delivery: Delivery)

	// Invoices
	@Query("SELECT * FROM invoice ORDER BY `rowid`")
	fun getInvoices(): List<Invoice>

	@Query("SELECT * FROM invoice WHERE project_id = :projectId ORDER BY rowid")
	fun getInvoices(projectId: Int): List<Invoice>

	@Query("SELECT * FROM invoice WHERE rowid = :rowid")
	fun getInvoice(rowid: Int): Invoice

	@Insert
	fun insert(invoice: Invoice)

	@Update
	fun update(invoice: Invoice)

	@Delete
	fun delete(invoice: Invoice)

	// Project
	@Insert(onConflict = OnConflictStrategy.FAIL)
	fun insert(project: Project): Int

	@Update
	fun update(project: Project): Int

	@Delete
	fun delete(project: Project)

	@Query("SELECT * FROM project WHERE name == :name ORDER BY last_updated")
	fun getProjectByName(name: String): List<Project>

	@Query("SELECT * FROM project ORDER BY last_updated")
	fun getAllProjects(): List<Project>

	@Query("SELECT * FROM project ORDER BY `rowid`")
	fun getAllProjectsById(): List<Project>

	@Query("SELECT * FROM project WHERE `rowid` == :rowid ORDER BY `rowid`")
	fun geProjecttById(rowid: String): List<Project>
}
