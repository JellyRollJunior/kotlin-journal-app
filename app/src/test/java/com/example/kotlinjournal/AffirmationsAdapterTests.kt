package com.example.kotlinjournal

import android.content.Context
import com.example.kotlinjournal.adapter.ItemAdapter
import com.example.kotlinjournal.model.Affirmation
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class AffirmationsAdapterTests {

    /**
     * In Android, Context is the context of the current state of the app, but remember that unit
     * tests run on the JVM and not on an actual device, so there is no Context. The mock method
     * allows us to create a "mocked" instance of a Context. It doesn't have any real functionality,
     * but it can be used to test methods that require a context.
     */
    private val context = mock(Context::class.java)

    @Test
    fun adapter_size() {

        /**
         *  The goal of this test is to make sure that the size of the adapter is the size of the
         *  list that was passed to the adapter. To do this, create an instance of ItemAdapter and
         *  pass in the list returned by the loadAffirmations() method in the Datasource class.
         *  Alternatively, create a new list and test that. For unit tests, it's best practice to
         *  create our own data unique to the test, so we'll create a custom list for this test.
         */
        val data = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2)
        )
        val adapter = ItemAdapter(context, data)

        /**
         * You're already familiar with the assertEquals() method, but it's worth examining the
         * line to be thorough. The first parameter is a string that displays in the test result
         * if the test fails. The second parameter is the expected value. The third parameter is
         * the actual value. Your test class should look like this:
         */
        assertEquals("ItemAdapter is not the correct size", data.size, adapter.itemCount)
    }
}