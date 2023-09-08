package com.nebraska.homecontrol.app.common.usecase

interface UseCase<TParam, TReturn> {
    operator fun invoke(args: TParam) : Result<TReturn>
}

interface CommandUseCase<TParam, TReturn> : UseCase<TParam, TReturn> {
    override operator fun invoke(args: TParam) : Result<TReturn>
}

interface QueryUseCase<TParam, TReturn> : UseCase<TParam, TReturn> {
    override operator fun invoke(args: TParam) : Result<TReturn>
}