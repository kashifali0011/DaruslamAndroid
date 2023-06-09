package com.dtech.darussalam.utilities.extensions

import android.animation.Animator
import android.app.Activity
import android.content.*
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.database.Cursor
import android.database.CursorIndexOutOfBoundsException
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.PictureDrawable
import android.location.Address
import android.location.Geocoder
import android.media.ExifInterface
import android.media.MediaScannerConnection
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.provider.ContactsContract
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.util.TypedValue
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.dtech.darussalam.DarusslamApp
import com.dtech.darussalam.R
import com.dtech.darussalam.data.remote.callback.ICallBackUri
import com.dtech.darussalam.data.remote.callback.ICallBackUriMultiple
import com.dtech.darussalam.utilities.Constants
import com.dtech.darussalam.utilities.utils.RealPathUtil
import com.dtech.darussalam.view.auth.AuthActivity
import com.dtech.darussalam.view.base.ActivityBase
import com.sangcomz.fishbun.FishBun.Companion.INTENT_PATH
import com.squareup.picasso.Picasso
import java.io.*
import java.time.DayOfWeek
import java.time.temporal.WeekFields
import java.util.*
import kotlin.math.hypot
import kotlin.math.roundToInt


/**
 * Develop By Messagemuse
 */
var fileUri: Uri? = null
var fileUriLis: ArrayList<Uri>? = null

val Context.glide: RequestManager?
    get() = Glide.with(this)

fun ImageView.load(path: String) {
    try {
        context.glide!!.load(path).thumbnail(0.1f).into(this)
    } catch (ex: IllegalArgumentException) {

    }
}

fun ImageView.loadDps(path: String) {
    if (TextUtils.isEmpty(path)) {
        this.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_dp_place_holder))
    } else {
        Picasso.get().load(path).placeholder(R.drawable.ic_dp_place_holder).into(this)
    }
//    val requestOptions = RequestOptions()
//    requestOptions.placeholder(R.drawable.bg_contact)
//    requestOptions.error(R.drawable.bg_contact)
//    try {
//        context.glide!!.setDefaultRequestOptions(requestOptions).load(path).thumbnail(0.1f).into(this)
//    } catch (ex: IllegalArgumentException) {
//
//    }
}


fun Context.dpToPx(dp: Int): Int {
    val density = this.resources
            .displayMetrics
            .density
    return (dp.toFloat() * density).roundToInt()
}

fun Context.showToastMessage(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

internal fun Context.getDrawableCompat(@DrawableRes drawable: Int) =
        ContextCompat.getDrawable(this, drawable)

internal fun Context.getColorCompat(@ColorRes color: Int) = ContextCompat.getColor(this, color)

internal fun TextView.setTextColorRes(@ColorRes color: Int) =
        setTextColor(context.getColorCompat(color))

fun dpToPx(dp: Int, context: Context): Int =
        TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
                context.resources.displayMetrics
        ).toInt()

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

internal fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return context.layoutInflater.inflate(layoutRes, this, attachToRoot)
}

internal val Context.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this)

internal val Context.inputMethodManager
    get() = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}


fun getCapsSentences(tagName: String): String? {
    val splits = tagName.toLowerCase(Locale.ROOT).split(" ".toRegex()).toTypedArray()
    val sb = StringBuilder()
    for (i in splits.indices) {
        val eachWord = splits[i]
        if (i > 0 && eachWord.length > 0) {
            sb.append(" ")
        }
        val cap = (eachWord.substring(0, 1).toUpperCase()
                + eachWord.substring(1))
        sb.append(cap)
    }
    return sb.toString()
}

fun convertCountToMonth(month: Int): String {
    return when (month) {
        1 -> "Jan"
        2 -> "Feb"
        3 -> "Mar"
        4 -> "Apr"
        5 -> "May"
        6 -> "Jun"
        7 -> "Jul"
        8 -> "Aug"
        9 -> "Sep"
        10 -> "Oct"
        11 -> "Nov"
        12 -> "Dec"
        else -> ""
    }
}

fun daysOfWeekFromLocale(): Array<DayOfWeek> {
    val firstDayOfWeek = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        WeekFields.of(Locale.getDefault()).firstDayOfWeek
    } else {
        TODO("VERSION.SDK_INT < O")
    }
    var daysOfWeek = DayOfWeek.values()
    // Order `daysOfWeek` array so that firstDayOfWeek is at index 0.
    // Only necessary if firstDayOfWeek != DayOfWeek.MONDAY which has ordinal 0.
    if (firstDayOfWeek != DayOfWeek.MONDAY) {
        val rhs = daysOfWeek.sliceArray(firstDayOfWeek.ordinal..daysOfWeek.indices.last)
        val lhs = daysOfWeek.sliceArray(0 until firstDayOfWeek.ordinal)
        daysOfWeek = rhs + lhs
    }
    return daysOfWeek
}

fun Activity.startCamera(requestCode: Int) {
    val values = ContentValues(1)
    values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
    fileUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    if (intent.resolveActivity(packageManager) != null) {
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        startActivityForResult(intent, requestCode)
    }
}

fun Activity.showGallery(requestCode: Int) {
    val galleryIntent: Intent?
    galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    galleryIntent.type = "image/*"
    if (galleryIntent.resolveActivity(packageManager) == null) {
        showToastMessage("This Application do not have Gallery Application")
        return
    }
    startActivityForResult(galleryIntent, requestCode)
}

fun Activity.processGalleryPhoto(data: Intent, callback: ICallBackUriMultiple) {
    val realPath = RealPathUtil.getRealPath(this, data.data!!)

    fileUri = try {
        Uri.fromFile(File(realPath))
    } catch (ex: Exception) {
        if (realPath != null)
            Uri.parse(realPath)
        else
            Uri.fromFile(File(data.data!!.path))
    }
   val filePathList : ArrayList<Uri> = ArrayList()
    filePathList.add(fileUri!!)
    callback.imageUri(filePathList)
}


fun Activity.processGalleryMultipleImages(data: Intent, callback: ICallBackUriMultiple) {
    val imagesList  = data!!.getParcelableArrayListExtra<Uri>(INTENT_PATH)!!
    val fileUriList: ArrayList<Uri> = ArrayList()
    if (imagesList != null) {
        for (element in imagesList) {
            val realPath = RealPathUtil.getRealPath(this, element)
            fileUriList.add(Uri.fromFile(File(realPath)))
        }
    }

    callback.imageUri(fileUriList)
}
fun Context.compressFile(fileUri: Uri): Uri {

    val image = this.compressBitmap(this.handleSamplingAndRotationBitmap(fileUri)!!)
    val file = File(this.cacheDir, getFileName(fileUri.path!!))
    try {
        file.createNewFile()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    val bitmap = Bitmap.createScaledBitmap(image, image.width, image.height, true)
    val bos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos)
    val bitmapdata = bos.toByteArray()
    try {
        val fos = FileOutputStream(file)
        fos.write(bitmapdata)
        fos.flush()
        fos.close()
    } catch (e: IOException) {

        e.printStackTrace()
    }

    return Uri.fromFile(file)
}

fun getFileName(wholePath: String): String {
    var name: String? = null
    val start: Int = wholePath.lastIndexOf('/')
    val end: Int = wholePath.length
    //lastIndexOf('.');
    name = wholePath.substring((start + 1), end)
    return name
}

fun Context.compressBitmap(image: Bitmap): Bitmap {

    var finalImage: Bitmap? = null
    if (image.width > Constants.CONST_DEFAULT_IMAGE_WIDTH || image.height > Constants.CONST_DEFAULT_IMAGE_WIDTH) {
        if (image.width > image.height) {
            val ratio = (Constants.CONST_DEFAULT_IMAGE_WIDTH.toFloat() / image.width.toFloat())
            finalImage = Bitmap.createScaledBitmap(
                    image,
                    Constants.CONST_DEFAULT_IMAGE_WIDTH,
                    (image.height * ratio).toInt(),
                    true
            )

        } else if (image.height > image.width) {

            val ratio = (Constants.CONST_DEFAULT_IMAGE_WIDTH.toFloat() / image.height.toFloat())
            finalImage = Bitmap.createScaledBitmap(
                    image,
                    (image.width * ratio).toInt(),
                    Constants.CONST_DEFAULT_IMAGE_WIDTH,
                    true
            )

        } else {
            if (image.width > Constants.CONST_DEFAULT_IMAGE_WIDTH) {
                finalImage = Bitmap.createScaledBitmap(
                        image,
                        Constants.CONST_DEFAULT_IMAGE_WIDTH,
                        Constants.CONST_DEFAULT_IMAGE_WIDTH,
                        true
                )
            } else {
                finalImage = image
            }
        }
    } else {
        finalImage = if (image.width > image.height) {
            val ratio = ((image.width * 0.7) / image.width.toFloat())
            Bitmap.createScaledBitmap(
                    image,
                    (image.width * 0.7).toInt(),
                    (image.height * ratio).toInt(),
                    true
            )
        } else {
            val ratio = ((image.height * 0.7) / image.height.toFloat())
            Bitmap.createScaledBitmap(
                    image,
                    (image.width * ratio).toInt(),
                    (image.height * 0.7).toInt(),
                    true
            )
        }
    }
    return finalImage!!
}

@Throws(IOException::class)
fun Context.handleSamplingAndRotationBitmap(selectedImage: Uri): Bitmap? {
    val MAX_HEIGHT = 1024
    val MAX_WIDTH = 1024

    // First decode with inJustDecodeBounds=true to check dimensions
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    var imageStream = contentResolver.openInputStream(selectedImage)
    BitmapFactory.decodeStream(imageStream, null, options)
    imageStream!!.close()

    // Calculate inSampleSize
    options.inSampleSize = calculateInSampleSize(options, MAX_WIDTH, MAX_HEIGHT)

    // Decode bitmap with inSampleSize set
    options.inJustDecodeBounds = false
    imageStream = contentResolver.openInputStream(selectedImage)
    var img = BitmapFactory.decodeStream(imageStream, null, options)
    if (img != null)
        img = rotateImageIfRequired(img, selectedImage)
    else {
        showToastMessage("Image not available")
        return null
    }

    return img
}

private fun calculateInSampleSize(
        options: BitmapFactory.Options,
        reqWidth: Int,
        reqHeight: Int
): Int {
    // Raw height and width of image
    val height = options.outHeight
    val width = options.outWidth
    var inSampleSize = 1

    if (height > reqHeight || width > reqWidth) {
        val heightRatio = (height.toFloat() / reqHeight.toFloat()).roundToInt()
        val widthRatio = (width.toFloat() / reqWidth.toFloat()).roundToInt()
        inSampleSize = if (heightRatio < widthRatio) heightRatio else widthRatio
        val totalPixels = (width * height).toFloat()
        val totalReqPixelsCap = (reqWidth * reqHeight * 2).toFloat()
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++
        }
    }
    return inSampleSize
}

private fun rotateImageIfRequired(img: Bitmap, selectedImage: Uri): Bitmap {
    val ei = selectedImage.path?.let { ExifInterface(it) }
    val orientation =
            ei!!.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
    return when (orientation) {
        ExifInterface.ORIENTATION_ROTATE_90 ->
            rotateImage(img, 90)
        ExifInterface.ORIENTATION_ROTATE_180 ->
            rotateImage(img, 180)
        ExifInterface.ORIENTATION_ROTATE_270 ->
            rotateImage(img, 270)
        else -> {
            img
        }
    }
}

private fun rotateImage(img: Bitmap, degree: Int): Bitmap {
    val matrix = Matrix()
    matrix.postRotate(degree.toFloat())
    val rotatedImg = Bitmap.createBitmap(img, 0, 0, img.width, img.height, matrix, true)
    img.recycle()
    return rotatedImg
}

fun Activity.processCapturedPhoto(callback: ICallBackUri) {
    try {
        val cursor = contentResolver.query(
                Uri.parse(fileUri.toString()),
                Array(1) { MediaStore.Images.ImageColumns.DATA },
                null,
                null,
                null
        )
        cursor!!.moveToFirst()
        val photoPath = cursor.getString(0)
        cursor.close()
        val file = File(photoPath)
        callback.imageUri(Uri.fromFile(file))
    } catch (ex: CursorIndexOutOfBoundsException) {
        ex.printStackTrace()

        val columns: Array<String> =
                arrayOf(MediaStore.MediaColumns.DATA, MediaStore.MediaColumns.DATE_ADDED)
        val cursor = contentResolver.query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                columns,
                null,
                null,
                "${MediaStore.MediaColumns.DATE_ADDED} DESC"
        )

        val coloumnIndex = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val photoPath = cursor.getString(coloumnIndex)
        cursor.close()
        val file = File(photoPath)
        callback.imageUri(Uri.fromFile(file))
    }

}
//fun Activity.processGalleryMultipleVideoGligar(data: Intent, callback: ICallBackUriMultiple) {
//    val imagesList = data.extras?.getStringArray(GligarPicker.IMAGES_RESULT)
//    val fileUriList: ArrayList<Uri> = ArrayList()
//    if (imagesList != null) {
//        for (element in imagesList) {
//            fileUriList.add(Uri.fromFile(File(element)))
//        }
//    }
//
//    callback.imageUri(fileUriList)

/*fun View.errorAnim(context: Context) {
    if (this is EditText) {
        this.setHintTextColor(resources.getColor(R.color.gray))
    }
    val anim = AnimationUtils.loadAnimation(context, R.anim.viberation_anim)
    anim.repeatCount = 0
    anim.fillAfter = false
    this.startAnimation(anim)
}*/

fun Context.isEmailValid(email: String): Boolean {
    return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun Context.convertBitmapToUri(bitmap: Bitmap): Uri? {
    val file = File(this.cacheDir, System.currentTimeMillis().toString() + ".png")
    try {
        file.createNewFile()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    val bos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos)
    val bitmapdata = bos.toByteArray()
    try {
        val fos = FileOutputStream(file)
        fos.write(bitmapdata)
        fos.flush()
        fos.close()
    } catch (e: IOException) {

        e.printStackTrace()
    }

    return Uri.fromFile(file)
}

fun getExternalStorageDir(context: Context, folderName: String): File? {
    val file = File(Environment.getExternalStorageDirectory(), folderName)
    if (!file.exists()) {
        if (!file?.mkdir()!!) {
        }
    }
    return file
}

fun saveBitmap(path: String, bitmap: Bitmap, context: Context) {
    var myDir = File(path)
    try {
        var outStream = FileOutputStream(myDir)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream)
        outStream.flush()
        outStream.close()
        val paths = arrayOf<String>(myDir.toString())
        MediaScannerConnection.scanFile(context, paths, null, null)
    } catch (ex: java.lang.Exception) {
        ex.printStackTrace()
    }
}

fun getBitmap(v: View): Bitmap? {
    try {
        v.clearFocus()
        v.isPressed = false
        val willNotCache = v.willNotCacheDrawing()
        v.setWillNotCacheDrawing(false)
        val color = v.drawingCacheBackgroundColor
        v.drawingCacheBackgroundColor = 0
        if (color != 0) {
            v.destroyDrawingCache()
        }
        v.isDrawingCacheEnabled = true
        v.buildDrawingCache(true)
        val bitmap = Bitmap.createBitmap(v.drawingCache)
        v.isDrawingCacheEnabled = false
        v.destroyDrawingCache()
        v.setWillNotCacheDrawing(willNotCache)
        v.drawingCacheBackgroundColor = color
        return bitmap
    } catch (ex: NullPointerException) {
        ex.printStackTrace()
        return null
    }
}


fun Activity.onTokenExpiredLogout() {

    val token = DarusslamApp.db.getString(Constants.DEVICE_ID)
    val toTour = DarusslamApp.db.getBoolean(Constants.CONST_IS_TOUR)
    val userPhone = DarusslamApp.db.getString(Constants.CONST_USER_PHONE)
    val language = DarusslamApp.db.getString(Constants.LANGUAGE , Constants.ENGLISH)
    DarusslamApp.db.clear()
    DarusslamApp.db.putString(Constants.DEVICE_ID, token!!)
    DarusslamApp.db.putString(Constants.CONST_USER_PHONE , userPhone!!)
    DarusslamApp.db.putBoolean(Constants.CONST_IS_LOGIN, false)
    DarusslamApp.db.putBoolean(Constants.CONST_IS_TOUR, toTour)
    DarusslamApp.db.putString(Constants.LANGUAGE,language!!)
    startActivity(Intent(this, AuthActivity::class.java))
    this.finish()
}

fun Activity.onDeleteUserLogout() {

    val token = DarusslamApp.db.getString(Constants.DEVICE_ID)
    val toTour = DarusslamApp.db.getBoolean(Constants.CONST_IS_TOUR)
    DarusslamApp.db.clear()
    DarusslamApp.db.putString(Constants.DEVICE_ID, token!!)
    DarusslamApp.db.putBoolean(Constants.CONST_IS_LOGIN, false)
    DarusslamApp.db.putBoolean(Constants.CONST_IS_TOUR, toTour)
    startActivity(Intent(this, AuthActivity::class.java))
    this.finish()
}





fun currentOS(): String {
    val builder = StringBuilder()
    val fields = Build.VERSION_CODES::class.java.fields
    for (field in fields) {
        val fieldName = field.name
        var fieldValue = -1

        try {
            fieldValue = field.getInt(Any())
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }

        if (fieldValue == Build.VERSION.SDK_INT) {
            builder.append(fieldName)
        }
    }
    return builder.toString()
}

fun Activity.startVideoCamera(requestCode: Int) {
    val values = ContentValues(1)
    values.put(MediaStore.Video.Media.MIME_TYPE, "video/*")
    fileUri = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values)
    val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
    if (intent.resolveActivity(packageManager) != null) {
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 20)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        startActivityForResult(intent, requestCode)
    }
}


fun Activity.showGalleryVideo(requestCode: Int) {
    val galleryIntent: Intent?
    galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
    galleryIntent.type = "video/*"
    if (galleryIntent.resolveActivity(packageManager) == null) {
        showToastMessage("This Application do not have Gallery Application")
        return
    }
    startActivityForResult(galleryIntent, requestCode)
}




fun Context.getRootParentFragment(fragment: Fragment): Fragment {
    val parent = fragment.parentFragment
    return if (parent == null)
        fragment
    else
        getRootParentFragment(parent)
}

fun Context.copyText(text: String) {
    val clipboard: ClipboardManager = this.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
    val clip: ClipData = ClipData.newPlainText("label", text)
    clipboard.setPrimaryClip(clip)
}

fun visibleAnim(view: View, Toggle: Boolean) {
    view.visibility = View.VISIBLE
    val anim: Animation = if (Toggle) {
        //fadeOut
        AnimationUtils.loadAnimation(ActivityBase.activity, R.anim.fade_out)
    } else {
        //fadeIn
        AnimationUtils.loadAnimation(ActivityBase.activity, R.anim.fade_in)
    }
    view.startAnimation(anim)
    anim.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {}
        override fun onAnimationEnd(arg0: Animation) {
            //Functionality here
            if (Toggle) {
                view.visibility = View.GONE
            } else {
                view.visibility = View.VISIBLE
            }
        }

        override fun onAnimationRepeat(animation: Animation) {}
    })
}

fun adjustFontScale(configuration: Configuration, context: Context) {
    configuration.fontScale = 1.0.toFloat()
    val metrics = context.resources.displayMetrics
    val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    wm.defaultDisplay.getMetrics(metrics)
    metrics.scaledDensity = configuration.fontScale * metrics.density
    context.resources.updateConfiguration(configuration, metrics)
}


fun getBitmapFromView(view: View): Bitmap? {
    val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(returnedBitmap)
    val bgDrawable: Drawable? = view.background
    if (bgDrawable != null) bgDrawable.draw(canvas) else canvas.drawColor(Color.WHITE)
    view.draw(canvas)
    return returnedBitmap
}

fun getPrivateStorageDir(context: Context, folderName: String): File? {
    val file = File(context.filesDir, folderName)
    if (!file.exists()) {
        if (!file?.mkdir()!!) {
        }
    }
    return file
}

fun getMediaPath(context: Context, uri: Uri): String {

    val resolver = context.contentResolver
    val projection = arrayOf(MediaStore.Video.Media.DATA)
    var cursor: Cursor? = null
    try {
        cursor = resolver.query(uri, projection, null, null, null)
        return if (cursor != null) {
            val columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)
            cursor.moveToFirst()
            cursor.getString(columnIndex)

        } else ""

    } catch (e: Exception) {
        resolver.let {
            val filePath = (context.applicationInfo.dataDir + File.separator
                    + System.currentTimeMillis())
            val file = File(filePath)

            resolver.openInputStream(uri)?.use { inputStream ->
                FileOutputStream(file).use { outputStream ->
                    val buf = ByteArray(4096)
                    var len: Int
                    while (inputStream.read(buf).also { len = it } > 0) outputStream.write(
                            buf,
                            0,
                            len
                    )
                }
            }
            return file.absolutePath
        }
    } finally {
        cursor?.close()
    }
}

@Suppress("DEPRECATION")
fun saveVideoFile(filePath: String?): File? {
    filePath?.let {
        val videoFile = File(filePath)
        val videoFileName = "${System.currentTimeMillis()}_${videoFile.name}"
        val folderName = Environment.DIRECTORY_MOVIES
        if (Build.VERSION.SDK_INT >= 30) {

            val values = ContentValues().apply {

                put(
                        MediaStore.Images.Media.DISPLAY_NAME,
                        videoFileName
                )
                put(MediaStore.Images.Media.MIME_TYPE, "video/mp4")
                put(MediaStore.Images.Media.RELATIVE_PATH, folderName)
                put(MediaStore.Images.Media.IS_PENDING, 1)
            }

            val collection =
                    MediaStore.Video.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)

            val fileUri = ActivityBase.activity.contentResolver.insert(collection, values)

            fileUri?.let {
                ActivityBase.activity.contentResolver.openFileDescriptor(fileUri, "rw")
                        .use { descriptor ->
                            descriptor?.let {
                                FileOutputStream(descriptor.fileDescriptor).use { out ->
                                    FileInputStream(videoFile).use { inputStream ->
                                        val buf = ByteArray(4096)
                                        while (true) {
                                            val sz = inputStream.read(buf)
                                            if (sz <= 0) break
                                            out.write(buf, 0, sz)
                                        }
                                    }
                                }
                            }
                        }

                values.clear()
                values.put(MediaStore.Video.Media.IS_PENDING, 0)
                ActivityBase.activity.contentResolver.update(fileUri, values, null, null)

                return File(getMediaPath(ActivityBase.activity, fileUri))
            }
        } else {
            val downloadsPath =
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val desFile = File(downloadsPath, videoFileName)

            if (desFile.exists())
                desFile.delete()

            try {
                desFile.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return desFile
        }
    }
    return null
}


fun shareCard(path: String, text: String) {
    val uri = Uri.parse(path)
    val shareIntent = Intent()
    shareIntent.action = Intent.ACTION_SEND
    shareIntent.putExtra(Intent.EXTRA_TEXT, text)
    shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
    shareIntent.type = "image/*"
    ActivityBase.activity.startActivity(Intent.createChooser(shareIntent, "Share Card"))
}

fun shareEmailIntent(mailTo: String) {
    val uriText = "mailto:${mailTo}" +
            "?subject=" + Uri.encode("") +
            "&body=" + Uri.encode("")

    val uri = Uri.parse(uriText)

    val sendIntent = Intent(Intent.ACTION_SENDTO)
    sendIntent.data = uri
    ActivityBase.activity.startActivity(Intent.createChooser(sendIntent, "Send email"))

}

@RequiresApi(Build.VERSION_CODES.M)
fun Context.InternetSpeedChecker() {
    Handler().postDelayed({
        val cm: ConnectivityManager = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val nc: NetworkCapabilities = cm.getNetworkCapabilities(cm.activeNetwork)!!
        val downSpeed = nc.getLinkDownstreamBandwidthKbps()
        val upSpeed = nc.getLinkUpstreamBandwidthKbps()
        Log.d("InternetSpeed", "downSpeed " + downSpeed / 1024 + "\n" + "upSpeed " + upSpeed / 1024)
        InternetSpeedChecker()
    }, 5000)
}

fun validCellPhone(number: String): Boolean {
    return number.isNotEmpty() && Patterns.PHONE.matcher(number).matches()
}

fun openCreateContact() {
    val intent = Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI)
    ActivityBase.activity.startActivity(intent)
}

fun getBuildVersion() : String {
    var build = ""
    build = if (Constants.BASE_URL.contains("stagingdesk.com")){
        "Build: Development"
    }else if (Constants.BASE_URL.contains("clientstagingapi")){
        "Build: Client Staging"
    }else {
        ""
    }
    return  build
}

fun watchYoutubeVideo(id: String) {
    val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))
    try {
        ActivityBase.activity.startActivity(appIntent)
    } catch (ex: ActivityNotFoundException) {
        ActivityBase.activity.startActivity(webIntent)
    }
}


fun Context.getAddressFromLatLng(latitude: Double, longitude: Double): String {

    var geocoder: Geocoder = Geocoder(this, Locale.getDefault())
    var addresses: List<Address>
    var isLahore: Boolean = false
    var completeAddress = ""

    var addressToShow = ""

    var featureName = ""
    var locatlity = ""
    var premises = ""
    var subAdminArea = ""
    var subLocality = ""
    var thoroughfare = ""
    var subThoroughfare = ""

    var lahoreString = ""

    try {
        addresses = geocoder.getFromLocation(latitude, longitude, 1) // addresses list
        completeAddress = addresses[0].getAddressLine(0) // gives the complete address
        val splitAddress = completeAddress.split(",")
        val mainLane = splitAddress[0]
        val customLine = splitAddress[1]
        if (addresses[0].featureName != null) {
            featureName = addresses[0].featureName
        }
        if (addresses[0].locality != null) {
            locatlity = addresses[0].locality
        }
        if (addresses[0].premises != null) {
            premises = addresses[0].premises
        }
        if (addresses[0].subAdminArea != null) {
            subAdminArea = addresses[0].subAdminArea
        }
        if (addresses[0].subLocality != null) {
            subLocality = addresses[0].subLocality
        }
        if (addresses[0].thoroughfare != null) {
            thoroughfare = addresses[0].thoroughfare
        }
        if (addresses[0].subThoroughfare != null) {
            subThoroughfare = addresses[0].subThoroughfare
        }

        lahoreString = featureName + locatlity + premises + subAdminArea + subLocality + thoroughfare + subThoroughfare
        isLahore = lahoreString.contains("lahore", true)


        addressToShow = mainLane

        if (!TextUtils.isEmpty(subLocality)) {
            addressToShow += ", $subLocality"
        } else {
            addressToShow += ", $customLine"
        }

    } catch (ex: Exception) {
        addressToShow = "Unnamed Road, Lahore"
    }
    return addressToShow

}

fun circleReveal(myView: View, posFromRight: Int, containsOverflow: Boolean, isShow: Boolean) {
    try {
        var width = myView.width
        if (posFromRight > 0)
            width -= (posFromRight * ActivityBase.activity.resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_action_button_min_width_overflow_material)) - (ActivityBase.activity.resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_action_button_min_width_overflow_material) / 2)
        if (containsOverflow)
            width -= ActivityBase.activity.resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_action_button_min_width_overflow_material)
        val cx = myView.width
        val cy = myView.height / 2
        val initialRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()
        val anim: Animator
        anim = if (isShow) {
            ViewAnimationUtils.createCircularReveal(myView, cx, 0, 0F, initialRadius)
        } else
            ViewAnimationUtils.createCircularReveal(myView, cx, 0, initialRadius, 0F)
        anim.duration = 300.toLong()
        anim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationStart(animation: Animator?) {}
            override fun onAnimationEnd(animation: Animator?) {
                if (!isShow) {
                    anim.end()
                    myView.visibility = View.GONE
                }
            }
        })
        if (isShow)
            myView.visibility = View.VISIBLE
        anim.start()
    } catch (ex: java.lang.Exception) {
        ex.printStackTrace()
    }
}



/*
fun gotoHome() {
    val fm = ActivityBase.activity.supportFragmentManager
    for (i in 0 until fm.backStackEntryCount) {
        fm.popBackStack()
    }
    (ActivityBase.activity as ActivityBase).addFragment(
        R.id.mainContainer,
        HomeFragmentCustomer(),
        null
    )

}
*/


/*
fun gotoProviderHome() {
    val fm = ActivityBase.activity.supportFragmentManager
    for (i in 0 until fm.backStackEntryCount) {
        fm.popBackStack()
    }
    (ActivityBase.activity as ActivityBase).addFragment(
        R.id.mainProviderContainer,
        ProviderHomeFragment(),
        null
    )

}*/

fun Context.openWhatsapp(contact : String){

    val url = "https://api.whatsapp.com/send?phone=$contact"
    try {
        val pm: PackageManager = this.packageManager
        pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        this.startActivity(i)
    } catch (e: PackageManager.NameNotFoundException) {
        Toast.makeText(this, "Whatsapp app not installed in your phone", Toast.LENGTH_LONG).show()
        e.printStackTrace()
    }
}

fun ImageView.loadSvg(url : String){
    var requestBuilder = context.glide!!
        .`as`(PictureDrawable::class.java)
        .transition(withCrossFade())

    requestBuilder.load(Uri.parse(url)).into(this)
}

fun Activity.openGoogleMap(lat : Double , long : Double){
    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("http://maps.google.com/maps?daddr=${lat},${long}")
    )
    this.startActivity(intent)
}

fun Context.setAppLocale() {

    val locale = Locale(DarusslamApp.db.getString(Constants.LANGUAGE , Constants.ENGLISH))
    Locale.setDefault(locale)
    val config = resources.configuration
    config.setLocale(locale)
    config.setLayoutDirection(locale)
    createConfigurationContext(config)
    this.resources.updateConfiguration(config,this.resources.displayMetrics)
    DarusslamApp.configRetrofit()

}

fun Context.setClipboard(text: String) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
        val clipboard = this.getSystemService(CLIPBOARD_SERVICE) as android.text.ClipboardManager
        clipboard.text = text
    } else {
        val clipboard = this.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Coupon copy", text)
        clipboard.setPrimaryClip(clip)
    }
}

