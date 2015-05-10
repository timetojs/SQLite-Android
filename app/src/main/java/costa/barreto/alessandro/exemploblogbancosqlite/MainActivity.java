package costa.barreto.alessandro.exemploblogbancosqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import costa.barreto.alessandro.exemploblogbancosqlite.dao.BancoDao;
import costa.barreto.alessandro.exemploblogbancosqlite.domain.Pessoa;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BancoDao bancoDao = new BancoDao(this);

        /* === INSERIRNDO REGISTRO NO BANCO === */
        bancoDao.inserir(new Pessoa("Fulano", 20, "email@gmail.com"));
        bancoDao.inserir(new Pessoa("Super Mario",30,"supermario@email.com"));
        bancoDao.inserir(new Pessoa("Android", 22, "android@android.com"));
        bancoDao.inserir(new Pessoa("Git", 50, "git@git.com"));

        Log.i("TAG", "=== RETORNANDO TODOS OS CONTATOS INSERIDOS ===");

        List<Pessoa> pessoaList = bancoDao.listarPessoas();

        for (Pessoa pessoa: pessoaList){
            String registro = "ID = "+pessoa.get_id()+" Nome: "+pessoa.getNome()+" Idade: "+pessoa.getIdade()+" Email: "+pessoa.getEmail();
            Log.i("TAG","Registros "+registro);
        }

    }

}
