package variance


interface Parent
interface Child: Parent

interface X {
    fun f(): Parent
}

interface Y : X {

    /*
    *  함수는 공변적인 반환 타입을 가진다
    *  -> 더 구체적인 반환 타입을 돌려줘도 된다(오버라이딩 대상 함수의 타입보다 오버라이딩 한 함수가 더 구체적인 반환 타입을 돌려줘도 된다)
    */
    override fun f(): Child
}