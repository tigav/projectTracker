package net.designanddata.etools.projecttracker.model

import android.arch.persistence.room.*
// import java.sql.Blob
// https://stackoverflow.com/questions/46337519/how-insert-image-in-room-persistence-library/46356934
// blob not recommended

@Entity(indices = [Index(value = ["project_id"])],
	foreignKeys = [
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

	@ColumnInfo(name = "filepath")
	var file: String
)

