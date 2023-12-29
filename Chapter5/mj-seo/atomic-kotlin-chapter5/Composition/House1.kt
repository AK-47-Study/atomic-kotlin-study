package composition1


interface Building
interface Kitchen

// 집은 건물이다(is - a 관계)
interface House: Building {
    // 집은 부엌을 가지고 있다(has - a 관계)
    val kitchen: Kitchen
}