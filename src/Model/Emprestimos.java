/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;



/**
 *
 * @author Lucas
 */
public class Emprestimos {
    private int id,aluno,livro1,livro2,pendentes,multa;
    private String datarealizacao,dataDevolucao,dataPagamento;

    

    /**
     * @return the aluno
     */
    public int getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(int aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the livro1
     */
    public int getLivro1() {
        return livro1;
    }

    /**
     * @param livro1 the livro1 to set
     */
    public void setLivro1(int livro1) {
        this.livro1 = livro1;
    }

    /**
     * @return the livro2
     */
    public int getLivro2() {
        return livro2;
    }

    /**
     * @param livro2 the livro2 to set
     */
    public void setLivro2(int livro2) {
        this.livro2 = livro2;
    }

    /**
     * @return the pendente
     */
    public int getPendentes() {
        return pendentes;
    }

    /**
     * @param pendente the pendente to set
     */
    public void setPendentes(int pendentes) {
        this.pendentes = pendentes;
    }

    /**
     * @return the datarealizacao
     */
    public String getDatarealizacao() {
        return datarealizacao;
    }

    /**
     * @param datarealizacao the datarealizacao to set
     */
    public void setDatarealizacao(String datarealizacao) {
        this.datarealizacao = datarealizacao;
    }

    /**
     * @return the dataDevolucao
     */
    public String getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    

    /**
     * @return the multa
     */
    public int getMulta() {
        return multa;
    }

    /**
     * @param multa the multa to set
     */
    public void setMulta(int multa) {
        this.multa = multa;
    }

    /**
     * @return the dataPagamento
     */
    public String getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

   
     
     
   
    
}
