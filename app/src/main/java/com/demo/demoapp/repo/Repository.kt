/*
*Android assessment from 20021590
**/
package com.demo.demoapp.repo

class Repository(private val mRemoteDataSource: DataSource,
                 private val mLocalDataSource: DataSource?) : DataSource {

    override fun getRemoteData(value: String?, callback: DataSource.GetCallback?) {
        mRemoteDataSource.getRemoteData(value, callback)
    }

    companion object {
        private var INSTANCE: Repository? = null
        fun getInstance(remoteDataSource: DataSource, localDataSource: DataSource?): Repository? {
            if (INSTANCE == null) {
                INSTANCE = Repository(remoteDataSource, localDataSource)
            }
            return INSTANCE
        }
    }
}