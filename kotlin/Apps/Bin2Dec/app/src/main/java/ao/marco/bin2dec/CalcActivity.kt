package ao.marco.bin2dec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ao.marco.bin2dec.databinding.ActivityCalcBinding
import ao.marco.bin2dec.databinding.ActivityMainBinding
import ao.marco.bin2dec.resources.Calculator

class CalcActivity : AppCompatActivity() {

    lateinit var binding: ActivityCalcBinding
    private var instructions: String = ""
    var binaryRegex = Regex("^[1,0]+")
    var numberRegex = Regex("^[0-9]+")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalcBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //This will initialize the Calculator Resource
        var calc: Calculator = Calculator()

        //This will set the instruction text above the fields
        instructions = "Instruções:\n"
        instructions += "- Insira um Binário ou Decimal que deseja converter\n"
        instructions += "- Clique no botão para converter\n"
        instructions += "- Aguarde o resultado no campo abaixo\n"
        binding.textView.text = instructions

        binding.materialButton.setOnClickListener {
            //This will confirm that the field isn't empty when click
            if(binding.materialNumberField.text?.isEmpty()!!){
                binding.materialNumberLayout.error = "Por favor insira um número"
            }else{
                binding.materialNumberLayout.error = null
                if(numberRegex.matches(binding.materialNumberField.text!!)){
                    if(binaryRegex.matches(binding.materialNumberField.text!!)){
                        binding.materialResultField.setText(calc.binary(Integer.parseInt(binding.materialNumberField.text!!.toString())).toString())
                    }else{
                        binding.materialResultField.setText(calc.decimal(Integer.parseInt(binding.materialNumberField.text!!.toString())).toString())
                    }
                }else{
                    binding.materialNumberLayout.error = "Apenas números são aceites"
                }
            }
        }
    }
}