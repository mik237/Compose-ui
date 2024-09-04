package me.ibrahim.composepractice.gravatar

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.ibrahim.composepractice.R
import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


@Composable
fun GravatarProfileSummary(emailAddress: String = "gravatar@automattic.com") {
    /*// Create a ProfileService instance
    val profileService = ProfileService()

    // Set the default profile state to loading
    var profileState: ComponentState<Profile> by remember { mutableStateOf(ComponentState.Loading, neverEqualPolicy()) }

    // We wrap the fetch call in a LaunchedEffect to fetch the profile when the composable is first launched, but this
    // could be triggered by a button click, a text field change, etc.
    LaunchedEffect(emailAddress) {
        // Set the profile state to loading
        profileState = ComponentState.Loading
        // Fetch the user profile
        when (val result = profileService.fetch(Email(emailAddress))) {
            is Result.Success -> {
                // Update the profile state with the loaded profile
                result.value.let {
                    profileState = ComponentState.Loaded(it)
                }
            }
            is Result.Failure -> {
                // An error can occur when a profile doesn't exist, if the phone is in airplane mode, etc.
                // Here we log the error, but ideally we should show an error to the user.
                Log.e("Gravatar", result.error.name)
                // Set the Empty state on error
                profileState = ComponentState.Empty
            }
        }
    }

    // Show the profile as a ProfileCard
    ProfileSummary(profileState, modifier = Modifier.fillMaxWidth().padding(16.dp))*/

    val email = "ad.mik237@gmail.com"
    val digest = "8265f8920dd05478789c0ead9a3ad37155638b385e197a42a1b51f530b95433a"
    val made = makeSHA1Hash(email)


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "digest: $digest", modifier = Modifier
                .padding(20.dp))
            Text(text = "made: $made", modifier = Modifier
                .padding(20.dp))

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.gravatar.com/avatar/$digest")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.profile),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape)
                    .size(250.dp)
            )
        }

    }

}

@Throws(NoSuchAlgorithmException::class, UnsupportedEncodingException::class)
fun makeSHA1Hash(input: String): String {
    val md = MessageDigest.getInstance("SHA256")
    md.reset()
    val buffer = input.toByteArray(charset("UTF-8"))
    md.update(buffer)
    val digest = md.digest()

    var hexStr = ""
    for (i in digest.indices) {
        hexStr += ((digest[i].toInt() and 0xff) + 0x100).toString(16).substring(1)
    }
    return hexStr
}