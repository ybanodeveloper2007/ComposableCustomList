package com.example.invisiademoapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.invisiademoapplication.ui.theme.InvisiaDemoApplicationTheme
import com.example.invisiademoapplication.ui.theme.greenColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvisiaDemoApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                     Scaffold(
                        topBar = {
                            TopAppBar(backgroundColor = greenColor,
                                title = {
                                    Text(
                                         text = "Employee List",
                                         modifier = Modifier.fillMaxWidth(),
                                         textAlign = TextAlign.Center,
                                         color = Color.White
                                    )
                                }
                            )
                        }
                    ) {
                        customListView(LocalContext.current)
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun customListView(context: Context) {
    lateinit var empList: List<Person>
    empList = ArrayList<Person>()

    empList = empList + Person("Abhinash",123, R.drawable.man_png)
    empList = empList + Person("Jiya",124, R.drawable.woman_png)
    empList = empList + Person("Pooja",125, R.drawable.woman_png)
    empList = empList + Person("Vineet", 126,R.drawable.man_png)
    empList = empList + Person("Rocky", 127,R.drawable.man_png)
    empList = empList + Person("Riya",128, R.drawable.woman_png)
    empList = empList + Person("Sam",129, R.drawable.man_png)
    empList = empList + Person("Manisha",131, R.drawable.woman_png)
    empList = empList + Person("Deepti",134, R.drawable.woman_png)
    empList = empList + Person("Shagun",136, R.drawable.woman_png)
    empList = empList + Person("Abhishek",147, R.drawable.man_png)
    empList = empList + Person("Akansha", 145,R.drawable.woman_png)
    empList = empList + Person("Ritesh",167, R.drawable.man_png)
    empList = empList + Person("Imran",187, R.drawable.man_png)

   LazyColumn {
        itemsIndexed(empList) { index, item ->
            Card(
                onClick = {
                    Toast.makeText(
                        context,
                        empList[index].Name + " selected..",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier.padding(8.dp),

                elevation = 6.dp
            )
            {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.width(5.dp))

                    Image(
                        painter = painterResource(id = empList[index].empImg),

                        contentDescription = "Javascript",

                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .padding(5.dp, top = 10.dp)

                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {

                        Text(
                            text = empList[index].Name,
                            modifier = Modifier.padding(4.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black, textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Text(

                            text = "Employee Code : "+empList[index].empCode.toString(),
                            modifier = Modifier.padding(4.dp),
                            color = Color.Black, textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InvisiaDemoApplicationTheme {
        customListView(context = LocalContext.current )
    }
}