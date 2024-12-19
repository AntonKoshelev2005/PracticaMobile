package com.example.practika2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practika2.ui.theme.HeaderColor
import com.example.practika2.ui.theme.Practika2Theme
import com.example.practika2.ui.theme.components.NumInput
import com.example.practika2.ui.theme.components.OnboardDescription
import com.example.practika2.ui.theme.components.SearchInput
import com.example.practika2.ui.theme.components.TextInput
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practika2Theme {
                AppNavigator()
            }
        }
    }
}

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("welcome") { WelcomeScreen(navController) }
        composable("main") { MainScreen(navController) }
        composable("code") { Code(navController) }
        composable("mainSearch") { SearchScreen(navController) }
        composable("createPassword") { CreatePassword(navController) }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practika2Theme {
        AppNavigator()
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(1)
        navController.navigate("welcome") {
            popUpTo("splash") { inclusive = true }
        }
    }
}
@Composable
fun SearchScreen(navController: NavController) {
    Box (modifier = Modifier.background(Color.White).fillMaxSize()) {
        Column(modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth()

        ) {

            SearchInput(
                modifier = Modifier
                    .size(335.dp,48.dp).align(Alignment.CenterHorizontally),
                placeholder = "Искать анализы",
            )
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Акции и новости",
                fontWeight = FontWeight.W400,
                fontSize = 17.sp,
                lineHeight = 20.sp,
                modifier =Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                color = Color.Gray
            )
            Row (Modifier.padding(top = 20.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "..",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(270.dp, 152.dp).padding(horizontal = 10.dp)
                )
            }
            Text(
                text = "Каталог анализов",
                fontWeight = FontWeight.W400,
                fontSize = 17.sp,
                lineHeight = 20.sp,
                modifier =Modifier.fillMaxWidth().padding(top = 30.dp).padding(horizontal = 10.dp),
                color = Color.Gray
            )
            Row (Modifier.padding(top = 10.dp)) {
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .height(48.dp).width(170.dp).padding(horizontal = 10.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Cyan,
                        contentColor = Color.White,
                        disabledContentColor = Color.White,
                        disabledContainerColor = Color.Blue
                    ),
                    border = BorderStroke(1.dp, color = Color(0xFFEBEBEB))
                ) {
                    Text(
                        text = "Популярное",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            Box (Modifier.padding(10.dp).background(Color.White).border(1.dp, color = Color(0xFFEBEBEB))) {
                Text(
                    text = "ПЦР-тест на определение РНК коронавируса стандартный",
                    fontWeight = FontWeight.W400,
                    fontSize = 17.sp,
                    lineHeight = 20.sp,
                    modifier =Modifier.fillMaxWidth().padding(10.dp)
                )
                Row (Modifier.padding(top = 45.dp)) {
                    Text(
                        text = "2 дня",
                        fontWeight = FontWeight.W400,
                        fontSize = 17.sp,
                        lineHeight = 20.sp,
                        modifier =Modifier.fillMaxWidth().padding(10.dp),
                        color = Color.Gray
                    )
                    Button(
                        enabled = true,
                        onClick = { navController.navigate("code") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue,
                            contentColor = Color.White,
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.Blue
                        ),
                        border = BorderStroke(1.dp, color = Color(0xFFEBEBEB))
                    ) {
                        Text(
                            text = "Популярное",
                            fontSize = 17.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight.W400
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            BottomNavigation (modifier = Modifier, backgroundColor =  Color.White, contentColor = Color.Blue) {
                // Добавьте элементы меню
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Главная") },
                    selected = false,
                    onClick = { },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    label = { Text("Профиль") },
                    selected = false,
                    onClick = {  },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Build, contentDescription = null) },
                    label = { Text("Профиль") },
                    selected = false,
                    onClick = {  },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Phone, contentDescription = null) },
                    label = { Text("Профиль") },
                    selected = false,
                    onClick = {  },
                )
            }
        }

    }
}
@Composable
fun Code(navController: NavController) {
    Box (modifier = Modifier.background(Color.White).fillMaxSize()) {
        Row (modifier = Modifier.background(Color.White).fillMaxSize().padding(top = 60.dp).padding(horizontal = 15.dp)) {
            Button(
                enabled = true,
                onClick = { navController.navigate("createPassword") },
                modifier = Modifier
                    .size(150.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, color = Color(0xFFEBEBEB)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back), // Ссылка на векторное изображение
                    contentDescription = "",
                    modifier = Modifier.size(32.dp).padding(start = 1.dp)
                )
            }
        }
        Column(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .align(Alignment.Center)
        ) {

            Text(
                text = "Введите код из E-mail",
                fontWeight = FontWeight.W400,
                fontSize = 17.sp,
                lineHeight = 20.sp,
                modifier =Modifier.fillMaxWidth()
            )
            Row {
                NumInput(
                    modifier = Modifier
                        .size(48.dp).weight(1f),

                    )
                NumInput(
                    modifier = Modifier
                        .size(48.dp).weight(1f),


                    )
                NumInput(
                    modifier = Modifier
                        .size(48.dp).weight(1f),

                    )
                NumInput(
                    modifier = Modifier
                        .size(48.dp).weight(1f),

                    )
                NumInput(
                    modifier = Modifier
                        .size(48.dp).weight(1f),


                    )
            }
            Text(
                text = "Отправить код повторно можно",
                fontWeight = FontWeight.W400,
                fontSize = 17.sp,
                lineHeight = 20.sp,
                modifier =Modifier.fillMaxWidth()
            )
            Text(
                text = "будет через 59 секунд",
                fontWeight = FontWeight.W400,
                fontSize = 17.sp,
                lineHeight = 20.sp,
                modifier =Modifier.fillMaxWidth()
            )
            Button(
                enabled = true,
                onClick = {navController.navigate("mainSearch")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.Blue
                ),
                border = BorderStroke(1.dp, color = Color(0xFFEBEBEB))
            ) {
                Text(
                    text = "Далее",
                    fontSize = 17.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W400
                )
            }
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    val pagerState = rememberPagerState()

    val pages = listOf(
        PageData("Пропустить","Анализы", "Здесь вы можете увидеть свои анализы", R.drawable.illustration, R.drawable.group1),
        PageData("Пропустить","Удобство", "Работа с врачами станет проще", R.drawable.__2022_09_17__19_21_1, R.drawable.group2),
        PageData("Завершить","Мониторинг", "Следите за состоянием здоровья", R.drawable._30_1, R.drawable.group3)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Row(Modifier.fillMaxWidth().padding(10.dp),horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(
                onClick = { navController.navigate("main") },
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text("Пропустить")
            }
            Image(
                painter = painterResource(id = R.drawable.shape), // Ссылка на векторное изображение
                contentDescription = "",
                contentScale = ContentScale.Fit, // Масштабирование изображения
                modifier = Modifier.size(150.dp) // Размер изображения
                    .padding(top = 20.dp)
            )

        }

        Row(horizontalArrangement = Arrangement.Center) {
            HorizontalPager(
                count = pages.size,
                state = pagerState,
                //modifier = Modifier.weight(1f),
            ) { page ->
                WelcomePage(pages[page])
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    //.align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                activeColor = Color.Blue
            ) }

    }
}

@Composable
fun WelcomePage(page: PageData) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .height(60.dp))
            Text(page.title, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = HeaderColor)
            Spacer(modifier = Modifier.height(8.dp))
            Text(page.description, fontSize = 16.sp, color = Color.DarkGray)
            Image(
                painter = painterResource(id = page.dotimgId), // Ссылка на векторное изображение
                contentDescription = "..",
                contentScale = ContentScale.Fit, // Масштабирование изображения
                modifier = Modifier.size(50.dp) // Размер изображения
            )
            Spacer(
                modifier = Modifier
                    .weight(1f))
        }
        Image(
            painter = painterResource(id = page.imgId), // Ссылка на векторное изображение
            contentDescription = "..",
            contentScale = ContentScale.Fit, // Масштабирование изображения
            modifier = Modifier.align(Alignment.BottomCenter).size(400.dp) // Размер изображения
        )
    }
}

data class PageData(
    val button: String,
    val title: String,
    val description: String,
    val imgId:Int,
    val dotimgId:Int
)


@Composable
fun MainScreen(navController: NavController) {
    Box (modifier = Modifier.background(Color.White)) {
        Column(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 61.dp, bottom = 56.dp)
            .fillMaxWidth()
        ) {

            Row {
                Image(
                    ImageBitmap.imageResource(R.drawable.hello),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                )
                Spacer(
                    modifier = Modifier
                        .width(16.dp)
                )
                Text(
                    text = "Добро пожаловать!",
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp,
                    lineHeight = 28.sp
                )
            }

            Spacer(
                modifier = Modifier
                    .size(25.dp)
            )

            Text(
                text = "Войдите, чтобы пользоваться функциями приложения",
                fontWeight = FontWeight.W400,
                fontSize = 15.sp,
                lineHeight = 20.sp
            )

            Spacer(
                modifier = Modifier
                    .size(64.dp)
            )

            OnboardDescription(
                modifier = Modifier,
                text = "Вход по E-mail"
            )

            Spacer(
                modifier = Modifier
                    .size(4.dp)
            )

            TextInput(
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = "example@mail.ru",

                )

            Spacer(
                modifier = Modifier
                    .size(32.dp)
            )
            Button(
                enabled = true,
                onClick = {navController.navigate("code")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.Blue
                ),
                border = BorderStroke(1.dp, color = Color(0xFFEBEBEB))
            ) {
                Text(
                    text = "Далее",
                    fontSize = 17.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W400
                )
            }

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )


            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Или войдите с помощью",
                color = Color(0xFF939396),
                fontWeight = FontWeight.W400,
                fontSize = 15.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier
                    .size(16.dp)
            )
            Button(
                enabled = true,
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.White
                ),
                border = BorderStroke(1.dp, color = Color(0xFFEBEBEB))
            ) {
                Text(
                    text = "Войти с Яндекс",
                    fontSize = 17.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W400
                )
            }
        }
    }
}
@Composable
fun CreatePassword(navController: NavController) {
    Box (modifier = Modifier.background(Color.White).fillMaxSize()) {
        Column(modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth()

        ) {

            SearchInput(
                modifier = Modifier
                    .size(335.dp,48.dp).align(Alignment.CenterHorizontally),
                placeholder = "Искать анализы",
            )
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Акции и новости",
                fontWeight = FontWeight.W400,
                fontSize = 17.sp,
                lineHeight = 20.sp,
                modifier =Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                color = Color.Gray
            )
            Row (Modifier.padding(top = 20.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "..",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(270.dp, 152.dp).padding(horizontal = 10.dp)
                )
            }
            Text(
                text = "Каталог анализов",
                fontWeight = FontWeight.W400,
                fontSize = 17.sp,
                lineHeight = 20.sp,
                modifier =Modifier.fillMaxWidth().padding(top = 30.dp).padding(horizontal = 10.dp),
                color = Color.Gray
            )
            Row (Modifier.padding(top = 10.dp)) {
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .height(48.dp).width(170.dp).padding(horizontal = 10.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Cyan,
                        contentColor = Color.White,
                        disabledContentColor = Color.White,
                        disabledContainerColor = Color.Blue
                    ),
                    border = BorderStroke(1.dp, color = Color(0xFFEBEBEB))
                ) {
                    Text(
                        text = "Популярное",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            Box (Modifier.padding(10.dp).background(Color.White).border(1.dp, color = Color(0xFFEBEBEB))) {
                Text(
                    text = "ПЦР-тест на определение РНК коронавируса стандартный",
                    fontWeight = FontWeight.W400,
                    fontSize = 17.sp,
                    lineHeight = 20.sp,
                    modifier =Modifier.fillMaxWidth().padding(10.dp)
                )
                Row (Modifier.padding(top = 45.dp)) {
                    Text(
                        text = "2 дня",
                        fontWeight = FontWeight.W400,
                        fontSize = 17.sp,
                        lineHeight = 20.sp,
                        modifier =Modifier.fillMaxWidth().padding(10.dp),
                        color = Color.Gray
                    )
                    Button(
                        enabled = true,
                        onClick = { navController.navigate("code") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue,
                            contentColor = Color.White,
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.Blue
                        ),
                        border = BorderStroke(1.dp, color = Color(0xFFEBEBEB))
                    ) {
                        Text(
                            text = "Популярное",
                            fontSize = 17.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight.W400
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            BottomNavigation (modifier = Modifier, backgroundColor =  Color.White, contentColor = Color.Blue) {
                // Добавьте элементы меню
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Главная") },
                    selected = false,
                    onClick = { },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    label = { Text("Профиль") },
                    selected = false,
                    onClick = {  },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Build, contentDescription = null) },
                    label = { Text("Профиль") },
                    selected = false,
                    onClick = {  },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Phone, contentDescription = null) },
                    label = { Text("Профиль") },
                    selected = false,
                    onClick = {  },
                )
            }
        }

    }
}