package com.sairam.retrofit.data
//getting data from api
//reusable for other api's too
import com.sairam.retrofit.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class ProductsRepoImplementation (
    private val api : Api
    ) : ProductsRepo {

    override suspend fun getProductsList(): Flow<Result<List<Product>>> {
       return flow {
           val productsFromApi = try {
               api.getProductsList()
           }
           catch (e: IOException){
               e.printStackTrace() // printing error in stack
               emit(Result.Error(message = "Error loading products data")) // u can also pass data here
               return@flow
           }
           catch (e: HttpException){
               e.printStackTrace()
               emit(Result.Error(message = "Error loading products data"))
               return@flow
           }
           emit(Result.Success(productsFromApi.products))
       }
    }
}