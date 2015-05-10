package costa.barreto.alessandro.exemploblogbancosqlite.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alessandro on 09/05/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Versao do Banco
    private static final int BANCO_VERSAO = 1;

    // Nome do Banco
    private static final String BANCO_NOME = "exemploblog";

    public DatabaseHelper(Context context) {
        super(context, BANCO_NOME, null, BANCO_VERSAO);
    }

    public static class Pessoa_BANCO{
        public static final String TABELA = "pessoa";
        public static final String ID = "_id";
        public static final String NOME = "nome";
        public static final String IDADE = "idade";
        public static final String EMAIL = "email";
        public final static String[] COLUNAS = new String[]{TABELA,ID,NOME,IDADE,EMAIL};
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = String.format("CREATE TABLE %s (\n" +
                "\t%s\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t%s\tTEXT,\n" +
                "\t%s\tINTEGER,\n" +
                "\t%s\tTEXT\n" +
                ");",Pessoa_BANCO.TABELA,Pessoa_BANCO.ID,Pessoa_BANCO.NOME,Pessoa_BANCO.IDADE,Pessoa_BANCO.EMAIL);

        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
