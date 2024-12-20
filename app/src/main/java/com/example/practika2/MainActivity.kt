package com.example.smartlab

import android.os.Bundle
import android.text.Layout
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practika2.ui.theme.components.NumInput
import com.example.practika2.ui.theme.components.OnboardDescription
import com.example.practika2.ui.theme.components.SearchInput
import com.example.practika2.ui.theme.components.TextInput
import com.example.practika2.ui.theme.components.PrimaryButton
import com.example.practika2.ui.theme.HeaderColor
import com.example.practika2.ui.theme.Practika2Theme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.practika2.ui.theme.Practika2Theme
import com.example.practika2.ui.theme.components.OnboardDescription
import com.example.practika2.ui.theme.components.SearchInput
import com.example.practika2.ui.theme.components.TextInput

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
        composable("patient") { CreatePatient(navController) }
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
                        containerColor = Color(0xFF1A6FEE),
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
            BottomNavigation (modifier = Modifier, backgroundColor =  Color.White, contentColor = Color.Gray) {
                // Добавьте элементы меню
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Анализы") },
                    selected = false,
                    onClick = { },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    label = { Text("Результаты") },
                    selected = false,
                    onClick = {  },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Build, contentDescription = null) },
                    label = { Text("Поддержка") },
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
    var code by remember { mutableStateOf("") }
    val maxCodeLength = 6

    // Состояние для таймера
    var timerSeconds by remember { mutableStateOf(60) }
    var isTimerRunning by remember { mutableStateOf(true) }
    val textFieldValues = remember { mutableStateListOf("", "", "", "", "", "") }

    val allFieldsFilled = textFieldValues.all { it.isNotBlank() }
    LaunchedEffect(key1 = isTimerRunning) {
        if (isTimerRunning) {
            while (timerSeconds > 0) {
                delay(1000L) // Задержка на 1 секунду
                timerSeconds--
            }
            isTimerRunning = false
        }
    }
    Box (modifier = Modifier.background(Color.White).fillMaxSize()) {
        Row (modifier = Modifier.background(Color.White).fillMaxSize().padding(top = 60.dp).padding(horizontal = 15.dp)) {
            TextButton(
                onClick = { navController.navigate("main") },
                modifier = Modifier
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
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                textFieldValues.forEachIndexed { index, value ->
                    OutlinedTextField(
                        value = value,
                        onValueChange = { newValue ->
                            textFieldValues[index] = newValue
                            if(allFieldsFilled ){
                                navController.navigate("splash")
                            }

                        },
                        modifier = Modifier
                            .width(42.dp)
                            .height(48.dp)
                            .padding(top = 1.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold)
                    )
                }
            }
            if (isTimerRunning) {
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Отправить код повторно можно\n        будет через $timerSeconds секунд",
                    style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                )
            } else {
                PrimaryButton(modifier = Modifier.align(Alignment.CenterHorizontally), text = "Выслать код повторно",onClick = {
                    // Сбросить таймер и вызвать повторную отправку кода
                    timerSeconds = 60
                    isTimerRunning = true
                })
            }
            Button(
                enabled = true,
                onClick = {navController.navigate("createPassword")},
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
        PageData("Пропустить","Уведомления", "Работа с врачами станет проще", R.drawable.__2022_09_17__19_21_1, R.drawable.group2),
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

        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(top = 40.dp)) {
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
            var email by remember { mutableStateOf("") }
            var isValidEmail by remember { mutableStateOf(false) }
            val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")
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

            OutlinedTextField(
                value = email,
                onValueChange = { newValue ->
                    email = newValue
                    isValidEmail = emailRegex.matches(newValue) // Проверка email
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                enabled = true,
                readOnly = false,
                placeholder = {
                    Text(
                        text = "example@mail.ru",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 20.sp
                    )
                },
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black.copy(0.5f),
                    unfocusedTextColor = Color.Black.copy(0.5f),
                    focusedBorderColor = Color.Black.copy(0.5f),
                    unfocusedBorderColor = Color.Black.copy(0.5f)
                ),
                shape = RoundedCornerShape(20.dp)
            )

            Spacer(
                modifier = Modifier
                    .size(32.dp)
            )
            PrimaryButton(
                text = "Далее",
                enabled = isValidEmail,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp),
                onClick = {navController.navigate("code")})

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
    Box (modifier = Modifier.background(Color.White).fillMaxSize().padding(horizontal = 15.dp)) {
        Column(modifier = Modifier.padding(top = 60.dp)) {
            TextButton(
                onClick = { navController.navigate("mainSearch") },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Пропустить")
            }
            Text(text = "Создайте пароль", modifier = Modifier.padding(top = 10.dp).align(Alignment.CenterHorizontally))
            Text(text = "Для защиты персональных данных", modifier = Modifier.padding(top = 10.dp).align(Alignment.CenterHorizontally))
            Image(
                painter = painterResource(id = R.drawable.progress1), // Ссылка на векторное изображение
                contentDescription = "",
                contentScale = ContentScale.Fit, // Масштабирование изображения
                modifier = Modifier.size(100.dp, 16.dp).align(Alignment.CenterHorizontally) // Размер изображения
            )
            Row (modifier = Modifier.padding(top = 10.dp).align(Alignment.CenterHorizontally)) {
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
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
                        text = "1",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
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
                        text = "2",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
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
                        text = "3",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            Row (modifier = Modifier.padding(top = 10.dp).align(Alignment.CenterHorizontally)) {
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
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
                        text = "4",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
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
                        text = "5",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
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
                        text = "6",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            Row (modifier = Modifier.padding(top = 10.dp).align(Alignment.CenterHorizontally)) {
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
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
                        text = "7",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
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
                        text = "8",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
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
                        text = "9",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            Row (modifier = Modifier.padding(top = 10.dp).align(Alignment.CenterHorizontally))  {
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
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
                        text = "0",
                        fontSize = 17.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    )
                }
                Button(
                    enabled = true,
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Black,
                        disabledContainerColor = Color.White
                    ),
                    border = BorderStroke(1.dp, color = Color(0xFFEBEBEB))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.del_icon), // Ссылка на векторное изображение
                        contentDescription = "",
                        modifier = Modifier.size(32.dp).padding(start = 1.dp)
                    )
                }
            }
            Button(
                enabled = true,
                onClick = { navController.navigate("patient") },
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
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CreatePatient(navController: NavController) {
    Box (modifier = Modifier.background(Color.White).fillMaxSize().padding(horizontal = 15.dp)) {
        Column(modifier = Modifier.padding(top = 60.dp)) {
            TextButton(
                onClick = { navController.navigate("mainSearch") },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Пропустить")
            }

            Text(text = "Создание карты \nпациента", modifier = Modifier.padding(top = 10.dp), color = Color.Black)
            Text(text = "Без карты пациента вы не сможете заказать \nанализы.", modifier = Modifier.padding(top = 10.dp), color = Color.Gray)
            Text(text = "В картах пациентов будут храниться результаты \nанализов вас и ваших близких.", modifier = Modifier , color = Color.Gray)
            TextInput(
                modifier = Modifier
                    .size(335.dp,48.dp).align(Alignment.CenterHorizontally),
                placeholder = "Имя",
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TextInput(
                modifier = Modifier
                    .size(335.dp,48.dp).align(Alignment.CenterHorizontally),
                placeholder = "Отчество",
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TextInput(
                modifier = Modifier
                    .size(335.dp,48.dp).align(Alignment.CenterHorizontally),
                placeholder = "Фамилия",
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            TextInput(
                modifier = Modifier
                    .size(335.dp,48.dp).align(Alignment.CenterHorizontally),
                placeholder = "Дата рождения",
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))


            //
            // Declaring a boolean value to store
            // the expanded state of the Text Field
            var mExpanded by remember { mutableStateOf(false) }

            // Create a list of cities
            val mCities = listOf("Мужчина", "Женщина")

            // Create a string value to store the selected city
            var mSelectedText by remember { mutableStateOf("") }

            var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

            // Up Icon when expanded and down icon when collapsed
            val icon = if (mExpanded)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.KeyboardArrowDown

            Column(Modifier.padding(10.dp)) {

                // Create an Outlined Text Field
                // with icon and not expanded
                OutlinedTextField(
                    value = mSelectedText,
                    onValueChange = { mSelectedText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            // This value is used to assign to
                            // the DropDown the same width
                            mTextFieldSize = coordinates.size.toSize()
                        },
                    label = {Text("Пол")},
                    trailingIcon = {
                        Icon(icon,"contentDescription",
                            Modifier.clickable { mExpanded = !mExpanded })
                    }
                )

                // Create a drop-down menu with list of cities,
                // when clicked, set the Text Field text as the city selected
                DropdownMenu(
                    expanded = mExpanded,
                    onDismissRequest = { mExpanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
                ) {
                    mCities.forEach { label ->
                        DropdownMenuItem(onClick = {
                            mSelectedText = label
                            mExpanded = false
                        }) {
                            Text(text = label)
                        }
                    }
                }
            }

            //
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Button(
                enabled = true,
                onClick = {navController.navigate("mainSearch")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp).padding(top = 10.dp),
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
                    text = "Создать",
                    fontSize = 17.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W400
                )
            }

        }
    }
}


