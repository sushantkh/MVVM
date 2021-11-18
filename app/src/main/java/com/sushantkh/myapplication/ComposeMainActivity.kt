package com.sushantkh.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sushantkh.model.Data

class ComposeMainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier
                .background(Color.White)
                .padding(8.dp)) {
                PostList()
            }

        }
    }

    @Composable
    fun PostList(model: MainViewModel = viewModel()) {
        model.getRemoteData()
        val remoteData by model.posts.observeAsState()
        LazyColumn()
        {
            if (remoteData!=null)
            {
                items(remoteData!!.data) { post ->
                    TextMessage(data = post)
                }
            }
        }
    }

    @Composable
    fun TextMessage(data: Data) {
        Card(modifier = Modifier.border(1.dp, Color.Black)
            .padding(5.dp))
        {
            Column {
                Text(text = data.title,)
                Text(text = data.body)
            }
        }

    }
}