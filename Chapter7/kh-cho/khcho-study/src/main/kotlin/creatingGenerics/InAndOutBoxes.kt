package variance

class Box<T>( private var contents: T)
 { fun put(item: T) { contents = item }
  fun get(): T = contents
}
class InBox<in T>( private var contents: T) {
   fun put(item: T) {
    contents = item
   }
 }
class OutBox<out>( private var contents: T){
  fun get(): T = contents
}