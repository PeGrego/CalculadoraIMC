package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val classificacao: String = if (result <= 18.5f) { tvClassificacao.setTextColor(ContextCompat.getColor(this,R.color.MAGREZA))
            "MAGREZA"
        } else if (result > 18.5f && result <= 24.99f) { tvClassificacao.setTextColor(ContextCompat.getColor(this,R.color.NORMAL))
            "NORMAL"
        } else if (result > 25f && result <= 29.99f) { tvClassificacao.setTextColor(ContextCompat.getColor(this,R.color.SOBREPESO))
            "SOBREPESO"
        } else if (result > 30f && result <= 39.9f) { tvClassificacao.setTextColor(ContextCompat.getColor(this,R.color.OBESIDADE))
            "OBESIDADE"
        } else { tvClassificacao.setTextColor(ContextCompat.getColor(this,R.color.OBESIDADE_GRAVE))
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = classificacao

    }
}
