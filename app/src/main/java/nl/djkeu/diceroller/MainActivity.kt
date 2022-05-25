package nl.djkeu.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Click a button to roll a dice and view the results
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Make the button respond to click
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll a dice
     */
    private fun rollDice() {
        // Create a six-side dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Show the result of the roll on screen
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

/**
 * Model a dice
 */
class Dice(private val numSides: Int) {

    // Return a random number
    fun roll(): Int {
        return(1..numSides).random()
    }
}
