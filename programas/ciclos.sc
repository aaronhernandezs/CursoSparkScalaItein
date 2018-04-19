object ciclos {

  
  
  val estados = List ("Aaron","Josse","Luis")
  
  
  estados.flatMap{ nombres => nombres.toUpperCase()}.distinct
  
}