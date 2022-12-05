package com.mycompany.banco;
public class ContaBanco {
   //atributo
   public int numConta;
   protected String tipo;
   private String dono;
   private float saldo;
   private boolean status;
   //metodos personalizados
   public void estadoAtual(){
       System.out.println("------------------------------------");
       System.out.println("Conta: " + this.getNumConta());
       System.out.println("Tipo: " + this.getTipo());
       System.out.println("Dono: " + this.getDono());
       System.out.println("Saldo: " + this.getSaldo());
       System.out.println("Status: " + this.getStatus());
   }
   public void abrirConta(String t){
       this.setTipo(t);
       this.setStatus(true);
       if (t == "cc"){
           this.setSaldo(50);
       }else if (t == "CP") {
           this.setSaldo(150);
       }
   }
   public void fechaConta(){
       if (this.getSaldo() > 0){
           System.out.println("conta não pode ser fechada porque ainda tem dinheiro");
       }else if (this.getSaldo() < 0){
           System.out.println("conta não pode ser fechada pois tem débito");
       }else{
           this.setStatus(false);
           System.out.println("conta fechada com sucesso!");
       }
   }
   public void depositar(float v){
       if (this.getStatus()){
           //this.saldo = this.saldo + v;
           this.setSaldo(this.getSaldo()+ v);
           System.out.println("deposito realizado com sucesso na conta: " + this.getDono());
          }else {
           System.out.println("impossivel depositar em conta fechada!");
       }
   }
   public void sacar(float v){
       if (this.getStatus()){
       if (this.getSaldo() >= v){    
           this.setSaldo(this.getSaldo() - v);
           System.out.println("Saque realizado na conta de: " + this.getDono());
       }else {
           System.out.println("Saldo insuficiente pra saque");
       }
       }else {
           System.out.println("Impossivel saca de uma conta fechada!");
       }
   }
   public void pagarMensal(){
       int v = 0;
       if (this.getTipo()== "CC"){
           v=12;
       }else if (this.getTipo() == "CP"){
           v=20;
       }
       if (this.getStatus()){
           if (this.getSaldo()> v) {
               this.setSaldo(this.getSaldo() - v);
               System.out.println("Mensalidade paga com sucesso por " + this.getDono());
           } else {
               System.out.println("impossivel pagar uma conta fechada");
           }
       }
   }
   //metodo especial construtor

    public ContaBanco() {
        this.saldo = saldo;
        this.status = status;
    }    
    // metodo especial geters e seters

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
