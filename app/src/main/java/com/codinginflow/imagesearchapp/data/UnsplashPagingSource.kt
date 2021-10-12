package com.codinginflow.imagesearchapp.data

import android.app.DownloadManager
import androidx.paging.PagingSource
import com.bumptech.glide.load.HttpException
import com.codinginflow.imagesearchapp.data.cloud.UnsplashPhotoCloud
import com.codinginflow.imagesearchapp.data.cloud.UnsplashService
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class UnsplashPagingSource(
    private val unsplashService: UnsplashService,
    private val query: String
) : PagingSource<Int, UnsplashPhotoCloud>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhotoCloud> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try {
            val response = unsplashService.searchPhotos(query, position, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null
                else
                    position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}