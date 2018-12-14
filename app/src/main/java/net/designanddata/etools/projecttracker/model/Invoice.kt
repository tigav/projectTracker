package net.designanddata.etools.projecttracker.model

import android.arch.persistence.room.*
import java.sql.Blob

@Entity(foreignKeys = [
	ForeignKey(
		entity = Project::class,
		parentColumns = arrayOf("rowid"),
		childColumns = arrayOf("project_id"),
		onDelete = ForeignKey.RESTRICT,
		onUpdate = ForeignKey.CASCADE
	)])
data class Invoice (
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name="rowid")
	var rowid: Int,

	@ColumnInfo(name = "project_id")
	var projectId: Int?,

	@ColumnInfo(name = "paid")
	var paid: Boolean,

	@ColumnInfo(name = "file")
	var file: Blob
)

