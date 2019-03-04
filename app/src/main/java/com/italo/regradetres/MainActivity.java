package com.italo.regradetres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultado, dica;
    private EditText valor1, valor2, quantidade1, quantidade2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        valor1 = findViewById(R.id.valor1);
        valor2 = findViewById(R.id.valor2);
        quantidade1 = findViewById(R.id.quantidade1);
        quantidade2 = findViewById(R.id.quantidade2);
        resultado = findViewById(R.id.resultado_txt);
        dica = findViewById(R.id.dica_txt);
    }

    public void onCalcular(View view) {
        float compare1, compare2, fValor1, fValor2, fQuantidade1, fQuantidade2;
        if (valor1.getText().toString().isEmpty()) {
            fValor1 = 0;
        } else {
            fValor1 = Float.parseFloat(valor1.getText().toString());
        }

        if (valor2.getText().toString().isEmpty()) {
            fValor2 = 0;
        } else {
            fValor2 = Float.parseFloat(valor2.getText().toString());
        }

        if (quantidade1.getText().toString().isEmpty()) {
            fQuantidade1 = 0;
        } else {
            fQuantidade1 = Float.parseFloat(quantidade1.getText().toString());
        }

        if (quantidade2.getText().toString().isEmpty()) {
            fQuantidade2 = 0;
        } else {
            fQuantidade2 = Float.parseFloat(quantidade2.getText().toString());
        }


        compare1 = fValor1 * fQuantidade2;
        compare2 = fValor2 * fQuantidade1;

        Float valor1menor = compare1 / fQuantidade1;
        Float valor2menor = compare2 / fQuantidade2;




        if (compare1 > compare2) {
            //produto 2 e barato
            resultado.setText(getResources().getString(R.string.o_produto_x_e_mais_barato, "2"));
            resultado.setVisibility(View.VISIBLE);
            dica.setText(getResources().getString(R.string.apenas_compre_o_produto_x_caso_o_valor_seja_abaixo_de, "1", String.valueOf(valor2menor)));
            dica.setVisibility(View.VISIBLE);
        } else if (compare1 < compare2) {
            //produto 1 e barato
            resultado.setText(getResources().getString(R.string.o_produto_x_e_mais_barato, "1"));
            resultado.setVisibility(View.VISIBLE);
            dica.setText(getResources().getString(R.string.apenas_compre_o_produto_x_caso_o_valor_seja_abaixo_de, "2", String.valueOf(valor1menor)));
            dica.setVisibility(View.VISIBLE);
        } else {
            //mesmo preco
            resultado.setText(getResources().getString(R.string.os_produtos_tem_preco_igual));
            resultado.setVisibility(View.VISIBLE);
            dica.setVisibility(View.INVISIBLE);
        }

    }
}
