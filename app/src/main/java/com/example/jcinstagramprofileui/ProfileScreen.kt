package com.example.jcinstagramprofileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showSystemUi = true)
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "deadpool")
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(12.dp))
        ButtonSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        HighlightSection(
            highlight = listOf(
                ImageWithText(painterResource(id = R.drawable.a), "Coming🔥"),
                ImageWithText(painterResource(id = R.drawable.b), "Hugh Res"),
                ImageWithText(painterResource(id = R.drawable.c), "Moisturizer"),
                ImageWithText(painterResource(id = R.drawable.d), "Comic"),
                ImageWithText(painterResource(id = R.drawable.e), "No sh!t"),
                ImageWithText(painterResource(id = R.drawable.f), "So cheeky"),
                ImageWithText(painterResource(id = R.drawable.g), "Entertainment"),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        PostTabView(
            imageWithText = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid), text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels), text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile), text = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.deadpool_1710233082733395),
                    painterResource(id = R.drawable.deadpool_1710233082733262),
                    painterResource(id = R.drawable.deadpool_1710233082733362),
                    painterResource(id = R.drawable.deadpool_1710233012950289),
                    painterResource(id = R.drawable.deadpoolmovie_1710233207807845),
                    painterResource(id = R.drawable.d),
                    painterResource(id = R.drawable.deadpoolmovie_1710233163900237),
                    painterResource(id = R.drawable.styledbymarvel_171023297887066),
                    painterResource(id = R.drawable.styledbymarvel_1710232979894380),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
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
            modifier = Modifier.padding(start = 34.dp, end = 4.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic),
            contentDescription = "Back",
            modifier = Modifier.size(18.dp)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
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
                .padding(top = 20.dp)
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
            description = "The official @Marvel's Deadpool account,\n" + "A.K.A., the Merc with a Mouth\n" + "Two fists, two swords, and a total bada\$\$.\n" + "Bea Arthur's #1 fan.",
            url = "🔗 www.mintmobile.com",
            followedBy = listOf("chrishemsworth", "robertdowneyjr"),
            otherCount = 17,
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
//    val letterSpacing = 0.0.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName, /*letterSpacing = letterSpacing,*/
            lineHeight = lineHeight, fontWeight = FontWeight.Bold, fontSize = 16.sp
        )
        Text(
            text = description, /*letterSpacing = letterSpacing,*/
            lineHeight = lineHeight, fontSize = 14.sp
        )
        Text(
            text = url, color = Color(0xFFC8E7F1),
//            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val bondStyle = SpanStyle(
                        fontWeight = FontWeight.Bold
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
//                letterSpacing = letterSpacing,
                lineHeight = lineHeight, fontSize = 14.sp
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWeight = 104.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceAround, modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWeight)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWeight)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWeight)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier, text: String? = null, icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp))
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text, fontWeight = FontWeight.SemiBold, fontSize = 12.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlight: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlight.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(image = highlight[it].image, modifier = Modifier.size(70.dp))
                Text(
                    text = highlight[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val inactiveColor = Color(0xff777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        contentColor = Black,
        modifier = modifier,

        ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == 0) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }

    }
}

@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it], contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(1.dp, White)
            )
        }
    }
}