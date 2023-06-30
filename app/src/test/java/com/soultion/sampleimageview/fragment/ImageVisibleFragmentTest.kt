package com.soultion.sampleimageview.fragment

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class ImageVisibleFragmentTest {

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }

    @Test
    fun image_data_is_missing(){
        val image="https://via.placeholder.com/600/92c952"
        val assert=ImageUtils.validate(image)
        assert(assert=="Email Url Is Missing")
    }
}