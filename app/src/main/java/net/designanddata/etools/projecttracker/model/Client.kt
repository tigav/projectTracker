package net.designanddata.etools.projecttracker.model

import android.arch.persistence.room.*

/*
By default Room uses the class name as the database table name
@Entity(tableName="clients")
@Entity(primaryKeys = arrayOf("FirstName","LastName")

Not a column - @Ignore var picture: Bitmap?
vs.
open class User {
    var picture: Bitmap? = null
}
@Entity(ignoredColumns = arrayOf("picture"))
data class RemoteUser (
    @PrimaryKey var id: Int,
    var hasVpn: Boolean
) : User()

data types - String, Long, Boolean, Int, Date

A data class refers to a class that contains only fields and crude methods for accessing them (getters and setters).
These are simply containers for data used by other classes. These classes do not contain any additional functionality
 and cannot independently operate on the data that they own.
 */
@Entity
data class Client(
	@PrimaryKey(autoGenerate = true) @ColumnInfo(name="rowid") var id: Int,
	@ColumnInfo(name = "first_name") var firstName: String?,
	@ColumnInfo(name = "last_name") var lastName: String?,
    // contacts reference?
	@ColumnInfo(name = "email") var email: String?,
	@ColumnInfo(name = "phone") var phone: String?,
    // business . id
	@ColumnInfo(name = "businesses") var businesses: String?
)
