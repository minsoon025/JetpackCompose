package com.example.jetpackcomposeinstagram

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeInstagramTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Scaffold(
                        bottomBar = {
                            SootheBottomNavigation(Modifier.padding(top = 24.dp))
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState())
                        ) {
                            TopBarPreview()
                            AlignYourBodyRowPreview()
                            PostBarPreview()
                            PostBarPreview()
                            PostBarPreview()
                        }
                    }
                }
            }
        }
    }
}


private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Composable
fun TopBar(
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier
){
    Surface(
        color = Color.Black, // 검정색 배경
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(16.dp)) // 아이콘 사이 간격 조정

            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.weight(1f)) // 우측으로 확장되는 Spacer

            // 하트 아이콘
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Favorite",
                modifier = Modifier.size(16.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(16.dp)) // 아이콘 사이 간격 조정

            // 메시지 아이콘
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Message",
                modifier = Modifier.size(16.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(16.dp))

        }
    }
}





@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TopBarPreview() {
    JetpackComposeInstagramTheme {
        TopBar(
            drawable = R.drawable.instalogo,
        )
    }
}


// 크롭된 사진 나오는 부분
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    val instagramRainbowColors = listOf(
        Color(0xFF833AB4), // 보라색
        Color(0xFFF77737), // 주황색
        Color(0xFFFFDC80), // 노란색
        Color(0xFF34A853), // 초록색
        Color(0xFF8258FA) , // 보라색
        Color(0xFFFD1D1D) // 붉은색
    )
    Column(
        modifier = modifier
            .background(Color.Black), // 배경색을 검정색으로 설정
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(100.dp) // 이미지 크기
                .clip(CircleShape) // 동그라미 모양으로 클리핑
                .border(
                    width = 4.dp, // 테두리 두께
                    brush = Brush.linearGradient(
                        colors = instagramRainbowColors, // 무지개색
                        start = Offset(0f, 0f), // 그라데이션 시작점
                        end = Offset(0f, 999f) // 그라데이션 끝점
                    ),
                    shape = CircleShape // 테두리 모양
                )
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize() // 이미지를 박스 안에 꽉 채우기
            )
        }
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 12.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White // 텍스트 색상을 흰색으로 설정
        )
    }
}




@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    JetpackComposeInstagramTheme {

        AlignYourBodyElement(
            text = R.string.mintae,
            drawable = R.drawable.mintae,
            modifier = Modifier.padding(8.dp)
        )
    }
}



@Composable
fun HomeSection(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {

        content()
    }
}
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.background(Color.Black) // 배경색을 검정색으로 설정
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}



//사진 데이터 모음
private val alignYourBodyData = listOf(
    R.drawable.mintae to R.string.mintae,
    R.drawable.pica to R.string.pica,
    R.drawable.bugi to R.string.bugi,
    R.drawable.digda to R.string.digda,
    R.drawable.pairi to R.string.pairi,
    R.drawable.sixtail to R.string.sixtail,

    ).map { DrawableStringPair(it.first, it.second) }


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyRowPreview() {
    JetpackComposeInstagramTheme { AlignYourBodyRow() }
}




@Composable
fun LikeBar(
    modifier: Modifier = Modifier
){
    Surface(
        color = Color.Black, // 검정색 배경
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(8.dp)) // 아이콘 사이 간격 조정

            // 하트 아이콘
            Icon(
                imageVector = Icons.Default.FavoriteBorder, // 하트
                contentDescription = "Favorite",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp)) // 아이콘 사이 간격 조정

            Icon(
                imageVector = Icons.Default.MailOutline, // 메일
                contentDescription = "Message",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp)) // 아이콘 사이 간격 조정

            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Message",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.weight(1f)) // 우측으로 확장되는 Spacer
            Spacer(modifier = Modifier.width(24.dp)) // 아이콘 사이 간격 조정

            // 저장 아이콘
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Message",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(16.dp))

        }
    }
}





@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun LikeBarPreview() {
    JetpackComposeInstagramTheme {
        LikeBar()
    }
}



@Composable
fun TopPhoto(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.background(Color.Black) // 배경을 검정색으로 설정
                   .height(40.dp) // 높이를 88dp로 설정

    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(25.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(5.dp)) // 아이콘 사이 간격 조정

        // 이름 표시
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 8.dp),
            color = Color.White,
            fontSize = 16.sp // 텍스트 크기


        )
        Spacer(modifier = Modifier.weight(1f)) // 우측으로 확장되는 Spacer
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Favorite",
            modifier = Modifier.size(16.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(16.dp)) // 아이콘 사이 간격 조정

    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TopPhotoPreview() {
    JetpackComposeInstagramTheme {
        TopPhoto(
            drawable = R.drawable.mintae,
            text = R.string.mintae,
        )
    }
}



@Composable
fun TextBar(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.background(Color.Black)) {
        // Liked by 랜덤 이름 and Other 표시
        val randomName = listOf("Alice", "Bob", "Charlie", "David", "Eva").random()
        val otherCount = Random.nextInt(999) // 랜덤하게 0에서 10 사이의 숫자 생성
        Text(
            text = "Liked by $randomName and Other ${if (otherCount > 0) otherCount else ""}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 8.dp),
            fontWeight = FontWeight.Bold, // 텍스트를 볼드체로 설정
            color = Color.White // 텍스트 색상을 흰색으로 설정
        )

        // 한 줄 띄기
        Spacer(modifier = Modifier.height(3.dp))

        // 랜덤 내용 추가
        val randomContent = listOf(
            "Hi, my name is $randomName. Nice to meet you! I'm really excited to share my experience with Jetpack Compose. It's such an amazing framework and I can't wait to explore more features.",
            "This is my first Jetpack Compose app, and I'm thrilled to showcase it to you all. I've put a lot of effort into designing and implementing it, and I hope you enjoy using it as much as I enjoyed creating it!",
            "I'm currently learning Jetpack Compose, and I must say, it's been an incredible journey so far. The flexibility and ease of use of this toolkit make UI development so much more efficient and enjoyable.",
            "Hello everyone! I'm $randomName, and I'm delighted to present my latest Android app built with Jetpack Compose. I believe this app will revolutionize the way you interact with your device, offering a seamless and intuitive user experience.",
            "Jetpack Compose has completely changed the way I approach UI development. It's intuitive, powerful, and a joy to work with. I'm excited to see what amazing apps we can create with this groundbreaking technology."
        ).random()
        Text(
            text = randomContent,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 6.dp),
            color = Color.White // 텍스트 색상을 흰색으로 설정
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TextBarPreview() {
    JetpackComposeInstagramTheme {
        TextBar()
    }
}


@Composable
fun PostBar(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()
        .background(Color.Black)) {
        // TopPhoto
        TopPhoto(
            drawable = R.drawable.mintae,
            text = R.string.mintae,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Image
        Image(
            painter = painterResource(R.drawable.mintae),
            contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(Color.Black)
        )
        Spacer(modifier = Modifier.width(10.dp)) // 아이콘 사이 간격 조정

        // LikeBar
        LikeBar(
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.width(10.dp)) // 아이콘 사이 간격 조정

        // TextBar
        TextBar(
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun PostBarPreview() {
    JetpackComposeInstagramTheme {
        PostBar()
    }
}

@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = Color.Black,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    tint = Color.White)
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.White)
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = Color.White,
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.White
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    tint = Color.White
                )
            },
            selected = false,
            onClick = {}
        )
    }
}



@Preview(showBackground = true, backgroundColor = 0x0000)
@Composable
fun BottomNavigationPreview() {
    JetpackComposeInstagramTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun PreviewAll() {
    JetpackComposeInstagramTheme {
        Scaffold(
            bottomBar = {
                SootheBottomNavigation(Modifier.padding(top = 24.dp))
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                TopBarPreview()
                AlignYourBodyRowPreview()
                PostBarPreview()
                PostBarPreview()
                PostBarPreview()
            }
        }
    }
}





