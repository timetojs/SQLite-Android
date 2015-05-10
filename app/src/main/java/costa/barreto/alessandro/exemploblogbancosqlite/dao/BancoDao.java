package costa.barreto.alessandro.exemploblogbancosqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import costa.barreto.alessandro.exemploblogbancosqlite.domain.Pessoa;

/**
 * Created by Alessandro on 09/05/2015.
 */
public class BancoDao {
    private final DatabaseHelper helper;
    private Context context;
    private SQLiteDatabase db;

    public BancoDao(Context context) {
        this.context = context;
        helper = new DatabaseHelper(context);
    }

    public Long inserir(Pessoa pessoa){
        ContentValues values = new ContentValues();
        if (pessoa.getNome() != null)
            values.put(DatabaseHelper.Pessoa_BANCO.NOME,pessoa.getNome());
        if (pessoa.getIdade() != 0)
            values.put(DatabaseHelper.Pessoa_BANCO.IDADE,pessoa.getIdade());
        if (pessoa.getEmail() != null)
            values.put(DatabaseHelper.Pessoa_BANCO.EMAIL,pessoa.getEmail());
        return getDb().insert(DatabaseHelper.Pessoa_BANCO.TABELA,null,values);

    }

    public List<Pessoa> listarPessoas(){
        List<Pessoa> list = new ArrayList<>();

        Cursor cursor = getDb().rawQuery("SELECT * FROM pessoa",null);

        while(cursor.moveToNext()){
            Pessoa pessoa = criarPessoa(cursor);
            list.add(pessoa);
        }

        return list;

    }

    private Pessoa criarPessoa(Cursor cursor){
        return new Pessoa(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Pessoa_BANCO.ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Pessoa_BANCO.NOME)),
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Pessoa_BANCO.IDADE)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Pessoa_BANCO.EMAIL)));
    }

    // Obter o Banco de Dados.
    private SQLiteDatabase getDb(){

        try {
            if(db == null)
                restart();

            return db;
        } catch (SQLException e) {
            Log.i("TAG", "Ocorreu um erro ao abrir o database " + e.getLocalizedMessage());
            e.printStackTrace();
            restart();
            return db;
        }
    }

    private void restart(){
        db = helper.getWritableDatabase();
    }

    public void close(){
        helper.close();
    }

}
