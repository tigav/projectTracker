package net.designanddata.etools.projecttracker.model

import android.arch.persistence.room.*

@Entity class Business(
	@PrimaryKey(autoGenerate = true) @ColumnInfo(name="rowid") var id: Int,
	@ColumnInfo(name = "name") var name: String,
	@ColumnInfo(name = "address") var address: String?,
	@ColumnInfo(name = "town") var town: String?,
	@ColumnInfo(name = "state") var state: String?,
	@ColumnInfo(name = "postcode") var postcode: String?,
	@ColumnInfo(name = "phone") var phone: String?,
	@ColumnInfo(name = "email") var email: String?
)
