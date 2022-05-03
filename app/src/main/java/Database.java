import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context) {
        super(context, "fitness.sqlite",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS \"BodySection\" (\n" +
                "\t\"bodysection_id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"bodysection_name\"\tTEXT,\n" +
                "\t\"bodysection_image\"\tBLOB\n" +
                ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Bodysection");
        onCreate(sqLiteDatabase);

    }
}
