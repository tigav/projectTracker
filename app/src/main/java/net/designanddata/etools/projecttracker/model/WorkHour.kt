package net.designanddata.etools.projecttracker.model

import android.arch.persistence.room.*

@Entity
data class WorkHour (
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name="rowid")
	var rowid: Int,

	@ColumnInfo(name="project")
	var project: Int,

	@ColumnInfo(name="hours_spent")
	var hours: String?,

	@ColumnInfo(name="notes")
	var notes: String?
)
