package br.edu.ifsp.scl.ads.pdm.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textName;
    private EditText textTel;
    private EditText textEmail;
    private CheckBox checkBox;
    private RadioButton radioMasc, radioFem;
    private EditText textCidade;
    private Spinner opcoesUf;
    private Button buttonSalvar;
    private Button buttonLimpar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.textName);
        textTel = findViewById(R.id.textTel);
        textEmail = findViewById(R.id.textEmail);
        checkBox = findViewById(R.id.checkBox);
        radioMasc = findViewById(R.id.radioMasc);
        radioFem = findViewById(R.id.radioFem);
        textCidade = findViewById(R.id.textCidade);
        opcoesUf = findViewById(R.id.opcoesUf);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonLimpar = findViewById(R.id.buttonLimpar);

        checkBox.setChecked(true);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Formulario form = new Formulario();
                form.setNome(textName.getText().toString());
                form.setTelefone(textTel.getText().toString());
                form.setEmail(textEmail.getText().toString());
                form.setIngressar(checkBox.isChecked()? (String) checkBox.getText() : "Não recebe informações pelo e-mail!");
                form.setSexo(radioMasc.isChecked()? (String) radioMasc.getText() : (String) radioFem.getText());
                form.setCidade(textCidade.getText().toString());
                form.setUf((String) ((TextView)opcoesUf.getSelectedView()).getText());


                Toast.makeText(MainActivity.this, form.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textName.setText("");
                textTel.setText("");
                textEmail.setText("");
                checkBox.setChecked(false);
                textCidade.setText("");

                textName.requestFocus();



                Toast.makeText(MainActivity.this, "Você limpou o  formulário!", Toast.LENGTH_SHORT).show();




            }
        });




    }
}