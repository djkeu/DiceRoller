package nl.djkeu.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
     * Roll a dice, update the screen
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

        when (diceRoll) {
            1 -> diceImage.setImageResource((R.drawable.dice_1))
            2 -> diceImage.setImageResource((R.drawable.dice_2))
            3 -> diceImage.setImageResource((R.drawable.dice_3))
            4 -> diceImage.setImageResource((R.drawable.dice_4))
            5 -> diceImage.setImageResource((R.drawable.dice_5))
            6 -> diceImage.setImageResource((R.drawable.dice_6))
        }

    }
}

/**
 * Model a dice
 */
class Dice(private val numSides: Int) {

    // Return a random number
    fun roll(): Int {
        return (1..numSides).random()
    }
}
