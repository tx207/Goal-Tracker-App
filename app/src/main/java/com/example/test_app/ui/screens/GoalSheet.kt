package com.example.test_app.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.test_app.R
import com.example.test_app.data.model.DataGoalInfo
import com.example.test_app.data.model.DataState
import com.example.test_app.data.model.goalList
import com.example.test_app.data.model.totalGoals
import com.example.test_app.data.repository.AddDone
import com.example.test_app.data.repository.AddMoney
import com.example.test_app.data.repository.AddName

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalSheet() {

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
        confirmValueChange = {newValue -> newValue != SheetValue.Expanded}
    )

    var currentGoal by remember { mutableStateOf(DataGoalInfo("", R.drawable.ic_goal, 0, 0))}
    var pageNow by remember { mutableStateOf(0) }

    if (DataState.AddGoalSheetState) {
        ModalBottomSheet(
            onDismissRequest = { DataState.AddGoalSheetState = false },
            sheetState = sheetState,
        ) {
            ChangeAddPage(
                pageNow = pageNow,
                currentGoal,
                changeStep = {updatedGoal, updatedPage ->
                    currentGoal = updatedGoal
                    pageNow = updatedPage
                }
            )
        }
    }
}

@Composable
fun ChangeAddPage(pageNow: Int , currentGoal: DataGoalInfo, changeStep: (DataGoalInfo, Int) -> Unit) {
    when (pageNow) {
        0 -> AddName(currentGoal, pageNow, changeStep)
        1 -> AddMoney(currentGoal, pageNow, changeStep)
        2 -> AddDone(currentGoal, pageNow ,changeStep)
        3 -> {
            totalGoals++
            goalList.add(currentGoal)
            DataState.AddGoalSheetState = false
            changeStep(DataGoalInfo("", R.drawable.ic_goal, 0, 0), 0)
        }
    }
}



