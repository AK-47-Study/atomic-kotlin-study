package propertydelegation

import java.io.File
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class FileDelegate : ReadWriteProperty<Any?, String> {
    override fun getValue(
        // 이 위임은 파일과 상호 작용할 수만 있으면 되고, thisRef의 내부 정보는 필요하지 않다.
        thisRef: Any?,
        property: KProperty<*>
    ): String {
       val file = DataFile(property.name + ".txt")

        return if (file.exists()) file.readText()
        else ""
    }

    override fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: String) {
        DataFile(property.name + ".txt")
            .writeText(value)
    }
}

val targetDir = File("DataFiles")

class DataFile(val fileName: String) : File(targetDir, fileName) {
    init {
        if (!targetDir.exists()) {
            targetDir.mkdir()
        }
    }
    fun erase() { if (exists()) delete() }
    fun reset(): File {
        erase()
        createNewFile()
        return this
    }
}