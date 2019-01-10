package net.designanddata.etools.projecttracker.model
// https://developer.android.com/training/data-storage/room/#kotlin

import android.arch.persistence.room.*
import android.content.Context

// option: exportSchema = false to skip schema checks

@Database(entities = [Client::class, Business::class, WorkHour::class,Payment::class,Delivery::class,Invoice::class,Project::class],
	version = 1)
@TypeConverters(ProjectTrackerConverters::class)
abstract class ProjectTrackerDatabase : RoomDatabase() {
	abstract fun projectTrackerDao(): ProjectTrackerDao

	companion object {
		@Volatile // still not sure on when I should use this...
		private var INSTANCE: ProjectTrackerDatabase? = null

		// public static
		fun getInstance(context: Context): ProjectTrackerDatabase? {
			return INSTANCE ?: synchronized(this) {
				// build
				INSTANCE = Room.databaseBuilder(
					context.applicationContext,
					ProjectTrackerDatabase::class.java,
					"db")
					.build()
				// Init
				INSTANCE
			}
		}
		// close database connection and free persistent instance.
		// Not used:: fun destroyInstance() {INSTANCE = null
	}
}
