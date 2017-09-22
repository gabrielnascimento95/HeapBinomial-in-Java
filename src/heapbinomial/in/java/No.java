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
public class No {
    private int chave;
    private int nivel;
    private No pai;
    private No irmao;
    private No filho;

    public No(int chave) {
        this.chave = chave;
        this.nivel = 0;
        this.pai = null;
        this.irmao = null;
        this.filho = null;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getIrmao() {
        return irmao;
    }

    public void setIrmao(No irmao) {
        this.irmao = irmao;
    }

    public No getFilho() {
        return filho;
    }

    public void setFilho(No filho) {
        this.filho = filho;
    }
   
}
