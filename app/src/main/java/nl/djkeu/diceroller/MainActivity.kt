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

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice, update the screen
     */
    private fun rollDice() {
        // Create and roll a six sided dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the imageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which dice image to use according to dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the imageView with the correct drawalbe resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
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
