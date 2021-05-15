package com.example.android.o

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import com.example.android.o.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener  {

    private val diameter = 100

    // initiate viewBinding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    // create array of Items (Views)
    private var itemsList = arrayListOf<Item>()
    // create array of Items (Views)
    private var itemsViewsList = arrayListOf<ImageView>()
    // create array of Strings
    private val numItems = arrayOf<String?>("1", "2", "3", "4", "5", "6", "7", "8")
    private val nameItems = arrayOf<String?>("Shift", "Force", "Stone", "Sound", "Water", "Fire", "Sunlight", "Spirit")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // select num of items to display
        binding.numItemsSpinner.setOnItemSelectedListener(this)

        // Create the instance of ArrayAdapter
        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, numItems)

        // set simple layout resource file for each item of spinner
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        binding.numItemsSpinner.adapter = ad

        // Right spinning and scaling
        binding.spinRightButton.setOnClickListener {
            spin_right()
        }

        // Left spinning and scaling
        binding.spinRightButton.setOnClickListener {
            spin_left()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        // Make toastof which number of Items to display
        Toast.makeText(applicationContext, nameItems[position], Toast.LENGTH_LONG).show()

        // Clear Items
        clearViews()

        // Display new Items accordingly
        for (i in 0 until position+1) {
            addNewItem(position)
        }

        // Position Items accordingly
        initial_position(position)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    private fun addNewItem(position : Int) {

        // Create a new Item's view
        val inflater = LayoutInflater.from(this).inflate(R.layout.item, null)
        binding.itemsLayout.addView(inflater, binding.itemsLayout.childCount)

        val img: ImageView = inflater.findViewById<ImageView>(R.id.imageView)

        when(position){
            0->img.setImageResource(R.drawable.shift)
            1->img.setImageResource(R.drawable.force)
            2->img.setImageResource(R.drawable.stone)
            3->img.setImageResource(R.drawable.sound)
            4->img.setImageResource(R.drawable.water)
            5->img.setImageResource(R.drawable.fire)
            6->img.setImageResource(R.drawable.sunlight)
            7->img.setImageResource(R.drawable.spirit)
        }
        // Store in itemsViewsList
        itemsViewsList.add(img)

        // Create a new Item
        val item = Item()
        when(position){
            0->item.name = getString(R.string.shift)
            1->item.name = getString(R.string.force)
            2->item.name = getString(R.string.stone)
            3->item.name = getString(R.string.sound)
            4->item.name = getString(R.string.water)
            5->item.name = getString(R.string.fire)
            6->item.name = getString(R.string.sunlight)
            7->item.name = getString(R.string.spirit)
        }
        // Store in itemsList
        itemsList.add(item)
    }

    private fun clearViews() {
        itemsViewsList.clear()
        itemsList.clear()
        binding.itemsLayout.removeAllViews()
    }

    private fun initial_position(numItems : Int) {
        when (numItems) {
            // Only one item
            //0 -> itemsViewsList.get(0).(diameter/2)

            // Two items 180° spaced

            // Three

            // Four items 90° spaced

            // Five

            // Six

            // Seven

            // Eight (Alpha Version Menu)

        }
    }

    private fun spin_right() {
        ObjectAnimator.ofFloat(itemsList[0], "translationX", 500f).apply {
            duration = 2000
            start()
        }


    }

    private fun spin_left() {


    }

}