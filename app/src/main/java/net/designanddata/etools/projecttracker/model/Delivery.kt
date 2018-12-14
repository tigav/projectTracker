package net.designanddata.etools.projecttracker.model

import android.arch.persistence.room.*
// Foreign keys: https://gist.github.com/tinmegali/13054e4eeab1f91a8b3992f686fc1024
@Entity(foreignKeys = [
	ForeignKey(
		entity = Project::class,
		parentColumns = arrayOf("rowid"),
		childColumns = arrayOf("project_id"),
		onDelete = ForeignKey.RESTRICT,
		onUpdate = ForeignKey.CASCADE
	)]
)
data class Delivery (
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name="rowid")
	var rowId: Int,

	@ColumnInfo(name="completed")
	var completed: Boolean,

	@ColumnInfo(name="delivered")
	var delivered: Boolean,

	@ColumnInfo(name="project_id")
	var projectId: Int,

	@ColumnInfo(name="notes")
	var notes: String?
)
