package com.example.myapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Preview
@Composable
fun Twit() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFF161026))
            .padding(8.dp)
    ) {
        UserImage()
        TwitBody()
    }
}

@Composable
fun TwitBody() {
    Column {
        Row(Modifier.fillMaxWidth()) {
            TitleText()
            UserName()
            TwitTime()
            Spacer(modifier = Modifier.weight(1f))
            OptionsIcon()
        }
        UserTwit()
        SocialIcons()
    }
}

@Composable
fun OptionsIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_dots),
        contentDescription = "options",
        tint = Color.White
    )
}

@Composable
fun SocialIcons() {
    var messagesOn by rememberSaveable { mutableStateOf(false) }
    var retwitted by rememberSaveable { mutableStateOf(false) }
    var favourite by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.padding(top = 8.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_chat),
            contentDescription = "messages",
            tint = if (messagesOn) {
                Color.Green
            } else {
                Color.Gray
            },
            modifier = Modifier
                .weight(1f)
                .clickable { messagesOn = !messagesOn }
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_rt),
            contentDescription = "retweet",
            tint = if (retwitted) {
                Color.Green
            } else {
                Color.Gray
            },
            modifier = Modifier
                .weight(1f)
                .clickable { retwitted = !retwitted }
        )
        Icon(
            painter = if (favourite) {
                painterResource(id = R.drawable.ic_like_filled)
            } else {
                painterResource(id = R.drawable.ic_like)
            },
            contentDescription = "likes",
            tint = if (favourite) {
                Color.Red
            } else {
                Color.Gray
            },
            modifier = Modifier.weight(1f).clickable { favourite=!favourite }
        )
    }
}

@Composable
fun UserTwit(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                    " Nunc facilisis lacus quis arcu lobortis, eget accumsan lacus porta." +
                    " Mauris efficitur orci enim, ut ornare lectus pretium nec.",
            color = Color.White,
            modifier = modifier.padding(start = 8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "image from the user",
            Modifier
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(12.dp))
        )
    }
}

@Composable
fun TwitTime() {
    Text(text = "4h", color = Color.Gray)
}

@Composable
fun TitleText(modifier: Modifier = Modifier) {
    Text(
        text = "Marti",
        color = Color.White,
        fontWeight = FontWeight.ExtraBold,
        modifier = modifier.padding(horizontal = 8.dp)
    )
}

@Composable
fun UserName(modifier: Modifier = Modifier) {
    Text(text = "@marti_cv", color = Color.Gray, modifier = modifier.padding(end = 8.dp))
}

@Composable
fun UserImage() {
    Image(
        painter = painterResource(id = R.drawable.profile), contentDescription = "user icon",
        Modifier
            .size(60.dp)
            .clip(CircleShape)
    )
}
