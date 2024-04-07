package com.lemondog.simpleplayer.common.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

class ApplicationCoroutineScope(context: CoroutineContext) : CoroutineScope {
    override val coroutineContext: CoroutineContext = context
}
