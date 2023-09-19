package com.cookandroid.calculator_ex

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import com.cookandroid.calculator_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var firstValue: Double = 0.0
    private var secondValue: Double = 0.0
    private var currentOperator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 숫자 버튼들에 대한 클릭 리스너 설정
        val numberButtons = arrayOf(
            binding.Btn0, binding.Btn1, binding.Btn2, binding.Btn3, binding.Btn4,
            binding.Btn5, binding.Btn6, binding.Btn7, binding.Btn8, binding.Btn9
        )

        for (button in numberButtons) {
            button.setOnClickListener { onNumberClick(button) }
        }

        // 연산자 버튼들에 대한 클릭 리스너 설정
        val operatorButtons = arrayOf(binding.BtnAdd, binding.BtnMinus, binding.BtnMultiple, binding.BtnDivide)

        for (operatorButton in operatorButtons) {
            operatorButton.setOnClickListener { onOperatorClick(operatorButton) }
        }

        // 등호와 C(클리어) 버튼에 대한 클릭 리스너 설정
        binding.BtnResult.setOnClickListener { onResultClick() }
        binding.BtnRetry.setOnClickListener { onRetryClick() }
    }

    // 숫자 버튼 클릭 이벤트 처리
    private fun onNumberClick(button: Button) {
        val number = button.text.toString()
        val currentText = binding.Text1.text.toString()

        if (currentText == "0" || currentText == "ERROR") {
            binding.Text1.text = number
        } else {
            binding.Text1.append(number)
        }
    }

    // 연산자 버튼 클릭 이벤트 처리
    private fun onOperatorClick(operatorButton: Button) {
        val operator = operatorButton.text.toString()

        if (currentOperator != null) {
            // 이미 연산자가 선택된 경우 이전 연산을 수행하고 결과를 표시
            onResultClick()
        }

        val currentText = binding.Text1.text.toString()
        if (currentText.isNotEmpty()) {
            firstValue = currentText.toDouble()
            currentOperator = operator
            binding.TextProcess.text = "$firstValue $currentOperator "
            binding.Text1.text = ""
        }
    }

    // 등호 버튼 클릭 이벤트 처리
    private fun onResultClick() {
        val currentText = binding.Text1.text.toString()

        if (currentText.isNotEmpty()) {
            try {
                secondValue = currentText.toDouble()
                var result = 0.0

                when (currentOperator) {
                    "+" -> result = firstValue + secondValue
                    "-" -> result = firstValue - secondValue
                    "x" -> result = firstValue * secondValue
                    "/" -> {
                        if (secondValue != 0.0) {
                            result = firstValue / secondValue
                        } else {
                            binding.Text1.text = "ERROR"
                            binding.TextResult.text = "RESULT : "+"0으로 나눌 수 없음"
                            binding.TextResult.visibility = View.VISIBLE
                            return
                        }
                    }
                }

                binding.Text1.text = "$result"
                binding.TextResult.text = "RESULT : $result"
                binding.TextResult.visibility = View.VISIBLE
                binding.TextProcess.text = "PROCESS : $firstValue $currentOperator $secondValue"
                binding.TextProcess.visibility = View.VISIBLE
                currentOperator = null
            } catch (e: NumberFormatException) {
                binding.Text1.text = "ERROR"
            }
        }
    }

    // 클리어 버튼 클릭 이벤트 처리
    private fun onRetryClick() {
        binding.Text1.text = "0"
        binding.TextProcess.text = ""
        currentOperator = null
        binding.TextResult.visibility = View.INVISIBLE
        binding.TextProcess.visibility = View.INVISIBLE
    }

    // 키보드 숨기기 함수
    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}