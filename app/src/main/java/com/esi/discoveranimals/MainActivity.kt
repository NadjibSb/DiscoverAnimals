package com.esi.discoveranimals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var animals = mutableListOf(
            Animal("Cow","http://clipart-library.com/images/gTeEkLXxc.png","https://freeanimalsounds.org/wp-content/uploads/2017/07/Rinder_muh.mp3"),
            Animal("Sheep","https://i.pinimg.com/originals/6a/a5/94/6aa5940c04905952bc7d6cd61b5cd4e1.jpg","https://freeanimalsounds.org/wp-content/uploads/2017/07/schafe.mp3"),
            Animal("Checken","https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Chicken_cartoon_04.svg/723px-Chicken_cartoon_04.svg.png","https://freeanimalsounds.org/wp-content/uploads/2017/07/huehner.mp3"),
            Animal("Dog","https://image.freepik.com/free-vector/happy-dog-cartoon_49499-511.jpg","https://freeanimalsounds.org/wp-content/uploads/2017/07/Bluthund_jault.mp3"),
            Animal("Horse","https://image.freepik.com/free-vector/cute-horse-cartoon_50699-40.jpg","https://freeanimalsounds.org/wp-content/uploads/2017/07/Pony.mp3"),
            Animal("Goat","https://previews.123rf.com/images/dualororua/dualororua1605/dualororua160500016/56379057-cartoon-goat-character.jpg","https://freeanimalsounds.org/wp-content/uploads/2017/07/Ziege.mp3"),
            Animal("Rooster","https://previews.123rf.com/images/sararoom/sararoom1611/sararoom161100017/66380112-vector-illustration-of-cartoon-rooster.jpg","https://freeanimalsounds.org/wp-content/uploads/2017/07/hahn_kikeriki.mp3"),
            Animal("Cat","https://img.pixers.pics/pho_wat(s3:700/FO/62/94/93/06/700_FO62949306_020b07b16b048d353b453df499d34053.jpg,492,700,cms:2018/10/5bd1b6b8d04b8_220x50-watermark.png,over,272,650,jpg)/wall-murals-funny-cat-cartoon.jpg.jpg","https://freeanimalsounds.org/wp-content/uploads/2017/07/Katze_miaut.mp3"),
            Animal("Duck","https://img.freepik.com/free-vector/funny-cartoon-duck-swimming_50699-281.jpg?size=626&ext=jpg","https://freeanimalsounds.org/wp-content/uploads/2017/07/Ente_quackt.mp3"),
            Animal("Elephant","https://image.shutterstock.com/image-vector/cartoon-cute-baby-elephant-sitting-260nw-710514844.jpg","https://freeanimalsounds.org/wp-content/uploads/2017/07/Elefant.mp3"),
            Animal("Wolf","https://image.shutterstock.com/image-vector/cheerful-wolf-on-white-background-260nw-164927918.jpg","https://freeanimalsounds.org/wp-content/uploads/2017/07/wolf.mp3"),
            Animal("Bird","https://image.shutterstock.com/image-vector/cute-blue-bird-cartoon-260nw-475041247.jpg","https://freeanimalsounds.org/wp-content/uploads/2017/07/Steller_Jay.mp3")
        )

        setupRecycleView(animals)

    }


    private fun setupRecycleView(list: List<Animal>) {
        var recycleView = this.findViewById<RecyclerView>(R.id.recycleView)
        var adapter = ImageAdapter(list)
        recycleView.adapter = adapter
        recycleView.layoutManager = GridLayoutManager(applicationContext,2)
        recycleView.setHasFixedSize(true)
    }
}
