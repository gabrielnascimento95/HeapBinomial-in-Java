/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapbinomial.in.java;

/**
 *
 * @author Gabriel_Nascimento
 */
public class HealBinomial {
    private No nos;
    private int tamanho;

    public HealBinomial() {
        this.nos = null;
        this.tamanho = 0;
    }
    
    public boolean vazio(){
        return nos == null;
    }

    public int getTamanho() {
        return tamanho;
    }
    
    public void remover(){
        this.nos = null;
        this.tamanho = 0;
    }
    
    public void insere(int valor){
        if(valor >0){
            No aux = new No(valor);
            if(nos == null){
                nos = aux;
            }else{
                uniaoNo(aux);
                this.tamanho++;
            }
        }
    }
    
    private void uniaoNo(No aux) {
        uniaoHeaps(aux);
        No x = null;
        No y = nos;
        No z = nos.getIrmao();
        
        while(z != null){
            if((y.getNivel() != z.getNivel()) || ((z.getIrmao() != null) && (z.getIrmao().getNivel() == y.getNivel()))){
                x = y;
                y = z;
            }
            else{
                if(y.getChave() <= z.getChave()){
                    y.setIrmao(z.getIrmao());
                    z.setPai(y);
                    z.setIrmao(y.getFilho());
                    y.setFilho(z);
                    y.setNivel(y.getNivel()+1);
                }else{
                    if(x == null){
                        nos = z;
                    }else{
                        x.setIrmao(z);
                    }
                    y.setPai(z);
                    y.setIrmao(z.getFilho());
                    z.setFilho(y);
                    z.setNivel(z.getNivel()+1);
                    y = z;
                }
            }
            z = y.getIrmao();
        }
    }
    
    private void uniaoHeaps(No aux){
        No x = this.nos;
        No y = aux;
        
        while((x != null) && (y != null)){
            if(x.getNivel() == y.getNivel()){
                No z = y;
                y = y.getIrmao();
                z.setIrmao(x.getIrmao());
                x.setIrmao(z);
                x = z.getIrmao();
            }else{
                if(x.getNivel() < y.getNivel()){
                    if((x.getIrmao() == null) || (x.getIrmao().getNivel() > y.getNivel())){
                        No z = y;
                        y = y.getIrmao();
                        z.setIrmao(x.getIrmao());
                        x.setIrmao(z);
                        x = z.getIrmao();
                    }else{
                        x = x.getIrmao();
                    }
                }else{
                    No z = x;
                    x = y;
                    y = y.getIrmao();
                    x.setIrmao(z);
                    if(z == nos){
                        nos = x;
                    }
                }
            }
            if(x == null){
                x = nos;
                while(x.getIrmao() != null){
                    x = x.getIrmao();
                }
                x.setIrmao(y);
            }
        }
    }
    
}
