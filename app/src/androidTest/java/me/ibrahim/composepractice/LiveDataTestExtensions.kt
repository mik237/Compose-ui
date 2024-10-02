package me.ibrahim.composepractice

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * Extension function to get the value from LiveData for testing purposes.
 */
@MainThread
fun <T> LiveData<T>.getOrAwait(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
): T {
    var data: T? = null
    val latch = CountDownLatch(1)

    val observer = object : Observer<T> {
        override fun onChanged(value: T) {
            data = value
            latch.countDown()
            this@getOrAwait.removeObserver(this)
        }
    }

    this.observeForever(observer)
    try {
        afterObserve.invoke()
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }
    } catch (e: InterruptedException) {
        throw RuntimeException("Interrupted while waiting for LiveData value.", e)
    }
    @Suppress("UNCHECKED_CAST")
    return data as T
}
