val number = 10
implicit class IntOps(n: Int){
  private def createVectorFrom(number: Int): Seq[Int] = {
    number.toString.flatMap(_ :: Nil).map(_.toString.toInt)
  }
  def devided3: Boolean = createVectorFrom(n).sum % 3 == 0
  def devided5: Boolean = createVectorFrom(n).last == 5
  def devided3And5: Boolean = devided3 && devided5
}
12.devided3