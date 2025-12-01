package org.godotengine.plugin.android.template

import android.util.Log
import android.widget.Toast
import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin
import org.godotengine.godot.plugin.SignalInfo
import org.godotengine.godot.plugin.UsedByGodot
import org.godotengine.plugin.android.template.signals.HelloSignals.userPrintHello
import org.godotengine.plugin.android.template.signals.HelloSignals.userSayHello
import org.godotengine.plugin.android.template.signals.getSignals

class GodotAndroidPlugin(godot: Godot) : GodotPlugin(godot) {
    override fun getPluginName(): String {
        return "GodotAndroidPluginTemplate";
    }

    /** @suppress */
    override fun getPluginSignals(): Set<SignalInfo> {
        return getSignals()
    }

    /**
     * Example showing how to declare a method that's used by Godot.
     *
     * Shows a 'Hello World' toast.
     */
    @UsedByGodot
    fun sayHello()
    {
        godot.getActivity()?.runOnUiThread {
            Toast.makeText(activity, "Hello World", Toast.LENGTH_LONG).show()
            Log.v(pluginName, "Hello World")
            emitSignal(userSayHello.name, true)
        };
    }

    @UsedByGodot
    fun printHello(): String {
        emitSignal(userPrintHello.name, "This is a return from a signal")
        return "Hello from Android plugin";
    }
}
