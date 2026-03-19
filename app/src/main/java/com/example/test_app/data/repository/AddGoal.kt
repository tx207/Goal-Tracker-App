package com.example.test_app.data.repository

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_app.R
import com.example.test_app.data.model.DataGoalInfo


@Composable
fun AddName(currentGoal: DataGoalInfo, pageNow: Int ,changeStep: (DataGoalInfo, Int) -> Unit) {

    var newName by remember { mutableStateOf(currentGoal.name) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color(0xFFFDC3A1))
                .padding(6.dp),
        ) {
            Text(
                text = "Add Goal",
                modifier = Modifier,
                fontSize = 30.sp
            )
            Image(
                painterResource(id = R.drawable.ic_goal),
                contentDescription = "goal",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(30.dp)
            )
        }

        OutlinedTextField(
            value = newName,
            onValueChange = {text -> newName = text },
            label = { Text("Goal Name") },
            modifier = Modifier
        )

        Button(
            modifier = Modifier
                .background(color = Color(0xFFFDC3A1)),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                val updatedName = currentGoal.copy(name = newName)
                val updatedPage = pageNow + 1
                changeStep(updatedName, updatedPage)
            }
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun AddMoney(currentGoal: DataGoalInfo, pageNow: Int, changeStep: (DataGoalInfo, Int) -> Unit) {

    var nowMoney by remember { mutableStateOf(currentGoal.nowMoney.toString()) }
    if (nowMoney == "0") nowMoney =""
    var goalMoney by remember { mutableStateOf(currentGoal.goalMoney.toString()) }
    if (goalMoney == "0") goalMoney =""

    OutlinedTextField(
        value = nowMoney,
        onValueChange = {text -> nowMoney = text },
        label = { Text("Now Money") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    OutlinedTextField(
        value = goalMoney,
        onValueChange = {text -> goalMoney = text },
        label = { Text("Goal Money") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )

    var InputValid = nowMoney.isNotEmpty() and goalMoney.isNotEmpty()

    Button(
        modifier = Modifier
            .background(color = Color(0xFFFDC3A1)),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            val updatedMoney = currentGoal.copy(nowMoney = nowMoney.toInt(), goalMoney = goalMoney.toInt())
            val updatedPage = pageNow + 1
            changeStep(updatedMoney, updatedPage)
        },
        enabled = InputValid
    ) {
        Text(text = "Next")
    }
}



@Composable
fun AddDone(currentGoal: DataGoalInfo, pageNow: Int, changeStep: (DataGoalInfo, Int) -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxHeight(0.7f)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {

        //Back
        Button(
            modifier = Modifier
                .background(color = Color(0xFFFDC3A1))
                .align(Alignment.CenterStart),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                val updatedPage = pageNow - 1
                changeStep(currentGoal, updatedPage)
            }
        ) {
            Text(text = "Back")
        }

        //Done
        Button(
            modifier = Modifier
                .background(color = Color(0xFFFDC3A1))
                .align(Alignment.CenterEnd),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                val updatedPage = pageNow + 1
                changeStep(currentGoal, updatedPage)
            }
        ) {
            Text(text = "Done")
        }
    }
}

