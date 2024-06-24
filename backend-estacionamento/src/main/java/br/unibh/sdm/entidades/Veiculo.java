package br.unibh.sdm.entidades;

public class Veiculo {
// Atributos

private String placa;
private String modelo;
private String marca;
private String cor;

public Veiculo(){

}

public Veiculo(String placa, String modelo, String marca, String cor) {
   this.placa = placa;
   this.modelo = modelo;
   this.marca = marca;
   this.cor = cor;
}
public String getPlaca() {
   return placa;
}
public void setPlaca(String placa) {
   this.placa = placa;
}
public String getModelo() {
   return modelo;
}
public void setModelo(String modelo) {
   this.modelo = modelo;
}
public String getMarca() {
   return marca;
}
public void setMarca(String marca) {
   this.marca = marca;
}
public String getCor() {
   return cor;
}
public void setCor(String cor) {
   this.cor = cor;
}

@Override
public String toString() {
   return "Entidade_Veiculo [placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", cor=" + cor + "]";
}

@Override
public int hashCode() {
   final int prime = 31;
   int result = 1;
   result = prime * result + ((placa == null) ? 0 : placa.hashCode());
   result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
   result = prime * result + ((marca == null) ? 0 : marca.hashCode());
   result = prime * result + ((cor == null) ? 0 : cor.hashCode());
   return result;
}

@Override
public boolean equals(Object obj) {
   if (this == obj)
       return true;
   if (obj == null)
       return false;
   if (getClass() != obj.getClass())
       return false;
   Veiculo other = (Veiculo) obj;
   if (placa == null) {
       if (other.placa != null)
           return false;
   } else if (!placa.equals(other.placa))
       return false;
   if (modelo == null) {
       if (other.modelo != null)
           return false;
   } else if (!modelo.equals(other.modelo))
       return false;
   if (marca == null) {
       if (other.marca != null)
           return false;
   } else if (!marca.equals(other.marca))
       return false;
   if (cor == null) {
       if (other.cor != null)
           return false;
   } else if (!cor.equals(other.cor))
       return false;
   return true;
}


}