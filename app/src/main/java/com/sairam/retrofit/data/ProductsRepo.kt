package com.sairam.retrofit.data
// getting products and updating ui also showing a toast msg is error occurs loading data
import com.sairam.retrofit.data.model.Product
import kotlinx.coroutines.flow.Flow


interface ProductsRepo {
    suspend fun getProductsList() : Flow<Result<List<Product>>>
}