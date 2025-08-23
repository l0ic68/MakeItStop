import androidx.room.Embedded
import androidx.room.Relation
import com.nesta.makeitstop.addiction.data.Addiction
import com.nesta.makeitstop.addiction.data.DailyRecord

data class AddictionWithDailyRecords(
    @Embedded val addiction: Addiction,
    @Relation(
        parentColumn = "id",
        entityColumn = "addictionId"
    )
    val dailyRecords: List<DailyRecord>
)
