package com.example.jcinstagramprofileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showSystemUi = true)
@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "deadpool")
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
    }
}

@Composable
fun TopBar(name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .padding(start = 12.dp)
                .size(26.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(start = 34.dp, end = 4.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic),
            contentDescription = "Back",
            modifier = Modifier
                .size(18.dp)
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            modifier = Modifier
                .padding(end = 28.dp)
                .size(18.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Back",
            modifier = Modifier
                .padding(end = 22.dp, bottom = 2.dp)
                .size(14.dp)
        )
    }
}

@Composable
fun ProfileSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.dp),
                modifier = Modifier
                    .padding(start = 30.dp)
                    .size(90.dp)
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(
                modifier = Modifier
                    .weight(3f)
                    .padding(start = 16.dp, end = 10.dp)
            )
        }
        ProfileDescription(
            displayName = "Deadpool",
            description = "The official @Marvel's Deadpool account,\n" +
                    "A.K.A., the Merc with a Mouth\n" +
                    "Two fists, two swords, and a total bada\$\$.\n" +
                    "Bea Arthur's #1 fan.\n",
            url = "www.mintmobile.com",
            followedBy = listOf("chrishemsworth", "robertdowneyjr"),
            otherCount = 17
        )
    }
}

@Composable
fun RoundImage(
    image: Painter, modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                2.dp, Color.LightGray, CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStats(numberText = "23", text = "Post")
        ProfileStats(numberText = "34M", text = "Followers")
        ProfileStats(numberText = "452", text = "Following")
    }
}

@Composable
fun ProfileStats(numberText: String, text: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = text, fontWeight = FontWeight.Normal, fontSize = 14.sp)
    }
}


@Composable
fun ProfileDescription(
    displayName: String, description: String, url: String, followedBy: List<String>, otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName, letterSpacing = letterSpacing, lineHeight = lineHeight
        )
        Text(
            text = description, letterSpacing = letterSpacing, lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xff3d3d91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val bondStyle = SpanStyle(
                        color = Color.Black, fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    pushStyle(bondStyle)
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(bondStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(bondStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}