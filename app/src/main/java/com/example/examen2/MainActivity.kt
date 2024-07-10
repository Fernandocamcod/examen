package com.example.examen2
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declarar las vistas
    private lateinit var numero1: EditText
    private lateinit var numero2: EditText
    private lateinit var resultado: TextView
    private lateinit var botonSuma: Button
    private lateinit var botonResta: Button
    private lateinit var botonMultiplicacion: Button
    private lateinit var botonDivision: Button
    private lateinit var botonModulo: Button

    // Método onCreate se ejecuta al iniciar la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar las vistas
        numero1 = findViewById(R.id.numero1)
        numero2 = findViewById(R.id.numero2)
        resultado = findViewById(R.id.resultado)
        botonSuma = findViewById(R.id.botonsuma)
        botonResta = findViewById(R.id.botonresta)
        botonMultiplicacion = findViewById(R.id.botonmultiplicacion)
        botonDivision = findViewById(R.id.botondivision)
        botonModulo = findViewById(R.id.botonmodulo)

        // Asignar eventos a los botones
        botonSuma.setOnClickListener { realizarOperacion("suma") }
        botonResta.setOnClickListener { realizarOperacion("resta") }
        botonMultiplicacion.setOnClickListener { realizarOperacion("multiplicacion") }
        botonDivision.setOnClickListener { realizarOperacion("division") }
        botonModulo.setOnClickListener { realizarOperacion("modulo") }
    }

    // Método para realizar la operación correspondiente
    private fun realizarOperacion(operacion: String) {
        // Obtener los valores de las entradas
        val strNumero1 = numero1.text.toString()
        val strNumero2 = numero2.text.toString()

        // Validar las entradas
        if (validarEntradas(strNumero1, strNumero2)) {
            // Convertir las entradas a Double
            val num1 = strNumero1.toDouble()
            val num2 = strNumero2.toDouble()

            // Variable para almacenar el resultado
            val resultadoOperacion = when (operacion) {
                "suma" -> sumar(num1, num2)
                "resta" -> restar(num1, num2)
                "multiplicacion" -> multiplicar(num1, num2)
                "division" -> if (num2 != 0.0) dividir(num1, num2) else {
                    // Mostrar mensaje si se intenta dividir entre cero
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT)
                        .show()
                    return
                }
                "modulo" -> if (num2 != 0.0) modulo(num1, num2) else {
                    // Mostrar mensaje si se intenta calcular el módulo con cero
                    Toast.makeText(this, "No se puede calcular el módulo con cero", Toast.LENGTH_SHORT)
                        .show()
                    return
                }
                else -> 0.0
            }

            // Mostrar el resultado en la vista correspondiente
            resultado.text = resultadoOperacion.toString()
        }
    }

    // Método para validar las entradas
    private fun validarEntradas(strNumero1: String, strNumero2: String): Boolean {
        // Verificar si las entradas están vacías
        if (TextUtils.isEmpty(strNumero1) || TextUtils.isEmpty(strNumero2)) {
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Métodos para realizar las operaciones aritméticas
    private fun sumar(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    private fun restar(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    private fun multiplicar(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    private fun dividir(num1: Double, num2: Double): Double {
        return num1 / num2
    }

    private fun modulo(num1: Double, num2: Double): Double {
        return num1 % num2
    }
}