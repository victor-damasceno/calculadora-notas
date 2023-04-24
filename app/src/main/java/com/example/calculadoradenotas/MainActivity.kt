package com.example.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IntegerRes
import com.example.calculadoradenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Após utilizar o viewBinding para poder recuperar o ID dos componentes, criei uma variável
        //para o botão de calcular e implementei uma ação a partir do momento em que ele for clicado.

        val calculo = binding.btCalcular
        calculo.setOnClickListener {

            // As variáveis abaixo possuem estão capturando os a campos serão preenchidos pelo usuário.

            val num1 = binding.nota1
            val num2 = binding.nota2
            val num3 = binding.nota3
            val num4 = binding.nota4
            val faltas = binding.faltas
            val resultado = binding.txtResultado

            //Como a entrada de dados vem, por padrão, como String, abaixo criei variáveis em que,
            //dentro delas, vai converter o tipo String para Números Inteiros.

            val nota1 = Integer.parseInt(num1.text.toString())
            val nota2 = Integer.parseInt(num2.text.toString())
            val nota3 = Integer.parseInt(num3.text.toString())
            val nota4 = Integer.parseInt(num4.text.toString())
            val numeroFaltas = Integer.parseInt(faltas.text.toString())

            //Para saber a média, basta pegar as notas e dividir pelo número de elementos desse conjunto, que no caso é 4.

            val media = (nota1 + nota2 + nota3 + nota4) /4

            //Aqui está o processamento e a saída de dados. Para o aluno passar, a média precisa ser igual a 5 ou acima disso.
            //Caso contrário será reprovado. Além da média, ele precisa ter um número de faltas menor ou igual a 20. Do contrário, ele será reprovado também.

            if(media >=5 && numeroFaltas <=20) {
                resultado.setText("Aluno foi aprovado! \n Média final: $media")
                resultado.setTextColor(getColor(R.color.green))

            }else if (media <5 && numeroFaltas >20) {
                resultado.setText("Aluno foi reprovado por nota e por falta. \n Média final: $media")
                resultado.setTextColor(getColor(R.color.red))

            }else if (media <5) {
                resultado.setText("Aluno foi reprovado por nota. \n Média final: $media")
                resultado.setTextColor(getColor(R.color.red))

            }else if (numeroFaltas >20) {
                resultado.setText("Aluno foi reprovado por falta. \n Média final: $media")
                resultado.setTextColor(getColor(R.color.red))

            }
        }

    }
}