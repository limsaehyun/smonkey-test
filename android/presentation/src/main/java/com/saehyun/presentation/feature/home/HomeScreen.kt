package com.saehyun.presentation.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.R
import com.saehyun.presentation.component.BigTopAppBar
import com.saehyun.presentation.component.SMonkeyLargeButton
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody10
import com.saehyun.presentation.style.SmonkeyBody3
import com.saehyun.presentation.style.SmonkeyBody5
import com.saehyun.presentation.style.SmonkeyBody8

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeState,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SMonkeyColor.Gray200)
            .verticalScroll(rememberScrollState()),
    ) {
        BigTopAppBar(
            leadingContent = {
                Image(
                    painter = painterResource(id = R.drawable.ic_smonkey_title),
                    contentDescription = null,
                )
            },
            trailingContent = {
                Image(
                    painter = painterResource(id = R.drawable.ic_notification_24),
                    contentDescription = null,
                )
            },
        )
        Spacer(space = 20.dp)
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .background(
                    shape = RoundedCornerShape(12.dp),
                    color = SMonkeyColor.Gray100,
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 18.dp,
                ),
        ) {
            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(id = R.drawable.character_smonkey_1),
                contentDescription = null,
            )
            Column {
                SmonkeyBody5(text = state.username)
                Spacer(space = 4.dp)
                SmonkeyBody8(text = "다음 단계까지 ${state.smonkey.nextPoint} 포인트")
                Spacer(space = 20.dp)
                SmonkeyBody10(text = "얼마 안남았어요! 조금만 힘내요!")
                Spacer(space = 8.dp)
                LinearProgressIndicator(
                    progress = 0.8f,
                    color = SMonkeyColor.Main1,
                )
            }
        }
        Spacer(space = 16.dp)
        SMonkeyLargeButton(
            modifier = Modifier.padding(horizontal = 30.dp),
            text = "금연 기록하기",
            enabled = true,
        ) {

        }
        Spacer(space = 16.dp)
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .background(
                    color = SMonkeyColor.Main1,
                    shape = RoundedCornerShape(12.dp),
                )
                .padding(all = 16.dp),
        ) {
            SmonkeyBody3(
                text = "장석연 님이",
                color = SMonkeyColor.Gray100
            )
            Spacer(space = 10.dp)
            HomeTitleAndDescription(
                title = "금연한 시간",
                description = "9일 14시간 13분 30초",
            )
            Spacer(space = 10.dp)
            HomeTitleAndDescription(
                title = "절약한 금액",
                description = "11,300 원",
            )
            Spacer(space = 10.dp)
            HomeTitleAndDescription(
                title = "흡연 기간",
                description = "365일 15시간 1분 21초",
            )
            Spacer(space = 10.dp)
            HomeTitleAndDescription(
                title = "소비 금액",
                description = "441,500 원",
            )
            Spacer(space = 6.dp)
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ic_down_24),
                contentDescription = null,
            )
        }
        Spacer(space = 16.dp)
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .background(
                    color = SMonkeyColor.Gray100,
                    shape = RoundedCornerShape(12.dp),
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                ),
        ) {
            SmonkeyBody3(text = "오늘의 명언")
            Spacer(space = 18.dp)
            SmonkeyBody8(text = "흡연자는 자신을 현인이나 자선가처럼 착각하고 행동한다.")
        }
        Spacer(space = 80.dp)
    }
}

@Composable
private fun HomeTitleAndDescription(
    title: String,
    description: String,
) {
    SmonkeyBody8(
        text = title,
        color = SMonkeyColor.Gray100,
    )
    Spacer(modifier = Modifier.height(4.dp))
    SmonkeyBody5(
        text = description,
        color = SMonkeyColor.Gray100,
    )
}