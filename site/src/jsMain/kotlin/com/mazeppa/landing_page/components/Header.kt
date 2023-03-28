package com.mazeppa.landing_page.components

import androidx.compose.runtime.Composable
import com.mazeppa.landing_page.models.Section
import com.mazeppa.landing_page.models.Theme
import com.mazeppa.landing_page.styles.LogoStyle
import com.mazeppa.landing_page.styles.NavigationItemStyle
import com.mazeppa.landing_page.util.Constants
import com.mazeppa.landing_page.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun Header() {
    Row(
        modifier = Modifier.width(80.percent)
            .backgroundColor(Theme.LighterGray.rgb)
            .margin(top =  80.px)
            .padding(right = 10.px)
            .borderRadius(50.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide()
        RightSide()
    }
}

@Composable
fun LeftSide() {
    Row {
        Image(
            modifier = LogoStyle.toModifier(),
            src = Res.Image.logo,
            desc = "Logo Image"
        )
    }
}

@Composable
fun RightSide() {
    Row {
        Section.values().take(6).forEach { section ->
            Link(
                modifier = NavigationItemStyle.toModifier()
                    .padding(15.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None),
                path = section.path,
                text = section.title
            )
        }
    }
}
