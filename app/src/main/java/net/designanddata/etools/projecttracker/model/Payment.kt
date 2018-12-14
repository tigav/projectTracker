package net.designanddata.etools.projecttracker.model

import android.arch.persistence.room.*
import java.util.*

@Entity
data class Payment (
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name="rowid")
	var rowid: Int,

	@ColumnInfo(name="amount")
	var amount: String,

	@ColumnInfo(name="client")
	var client: String,

	@ColumnInfo(name="date")
	var date: Date?,

	@ColumnInfo(name="note")
	var note: String?
)
