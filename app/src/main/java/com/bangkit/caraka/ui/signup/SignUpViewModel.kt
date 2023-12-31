package com.bangkit.caraka.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bangkit.caraka.data.networking.repository.ResultData
import com.bangkit.caraka.data.networking.repository.AppRepository
import com.bangkit.caraka.data.networking.response.RegisterResponse

class SignUpViewModel (private var repository: AppRepository) : ViewModel(){
    suspend fun register(name: String, email: String, password: String): LiveData<ResultData<RegisterResponse>> {
        return repository.register(name, email, password)
    }
}