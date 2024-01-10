package composition1


interface Building
interface Kitchen

interface House: Building {
    val kitchen: Kitchen
}

