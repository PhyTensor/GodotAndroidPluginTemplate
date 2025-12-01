package org.godotengine.plugin.android.template.signals

import org.godotengine.godot.plugin.SignalInfo


fun getSignals() : MutableSet<SignalInfo> = mutableSetOf(
    HelloSignals.userPrintHello,
    HelloSignals.userSayHello,
);

object HelloSignals {
    val userSayHello: SignalInfo = SignalInfo("userSayHello", Boolean::class.javaObjectType)
    val userPrintHello: SignalInfo = SignalInfo("userPrintHello", String::class.java)
}
