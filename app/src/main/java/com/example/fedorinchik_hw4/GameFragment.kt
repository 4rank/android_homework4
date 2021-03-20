package com.example.fedorinchik_hw4

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.*
import kotlin.random.Random

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GameFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var viewColor: View? = null
    private var textPoints: TextView? = null
    private var gameButtonLeft: Button? = null
    private var gameButtonRight: Button? = null
    private var result = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onStart() {
        super.onStart()
        setViewColor()
    }

    private fun setViewColor() {
        viewColor = view?.findViewById(R.id.frag_game)
        val randomColor = randomHexColor()
        viewColor?.setBackgroundColor(randomColor)
        var hexLine: String = Integer.toHexString(randomColor)
        hexLine = hexLine.replaceFirst("ff", "#").toUpperCase(Locale.ROOT)
        startGame(hexLine)
    }

    private fun randomHexColor(): Int {
        val red = Random.nextInt()
        val green = Random.nextInt()
        val blue = Random.nextInt()
        return Color.rgb(red, green, blue)
    }

    private fun startGame(trueAnswer: String) {
        gameButtonLeft = view?.findViewById(R.id.button_game_left)
        gameButtonRight = view?.findViewById(R.id.button_game_right)
        textPoints = view?.findViewById(R.id.game_points)
        textPoints?.text = result.toString()
        val randomAnswer = (0 until 3).random()
        val colorElse = randomHexColor()
        val falseAnswer: String = Integer.toHexString(colorElse)
            .toUpperCase(Locale.ROOT)
        if (randomAnswer == 1) {
            gameButtonLeft?.text = trueAnswer
            gameButtonRight?.text = falseAnswer
        } else {
            gameButtonLeft?.text = falseAnswer
            gameButtonRight?.text = trueAnswer
        }
        gameButtonLeft?.setOnClickListener {
            answerCounter(gameButtonLeft as Button, trueAnswer)
        }
        gameButtonRight?.setOnClickListener {
            answerCounter(gameButtonRight as Button, trueAnswer)
        }
    }

    private fun answerCounter(button: Button, trueHex: String) {
        if (button.text == trueHex) {
            result++
        }
        else {
            result--
        }
        setViewColor()
    }

}