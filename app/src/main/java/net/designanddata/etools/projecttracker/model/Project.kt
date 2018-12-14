package net.designanddata.etools.projecttracker.model

import android.arch.persistence.room.*
import java.util.*

@Entity
class Project (
	@PrimaryKey(autoGenerate = true) @ColumnInfo(name="rowid") var id: Int,
	@ColumnInfo(name="name") var name: String,
	@ColumnInfo(name = "last_updated") var lastUpdated: Date
)
